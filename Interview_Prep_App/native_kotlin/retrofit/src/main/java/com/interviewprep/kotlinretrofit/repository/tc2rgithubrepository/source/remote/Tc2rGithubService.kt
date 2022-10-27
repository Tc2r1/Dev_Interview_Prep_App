package com.interviewprep.kotlinretrofit.repository.tc2rgithubrepository.source.remote

import com.interviewprep.kotlinretrofit.repository.models.response.AnswersResponse
import com.interviewprep.kotlinretrofit.repository.models.response.QuestionsResponse
import retrofit2.Response
import retrofit2.http.GET

internal interface Tc2rGithubService {
    // Request method and URL specified in the annotation

    // Gets Android answers objects
    @GET("Tc2r1/DevInterview_Questions/master/Languages/Android/answers.json")
    suspend fun requestAndroidAnswers(): Response<AnswersResponse>

    // Gets Android questions objects
    @GET("Tc2r1/DevInterview_Questions/master/Languages/Android/questions.json")
    suspend fun getAndroidQuestionsJson(): Response<QuestionsResponse>

    // Gets C# answers objects
    @GET("Tc2r1/DevInterview_Questions/master/Languages/C%23/answers.json")
    suspend fun requestCSharpAnswers(): Response<AnswersResponse>

    // Gets C# questions objects
    @GET("Tc2r1/DevInterview_Questions/master/Languages/C%23/questions.json")
    suspend fun getCSharpQuestionsJson(): Response<QuestionsResponse>

    // Gets C answers objects
    @GET("Tc2r1/DevInterview_Questions/master/Languages/C/answers.json")
    suspend fun requestCAnswers(): Response<AnswersResponse>

    // Gets C questions objects
    @GET("Tc2r1/DevInterview_Questions/master/Languages/C/questions.json")
    suspend fun getCQuestionsJson(): Response<QuestionsResponse>

    // Gets CPP answers objects
    @GET("Tc2r1/DevInterview_Questions/master/Languages/CPP/answers.json")
    suspend fun requestCPPAnswers(): Response<AnswersResponse>

    // Gets CPP questions objects
    @GET("Tc2r1/DevInterview_Questions/master/Languages/CPP/questions.json")
    suspend fun getCPPQuestionsJson(): Response<QuestionsResponse>

    // Gets DART answers objects
    @GET("Tc2r1/DevInterview_Questions/master/Languages/DART/answers.json")
    suspend fun requestDartAnswers(): Response<AnswersResponse>

    // Gets DART questions objects
    @GET("Tc2r1/DevInterview_Questions/master/Languages/DART/questions.json")
    suspend fun getDartQuestionsJson(): Response<QuestionsResponse>

    // Gets DP answers objects
    @GET("Tc2r1/DevInterview_Questions/master/Languages/DP/answers.json")
    suspend fun requestDPAnswers(): Response<AnswersResponse>

    // Gets DP questions objects
    @GET("Tc2r1/DevInterview_Questions/master/Languages/DP/questions.json")
    suspend fun getDPQuestionsJson(): Response<QuestionsResponse>

    // Gets DSA answers objects
    @GET("Tc2r1/DevInterview_Questions/master/Languages/DSA/answers.json")
    suspend fun requestDSAAnswers(): Response<AnswersResponse>

    // Gets DSA questions objects
    @GET("Tc2r1/DevInterview_Questions/master/Languages/DSA/questions.json")
    suspend fun getDSAQuestionsJson(): Response<QuestionsResponse>

    // Gets Golang answers objects
    @GET("Tc2r1/DevInterview_Questions/master/Languages/Golang/answers.json")
    suspend fun requestGolangAnswers(): Response<AnswersResponse>

    // Gets Golang questions objects
    @GET("Tc2r1/DevInterview_Questions/master/Languages/Golang/questions.json")
    suspend fun getGolangQuestionsJson(): Response<QuestionsResponse>

    // Gets HTML5 answers objects
    @GET("Tc2r1/DevInterview_Questions/master/Languages/HTML5/answers.json")
    suspend fun requestHTML5Answers(): Response<AnswersResponse>

    // Gets HTML5 questions objects
    @GET("Tc2r1/DevInterview_Questions/master/Languages/HTML5/questions.json")
    suspend fun getHTML5QuestionsJson(): Response<QuestionsResponse>

    // Gets JS answers objects
    @GET("Tc2r1/DevInterview_Questions/master/Languages/JS/answers.json")
    suspend fun requestJSAnswers(): Response<AnswersResponse>

    // Gets JS questions objects
    @GET("Tc2r1/DevInterview_Questions/master/Languages/JS/questions.json")
    suspend fun getJSQuestionsJson(): Response<QuestionsResponse>

    // Gets Java answers objects
    @GET("Tc2r1/DevInterview_Questions/master/Languages/Java/answers.json")
    suspend fun requestJavaAnswers(): Response<AnswersResponse>

    // Gets Java questions objects
    @GET("Tc2r1/DevInterview_Questions/master/Languages/Java/questions.json")
    suspend fun getJavaQuestionsJson(): Response<QuestionsResponse>

    // Gets PHP answers objects
    @GET("Tc2r1/DevInterview_Questions/master/Languages/PHP/answers.json")
    suspend fun requestPHPAnswers(): Response<AnswersResponse>

    // Gets PHP questions objects
    @GET("Tc2r1/DevInterview_Questions/master/Languages/PHP/questions.json")
    suspend fun getPHPQuestionsJson(): Response<QuestionsResponse>

    // Gets Python answers objects
    @GET("Tc2r1/DevInterview_Questions/master/Languages/Python/answers.json")
    suspend fun requestPythonAnswers(): Response<AnswersResponse>

    // Gets Python questions objects
    @GET("Tc2r1/DevInterview_Questions/master/Languages/Python/questions.json")
    suspend fun getPythonQuestionsJson(): Response<QuestionsResponse>

    // Gets Ruby answers objects
    @GET("Tc2r1/DevInterview_Questions/master/Languages/Ruby/answers.json")
    suspend fun requestRubyAnswers(): Response<AnswersResponse>

    // Gets Ruby questions objects
    @GET("Tc2r1/DevInterview_Questions/master/Languages/Ruby/questions.json")
    suspend fun getRubyQuestionsJson(): Response<QuestionsResponse>

    // Gets iOS answers objects
    @GET("Tc2r1/DevInterview_Questions/master/Languages/iOS/answers.json")
    suspend fun requestIOSAnswers(): Response<AnswersResponse>

    // Gets iOS questions objects
    @GET("Tc2r1/DevInterview_Questions/master/Languages/iOS/questions.json")
    suspend fun getIOSQuestionsJson(): Response<QuestionsResponse>

}
