package com.tc2r.javatemplate.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.tc2r.javatemplate.R;
import com.tc2r.javatemplate.repositories.Tc2rGithubRepository;
import com.tc2r.javatemplate.repositories.models.Answer;
import com.tc2r.javatemplate.repositories.models.Question;
import com.tc2r.javatemplate.ui.questions.DialogFragment;
import com.tc2r.javatemplate.ui.questions.QuestionFragment;
import com.tc2r.javatemplate.ui.score.ScoreActivity;
import com.tc2r.javatemplate.util.OnFragmentInteractionListener;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.Callable;


public class MainActivity extends AppCompatActivity implements OnFragmentInteractionListener {
    // Static Variables
    private final static int QUIZ_SIZE = 5;

    // UI Variables
    private TextView titleTv, scoreTv;


    // Variables
    private Tc2rGithubRepository tc2rGithubRepository;
    private ArrayList<Question> quizList;
    private ArrayList<Question> testList;
    private ArrayList<Answer> answersList;
    private Random random;
    private int currentQuestion = 0;
    private int numOfCorrect = 0;
    private int scorePer = 0;
    private double pointPerQ, score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tc2rGithubRepository = new Tc2rGithubRepository();

        // Initialize and assignments
        titleTv = findViewById(R.id.title_tv);
        scoreTv = findViewById(R.id.score_tv);
        testList = new ArrayList<>();
        quizList = new ArrayList<>();
        answersList = new ArrayList<>();
        random = new Random();

        // FIXME: Call the below code off of the main thread in order not to freeze the main thread
        //  while information is being retrieved.
        getAnswers();
        getQuestions();
        createQuiz();
    }

    public void getAnswers() {
        answersList.addAll(tc2rGithubRepository.getAnswersList());
    }

    public void getQuestions() {
        quizList.addAll(tc2rGithubRepository.getQuestions());
    }

    private void createQuiz() {
        Log.i(" Size: ", "QuestionList is: " + quizList.size());
        Log.i(" Size: ", "AnswerList is: " + answersList.size());

        // set booleanArray to be same size as quizList
        boolean[] selectedQuestion = new boolean[quizList.size()];

        // set an int to a random number in the quizList
        int randNum = random.nextInt(quizList.size());
        int i = 0;

        // sets the score system for quiz.
        // TODO: 5/31/2017 maybe remove this and simply divide correct answers by total questions
        pointPerQ = 1.0 / QUIZ_SIZE;

        // prevent from having repeated questions in a single quiz
        while(i < QUIZ_SIZE) {
            // if boolean at randNum in selectedQuestion is false
            if(!selectedQuestion[randNum] && quizList.get(randNum).getQuestionType().equals("multi")) {

                // Add position randNum to test list;
                testList.add(quizList.get(randNum));
                // set this question selected to true.
                selectedQuestion[randNum] = true;
                i++;
            } else {
                // if question already selected, change randNum;
                randNum = random.nextInt(quizList.size());
            }
        }

        // On first run, start quiz without updating score
        nextQuestion(false);
    }

    public String goToNextQuestion(boolean isAnswerCorrect) {
        nextQuestion(isAnswerCorrect);
        return "True";
    }

    public void showDetails(Answer answer, boolean isAnswerCorrect) {
        // Show a details dialog fragment on top of the current screen.
        DialogFragment myDialogFragment = new DialogFragment(answer, new Callable<String>() {
            public String call() {
                // after user dismisses the dialogfragment, move on to next question.
                return goToNextQuestion(isAnswerCorrect);
            }
        });
        myDialogFragment.show(getSupportFragmentManager(), "details");
    }


    public void nextQuestion(boolean correctAnswer) {
        // if previous question was answered correctly
        // update variables accordingly.
        if(correctAnswer) {
            numOfCorrect++;
            score += pointPerQ;
            scorePer = (int) (score * 100);
            scoreTv.setText(String.format(Locale.US, "%s%d", getString(com.tc2r.sharedresources.R.string.score_display_text), scorePer));
        }

        // if quiz is not complete, continue quiz with new QuestionFragment
        if(currentQuestion < QUIZ_SIZE) {
            // Fragments and Model Variables
            QuestionFragment newFragment = QuestionFragment.newInstance(testList.get(currentQuestion), answersList);
            currentQuestion++;
            titleTv.setText(String.format(Locale.US, "%s%d of %d", getString(com.tc2r.sharedresources.R.string.question_display_text), currentQuestion, QUIZ_SIZE));
            // UI Variables
            LinearLayout fragContainer = findViewById(R.id.fragment_container);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(fragContainer.getId(), newFragment);
            ft.commit();
        } else {
            // Quiz is over, go to final page!
            // create intent
            Intent intent = new Intent(this, ScoreActivity.class);

            // add variables to send.
            intent.putExtra("scorePercentage", scorePer);
            intent.putExtra("quizSize", QUIZ_SIZE);
            intent.putExtra("numCorrect", numOfCorrect);

            // use intent.
            startActivity(intent);
        }
    }

    @Override
    public void fragmentInitialized() {

    }
}
