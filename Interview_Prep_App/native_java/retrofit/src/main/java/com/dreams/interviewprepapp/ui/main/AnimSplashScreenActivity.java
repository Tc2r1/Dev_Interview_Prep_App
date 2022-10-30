package com.dreams.interviewprepapp.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.dreams.interviewprepapp.R;

public class AnimSplashScreenActivity extends AppCompatActivity {
    // declare Lottie animation view
    LottieAnimationView lottieAnimationView;
    TextView appNameTv;
    private static  int SPLASH_TIME=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_splash_screen);

        lottieAnimationView=findViewById(R.id.lottie);
        appNameTv=findViewById(R.id.appName);

        //custom animation speed and duration
        lottieAnimationView.animate().translationY(1400).setDuration(800).setStartDelay(2000);
        appNameTv.animate().translationY(1800).setDuration(800).setStartDelay(2000);
       //code inside in the postDelayed method executed after the SPLASH_TIME is passed
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Intent for screen transition from one activity to another
                Intent intent=new Intent(AnimSplashScreenActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIME);
    }
}