package com.nudennie.interviewprepapp

// import com.nudennie.interviewprepapp.controllers.AnswersController.answers
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.nudennie.interviewprepapp.controllers.AnswersController
import com.nudennie.interviewprepapp.controllers.QuestionsController
import com.nudennie.interviewprepapp.fragments.QuestionFragment
import com.nudennie.interviewprepapp.models.Answer
import com.nudennie.interviewprepapp.models.Question
import java.util.Random

class MainActivity : AppCompatActivity(), OnFragmentInteractionListener {
    // UI Variables
    private var fragContainer: LinearLayout? = null
    private var titleTv: TextView? = null
    private var scoreTv: TextView? = null

    // Fragments and Model Variables
    private var newFragment: QuestionFragment? = null
    private var quizList: ArrayList<Question>? = null
    private var testList: ArrayList<Question>? = null
    private var answersList: ArrayList<Answer?>? = null
    private lateinit var selectedQuestion: BooleanArray

    // Variables
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
        setContentView(R.layout.activity_main)

        // Initalize and assignments
        titleTv = findViewById<TextView>(R.id.title_tv)
        scoreTv = findViewById<TextView>(R.id.score_tv)
        testList = ArrayList()
        quizList = ArrayList()
        answersList = ArrayList()
        random = Random()

        // get Wrong answers from server
        answers
        questions
        createQuiz()
    }

    val answers: Unit
        get() {
            answersController = AnswersController()
            answersList = answersController?.answers
        }
    val questions: Unit
        get() {
            questionsController = QuestionsController()
            quizList = questionsController!!.questions
        }

    private fun createQuiz() {
        Log.wtf(" Size: ", "QuestionList is: " + quizList!!.size)
        Log.wtf(" Size: ", "AnswerList is: " + answersList!!.size)
        // set booleanArray to be same size as quizList
        selectedQuestion = BooleanArray(quizList!!.size)

        // set an int to a random number in the quizList
        var randNum = random!!.nextInt(quizList!!.size)
        var i = 0

        // sets the score system for quiz.
        // TODO: 5/31/2017 maybe remove this and simply divide correct answers by total questions
        pointPerQ = 1.0 / QUIZ_SIZE
        while (i < QUIZ_SIZE) {
            // Log.wtf("testList Size: ", String.valueOf(testList.size()) + " Vs "+ String.valueOf(quizSize) );
            // if boolean at randNum in selectedQuestion is false
            if (!selectedQuestion[randNum]) {
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

    fun nextQuestion(correctAnswer: Boolean) {
        // if previous question was answered correctly
        // update variables accordingly.
        if (correctAnswer) {
            numOfCorrect++
            score += pointPerQ
            scorePer = (score * 100).toInt()
            scoreTv!!.text = getString(R.string.score_display_text) + scorePer.toString()
        }
        // if quiz is not complete, continue quiz with new QuestionFragment
        if (currentQuestion < QUIZ_SIZE) {
            newFragment = QuestionFragment.newInstance(testList!![currentQuestion], answersList)
            currentQuestion++
            titleTv!!.text = getString(R.string.question_display_text) + Integer.toString(
                currentQuestion
            ) + " of " + Integer.toString(QUIZ_SIZE)
            fragContainer = findViewById<LinearLayout>(R.id.fragment_container)
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

    companion object {
        // Static Variables
        private const val QUIZ_SIZE = 4
    }
}
