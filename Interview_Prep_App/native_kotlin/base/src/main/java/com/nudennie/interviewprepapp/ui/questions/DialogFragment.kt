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

    private lateinit var shortAnswerTv: TextView
    private lateinit var detailTv: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view: View = inflater.inflate(R.layout.fragment_dialog, container, false)
        shortAnswerTv = view.findViewById(R.id.short_ans_tv)
        detailTv = view.findViewById(R.id.details_tv)
        shortAnswerTv.text = "\"" + answer.answer + "\""
        detailTv.text = answer.details
        return view
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        try {
            func()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
