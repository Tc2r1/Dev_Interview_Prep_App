package com.interviewprep.kotlinretrofit.repository.tc2rgithubrepository

import android.util.Log
import com.interviewprep.kotlinretrofit.network.RetrofitBuilders
import com.interviewprep.kotlinretrofit.repository.models.Answer
import com.interviewprep.kotlinretrofit.repository.models.Question
import com.interviewprep.kotlinretrofit.repository.models.response.AnswersResponse
import com.interviewprep.kotlinretrofit.repository.models.response.QuestionsResponse
import com.interviewprep.kotlinretrofit.repository.tc2rgithubrepository.source.remote.Tc2rGithubService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class Tc2rGithubRepository {
    private val TAG = "ACTEST"

    companion object {
        private val retrofitBuilder: RetrofitBuilders = RetrofitBuilders()
    }

    // Creates API object using Retrofit to implement API Service
    private val tc2rGithubService: Tc2rGithubService by lazy {
        retrofitBuilder.tc2rGithubService
    }

    suspend fun getTheAnswers(): ArrayList<Answer> {
        val answersList: ArrayList<Answer> = arrayListOf()
        withContext(Dispatchers.IO) {
            val response = requestSelectedQuizAnswers("ANDROID")//TODO pass in user selected language
            val array = response.body()

            val responseCode = response.code()
            Log.i(TAG, "$responseCode")

            for (item in array?.answers!!) {
                val tempAnswer = item.answer
                val tempDetail = item.details

                val temp = Answer(tempAnswer, tempDetail)

                Log.i(TAG, "onResponse TempAnswer: $tempAnswer")
                Log.i(TAG, "onResponse TempDetail: $tempDetail")
                answersList.add(temp)
            }
        }
        return answersList
    }

    suspend fun getQuestions(): ArrayList<Question> {
        val questionsList: ArrayList<Question> = arrayListOf()
        withContext(Dispatchers.IO) {
            val response = requestSelectedQuizQuestions("ANDROID")//TODO pass in user selected language
            val array = response.body()
            Log.i(TAG, "onResponse Array: $array")

            for (item in array?.questions!!) {
                val tempId = item.id
                val tempQuestion = item.question
                val tempDetails = item.details
                val tempType = item.questionType
                val tempShortAns = item.shortAns
                val tempTF = item.trueOrFalse

                // Skips boolean type questions. Implement feature later
                if (tempType == "bool") continue

                val temp = Question(
                    item.id,
                    item.questionType,
                    item.question,
                    tempDetails,
                    tempShortAns,
                    tempTF
                )

                Log.i(TAG, "TempQuestion: $tempQuestion $tempId")
                questionsList.add(temp)
            }
        }
        return questionsList
    }

    // request for answers json based on selected quiz language
    suspend fun requestSelectedQuizAnswers(selectedLanguage: String): Response<AnswersResponse> {
        return when (selectedLanguage.uppercase()) {
            "ANDROID" -> tc2rGithubService.requestAndroidAnswers()
            "C"       -> tc2rGithubService.requestCAnswers()
            "C#"      -> tc2rGithubService.requestCSharpAnswers()
            "CPP"     -> tc2rGithubService.requestCPPAnswers()
            "DART"    -> tc2rGithubService.requestDartAnswers()
            "DP"      -> tc2rGithubService.requestDPAnswers()
            "DSA"     -> tc2rGithubService.requestDSAAnswers()
            "GOLANG"  -> tc2rGithubService.requestGolangAnswers()
            "HTML5"   -> tc2rGithubService.requestHTML5Answers()
            "JS"      -> tc2rGithubService.requestJSAnswers()
            "JAVA"    -> tc2rGithubService.requestJavaAnswers()
            "PHP"     -> tc2rGithubService.requestPHPAnswers()
            "PYTHON"  -> tc2rGithubService.requestPythonAnswers()
            "RUBY"    -> tc2rGithubService.requestRubyAnswers()
            "IOS"     -> tc2rGithubService.requestIOSAnswers()
            else      -> tc2rGithubService.requestAndroidAnswers()
        }
    }

    // request for questions json based on selected quiz language
    suspend fun requestSelectedQuizQuestions(selectedLanguage: String): Response<QuestionsResponse> {
        return when (selectedLanguage.uppercase()) {
            "ANDROID" -> tc2rGithubService.getAndroidQuestionsJson()
            "C"       -> tc2rGithubService.getCQuestionsJson()
            "C#"      -> tc2rGithubService.getCSharpQuestionsJson()
            "CPP"     -> tc2rGithubService.getCPPQuestionsJson()
            "DART"    -> tc2rGithubService.getDartQuestionsJson()
            "DP"      -> tc2rGithubService.getDPQuestionsJson()
            "DSA"     -> tc2rGithubService.getDSAQuestionsJson()
            "GOLANG"  -> tc2rGithubService.getGolangQuestionsJson()
            "HTML5"   -> tc2rGithubService.getHTML5QuestionsJson()
            "JS"      -> tc2rGithubService.getJSQuestionsJson()
            "JAVA"    -> tc2rGithubService.getJavaQuestionsJson()
            "PHP"     -> tc2rGithubService.getPHPQuestionsJson()
            "PYTHON"  -> tc2rGithubService.getPythonQuestionsJson()
            "RUBY"    -> tc2rGithubService.getRubyQuestionsJson()
            "IOS"     -> tc2rGithubService.getIOSQuestionsJson()
            else      -> tc2rGithubService.getAndroidQuestionsJson()
        }
    }
}
