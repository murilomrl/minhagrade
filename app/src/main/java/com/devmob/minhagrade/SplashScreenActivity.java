package com.devmob.minhagrade;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity implements  Runnable{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Handler handler = new Handler();
        handler.postDelayed(this,2000);

    }

    @Override
    public void run() {
        Intent intent = new Intent(SplashScreenActivity.this, CourseActivity.class);
        startActivity(intent);
        finish();
    }
}
