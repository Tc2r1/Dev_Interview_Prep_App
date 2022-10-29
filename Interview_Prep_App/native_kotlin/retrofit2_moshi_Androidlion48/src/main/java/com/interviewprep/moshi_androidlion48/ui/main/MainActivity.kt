package com.interviewprep.moshi_androidlion48.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.interviewprep.kotlinretrofit.util.OnFragmentInteractionListener
import com.interviewprep.moshi_androidlion48.R
import com.interviewprep.moshi_androidlion48.repository.models.Answer
import com.interviewprep.moshi_androidlion48.repository.models.Question
import com.interviewprep.moshi_androidlion48.repository.tc2rgithubrepository.Tc2rGithubRepository
import com.interviewprep.moshi_androidlion48.ui.questions.DialogFragment
import com.interviewprep.moshi_androidlion48.ui.questions.QuestionFragment
import com.interviewprep.moshi_androidlion48.ui.score.ScoreActivity
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

// fixme: (Optional) Use Databinding, Dependency Injection, or ViewBinding to refactor this fragment.
class MainActivity : AppCompatActivity(), OnFragmentInteractionListener {
    private val TAG = "MAINTEST"

    companion object {
        // Static Variables
        private const val QUIZ_SIZE = 5
    }

    private val tc2rGithubRepository: Tc2rGithubRepository by lazy {
        Tc2rGithubRepository()
    }

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

        // Initialize and assignments
        titleTv = findViewById(R.id.title_tv)
        scoreTv = findViewById(R.id.score_tv)
        testList = ArrayList()
        quizList = ArrayList()
        answersList = ArrayList()
        random = Random()

        // FIXME: Call the below code off of the main thread in order not to freeze the main thread
        //  while information is being retrieved.
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            Log.e("Tc2r1", throwable.message.toString())
        }

        lifecycleScope.launch(coroutineExceptionHandler) {
            answersList = ArrayList(tc2rGithubRepository.getAndroidAnswers().body()?.answers ?: emptyList())
            quizList = ArrayList(tc2rGithubRepository.getAndroidQuestions().body()?.questions ?: emptyList())

            launch(Dispatchers.Main) {
                createQuiz()
            }
        }
    }

    private fun createQuiz() {
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

    fun showDetails(answer: Answer, isAnswerCorrect: Boolean) {
        // Show a details dialog fragment on top of the current screen.
        val dialogFragment = DialogFragment.newInstance(
            answer = answer,
            func = {
                // after user dismisses the dialogFragment, move on to the next question.
                nextQuestion(isAnswerCorrect)
            }
        )
        dialogFragment.show(supportFragmentManager, "details")
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
            newFragment = QuestionFragment.newInstance(testList!![currentQuestion], answersList!!)
            currentQuestion++
            titleTv!!.text = getString(com.tc2r.sharedresources.R.string.question_display_text) + Integer.toString(currentQuestion) + " of " + Integer.toString(QUIZ_SIZE)
            fragContainer = findViewById(R.id.fragment_container)
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

    override fun fragmentInitialized() {}
}
