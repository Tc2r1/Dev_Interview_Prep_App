package com.dreams.interviewprepapp.ui.questions;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.dreams.interviewprepapp.repositories.models.response.Answer;

import java.util.concurrent.Callable;

public class DialogFragment extends androidx.fragment.app.DialogFragment {
    private final Answer answer;
    Callable<String> func;

    private TextView shortAnswerTv, detailTv;


    public DialogFragment(Answer answer, Callable<String> func) {
        this.answer = answer;
        this.func = func;
    }

    /**
     * Called to have the fragment instantiate its user interface view.
     * This is optional, and non-graphical fragments can return null. This will be called between
     * {@link #onCreate(Bundle)} and {@link #onActivityCreated(Bundle)}.
     * <p>A default View can be returned by calling {@link #Fragment(int)} in your
     * constructor. Otherwise, this method returns null.
     *
     * <p>It is recommended to <strong>only</strong> inflate the layout in this method and move
     * logic that operates on the returned View to {@link #onViewCreated(View, Bundle)}.
     *
     * <p>If you return a View from here, you will later be called in
     * {@link #onDestroyView} when the view is being released.
     *
     * @param inflater           The LayoutInflater object that can be used to inflate
     *                           any views in the fragment,
     * @param container          If non-null, this is the parent view that the fragment's
     *                           UI should be attached to.  The fragment should not add the view itself,
     *                           but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     *                           from a previous saved state as given here.
     * @return Return the View for the fragment's UI, or null.
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(com.dreams.interviewprepapp.R.layout.fragment_dialog, container, false);

        shortAnswerTv = view.findViewById(com.dreams.interviewprepapp.R.id.short_ans_tv);
        detailTv = view.findViewById(com.dreams.interviewprepapp.R.id.details_tv);
        shortAnswerTv.setText("\"" + answer.getAnswer() + "\"");
        detailTv.setText(answer.getDetails());
        return view;
    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        super.onDismiss(dialog);

        try {
            func.call();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
