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

	// コンストラクタ
	public RssParserTask(RssReaderActivity activity, RssListAdapter adapter) {
		mActivity = activity;
		mAdapter = adapter;
	}

	// タスクを実行した直後にコールされる
	@Override
	protected void onPreExecute() {
		// プログレスバーを表示する
		mProgressDialog = new ProgressDialog(mActivity);
		mProgressDialog.setMessage("Now Loading...");
		mProgressDialog.show();
	}

	// バックグラウンドにおける処理を担う。タスク実行時に渡された値を引数とする
	@Override
	protected RssListAdapter doInBackground(String... params) {
		RssListAdapter result = null;
		try {
 
			//XMLから読み込んだサイトリストを元にRSS取得
			for(int i=0;i < mRsslist.rsssite.size(); i++){
 
				// HTTP経由でアクセスし、InputStreamを取得する
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
		// ここで返した値は、onPostExecuteメソッドの引数として渡される
		return result;
	}

	// メインスレッド上で実行される
	@Override
	protected void onPostExecute(RssListAdapter result) {
		mProgressDialog.dismiss();
		mActivity.mGridView.setAdapter(result);
	}

	// XMLをパースする
	public RssListAdapter parseXml(InputStream is) {

		Serializer serializer = new Persister();
		 
        Rss rss = null;
 
        try {
        	// 読み込む
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