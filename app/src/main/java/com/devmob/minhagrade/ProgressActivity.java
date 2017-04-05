package com.devmob.minhagrade;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by devmob on 27/03/17.
 */

public class ProgressActivity extends AppCompatActivity {
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
//        Intent intent = getIntent();
//        String value =  intent.getStringExtra("MESSAGE");

//        Referencia de criação de elementos dinamicos no layout
//        Site: http://androidexample.com/Dynamically_Create_View_Elements__-_Android_Example/index.php?view=article_discription&aid=115

        final LinearLayout lm = (LinearLayout) findViewById(R.id.activity_progressbar);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        for (int i = 1; i<=9; i++){
            final int index = i;
            LinearLayout ll = new LinearLayout(this);
            ll.setOrientation(LinearLayout.HORIZONTAL);

            final Button btn = new Button(this);
            btn.setId(index);
            btn.setText(index+"º Periodo");

            btn.setLayoutParams(params);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("TAG", "index :" + index);

                    Toast.makeText(getApplicationContext(),"Clicked Button Index :" + index, Toast.LENGTH_LONG).show();
                }
            });

            ll.addView(btn);

            lm.addView(ll);
        }




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
//    public void addListenerButton(){
//        button = (Button)findViewById(R.id.periodo);
//        String msg =  (String) button.getText();
//        Toast.makeText(this,
//                "OnClickListener : " +
//                        "\n"+ msg,
//                Toast.LENGTH_SHORT).show();
//
//    }
}
