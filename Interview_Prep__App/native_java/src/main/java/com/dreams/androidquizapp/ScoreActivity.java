package com.dreams.androidquizapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by Tc2r on 5/31/2017.
 * <p>
 * Description: Displays the score after a quiz is taken.
 */

public class ScoreActivity extends AppCompatActivity{
	// UI Variables
	private TextView totalQuestionsTV, totalCorrectTV, finalGradeTV, commentTV;

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
		if (extras != null){

			// Assign Extras
			scorePer = extras.getInt("scorePercentage", 0);
			quizSize = extras.getInt("quizSize", 0);
			numCorrect = extras.getInt("numCorrect", 0);
		}
		setContentView(R.layout.activity_score);

		// Assign/initiate variables
		totalQuestionsTV = (TextView) findViewById(R.id.numofquestions_tv);
		commentTV = (TextView) findViewById(R.id.comment_tv);
		totalCorrectTV = (TextView) findViewById(R.id.numcorrect_tv);
		finalGradeTV = (TextView) findViewById(R.id.finalgrade_tv);


		//Set UI Objects Text values
		totalQuestionsTV.setText("There were "+ quizSize + " Questions.");
		totalCorrectTV.setText("Correct Answers: "+ numCorrect);
		finalGradeTV.setText(scorePer + "%");

		if(scorePer >= 80) {
			finalGradeTV.setTextColor(Color.GREEN);
			commentTV.setTextColor(Color.GREEN);
			commentTV.setText("OMEGA GOOD JOB!");
		}else if(scorePer > 50 && scorePer < 79){
			finalGradeTV.setTextColor(Color.YELLOW);
			commentTV.setTextColor(Color.YELLOW);
			commentTV.setText("YOU'RE ALMOST THERE!");
		}else{
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
