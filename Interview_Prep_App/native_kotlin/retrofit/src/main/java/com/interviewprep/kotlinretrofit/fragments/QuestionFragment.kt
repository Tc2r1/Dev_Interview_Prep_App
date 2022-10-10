package com.interviewprep.kotlinretrofit.fragments

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.interviewprep.kotlinretrofit.MainActivity
import com.interviewprep.kotlinretrofit.OnFragmentInteractionListener
import com.interviewprep.kotlinretrofit.R
import com.interviewprep.kotlinretrofit.models.Answer
import com.interviewprep.kotlinretrofit.models.Question
import java.util.Random

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [QuestionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuestionFragment : Fragment(), View.OnClickListener {
    // Declare UI Variables
    private var questionTV: TextView? = null
    private var detailsA: TextView? = null
    private var detailsB: TextView? = null
    private var detailsC: TextView? = null
    private var detailsD: TextView? = null
    private var answerA: TextView? = null
    private var answerB: TextView? = null
    private var answerC: TextView? = null
    private var answerD: TextView? = null

    // Declare Variables
    private var quizQuestion: String? = null
    private var quizAnswer: String? = null
    private var quizDetails: String? = null
    private var otherAnswers: ArrayList<Answer>? = null
    private var nextBtn: Button? = null
    private var newBtn: Button? = null
    private val answerCheck = BooleanArray(4)
    private var mListener: OnFragmentInteractionListener? = null
    private var keyPosition = 0
    private var answered = false
    private var correct = false
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mListener = if (context is OnFragmentInteractionListener) {
            context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Get Arguments from bundle
        if (arguments != null) {
            quizQuestion = requireArguments().getString(QUESTION)
            quizAnswer = requireArguments().getString(KEY)
            quizDetails = requireArguments().getString(DETAILS)
            otherAnswers = requireArguments().getParcelableArrayList(FILLANSWERS)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val mView = inflater.inflate(R.layout.fragment_question, container, false)

        // Assign Variables to Object Ids
        questionTV = mView.findViewById(R.id.question) as TextView
        answerA = mView.findViewById(R.id.answer_a_summary) as TextView
        detailsA = mView.findViewById(R.id.answer_a_details) as TextView
        answerB = mView.findViewById(R.id.answer_b_summary) as TextView
        detailsB = mView.findViewById(R.id.answer_b_details) as TextView
        answerC = mView.findViewById(R.id.answer_c_summary) as TextView
        detailsC = mView.findViewById(R.id.answer_c_details) as TextView
        answerD = mView.findViewById(R.id.answer_d_summary) as TextView
        detailsD = mView.findViewById(R.id.answer_d_details) as TextView
        nextBtn = mView.findViewById(R.id.nextBtn) as Button
        newBtn = mView.findViewById(R.id.newQuizBtn) as Button

        // Set Listeners
        nextBtn!!.setOnClickListener(this)
        newBtn!!.setOnClickListener(this)
        answerA!!.setOnClickListener(this)
        answerB!!.setOnClickListener(this)
        answerC!!.setOnClickListener(this)
        answerD!!.setOnClickListener(this)

        // Set the Question Text
        questionTV!!.text = quizQuestion

        // Create random and int for key positioning.
        val random = Random(System.currentTimeMillis())
        keyPosition = random.nextInt(4)
        when (keyPosition) {
            0 -> {
                answerA!!.text = quizAnswer
                detailsA!!.text = quizDetails
                answerCheck[0] = true
            }
            1 -> {
                answerB!!.text = quizAnswer
                detailsB!!.text = quizDetails
                answerCheck[1] = true
            }
            2 -> {
                answerC!!.text = quizAnswer
                detailsC!!.text = quizDetails
                answerCheck[2] = true
            }
            3 -> {
                answerD!!.text = quizAnswer
                detailsD!!.text = quizDetails
                answerCheck[3] = true
            }
        }
        var randomAnswer: Int
        for (j in answerCheck.indices) {
            // if position in answer check =/= true, fill with random answer
            if (!answerCheck[j]) {
                randomAnswer = random.nextInt(otherAnswers!!.size)
                when (j) {
                    0 -> {
                        answerA!!.text = otherAnswers!![randomAnswer].answer.toString()
                        detailsA!!.text = otherAnswers!![randomAnswer].details.toString()
                        answerCheck[0] = true
                    }
                    1 -> {
                        answerB!!.text = otherAnswers!![randomAnswer].answer.toString()
                        detailsB!!.text = otherAnswers!![randomAnswer].details.toString()
                        answerCheck[1] = true
                    }
                    2 -> {
                        answerC!!.text = otherAnswers!![randomAnswer].answer.toString()
                        detailsC!!.text = otherAnswers!![randomAnswer].details.toString()
                        answerCheck[2] = true
                    }
                    3 -> {
                        answerD!!.text = otherAnswers!![randomAnswer].answer.toString()
                        detailsD!!.text = otherAnswers!![randomAnswer].details.toString()
                        answerCheck[3] = true
                    }
                }
            }
        }
        return mView
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    override fun onClick(view: View) {
        // Switch statement for what is clicked.
        when (view.id) {
            R.id.nextBtn -> (activity as MainActivity).nextQuestion(correct)
            R.id.newQuizBtn -> {
                // start main Activity over
                val intent = Intent(activity, MainActivity::class.java)
                startActivity(intent)
                // remove previous from backstack
                activity?.finish()
            }
            R.id.answer_a_summary -> if (detailsA!!.visibility != View.VISIBLE) {
                detailsA!!.visibility = View.VISIBLE

                // Check if question has not been answered
                if (!answered) {
                    // Check if this selection is correct answer
                    if (keyPosition == 0) {
                        // Right answer is A
                        detailsA!!.setTextColor(Color.GREEN)
                        answerA!!.setTextColor(Color.GREEN)

                        // Register the correct answer
                        correct = true
                    } else {
                        // Incorrect Answer Selected
                        detailsA!!.setTextColor(Color.RED)
                        answerA!!.setTextColor(Color.RED)
                    }
                    answered = true
                }
            }
            R.id.answer_b_summary -> if (detailsB!!.visibility != View.VISIBLE) {
                detailsB!!.visibility = View.VISIBLE

                // Check if question has not been answered
                if (!answered) {
                    // Check if this selection is correct answer
                    if (keyPosition == 1) {
                        // Right answer is A
                        detailsB!!.setTextColor(Color.GREEN)
                        answerB!!.setTextColor(Color.GREEN)

                        // Register the correct answer
                        correct = true
                    } else {
                        // Incorrect Answer Selected
                        detailsB!!.setTextColor(Color.RED)
                        answerB!!.setTextColor(Color.RED)
                    }
                    answered = true
                }
            }
            R.id.answer_c_summary -> if (detailsC!!.visibility != View.VISIBLE) {
                detailsC!!.visibility = View.VISIBLE

                // Check if question has not been answered
                if (!answered) {
                    // Check if this selection is correct answer
                    if (keyPosition == 2) {
                        // Right answer is A
                        detailsC!!.setTextColor(Color.GREEN)
                        answerC!!.setTextColor(Color.GREEN)

                        // Register the correct answer
                        correct = true
                    } else {
                        // Incorrect Answer Selected
                        detailsC!!.setTextColor(Color.RED)
                        answerC!!.setTextColor(Color.RED)
                    }
                    answered = true
                }
            }
            R.id.answer_d_summary -> if (detailsD!!.visibility != View.VISIBLE) {
                detailsD!!.visibility = View.VISIBLE
                // Check if question has not been answered
                if (!answered) {
                    // Check if this selection is correct answer
                    if (keyPosition == 3) {
                        // Right answer is A
                        detailsD!!.setTextColor(Color.GREEN)
                        answerD!!.setTextColor(Color.GREEN)
                        // Register the correct answer
                        correct = true
                    } else {
                        // Incorrect Answer Selected
                        detailsD!!.setTextColor(Color.RED)
                        answerD!!.setTextColor(Color.RED)
                    }
                    answered = true
                }
            }
        }
    }

    companion object {
        // Declare Constants
        private const val QUESTION = "Question"
        private const val KEY = "Key"
        private const val DETAILS = "Details"
        private const val FILLANSWERS = "Fill"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param question Accepts a Question object.
         * @param fillAnswers Accepts an array of Incorrect Answer objects
         * @return A new instance of fragment QuestionFragment.
         */
        fun newInstance(question: Question, fillAnswers: ArrayList<Answer>): QuestionFragment {
            // Create new instance of fragment
            val fragment = QuestionFragment()
            // Add arguments to bundle of new instance.
            val args = Bundle()
            args.putString(QUESTION, question.question)
            args.putString(KEY, question.shortAns)
            args.putString(DETAILS, question.details)
            args.putParcelableArrayList(FILLANSWERS, fillAnswers)
            fragment.arguments = args
            return fragment
        }
    }
}
