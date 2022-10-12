package com.tc2r.javatemplate.ui.questions;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

import com.tc2r.javatemplate.R;
import com.tc2r.javatemplate.repositories.models.Answer;
import com.tc2r.javatemplate.repositories.models.MultipleChoiceQuestion;
import com.tc2r.javatemplate.repositories.models.Question;
import com.tc2r.javatemplate.ui.main.MainActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuestionFragment extends Fragment implements View.OnClickListener {

    // Declare Constants
    private static final String QUESTION = "Question";
    private static final String KEY = "Key";
    private static final String DETAILS = "Details";
    private static final String FILLANSWERS = "Fill";

    // Declare UI Variables
    private RadioGroup answersRadioGroup;

    // Declare Variables
    private final List<Answer> answerList = new ArrayList<>();

    private String quizQuestion;
    private String quizAnswer, quizDetails;
    private ArrayList<Answer> otherAnswers, shuffledAnswers;
    private MultipleChoiceQuestion mCquestion;

    public QuestionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param question    Accepts a Question object.
     * @param fillAnswers Accepts an array of Incorrect Answer objects
     * @return A new instance of fragment QuestionFragment.
     */
    public static QuestionFragment newInstance(Question question, ArrayList<Answer> fillAnswers) {
        // Create new instance of fragment
        QuestionFragment fragment = new QuestionFragment();
        // Add arguments to bundle of new instance.
        Bundle args = new Bundle();
        args.putString(QUESTION, question.getQuestion());
        args.putString(KEY, question.getShortAns());
        args.putString(DETAILS, question.getDetails());
        args.putParcelableArrayList(FILLANSWERS, fillAnswers);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get Arguments from bundle
        if(getArguments() != null) {
            quizQuestion = getArguments().getString(QUESTION);
            quizAnswer = getArguments().getString(KEY);
            quizDetails = getArguments().getString(DETAILS);
            otherAnswers = getArguments().getParcelableArrayList(FILLANSWERS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mView = inflater.inflate(R.layout.fragment_question, container, false);

        // Assign Variables to Object Ids
        // Declare UI Variables
        TextView questionTV = mView.findViewById(R.id.question);
        Button newBtn = mView.findViewById(R.id.newQuizBtn);
        answersRadioGroup = mView.findViewById(R.id.radio_group_answers);
        RadioButton firstAnswerRadioButton = mView.findViewById(R.id.radio_button_answer_a);
        RadioButton secondAnswerRadioButton = mView.findViewById(R.id.radio_button_answer_b);
        RadioButton thirdAnswerRadioButton = mView.findViewById(R.id.radio_button_answer_c);
        RadioButton fourthAnswerRadioButton = mView.findViewById(R.id.radio_button_answer_d);
        Button submitButton = mView.findViewById(R.id.submitButton);

        // Set Listeners
        newBtn.setOnClickListener(this);
        submitButton.setOnClickListener(this);


        // Create random
        Random random = new Random(System.currentTimeMillis());

        // Create the question: Multiple choice!
        answerList.add(new Answer(quizAnswer, quizDetails));

        for(int j = 0; j < 3; j++) {
            // if position in answer check =/= true, fill with random answer
            int randomAnswer = random.nextInt(otherAnswers.size());
            answerList.add(otherAnswers.get(randomAnswer));
        }
        MultipleChoiceQuestion.Builder builder = new MultipleChoiceQuestion.Builder();
        mCquestion = builder.quizQuestion(quizQuestion).possibleAnswers(answerList).build();

        shuffledAnswers = new ArrayList<>();
        shuffledAnswers.addAll(answerList);
        Collections.shuffle(shuffledAnswers);

        firstAnswerRadioButton.setText(shuffledAnswers.get(0).getAnswer());
        secondAnswerRadioButton.setText(shuffledAnswers.get(1).getAnswer());
        thirdAnswerRadioButton.setText(shuffledAnswers.get(2).getAnswer());
        fourthAnswerRadioButton.setText(shuffledAnswers.get(3).getAnswer());


        // Set the Question Text
        questionTV.setText(mCquestion.getQuestion());

        return mView;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {

        // Switch statement for what is clicked.
        switch(view.getId()) {
            case R.id.newQuizBtn:
                // start main Activity over
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                // remove previous from backstack
                getActivity().finish();
                break;


            case R.id.submitButton:
                int checkedId = answersRadioGroup.getCheckedRadioButtonId();
                // Do nothing if nothing is checked. (id == -1)
                if(checkedId != -1 && getActivity() != null) {
                    int answerIndex = 0;
                    switch(checkedId) {
                        case R.id.radio_button_answer_b:
                            answerIndex = 1;
                            break;
                        case R.id.radio_button_answer_c:
                            answerIndex = 2;
                            break;
                        case R.id.radio_button_answer_d:
                            answerIndex = 3;
                            break;
                    }

                    // The first answer in the original question is always the correct one, so if our
                    // answer matches, we have the correct answer.
                    RadioButton radioButton = (RadioButton) getActivity().findViewById(checkedId);
                    boolean correct;
                    if(shuffledAnswers.get(answerIndex) == mCquestion.getAnswers().get(0)) {
                        correct = true;
                        radioButton.setBackgroundResource(com.tc2r.sharedresources.R.drawable.green_bordered_background);
                    } else {
                        correct = false;
                        radioButton.setBackgroundResource(com.tc2r.sharedresources.R.drawable.red_bordered_background);
                    }

                    ((MainActivity) getActivity()).showDetails(shuffledAnswers.get(answerIndex), correct);
                }
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    }
}
