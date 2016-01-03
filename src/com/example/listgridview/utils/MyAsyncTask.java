package com.example.listgridview.utils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.json.JSONException;

import com.example.listgridview.R;
import com.example.listgridview.adapter.MyAdapter;
import com.example.listgridview.bean.Mybean;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;

public class MyAsyncTask extends AsyncTask<String, Void, List<Mybean>> {
	private ListView listview;
	private Context context;

	public MyAsyncTask(ListView listview,Context context) {
		this.listview = listview;
		this.context =context;
	}

	@Override
	protected List<Mybean> doInBackground(String... params) {
		
		try {
			return JsonUtils.getMyJsonData(params[0]);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	protected void onPostExecute(List<Mybean> result) {
		super.onPostExecute(result);
		listview.setAdapter(new MyAdapter(context, result, R.layout.item_list));
	}

}
