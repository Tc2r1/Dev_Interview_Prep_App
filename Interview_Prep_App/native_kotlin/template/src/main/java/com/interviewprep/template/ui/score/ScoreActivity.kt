package com.interviewprep.template.ui.score

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.interviewprep.template.R
import com.interviewprep.template.ui.main.MainActivity

/**
 * fixme: (Optional) Use Databinding, Dependency Injection, or ViewBinding to refactor this fragment.
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
        setContentView(R.layout.activity_score)

        // Assign/initiate variables
        totalQuestionsTV = findViewById(R.id.numofquestions_tv)
        commentTV = findViewById(R.id.comment_tv)
        totalCorrectTV = findViewById(R.id.numcorrect_tv)
        finalGradeTV = findViewById(R.id.finalgrade_tv)

        val closeButton = findViewById<Button>(R.id.close_button)
        val restartButton = findViewById<Button>(R.id.restart_button)
        closeButton.setOnClickListener {
            closeApp()
        }

        restartButton.setOnClickListener {
            startOver()
        }

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

    fun startOver() {
        // Returns to MainActivity page.
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun closeApp() {
        // Closes the App
        finishAffinity()
    }
}
