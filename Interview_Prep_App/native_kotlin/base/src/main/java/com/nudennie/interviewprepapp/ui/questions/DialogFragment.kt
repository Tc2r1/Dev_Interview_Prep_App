package com.nudennie.interviewprepapp.ui.questions

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.nudennie.interviewprepapp.R
import com.nudennie.interviewprepapp.repositories.models.response.Answer

class DialogFragment(private val answer: Answer, private val func: () -> Unit) : DialogFragment() {
    // Declaring variables
    private lateinit var shortAnswerTv: TextView
    private lateinit var detailTv: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        // Inflating view
        val view: View = inflater.inflate(R.layout.fragment_dialog, container, false)
        // Connecting short answer and deatils to their views
        shortAnswerTv = view.findViewById(R.id.short_ans_tv)
        detailTv = view.findViewById(R.id.details_tv)

        // Assigning the text to be displayed in short answer and details
        shortAnswerTv.text = "\"" + answer.answer + "\""
        detailTv.text = answer.details
        return view
    }

    // Function on what to do when a dialog is dismissed
    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        // Try catch block to catch exceptions
        try {
            func()
        } catch (e: Exception) {
            // Printing an exception if it is there
            e.printStackTrace()
        }
    }
}
