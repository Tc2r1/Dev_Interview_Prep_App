package com.dreams.interviewprepapp.ui.main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

import com.dreams.interviewprepapp.R;

@SuppressLint("CustomSplashScreen")
public class SplashScreenActivity extends AppCompatActivity {
    // Time for which the Splash Screen is to be displayed (in Milliseconds)
    long screenTimer = 4000L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        // Using Handlers to show the Splash Screen, passing a lambda to the postDelayed method call
        // which will be executed after the time passed to the postDelayed method (screenTimer ) has elapsed
        new Handler().postDelayed(() -> {
            // Using Intent for activity transition from SplashScreenActivity to MainActivity
            Intent i = new Intent(SplashScreenActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        }, screenTimer);
    }
}
