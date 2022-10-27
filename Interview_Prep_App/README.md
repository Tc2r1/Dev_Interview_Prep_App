# Developer Interview App

## Please star ⭐ this repo to help other developers

<h1 align="center">
<p>🎃
<img src="Assets/quiz_01.png?raw=true" height="500">
<img src="Assets/quiz_02.png?raw=true" height="500">
<img src="Assets/quiz_03.png?raw=true" height="500">🎃
</p>
</h1>

## This is the root folder you should open with IDE to build the android application

Inside this folder are modules written in Java or Kotlin that all showcase different libraries (hilt, retrofit, coroutines), patterns (mvp, mvvm, view models, DI), and techniques to build an application that takes a set of questions and answers from an api request and uses them to make a functioning quiz that users can use to study for their development!

## Our Code Standards

This project attempts to adhere to a level of professionalism:

* Well Documented Code - Please use comments to explain what your functions/methods are doing
* Error Free Code - Please check your code against a static linter for syntax errrors
* We Do Not Accept Spam - Pull Request that are deemed Spam will be marked so and excluded
  * Pull Request that have nothing to do with the subject of this project.
  * Pull Request that are not reworked after requested changes.
  * Empty or zero effort pull request
  * Pull Request without proper descriptions

## How To Contribute

(Type **"!assign"** in a comment under issues to be assigned an issue)

Contributors submitting low- or non-code content to projects [**should create a PR/MR to track it**](https://hacktoberfest.com/about/#low-or-non-code)

[Click Here to Create a Pull Request](https://github.com/Tc2r1/Hacktoberfest_Interview_App/compare)

## No Code Contributions

**LOG YOUR NON-CODE CONTRIBUTION IN THE CONTRIBUTIONS.MD FILE**

* Documentation
  * If you see an area that could benefit from documentation, we welcome these contributions. Be it Code of Conducts, Reformatting a readme., Adding Graphs etc.
  * Writing and translating technical documentation
  * Translating a readme.md to another language
* Designs
  * Use Tools Like Figma to create Mocks for the UI of the application
  * Redesign or create an application icon or splash screen
  * Create a header banner for the project
* Advocacy by podcasts, case studies, blog posts, or social media posts
  * Write a blog post about the github project and how it can help others
  * Shoutout the repository on social media to a popular group
* Maintenance
  * Create feature ideas you think would be benefitual for the application to have
    * At least 2 approve ideas must be submitted to satisfy a contribution of this type
    * Issues should be labeled Triage and Hacktoberfest
  * Review the Pull Request submitted by others.
    * At least 3 request must be reviewed in order to satisfy a contribution of this type.

## Low Code Contributions

* Coding Cheat Sheets
  * Add a coding Cheat Sheet to the `cheat_sheets` folder for a coding language.
* Add Comments to at least 2 files in the project
  * comments should explain and detail what the code is doing to help newer developers.
* Helpful Links
  * Add at least 3 links to helpful free resources developers can use to the `readme.md` in the root folder.

[Click Here to Create a Pull Request](https://github.com/Tc2r1/Hacktoberfest_Interview_App/compare)

## Code Contributions

### 🎃🎃 LEVEL 3 CONTRIBUTIONS 🎃🎃

Level Three Contributions are definately our favorite to see. Here you will create a module of your own within the project and showcase your skills at recreating the Quiz App using unique library combinations. You should focus on showing off a few different libraries and an architecture of your choice (MVP, MVC, MVVM, HILT, Coroutines, etc etc etc endless possibilities).

Please focus on and gain experience with the repository layer, dependency injection, view
models, and whatever else you like!

There are plenty of "Issues" for this type of contribution, though you may have to scroll through the issues page to find them. It is fine if you create one of these without an issue ticket.

Here are steps to complete this type of contribution:

1. navigate to `https://github.com/Tc2r1/DevInterview_Questions/tree/master/Interview_Prep_App/`
2. decide if you want to work in Native_Java or Native_Kotlin, or something else (for something else skip to 6b) open the folder you choose.
3. Fork the repo and create a branch to save your work to.
4. copy the template application folder, paste it into native_kotlin folder, and rename it based on what your project will showcase. for example "retrofit, coroutines, viewmodel, jetpack
   compose" along with your username (IE:
   retrofit2_tc2r1)

5. Open the "Interview_Prep_App" folder in android studio and add your module to the settings.gradle file.
6. Rename the module id com.interviewprep.unique_folder_name_from_step_3 6b. For those who want to work in something besides native android, create a
   folder with your application type in `Interview_Prep_App` folder: "SwiftUI" "Html5" etc.

7. Use your skills and libraries of choice to recreate the project.
8. Pull latest changes from master branch into your branch and resolve all merge conflicts.
9. Open Contributors.md file and add your name and relevant information.
10. Add a README.md to the base of your project folder/ module that list what makes your version of the quiz app special (aka libraries you used,
    patterns, languages, etc)
11. Create a PR (With detailed information and images if possible of your work)!
12. Your PR will be reviewed, after resolving all request, your PR will be accepted
13. CELEBRATE GOOD TIMES COME ON!!
14. RINSE REPEAT! You're a fireball!

### 🎃🎃 LEVEL 2 CONTRIBUTIONS 🎃🎃 - RESOLVE A SMALL "ISSUE" TICKET

Want to get your hands wet with some programming? Look at the open issues and find one that allows you to contribute to one of the modules! These will
vary but should be easy enough.

Alternatively, after building the project, check some of the modules for something you wish to update or add to, These code contributions will also be accepted. 

1. Find an issue and ask for rights/claim to work on it.
2. A Maintainer will grant said permissions.
3. Fork the repo and create a branch to save your work to.
4. Resolve the issue
5. Pull latest changes from master branch into your branch and resolve all merge conflicts.
6. Create a PR!
7. Your PR will be reviewed, after resolving all request, your PR will be accepted
8. Open Contributors.md file and add your name and relevant information.
9. CELEBRATE GOOD TIMES COME ON!!
10. RINSE REPEAT! You're a fireball!

### 🎃🎃Level 1 Contributions 🎃🎃 - Add a minimal of 3 objects to the questions or answers json of your choice

We are using Json to create a list of frequently given interview questions and answers for different languages! In every directory, you will find two files `questions` and `answers`

If you'd like to contribute to **questions.json**:

1. Fork this repo
2. Navigate to the language folder you would like to contribute to.
3. Open Questions, here copy the last item in the list, and fill in each label.

   **id**: incremental number.

   **question**: An interview question.

   **details**: An in depth answer of the question, **no more than 150 characters.**

   **questionType**: "multi" for a multiple answer type question, or "bool" for a true or false type question.

   **trueOrFalse**: if your question is multi, leave this false. If your question is true or false, type the correct answer.

   **shortAns**: The One Sentence Answer to your question PLEASE DO NOT INCLUDE THE TERM/SUBJECT USED IN THE QUESTION HERE, also Prefix with **"it
   is"**, **Please keep these less than 60 Characters**

   **tag**: A one word tag that specifies what part of a project your question is in reference to.

   Please make sure to match the syntax of the previous items. Questions should end with a punctuation mark. Example: Please Make sure to start "
   shortAns" with "It is" (ie if the answer is "a cat" then say "It is a cat."

   {
   "id": 0,

   "question": "What is Android?",

   "details": "Android is a stack of software for mobile devices which includes an Operating System, middleware and some key applications. The
   application executes within its own process and its own instance of Dalvik Virtual Machine.",

   "questionType": "multi",

   "trueOrFalse": false,

   "shortAns": "**It is** a stack of software for mobile devices.",

   "tag": "android"
   },

   {

   "id": 1,

   "question": "The Android Operating System runs on many different devices?",

   "details": "Android operating system devices — including computers, digital cameras, media players, notebooks, and smartphones. There are now more
   than 24,000 different Android devices.",

   "questionType": "bool",

   "trueOrFalse": true,

   "shortAns": "**NOTHING GOES HERE FOR BOOLEAN QUESTIONS" = "",

   "tag": "Operating System"

   }

4. Open Contributors.md file and add your name and relevant information.

5. Make Pull Request.

Json Objects in the Answers.json are terms that will be used to hide the correct answer supplied by an item from Questions. json. Please Make sure to
start "Answer" with "It is" (ie if the answer is "
a cat" then say "It is a cat."

If you'd like to contribute to **answers.json**:

1. Fork this repo
2. Navigate to the language folder you would like to contribute to.
3. Open Answers.json, here copy the last item in the list, and fill in each label.

**answer**: A topic with a basic small description.
**details**: Detailed Information on the subject supplied in Answer, **no more than 150 characters.**

Please make sure to match the syntax of the previous items. Answers should end with a punctuation mark. Example:

{

      "answer": "**It is** everything you can see on the screen of the app.",
      
      "details": "Think of the individual UI elements like buttons, labels, and text fields."

},

    {
    
      "answer": "**It is** a month-long celebration of open source software run by DigitalOcean.",
      
      "details": "Hacktoberfest encourages participation in the open source community, which grows bigger every year. Complete the 2021 challenge and earn a limited edition T-shirt."
      
    }

4. Open Contributors.md file and add your name and relevant information
5. Make Pull Request