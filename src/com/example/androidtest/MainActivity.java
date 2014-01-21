package com.example.androidtest;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.HttpURLConnection;

public class MainActivity extends Activity {
	private final String name="info";
	private final int value =10;
	private final String targetURL="http://www.baidu.com";
	private TextView textView;
	private boolean isWiFiConected;
	private boolean isMobileConected;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		SharedPreferences sharedPreferences=this.getSharedPreferences(name, this.MODE_PRIVATE);
		SharedPreferences.Editor editor =sharedPreferences.edit();
		editor.putInt("Integer", value);
		editor.commit();
		textView=(TextView)findViewById(R.id.textView);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	/**
	 * 回传数据
	 * @param view
	 */
	public void sendMessageHandler(View view){
		isMobileConected=false;
		isWiFiConected=false;
		
	        ConnectivityManager connMgr = (ConnectivityManager) 
	            getSystemService(Context.CONNECTIVITY_SERVICE);
	        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
	        if (networkInfo != null && networkInfo.isConnected()) {
	        	//wifi
	            if(networkInfo.getTypeName().equals("WIFI")){
	            	sendMessageWithWIFI();
	            	textView.setText("wifi is availble");
	            }
	            //mobile
	            else{
	            	sendMessageWithMobile();
	            	textView.setText("moblie is avaliable");
	            }
	        } else {
	            textView.setText("No network connection available.");
	        }
	}
	public int sendMessageWithWIFI(){
		
		return 1;
	}
	public int sendMessageWithMobile(){
		 return 1;
	}
}
