package com.dreams.interviewprepapp.repositories;

import com.dreams.interviewprepapp.network.RetrofitBuilders;
import com.dreams.interviewprepapp.repositories.models.response.AnswersResponse;
import com.dreams.interviewprepapp.repositories.models.response.QuestionsResponse;
import com.dreams.interviewprepapp.repositories.tc2rgithubrepository.source.remote.Tc2rGithubService;

import retrofit2.Call;

public class Tc2rGithubRepository {
    private static final RetrofitBuilders retrofitBuilder = new RetrofitBuilders();

    private final Tc2rGithubService tc2rGithubService = retrofitBuilder.tc2rGithubService;

    public Call<AnswersResponse> getAnswersList = getSelectedQuizAnswers("ANDROID"); //TODO change this as per user selected quiz language

    public Call<QuestionsResponse> getQuestionsList = getSelectedQuizQuestions("ANDROID"); //TODO change this as per user selected quiz language

    // request for answers json based on selected quiz language
    private Call<AnswersResponse> getSelectedQuizAnswers(String selectedLanguage) {
         Call<AnswersResponse> answersResponseCall;
         switch (selectedLanguage.toUpperCase()) {
            case "ANDROID" : answersResponseCall = tc2rGithubService.getAndroidAnswersList(); break;
            case "C"       : answersResponseCall = tc2rGithubService.getCAnswers()         ;  break;
            case "C#"      : answersResponseCall = tc2rGithubService.getCSharpAnswers()    ;  break;
            case "CPP"     : answersResponseCall = tc2rGithubService.getCPPAnswers()       ;  break;
            case "DART"    : answersResponseCall = tc2rGithubService.getDartAnswers()      ;  break;
            case "DP"      : answersResponseCall = tc2rGithubService.getDPAnswers()        ;  break;
            case "DSA"     : answersResponseCall = tc2rGithubService.getDSAAnswers()       ;  break;
            case "GOLANG"  : answersResponseCall = tc2rGithubService.getGolangAnswers()    ;  break;
            case "HTML5"   : answersResponseCall = tc2rGithubService.getHTML5Answers()     ;  break;
            case "JS"      : answersResponseCall = tc2rGithubService.getJSAnswers()        ;  break;
            case "JAVA"    : answersResponseCall = tc2rGithubService.getJavaAnswers()      ;  break;
            case "PHP"     : answersResponseCall = tc2rGithubService.getPHPAnswers()       ;  break;
            case "PYTHON"  : answersResponseCall = tc2rGithubService.getPythonAnswers()    ;  break;
            case "RUBY"    : answersResponseCall = tc2rGithubService.getRubyAnswers()      ;  break;
            case "IOS"     : answersResponseCall = tc2rGithubService.getIOSAnswers()       ;  break;
            default        : answersResponseCall = tc2rGithubService.getAndroidAnswersList(); break;
        };
        return answersResponseCall;
    }

    // request for questions json based on selected quiz language
    private Call<QuestionsResponse> getSelectedQuizQuestions(String selectedLanguage) {
        Call<QuestionsResponse> questionsResponseCall;
        switch (selectedLanguage.toUpperCase()) {
            case "ANDROID" : questionsResponseCall = tc2rGithubService.getAndroidQuestionsList() ; break;
            case "C"       : questionsResponseCall = tc2rGithubService.getCQuestionsJson()        ; break;
            case "C#"      : questionsResponseCall = tc2rGithubService.getCSharpQuestionsJson()   ; break;
            case "CPP"     : questionsResponseCall = tc2rGithubService.getCPPQuestionsJson()      ; break;
            case "DART"    : questionsResponseCall = tc2rGithubService.getDartQuestionsJson()     ; break;
            case "DP"      : questionsResponseCall = tc2rGithubService.getDPQuestionsJson()       ; break;
            case "DSA"     : questionsResponseCall = tc2rGithubService.getDSAQuestionsJson()      ; break;
            case "GOLANG"  : questionsResponseCall = tc2rGithubService.getGolangQuestionsJson()   ; break;
            case "HTML5"   : questionsResponseCall = tc2rGithubService.getHTML5QuestionsJson()    ; break;
            case "JS"      : questionsResponseCall = tc2rGithubService.getJSQuestionsJson()       ; break;
            case "JAVA"    : questionsResponseCall = tc2rGithubService.getJavaQuestionsJson()     ; break;
            case "PHP"     : questionsResponseCall = tc2rGithubService.getPHPQuestionsJson()      ; break;
            case "PYTHON"  : questionsResponseCall = tc2rGithubService.getPythonQuestionsJson()   ; break;
            case "RUBY"    : questionsResponseCall = tc2rGithubService.getRubyQuestionsJson()     ; break;
            case "IOS"     : questionsResponseCall = tc2rGithubService.getIOSQuestionsJson()      ; break;
            default        : questionsResponseCall = tc2rGithubService.getAndroidQuestionsList()  ; break;
        }
        return questionsResponseCall;
    }

}
