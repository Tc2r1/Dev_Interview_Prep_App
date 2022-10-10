package com.nudennie.interviewprepapp.ui.score

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.nudennie.interviewprepapp.R.id
import com.nudennie.interviewprepapp.R.layout
import com.nudennie.interviewprepapp.ui.main.MainActivity

/**
 * Created by Tc2r on 5/31/2017.
 *
 *
 * Description: Displays the score after a quiz is taken.
 */
class ScoreActivity : AppCompatActivity() {
    // UI Variables
    private var totalQuestionsTV: TextView? = null
    private var totalCorrectTV: TextView? = null
    private var finalGradeTV: TextView? = null
    private var commentTV: TextView? = null

    // Extras Variables
    private var numCorrect = 0
    private var quizSize = 0
    private var scorePer = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Get Extras from intent
        val extras = intent.extras

        // Check if null
        if (extras != null) {
            // Assign Extras
            scorePer = extras.getInt("scorePercentage", 0)
            quizSize = extras.getInt("quizSize", 0)
            numCorrect = extras.getInt("numCorrect", 0)
        }
        setContentView(layout.activity_score)

        // Assign/initiate variables
        totalQuestionsTV = findViewById<TextView>(id.numofquestions_tv)
        commentTV = findViewById<TextView>(id.comment_tv)
        totalCorrectTV = findViewById<TextView>(id.numcorrect_tv)
        finalGradeTV = findViewById<TextView>(id.finalgrade_tv)

        // Set UI Objects Text values
        totalQuestionsTV!!.text = "There were $quizSize Questions."
        totalCorrectTV!!.text = "Correct Answers: $numCorrect"
        finalGradeTV!!.text = "$scorePer%"
        if (scorePer >= 80) {
            finalGradeTV!!.setTextColor(Color.GREEN)
            commentTV!!.setTextColor(Color.GREEN)
            commentTV!!.text = "OMEGA GOOD JOB!"
        } else if (scorePer > 50 && scorePer < 79) {
            finalGradeTV!!.setTextColor(Color.YELLOW)
            commentTV!!.setTextColor(Color.YELLOW)
            commentTV!!.text = "YOU'RE ALMOST THERE!"
        } else {
            finalGradeTV!!.setTextColor(Color.RED)
            commentTV!!.setTextColor(Color.RED)
            commentTV!!.text = "BETTER STUDY!"
        }
    }

    fun startOver(view: View?) {
        // Returns to MainActivity page.
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun closeApp(view: View?) {
        // Closes the App
        finishAffinity()
    }
}
