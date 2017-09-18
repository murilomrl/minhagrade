package com.devmob.minhagrade;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import static java.lang.Thread.sleep;

public class SplashScreenActivity extends AppCompatActivity implements Animation.AnimationListener {

    Thread splashThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final ImageView imageView = (ImageView) findViewById(R.id.logoDevmob);
        final Animation animation = AnimationUtils.loadAnimation(getBaseContext(),R.anim.alpha);
        imageView.startAnimation(animation);
        animation.setAnimationListener(this);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Intent intent = new Intent(SplashScreenActivity.this, CourseActivity.class);
        ActivityOptionsCompat opts = ActivityOptionsCompat.makeCustomAnimation(SplashScreenActivity.this,R.anim.alpha,R.anim.reverse_alpha);
        ActivityCompat.startActivity(this,intent,opts.toBundle());
        finish();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
