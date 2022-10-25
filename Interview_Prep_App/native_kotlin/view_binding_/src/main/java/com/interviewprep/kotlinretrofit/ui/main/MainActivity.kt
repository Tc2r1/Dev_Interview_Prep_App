package com.interviewprep.kotlinretrofit.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.interviewprep.kotlinretrofit.databinding.ActivityMainBinding
import com.interviewprep.kotlinretrofit.repository.models.Answer
import com.interviewprep.kotlinretrofit.repository.models.Question
import com.interviewprep.kotlinretrofit.repository.tc2rgithubrepository.Tc2rGithubRepository
import com.interviewprep.kotlinretrofit.ui.questions.DialogFragment
import com.interviewprep.kotlinretrofit.ui.questions.QuestionFragment
import com.interviewprep.kotlinretrofit.ui.score.ScoreActivity
import com.interviewprep.kotlinretrofit.util.OnFragmentInteractionListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Random

class MainActivity : AppCompatActivity(), OnFragmentInteractionListener {
   // first create a variable of Binding class to use in activity.
    private lateinit var binding: ActivityMainBinding
    private val TAG = "MAINTEST"

    companion object {
        // Static Variables
        private const val QUIZ_SIZE = 10
    }

    private val tc2rGithubRepository: Tc2rGithubRepository by lazy {
        Tc2rGithubRepository()
    }

    // UI Variables
    // There is no need to declare ui variable since we are using View Binding

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
        // Now initialize the binding class
        binding = ActivityMainBinding.inflate(layoutInflater)
        // Now get a reference of root view and pass it to setContentView()
        setContentView(binding.root)

        // Initialize and assignments
        testList = ArrayList()
        quizList = ArrayList()
        answersList = ArrayList()
        random = Random()

        lifecycleScope.launch(Dispatchers.IO) {
            answersList = tc2rGithubRepository.getTheAnswers()
            quizList = tc2rGithubRepository.getQuestions()
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

    fun nextQuestion(correctAnswer: Boolean) {
        // if previous question was answered correctly
        // update variables accordingly.
        if (correctAnswer) {
            numOfCorrect++
            score += pointPerQ
            scorePer = (score * 100).toInt()
            // simply use binding object to refer scoreTv TextView
            binding.scoreTv.text = getString(com.tc2r.sharedresources.R.string.score_display_text) + scorePer.toString()
        }
        // if quiz is not complete, continue quiz with new QuestionFragment
        if (currentQuestion < QUIZ_SIZE) {
            newFragment = QuestionFragment.newInstance(testList!![currentQuestion], answersList!!)
            currentQuestion++
            // use binding object to refer titleTv TextView
           binding.titleTv.text = getString(com.tc2r.sharedresources.R.string.question_display_text) + Integer.toString(currentQuestion) + " of " + Integer.toString(QUIZ_SIZE)
            // Used binding object to refer fragmentContainer LinearLayout
           val fragContainer = binding.fragmentContainer
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(fragContainer.id, newFragment!!)
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
