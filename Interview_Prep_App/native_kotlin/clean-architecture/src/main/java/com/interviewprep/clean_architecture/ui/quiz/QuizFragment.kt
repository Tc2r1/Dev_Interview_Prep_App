package com.interviewprep.clean_architecture.ui.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.get
import androidx.core.view.indices
import androidx.core.view.size
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.findNavController
import com.interviewprep.clean_architecture.domain.Answer
import com.interviewprep.clean_architecture.ui.score.FinalScore
import com.interviewprep.template.databinding.FragmentQuizBinding
import com.tc2r.sharedresources.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class QuizFragment : Fragment() {
    private val viewModel by viewModels<QuizViewModel>()

    private var _binding: FragmentQuizBinding? = null
    private val binding: FragmentQuizBinding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        collectUiState { state ->
            if (state.isQuizFinished) {
                state.finalScore?.let { showFinalScore(it) }
            }

            updateUi(state)
            state.displayPopupUiState?.let {
                showPopUp(it)
                viewModel.popupShown()
            }
        }
    }

    private fun collectUiState(handleState: (QuizUiState) -> Unit) {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { handleState(it) }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuizBinding.inflate(inflater, container, false)
        setUpUi()
        return binding.root
    }

    private fun setUpUi() {
        binding.newQuizBtn.setOnClickListener { viewModel.startNewQuiz() }
        binding.submitButton.setOnClickListener {
            val index = with(binding.radioGroupAnswers) {
                indexOfChild(findViewById(checkedRadioButtonId))
            }
            viewModel.submitAnswer(index)
        }
    }

    private fun showPopUp(popupUiState: AnswerDetailsUiState) {
        QuizAnswerFragment(popupUiState, viewModel::goToNext).show(
            childFragmentManager,
            QuizAnswerFragment.TAG
        )
    }

    private fun updateUi(state: QuizUiState) {
        state.quizState?.let { quiz ->
            updateQuizProgress(quiz.currentQuestionNumber, quiz.questions.size, quiz.points)

            val question = quiz.currentQuestion
            updateQuestion(question.title, question.answers)
        }

        state.error?.let {
            showErrorMessage(it.message.toString())
        }
    }

    private fun updateQuizProgress(currentQuestionNumber: Int, questionsCount: Int, points: Int) {
        with(binding) {
            val progressText =
                getString(R.string.quiz_progress, currentQuestionNumber + 1, questionsCount)
            titleTv.text = progressText
            scoreTv.text = getString(R.string.score, points)
        }
    }

    private fun updateQuestion(title: String, answers: List<Answer>) {
        with(binding) {
            question.text = title
            for (index in radioGroupAnswers.indices){
                (radioGroupAnswers[index] as? RadioButton)?.let {
                    if(index > answers.lastIndex)
                        it.visibility = TextView.GONE
                    else {
                        it.visibility = TextView.VISIBLE
                        it.text = answers[index].body
                    }
                }
            }
        }
    }

    private fun showErrorMessage(errorMessage: String) {
        Toast.makeText(this.requireContext(), errorMessage, Toast.LENGTH_SHORT).show()
        viewModel.errorMessageShown()
    }

    private fun showFinalScore(finalScore: FinalScore) {
        val action = QuizFragmentDirections.actionQuizFragmentToScoreFragment(finalScore)
        binding.root.findNavController().navigate(action)
    }

    override fun onDetach() {
        super.onDetach()
        _binding = null
    }
}
