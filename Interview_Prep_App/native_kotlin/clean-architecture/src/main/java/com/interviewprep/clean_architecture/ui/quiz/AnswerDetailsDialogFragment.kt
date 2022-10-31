package com.interviewprep.clean_architecture.ui.quiz

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.interviewprep.template.databinding.FragmentDialogBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuizAnswerFragment(
    private val uiState: AnswerDetailsUiState,
    private val onDismiss: () -> Unit
) : DialogFragment() {

    companion object {
        val TAG = "QuizAnswerFragment"
    }

    private var _binding: FragmentDialogBinding? = null
    private val binding: FragmentDialogBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDialogBinding.inflate(inflater, container, false)
        updateUi(uiState)
        return binding.root
    }

    private fun updateUi(state: AnswerDetailsUiState) {
        with(binding) {
            shortAnsTv.text = state.answer.body
            detailsTv.text = state.answer.details
        }
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        onDismiss()
    }

    override fun onDetach() {
        super.onDetach()
        _binding = null
    }
}
