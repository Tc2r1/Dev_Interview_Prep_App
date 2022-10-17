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
