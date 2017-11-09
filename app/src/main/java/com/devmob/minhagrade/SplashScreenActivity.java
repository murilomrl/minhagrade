package com.devmob.minhagrade;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.devmob.minhagrade.Model.Prefs;

import static java.lang.Thread.sleep;

public class SplashScreenActivity extends AppCompatActivity implements Animation.AnimationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        final ImageView imageView = (ImageView) findViewById(R.id.logoDevmob);
        final Animation animationBegin = AnimationUtils.loadAnimation(getBaseContext(),R.anim.alpha);
        animationBegin.setDuration(1500);
        imageView.startAnimation(animationBegin);
        animationBegin.setAnimationListener(this);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Intent intent;
        if (Prefs.getString(this,"course").isEmpty()) {
            intent = new Intent(SplashScreenActivity.this, CourseActivity.class);
        }
        else {
            intent = new Intent(SplashScreenActivity.this, HomeActivity.class);
        }
        ActivityOptionsCompat opts = ActivityOptionsCompat.makeCustomAnimation(SplashScreenActivity.this,R.anim.alpha,R.anim.reverse_alpha);
        ActivityCompat.startActivity(this,intent,opts.toBundle());
        finish();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
