package com.buginthecode.witchname;

import com.buginthecode.witchname.R;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	static EditText firstName;
	static EditText lastName;
	static TextView witchName;
	static TextView outputName;
	static Button goButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
			.add(R.id.container, new PlaceholderFragment())
			.commit();
		}
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_main, container, false);
			return rootView;
		}
	}

	public void displayName(View view) {
		InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE); 
		inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
		firstName = (EditText) findViewById(R.id.editText1);
		lastName = (EditText) findViewById(R.id.editText2);
		witchName = (TextView) findViewById(R.id.textView3);
		outputName = (TextView) findViewById(R.id.textView4);
		goButton = (Button) findViewById(R.id.button1);
		Typeface font = Typeface.createFromAsset(getAssets(), "Chantelli_Antiqua.ttf");
		witchName.setVisibility(TextView.INVISIBLE);
		outputName.setText(" ");
		if(firstName.getText().toString().length() == 0 || lastName.getText().toString().length() == 0) {
			Toast.makeText(getApplicationContext(), "Invalid input!", Toast.LENGTH_SHORT).show();
		}
		else {
			char first = firstName.getText().toString().toLowerCase().charAt(firstName.getText().toString().length()-1);
			char last = lastName.getText().toString().toLowerCase().charAt(0);
			String output = getWitchName(first, last);
			witchName.setVisibility(TextView.VISIBLE);
			outputName.setTextColor(Color.RED);
			outputName.setTypeface(font);
			outputName.setText(output);
		}
	}

	static String getWitchName(char first, char last) {
		StringBuffer str = new StringBuffer();
		switch(first) {
		case 'a' : str.append("Cursed");break;
		case 'b' : str.append("Spellbound");break;
		case 'c' : str.append("Amber");break;
		case 'd' : str.append("Magic");break;
		case 'e' : str.append("Mystic");break;
		case 'f' : str.append("Charmed");break;
		case 'g' : str.append("Crescent");break;
		case 'h' : str.append("Sorcerous");break;
		case 'i' : str.append("Arcane");break;
		case 'j' : str.append("Cryptic");break;
		case 'k' : str.append("Secret");break;
		case 'l' : str.append("Transcendant");break;
		case 'm' : str.append("Divine");break;
		case 'n' : str.append("Entranced");break;
		case 'o' : str.append("Ensnared");break;
		case 'p' : str.append("Seductive");break;
		case 'q' : str.append("Wise");break;
		case 'r' : str.append("Sensual");break;
		case 's' : str.append("Blessed");break;
		case 't' : str.append("Bewitched");break;
		case 'u' : str.append("Conjured");break;
		case 'v' : str.append("Dazed");break;
		case 'w' : str.append("Fiery");break;
		case 'x' : str.append("Enigmatic");break;
		case 'y' : str.append("Mysterious");break;
		case 'z' : str.append("Darkest");break;
		}
		str.append(" ");
		switch(last) {
		case 'a' : str.append("Soul");break;
		case 'b' : str.append("Enchantress");break;
		case 'c' : str.append("Wench");break;
		case 'd' : str.append("Powers");break;
		case 'e' : str.append("Wand");break;
		case 'f' : str.append("Fortune");break;
		case 'g' : str.append("Illusion");break;
		case 'h' : str.append("Spell");break;
		case 'i' : str.append("Fascination");break;
		case 'j' : str.append("Prediction");break;
		case 'k' : str.append("Craft");break;
		case 'l' : str.append("Obsession");break;
		case 'm' : str.append("Magnetism");break;
		case 'n' : str.append("Sorcery");break;
		case 'o' : str.append("Glamor");break;
		case 'p' : str.append("Charm");break;
		case 'q' : str.append("Embrace");break;
		case 'r' : str.append("Light");break;
		case 's' : str.append("Seeker");break;
		case 't' : str.append("Healer");break;
		case 'u' : str.append("Sacrifice");break;
		case 'v' : str.append("Luck");break;
		case 'w' : str.append("Caster");break;
		case 'x' : str.append("Trickster");break;
		case 'y' : str.append("Ecstacy");break;
		case 'z' : str.append("Sphinx");break;
		}
		return str.toString();
	}
}
