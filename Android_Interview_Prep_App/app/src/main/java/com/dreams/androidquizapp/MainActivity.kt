package com.dreams.androidquizapp

// import com.dreams.androidquizapp.controllers.AnswersController.answers
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dreams.androidquizapp.controllers.AnswersController
import com.dreams.androidquizapp.controllers.QuestionsController
import com.dreams.androidquizapp.fragments.QuestionFragment
import com.dreams.androidquizapp.models.Answer
import com.dreams.androidquizapp.models.Question
import kotlinx.coroutines.*
import java.util.*







class MainActivity : AppCompatActivity(), OnFragmentInteractionListener {
    private val TAG = "MAINTEST"
    // Static Variables
    private val QUIZ_SIZE = 4
    // UI Variables
    private var fragContainer: LinearLayout? = null
    private var titleTv: TextView? = null
    private var scoreTv: TextView? = null

    // Fragments and Model Variables
    private var newFragment: QuestionFragment? = null
    private var quizList: ArrayList<Question>? = null
    private var testList: ArrayList<Question>? = null
    private var answersList: ArrayList<Answer>? = null
    private lateinit var selectedQuestion: BooleanArray

    // Variables
    private var random: Random? = null
    private var currentQuestion = 0
    private var numOfCorrect = 0
    private var scorePer = 0
    private var pointPerQ = 0.0
    private var score = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initalize and assignments
        titleTv = findViewById(R.id.title_tv) as TextView
        scoreTv = findViewById(R.id.score_tv) as TextView
        testList = ArrayList()
        quizList = ArrayList()
        answersList = ArrayList()
        random = Random()

        val job = Job()
        val coroutineScope = CoroutineScope(Dispatchers.IO + job)
        val coroutineExceptionHandler = CoroutineExceptionHandler{_, throwable ->
            throwable.printStackTrace()
        }

        coroutineScope.launch(Dispatchers.IO) {
            answersList = AnswersController().getTheAnswers()
            quizList = QuestionsController().getQuestions()
            createQuiz()
        }
    }

    private suspend fun createQuiz() {
        delay(1000)
        Log.i(TAG, "QuestionList is: " + quizList!!.size)
        Log.i(TAG, "AnswerList is: " + answersList!!.size)
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
            newFragment = QuestionFragment.newInstance(testList!![currentQuestion], answersList!!)
            currentQuestion++
            titleTv!!.text = getString(R.string.question_display_text) + Integer.toString(
                currentQuestion
            ) + " of " + Integer.toString(QUIZ_SIZE)
            fragContainer = findViewById(R.id.fragment_container) as LinearLayout
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(fragContainer!!.id, newFragment!!)
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

    override fun fragmentInitialized() { }
}