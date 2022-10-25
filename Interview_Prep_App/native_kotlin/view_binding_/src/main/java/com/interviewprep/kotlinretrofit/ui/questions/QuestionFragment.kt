package com.interviewprep.kotlinretrofit.ui.questions

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
import com.interviewprep.kotlinretrofit.R
import com.interviewprep.kotlinretrofit.databinding.FragmentDialogBinding
import com.interviewprep.kotlinretrofit.databinding.FragmentQuestionBinding
import com.interviewprep.kotlinretrofit.repository.models.Answer
import com.interviewprep.kotlinretrofit.repository.models.MultipleChoiceQuestion
import com.interviewprep.kotlinretrofit.repository.models.Question
import com.interviewprep.kotlinretrofit.ui.main.MainActivity
import com.interviewprep.kotlinretrofit.util.OnFragmentInteractionListener
import com.tc2r.sharedresources.R.drawable
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
    // assign the _binding variable initially to null
    private var _binding: FragmentQuestionBinding? = null
    // with the backing property of the kotlin we extract
    // the non null value of the _binding
    private val binding: FragmentQuestionBinding
        get() = _binding!!
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
        // inflate the layout and bind to the _binding
        _binding = FragmentQuestionBinding.inflate(inflater, container, false)
        //use binding object to refer to views in fragment
        // Declare UI Variables
        val questionTV = binding.question
        val newBtn = binding.newQuizBtn
        answersRadioGroup = binding.radioGroupAnswers
        val firstAnswerRadioButton =binding.radioButtonAnswerA
        val secondAnswerRadioButton = binding.radioButtonAnswerB
        val thirdAnswerRadioButton = binding.radioButtonAnswerC
        val fourthAnswerRadioButton = binding.radioButtonAnswerD
        val submitButton = binding.submitButton

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
        return binding.root
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
                val intent = Intent(requireActivity(), MainActivity::class.java)
                startActivity(intent)
                // remove previous from backstack
                requireActivity().finish()
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
                    val radioButton = requireActivity().findViewById<View>(checkedId) as RadioButton
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
