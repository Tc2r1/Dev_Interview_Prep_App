package com.nudennie.interviewprepapp.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.nudennie.interviewprepapp.R.id
import com.nudennie.interviewprepapp.R.layout
import com.nudennie.interviewprepapp.controllers.AnswersController
import com.nudennie.interviewprepapp.controllers.QuestionsController
import com.nudennie.interviewprepapp.repositories.models.response.Answer
import com.nudennie.interviewprepapp.repositories.models.response.Question
import com.nudennie.interviewprepapp.ui.questions.DialogFragment
import com.nudennie.interviewprepapp.ui.questions.QuestionFragment
import com.nudennie.interviewprepapp.ui.score.ScoreActivity
import com.nudennie.interviewprepapp.util.OnFragmentInteractionListener
import java.util.Random

class MainActivity : AppCompatActivity(), OnFragmentInteractionListener {
    companion object {
        // Static Variables
        private const val QUIZ_SIZE = 4
    }

    // UI Variables
    private var fragContainer: LinearLayout? = null
    private var titleTv: TextView? = null
    private var scoreTv: TextView? = null

    // Variables
    private lateinit var answersList: ArrayList<Answer>

    private var newFragment: QuestionFragment? = null
    private var quizList: ArrayList<Question>? = null
    private var testList: ArrayList<Question>? = null
    private var random: Random? = null
    private var currentQuestion = 0
    private var numOfCorrect = 0
    private var scorePer = 0
    private var pointPerQ = 0.0
    private var score = 0.0
    private var questionsController: QuestionsController? = null
    private var answersController: AnswersController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        // Initialize and assignments
        titleTv = findViewById(id.title_tv)
        scoreTv = findViewById(id.score_tv)
        testList = ArrayList()
        quizList = ArrayList()
        answersList = ArrayList()
        random = Random()

        // get Wrong answers from server
        answers
        questions
        createQuiz()
    }

    private val answers: Unit
        get() {
            answersController = AnswersController()
            answersList = answersController!!.answers
        }
    private val questions: Unit
        get() {
            questionsController = QuestionsController()
            quizList = questionsController!!.questions
        }

    private fun createQuiz() {
        Log.i(" Size: ", "QuestionList is: " + quizList!!.size)
        Log.i(" Size: ", "AnswerList is: " + answersList.size)

        // set booleanArray to be same size as quizList
        val selectedQuestion = BooleanArray(quizList!!.size)

        // set an int to a random number in the quizList
        var randNum = random!!.nextInt(quizList!!.size)
        var i = 0

        // sets the score system for quiz.
        pointPerQ = 1.0 / QUIZ_SIZE
        while (i < QUIZ_SIZE) {
            // if boolean at randNum in selectedQuestion is false
            if (!selectedQuestion[randNum] && quizList!![randNum].questionType == "multi") {
                // Add position randNum to test list;
                testList!!.add(quizList!![randNum])
                // set this question selected to true.
                selectedQuestion[randNum] = true
                i++
            } else {
                // if question already selected, change randNum;
                randNum = random!!.nextInt(quizList!!.size)
            }
        }
        // On first run, start quiz without updating score
        nextQuestion(false)
    }

    fun showDetails(answer: Answer, isAnswerCorrect: Boolean) {
        // Show a details dialog fragment on top of the current screen.
        val detailsDialogFragment = DialogFragment(
            answer = answer,
            func = {
                // after user dismisses the dialogfragment, move on to next question.
                nextQuestion(isAnswerCorrect)
            }
        )
        detailsDialogFragment.show(supportFragmentManager, "details")
    }

    private fun nextQuestion(correctAnswer: Boolean) {
        // if previous question was answered correctly
        // update variables accordingly.
        if (correctAnswer) {
            numOfCorrect++
            score += pointPerQ
            scorePer = (score * 100).toInt()
            scoreTv!!.text = getString(com.tc2r.sharedresources.R.string.score_display_text) + scorePer.toString()
        }
        // if quiz is not complete, continue quiz with new QuestionFragment
        if (currentQuestion < QUIZ_SIZE) {
            newFragment = QuestionFragment.newInstance(testList!![currentQuestion], answersList)
            currentQuestion++
            titleTv!!.text = getString(com.tc2r.sharedresources.R.string.question_display_text) + currentQuestion.toString() + " of " + Integer.toString(QUIZ_SIZE)
            fragContainer = findViewById<LinearLayout>(id.fragment_container)
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(fragContainer!!.id, newFragment as Fragment)
            ft.commit()
        } else {
            // Quiz is over, go to final page!
            // create intent
            val intent = Intent(this, ScoreActivity::class.java)

            // add variables to send.
            intent.putExtra("scorePercentage", scorePer)
            intent.putExtra("quizSize", QUIZ_SIZE)
            intent.putExtra("numCorrect", numOfCorrect)

            // use intent.
            startActivity(intent)
        }
    }

    override fun fragmentInitialized() {}
}
