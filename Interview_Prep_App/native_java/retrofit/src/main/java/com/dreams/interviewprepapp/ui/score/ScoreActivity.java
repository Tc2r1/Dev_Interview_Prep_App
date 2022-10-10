package com.dreams.interviewprepapp.ui.score;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.dreams.interviewprepapp.R;
import com.dreams.interviewprepapp.ui.main.MainActivity;

/**
 * Created by Tc2r on 5/31/2017.
 * <p>
 * Description: Displays the score after a quiz is taken.
 */

public class ScoreActivity extends AppCompatActivity {

    // Extras Variables
    private int numCorrect;
    private int quizSize;
    private int scorePer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get Extras from intent
        Bundle extras = getIntent().getExtras();

        // Check if null
        if(extras != null) {

            // Assign Extras
            scorePer = extras.getInt("scorePercentage", 0);
            quizSize = extras.getInt("quizSize", 0);
            numCorrect = extras.getInt("numCorrect", 0);
        }
        setContentView(R.layout.activity_score);

        // Assign/initiate variables
        // UI Variables
        android.widget.TextView totalQuestionsTV = findViewById(com.dreams.interviewprepapp.R.id.numofquestions_tv);
        android.widget.TextView commentTV = findViewById(com.dreams.interviewprepapp.R.id.comment_tv);
        android.widget.TextView totalCorrectTV = findViewById(com.dreams.interviewprepapp.R.id.numcorrect_tv);
        android.widget.TextView finalGradeTV = findViewById(com.dreams.interviewprepapp.R.id.finalgrade_tv);


        //Set UI Objects Text values
        totalQuestionsTV.setText("There were " + quizSize + " Questions.");
        totalCorrectTV.setText("Correct Answers: " + numCorrect);
        finalGradeTV.setText(scorePer + "%");

        if(scorePer >= 80) {
            finalGradeTV.setTextColor(Color.GREEN);
            commentTV.setTextColor(Color.GREEN);
            commentTV.setText("OMEGA GOOD JOB!");
        } else if(scorePer > 50 && scorePer < 79) {
            finalGradeTV.setTextColor(Color.YELLOW);
            commentTV.setTextColor(Color.YELLOW);
            commentTV.setText("YOU'RE ALMOST THERE!");
        } else {
            finalGradeTV.setTextColor(Color.RED);
            commentTV.setTextColor(Color.RED);
            commentTV.setText("BETTER STUDY!");
        }
    }

    public void startOver(View view) {
        // Returns to MainActivity page.
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void closeApp(View view) {
        // Closes the App
        finishAffinity();
    }
}
