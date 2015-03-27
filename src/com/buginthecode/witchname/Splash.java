package com.buginthecode.witchname;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class Splash extends ActionBarActivity {
	
	static TextView title;
	static Typeface font; 
	static TextView author;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

		font = Typeface.createFromAsset(getAssets(), "Chantelli_Antiqua.ttf");
		
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}

		
		final Intent i = new Intent(this, MainActivity.class);
		
		Handler handler = new Handler();
		class RefreshRunnable implements Runnable{
			public RefreshRunnable(){
			}
			public void run(){
				startActivity(i);
			}
		};
		RefreshRunnable r = new RefreshRunnable();
		handler.postDelayed(r, 5000);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.splash, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		
		if (id == R.id.action_about) {
			Intent i = new Intent(this, About.class);
			startActivity(i);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_splash,
					container, false);
			title = (TextView) rootView.findViewById(R.id.textView1);
			author = (TextView) rootView.findViewById(R.id.textView2);
			title.setTypeface(font);
			title.setTextColor(Color.RED);
			author.setTextColor(Color.WHITE);
			return rootView;
		}
	}

}
