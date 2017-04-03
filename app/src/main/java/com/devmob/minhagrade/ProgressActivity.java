package com.devmob.minhagrade;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by devmob on 27/03/17.
 */

public class ProgressActivity extends Activity{
    TextView text;
    private Button button;


    private static final int PROGRESS = 0x1;

    private ProgressBar mProgress;
    private int mProgressStatus = 0;

    private Handler mHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_progress);
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String value =  intent.getStringExtra("MESSAGE");
        


        //text = (TextView)findViewById(R.id.textView);
        //text.setText(value);




//        mProgress = (ProgressBar) findViewById(R.id.progressBar);

        //Start lengthy operation in a background thread
//        new Thread(new Runnable() {
//            public void run() {
//                while (mProgressStatus < 100) {
//                    mProgressStatus = 1;
//
//                    // Update the progress bar
//                    mHandler.post(new Runnable() {
//                        public void run() {
//                            mProgress.setProgress(mProgressStatus);
//                        }
//                    });
//                }
//            }
//        }).start();
    }
    public void addListenerButton(){
        button = (Button)findViewById(R.id.periodo);
        String msg =  (String) button.getText();
        Toast.makeText(this,
                "OnClickListener : " +
                        "\n"+ msg,
                Toast.LENGTH_SHORT).show();

    }
}
