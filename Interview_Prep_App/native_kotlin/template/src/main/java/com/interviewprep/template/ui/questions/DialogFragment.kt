package com.interviewprep.template.ui.questions

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.interviewprep.template.R
import com.interviewprep.template.repository.models.Answer

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

/**
 *fixme: (Optional) Use Databinding, Dependency Injection, ViewBinding
 * or etc, to refactor this fragment.
 */
class DialogFragment(private val func: () -> Unit) : DialogFragment() {
    private lateinit var shortAnswerTv: TextView
    private lateinit var detailTv: TextView
    private var answer: Answer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            answer = it.getParcelable(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_dialog, container, false)
        shortAnswerTv = view.findViewById(R.id.short_ans_tv)
        detailTv = view.findViewById(R.id.details_tv)
        shortAnswerTv.text = "\"" + answer?.answer + "\""
        detailTv.text = answer?.details
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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param answer Answer object the user clicked on.
         * @param func Callback Function when fragment is dismissed..
         * @return A new instance of fragment DialogFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(answer: Answer, func: () -> Unit) =
            DialogFragment(func).apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_PARAM1, answer)
                }
            }
    }
}
