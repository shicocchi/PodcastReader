package com.example.podcastreader;

import java.io.InputStream;
import java.util.ArrayList;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.GridView;

public class RssReaderActivity extends Activity {
	
	private ArrayList<Item> mItems;
	private RssListAdapter mAdapter;
	public GridView mGridView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rss_reader);
		mGridView = (GridView) findViewById(R.id.gridView1);
		loadRssList();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
  
	//RSSの読み込みを実施
	private void loadRssList(){
	    //rsslist.xmlを生ファイルとして開く
        InputStream is = getResources().openRawResource(R.raw.rsslist);
        Serializer serializer = new Persister();
 
        Rsslist rsslist = null;
 
        try {
        	// 読み込む
        	rsslist = serializer.read(Rsslist.class, is);
        	}
        catch (Exception e) {
 
        }
 
		// Itemオブジェクトを保持するためのリストを生成し、アダプタに追加する
		mItems = new ArrayList<Item>();
		mAdapter = new RssListAdapter(this, mItems);
	 
		// タスクを起動する
		RssParserTask task = new RssParserTask(this, mAdapter);
		task.setRsslist(rsslist);
		task.execute("");
  	}
}
