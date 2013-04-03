package com.json.php;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class JSONExampleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost("http://superserial.web.engr.illinois.edu/androidTest.php");
        TextView textView = (TextView)findViewById(R.id.textView1);
		try {
			Log.i("string", "1");
			HttpResponse response = httpclient.execute(httppost);
			
			String jsonResult = inputStreamToString(response.getEntity().getContent()).toString();
			Log.i("string", jsonResult);
			JSONObject object = new JSONObject(jsonResult);
			

			String name = object.getString("output");
	    	String version = object.getString("version");
	    	textView.setText(name + " - " + version);
	    	
		} 
		catch (JSONException e) {
			e.printStackTrace();
		} 
		catch (ClientProtocolException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}


       }
    private StringBuilder inputStreamToString(InputStream is) {
        String rLine = "";
        StringBuilder answer = new StringBuilder();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
         
        try {
         while ((rLine = rd.readLine()) != null) {
          answer.append(rLine);
           }
        }
         
        catch (IOException e) {
            e.printStackTrace();
         }
        return answer;
       }
}
    	
        
        
