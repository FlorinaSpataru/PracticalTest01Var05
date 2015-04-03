package ro.pub.cs.systems.pdsd.practicaltest01var05;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var05MainActivity extends Activity {
	
	private final static String TAG = "PracticalTest01Var05MainActivity";
	private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;
	private ButtonClickListener buttonClickListener = new ButtonClickListener();
	private int numberClicked = 0;
	 
	  private class ButtonClickListener implements Button.OnClickListener {
	 
		  @Override
		  public void onClick(View v) {
			  	TextView textView = (TextView)PracticalTest01Var05MainActivity.this.findViewById(R.id.TextView1);
			  	String str;
	 
			  	switch(v.getId()) {
			  		case R.id.north_button:
			  			numberClicked++;
			  			str = (String) textView.getText();
			  			if (str.isEmpty())
			  				textView.setText(str + "North");
			  			else
			  				textView.setText(str + ", North");
			  			break;
			  		case R.id.west_button:
			  			numberClicked++;
			  			str = (String) textView.getText();
			  			if (str.isEmpty())
			  				textView.setText(str + "West");
			  			else
			  				textView.setText(str + ", West");
			  			break;
			  		case R.id.east_button:
			  			numberClicked++;
			  			str = (String) textView.getText();
			  			if (str.isEmpty())
			  				textView.setText(str + "East");
			  			else
			  				textView.setText(str + ", East");
			  			break;
			  		case R.id.south_button:
			  			numberClicked++;
			  			str = (String) textView.getText();
			  			if (str.isEmpty())
			  				textView.setText(str + "South");
			  			else
			  				textView.setText(str + ", South");
			  			break;
			  		case R.id.navigate_to_secondary_activity_button:
			  			Intent intent = new Intent("ro.pub.cs.systems.pdsd.intent.action.PracticalTest01Var05SecondaryActivity");
			  			intent.putExtra("number_of_clicks", numberClicked);
			  			startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
			            break;
			  	}
		  }

	} 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate() was invoked");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var05_main);
		
		if (savedInstanceState != null) {
			int clicked = savedInstanceState.getInt("saved_numberClicked");
			this.numberClicked = clicked;
		}
		
		Button northButton = (Button)findViewById(R.id.north_button);
		northButton.setOnClickListener(buttonClickListener);
		
		Button westButton = (Button)findViewById(R.id.west_button);
		westButton.setOnClickListener(buttonClickListener);
		
		Button eastButton = (Button)findViewById(R.id.east_button);
		eastButton.setOnClickListener(buttonClickListener);
		
		Button southButton = (Button)findViewById(R.id.south_button);
		southButton.setOnClickListener(buttonClickListener);
		
		Button secondaryActivity = (Button)findViewById(R.id.navigate_to_secondary_activity_button);
		secondaryActivity.setOnClickListener(buttonClickListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_var05_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	protected void onSaveInstanceState(Bundle savedInstanceState) {
		Log.d(TAG, "onSaveInstanceState() was invoked");
		savedInstanceState.putInt("saved_numberClicked", this.numberClicked);
	}
}
