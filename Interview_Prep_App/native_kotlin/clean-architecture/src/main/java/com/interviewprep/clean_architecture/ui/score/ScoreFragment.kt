package com.interviewprep.clean_architecture.ui.score

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.interviewprep.template.databinding.FragmentScoreBinding
import com.tc2r.sharedresources.R
import kotlin.system.exitProcess

class ScoreFragment : Fragment() {
    private val args: ScoreFragmentArgs by navArgs()

    private var _binding: FragmentScoreBinding? = null
    private val binding: FragmentScoreBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentScoreBinding.inflate(inflater, container, false)
        setUpUi()
        return binding.root
    }

    private fun setUpUi() {
        val score = args.finalScore
        val resources = resources
        with(binding) {
            numofquestionsTv.text = resources.getQuantityString(
                R.plurals.final_score_question_count,
                score.questionsCount,
                score.questionsCount
            )
            numcorrectTv.text = getString(
                R.string.final_score_correct_answers_count,
                score.correctAnswersCount
            )
            finalgradeTv.text = getString(
                R.string.final_score_percentage,
                score.percentageScore
            )

            restartButton.setOnClickListener { startNewQuiz() }
            closeButton.setOnClickListener { closeApp() }
        }

    }

    private fun startNewQuiz() {
        val action = ScoreFragmentDirections.actionScoreFragmentToQuizFragment()
        binding.root.findNavController().navigate(action)
    }

    private fun closeApp() {
        finishAffinity(this.requireActivity())
        exitProcess(0)
    }

    override fun onDetach() {
        super.onDetach()
        _binding = null
    }
}