package ro.pub.cs.systems.pdsd.practicaltest01var05;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class PracticalTest01Var05SecondaryActivity extends Activity {

	private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;
	private ButtonClickListener buttonClickListener = new ButtonClickListener();
	 
	 private class ButtonClickListener implements Button.OnClickListener {
	 
		  @Override
		  public void onClick(View v) {
			  switch(v.getId()) {
			  		case R.id.navigate_to_secondary_activity_button:
			  			Intent intent = new Intent("ro.pub.cs.systems.pdsd.intent.action.PracticalTest01SecondaryActivity");
			  			startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
			  			break;
			  }
		  }
	}
	  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var05_secondary);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater()
				.inflate(R.menu.practical_test01_var05_secondary, menu);
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
}
