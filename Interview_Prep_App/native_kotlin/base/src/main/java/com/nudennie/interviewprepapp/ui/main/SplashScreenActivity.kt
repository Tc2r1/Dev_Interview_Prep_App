package com.nudennie.interviewprepapp.ui.main

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.nudennie.interviewprepapp.R

class SplashScreenActivity : AppCompatActivity() {

    // This holds the time in milisec for the splash screen display
    val screenTimer = 4000L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        Handler().postDelayed(Runnable { // This method executes once timer has ended



            // Starting app main activity
            val i = Intent(this@SplashScreenActivity, MainActivity::class.java)
            startActivity(i)

            // Closing this activity
            finish()

        }, screenTimer)
    }
}
