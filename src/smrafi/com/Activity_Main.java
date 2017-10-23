package smrafi.com;

import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_Main extends Activity {
    
	// IDs of all the numeric buttons
    private int[] numericButtons = {R.id.button_0, R.id.button_1, R.id.button_2, R.id.button_3, R.id.button_4, R.id.button_5, R.id.button_6, R.id.button_7, R.id.button_8, R.id.button_9};
    // IDs of all the operator buttons
    private int[] operatorButtons = {R.id.button_add, R.id.button_subtract, R.id.button_multiply, R.id.button_divide};
    // Object of input Display
    private TextView inputTextView;
    //Object of output Display
    private TextView displayTextView;
    // Represent that current state is in error or not
    private boolean stateError;
    // Represent whether the lastly pressed key is numeric or not
    private boolean lastNumeric;
	
	//This method is called on creation
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        stateError = true;
    }
    
    
    //This method is called on start
    @Override
    public void onStart() {
        super.onStart();
    }
    
    
    //This method is called on resume (User can interact in this state)
    @Override
    public void onResume() {
        super.onResume();
        setContentView(R.layout.main);
        
        inputTextView = (TextView)findViewById(R.id.input_text);
        displayTextView = (TextView)findViewById(R.id.display_text);
        
        setNumericOnClickListener();
    }
    
    
    //This method is called on pause (User pausing the app)
    @Override
    public void onPause() {
        super.onPause();
    }
    
    
    //This method is called on stop (sometimes pause state direct an app to this state)
    @Override
    public void onStop() {
        super.onStop();
    }
    
    
    //This method is called on Restart (Restart comes if stopped and again wanted to start)
    @Override
    public void onRestart() {
        super.onRestart();
    }
    
    
    //This method is called on Destroy (completely destroying the app (stop debugging or uninstall app))
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    
    /**
     * Find and set OnClickListener to numeric buttons.
     */
    private void setNumericOnClickListener() {
    	
        View.OnClickListener listener = new  View.OnClickListener() {
			
			public void onClick(View v) {
				
				TextView textView = (TextView) v;
				Toast.makeText(getApplicationContext(), textView.getText().toString(),
						   Toast.LENGTH_LONG).show();
				if(stateError) {
					inputTextView.setText(textView.getText().toString());
					stateError = false;
				} else {
					inputTextView.setText(inputTextView.getText().toString() + textView.getText().toString());
				}
				lastNumeric = true;
			}
		};
		
		 for (int id : numericButtons) {
	            findViewById(id).setOnClickListener(listener);
	     }
    }
    
}