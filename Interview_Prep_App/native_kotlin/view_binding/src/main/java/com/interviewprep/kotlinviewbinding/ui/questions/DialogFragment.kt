package com.interviewprep.kotlinviewbinding.ui.questions

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.interviewprep.kotlinviewbinding.databinding.FragmentDialogBinding
import com.interviewprep.kotlinviewbinding.repository.models.Answer

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [DialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DialogFragment(private val func: () -> Unit) : DialogFragment() {
    // assign the _binding variable initially to null
    private var _binding: FragmentDialogBinding? = null

    // with the backing property of the kotlin we extract
    // the non null value of the _binding
    private val binding: FragmentDialogBinding
        get() = _binding!!

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
        // inflate the layout and bind to the _binding
        _binding = FragmentDialogBinding.inflate(inflater, container, false)
        // use binding object to refer to views in fragment
        binding.shortAnsTv.text = "\"" + answer?.answer + "\""
        binding.detailsTv.text = answer?.details
        return binding.root
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
