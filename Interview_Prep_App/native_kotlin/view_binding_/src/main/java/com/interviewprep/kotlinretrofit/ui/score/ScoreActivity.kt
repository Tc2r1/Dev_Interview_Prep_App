package com.interviewprep.kotlinretrofit.ui.score

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.interviewprep.kotlinretrofit.databinding.ActivityScoreBinding
import com.interviewprep.kotlinretrofit.ui.main.MainActivity

/**
 * Created by Tc2r on 5/31/2017.
 *
 *
 * Description: Displays the score after a quiz is taken.
 */
class ScoreActivity : AppCompatActivity() {
    // create a variable of Binding class to use in activity.
    private lateinit var binding: ActivityScoreBinding
    // UI Variables
    //No need to declare Ui variables since we are using ViewBinding

    // Extras Variables
    private var numCorrect = 0
    private var quizSize = 0
    private var scorePer = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Now initialize the binding class
        binding = ActivityScoreBinding.inflate(layoutInflater)
        // Get Extras from intent
        val extras = intent.extras

        // Check if null
        if (extras != null) {
            // Assign Extras
            scorePer = extras.getInt("scorePercentage", 0)
            quizSize = extras.getInt("quizSize", 0)
            numCorrect = extras.getInt("numCorrect", 0)
        }
        // Now get a reference of root view and pass it to setContentView()
        setContentView(binding.root)

        // Assign/initiate variables
        // use binding object to refer to views from root view
        val totalQuestionsTV = binding.numofquestionsTv
        val commentTV = binding.commentTv
        val totalCorrectTV = binding.numcorrectTv
        val finalGradeTV = binding.finalgradeTv

        val closeButton = binding.closeButton
        val restartButton = binding.restartButton
        closeButton.setOnClickListener {
            closeApp()
        }

        restartButton.setOnClickListener {
            startOver()
        }

        // Set UI Objects Text values
        totalQuestionsTV.text = "There were $quizSize Questions."
        totalCorrectTV.text = "Correct Answers: $numCorrect"
        finalGradeTV.text = "$scorePer%"
        if (scorePer >= 80) {
            finalGradeTV.setTextColor(Color.GREEN)
            commentTV.setTextColor(Color.GREEN)
            commentTV.text = "OMEGA GOOD JOB!"
        } else if (scorePer in 51..78) {
            finalGradeTV.setTextColor(Color.YELLOW)
            commentTV.setTextColor(Color.YELLOW)
            commentTV.text = "YOU'RE ALMOST THERE!"
        } else {
            finalGradeTV.setTextColor(Color.RED)
            commentTV.setTextColor(Color.RED)
            commentTV.text = "BETTER STUDY!"
        }
    }

    private fun startOver() {
        // Returns to MainActivity page.
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun closeApp() {
        // Closes the App
        finishAffinity()
    }
}
