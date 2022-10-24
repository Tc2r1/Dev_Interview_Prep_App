---
name: 🚀 Add api methods
about: Add Method to request Json Information for a language in the languages folder. 
title: "Add Method to request Json Information for a language in the languages folder."
labels: good first issue, hacktoberfest, help-wanted, help wanted
---

## Add Method to request Json Information for a language in the languages folder. 
### Skill Level: Easy

1) Navigate to `[MODULE]/repository.tc2rgithubrepository.source.remote.Tc2rGithubService`

2) Add a request method to get both the Answers.json and Questions.json from a missing language folder so that application may have a way of retrieving information for more than one type of quiz.  

Example: 

    @GET("Tc2r1/DevInterview_Questions/master/Languages/Android/answers.json")
    suspend fun requestAndroidAnswers(): Response<AnswersResponse>

    // Gets answers objects
    @GET("Tc2r1/DevInterview_Questions/master/Languages/Android/questions.json")
    suspend fun requestAndroidQuestionsJson(): Response<QuestionsResponse>
    

    ### Optionally: 
    Additionally create the methods that will evoke these calls. 
