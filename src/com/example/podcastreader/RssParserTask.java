package com.example.podcastreader;

import java.io.InputStream;
import java.net.URL;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

public class RssParserTask extends AsyncTask<String, Integer, RssListAdapter> {
	private RssReaderActivity mActivity;
	private RssListAdapter mAdapter;
	private Rsslist mRsslist;
	private ProgressDialog mProgressDialog;

	// �R���X�g���N�^
	public RssParserTask(RssReaderActivity activity, RssListAdapter adapter) {
		mActivity = activity;
		mAdapter = adapter;
	}

	// �^�X�N�����s��������ɃR�[�������
	@Override
	protected void onPreExecute() {
		// �v���O���X�o�[��\������
		mProgressDialog = new ProgressDialog(mActivity);
		mProgressDialog.setMessage("Now Loading...");
		mProgressDialog.show();
	}

	// �o�b�N�O���E���h�ɂ����鏈����S���B�^�X�N���s���ɓn���ꂽ�l�������Ƃ���
	@Override
	protected RssListAdapter doInBackground(String... params) {
		RssListAdapter result = null;
		try {
 
			//XML����ǂݍ��񂾃T�C�g���X�g������RSS�擾
			for(int i=0;i < mRsslist.rsssite.size(); i++){
 
				// HTTP�o�R�ŃA�N�Z�X���AInputStream���擾����
				URL url = new URL(mRsslist.rsssite.get(i).url);
				Log.v("podCastreader", i + "_url :" + mRsslist.rsssite.get(i).url);
				Log.v("podCastreader", i + "_key :" + mRsslist.rsssite.get(i).key);
//				setSitetitle(mRsslist.rsssite.get(i).key);
				InputStream is = url.openConnection().getInputStream();
				
				result = parseXml(is);
			}
 
		} catch (Exception e) {
			e.printStackTrace();
		}
		// �����ŕԂ����l�́AonPostExecute���\�b�h�̈����Ƃ��ēn�����
		return result;
	}

	// ���C���X���b�h��Ŏ��s�����
	@Override
	protected void onPostExecute(RssListAdapter result) {
		mProgressDialog.dismiss();
		mActivity.mGridView.setAdapter(result);
	}

	// XML���p�[�X����
	public RssListAdapter parseXml(InputStream is) {

		Serializer serializer = new Persister();
		 
        Rss rss = null;
 
        try {
        	// �ǂݍ���
        	rss = serializer.read(Rss.class, is);
    	} catch (Exception e) {
			e.printStackTrace();
        }
        
		Item currentItem = null;
		
		Log.v("podCastreader", "setTitle       :" + rss.getChannel().getTitle());
		Log.v("podCastreader", "setDescription :" + rss.getChannel().getDescription());
		
		currentItem = new Item();
		currentItem.setTitle(rss.getChannel().getTitle());
		currentItem.setDescription(rss.getChannel().getDescription());
		mAdapter.add(currentItem);
		return mAdapter;
	}

	public void setRsslist(Rsslist rsslist) {
		this.mRsslist = rsslist;
	}
}