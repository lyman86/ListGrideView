package com.example.listgridview.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.listgridview.bean.Mybean;

public class JsonUtils {
		public static List<Mybean> getMyJsonData(String url) throws MalformedURLException, IOException, JSONException{
			String jsonString = readStreamFromUrl(new URL(url).openStream());
			List<Mybean>list = new ArrayList<>();
			Mybean mybean;
			JSONObject jsonObject = new JSONObject(jsonString);
			JSONArray jsonArray = jsonObject.getJSONArray("data");
			for (int i = 0; i < jsonArray.length(); i++) {
				mybean = new Mybean();
				jsonObject = jsonArray.getJSONObject(i);
				mybean.imagePath = jsonObject.getString("picBig");
				mybean.imagePath2 = jsonObject.getString("picBig");
				mybean.imagePath3 = jsonObject.getString("picBig");
				mybean.imagePath4 = jsonObject.getString("picBig");
				list.add(mybean);
			}
			return list;
			
		}

		private static String readStreamFromUrl(InputStream is) throws IOException {
			StringBuffer stringBuffer = new StringBuffer();
			String line = "";
			InputStreamReader inputStreamReader = new InputStreamReader(is);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			while((line=bufferedReader.readLine())!=null){
				stringBuffer.append(line);
			}
			
			return stringBuffer.toString();
		}

}
