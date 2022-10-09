package com.nudennie.interviewprepapp.ui.questions

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.nudennie.interviewprepapp.R
import com.nudennie.interviewprepapp.repositories.models.MultipleChoiceQuestion
import com.nudennie.interviewprepapp.repositories.models.response.Answer
import com.nudennie.interviewprepapp.repositories.models.response.Question
import com.nudennie.interviewprepapp.ui.main.MainActivity
import com.nudennie.interviewprepapp.util.OnFragmentInteractionListener
import com.tc2r.sharedresources.R.drawable
import java.util.Random

class QuestionFragment : Fragment(), View.OnClickListener {
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

    // Declare UI Variables
    private lateinit var answersRadioGroup: RadioGroup

    // Declare Variables
    private var quizQuestion: String = ""
    private var quizAnswer: String? = null
    private var quizDetails: String? = null
    private var otherAnswers: ArrayList<Answer>? = null
    private var shuffledAnswers: ArrayList<Answer>? = null
    private val answerList = arrayListOf<Answer>()

    private lateinit var mCquestion: MultipleChoiceQuestion

    private var mListener: OnFragmentInteractionListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mListener = if (context is OnFragmentInteractionListener) {
            context
        } else {
            throw RuntimeException(
                context.toString() + " must implement OnFragmentInteractionListener"
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Get Arguments from bundle
        arguments?.let {
            quizQuestion = it.getString(QUESTION)!!
            quizAnswer = it.getString(KEY)
            quizDetails = it.getString(DETAILS)
            otherAnswers = it.getParcelableArrayList(FILLANSWERS)
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
        // Declare UI Variables
        val questionTV = mView.findViewById<TextView>(R.id.question)
        val newBtn = mView.findViewById<Button>(R.id.newQuizBtn)
        answersRadioGroup = mView.findViewById(R.id.radio_group_answers)
        val firstAnswerRadioButton = mView.findViewById<RadioButton>(R.id.radio_button_answer_a)
        val secondAnswerRadioButton = mView.findViewById<RadioButton>(R.id.radio_button_answer_b)
        val thirdAnswerRadioButton = mView.findViewById<RadioButton>(R.id.radio_button_answer_c)
        val fourthAnswerRadioButton = mView.findViewById<RadioButton>(R.id.radio_button_answer_d)
        val submitButton = mView.findViewById<Button>(R.id.submitButton)

        // Set Listeners
        newBtn.setOnClickListener(this)
        submitButton.setOnClickListener(this)

        // Set the Question Text
        questionTV!!.text = quizQuestion

        // Create random
        val random = Random(System.currentTimeMillis())

        // Create the question: Multiple choice!

        answerList.add(Answer(quizAnswer!!, quizDetails!!))

        for (j in 0..2) {
            // if position in answer check =/= true, fill with random answer
            val randomAnswer = random.nextInt(otherAnswers!!.size)
            answerList.add(otherAnswers!![randomAnswer])
        }
        val builder: MultipleChoiceQuestion.Builder = MultipleChoiceQuestion.Builder()
        mCquestion = builder.quizQuestion(quizQuestion).possibleAnswers(answerList).build()

        shuffledAnswers = arrayListOf()
        shuffledAnswers!!.addAll(answerList)
        shuffledAnswers!!.shuffle()

        firstAnswerRadioButton.text = shuffledAnswers!![0].answer
        secondAnswerRadioButton.text = shuffledAnswers!![1].answer
        thirdAnswerRadioButton.text = shuffledAnswers!![2].answer
        fourthAnswerRadioButton.text = shuffledAnswers!![3].answer

        // Set the Question Text
        questionTV.text = mCquestion.question
        return mView
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    override fun onClick(view: View) {
        // Switch statement for what is clicked.
        when (view.id) {
            R.id.newQuizBtn -> {
                // start main Activity over
                val intent = Intent(activity, MainActivity::class.java)
                startActivity(intent)
                // remove previous from backstack
                activity?.finish()
            }

            R.id.submitButton -> {
                val checkedId = answersRadioGroup.checkedRadioButtonId
                // Do nothing if nothing is checked. (id == -1)
                if (checkedId != -1 && activity != null) {
                    var answerIndex = 0
                    when (checkedId) {
                        R.id.radio_button_answer_b -> answerIndex = 1
                        R.id.radio_button_answer_c -> answerIndex = 2
                        R.id.radio_button_answer_d -> answerIndex = 3
                    }

                    // The first answer in the original question is always the correct one, so if our
                    // answer matches, we have the correct answer.
                    val radioButton = activity!!.findViewById<View>(checkedId) as RadioButton
                    val correct: Boolean
                    if (shuffledAnswers!![answerIndex] == mCquestion.answers[0]) {
                        correct = true
                        radioButton.setBackgroundResource(drawable.green_bordered_background)
                    } else {
                        correct = false
                        radioButton.setBackgroundResource(drawable.red_bordered_background)
                    }

                    (activity as MainActivity).showDetails(shuffledAnswers!![answerIndex], correct)
                }
            }
        }
    }
}
