<div align="center">
    <br>
    <a href="https://github.com/Tc2r1/Hacktoberfest_Interview_App/tree/master/Interview_Prep_App">
        <img src="Assets/developer_interview_app.svg" width="1080" height="250" alt="Dev Interview App for HacktoberFest!">
    </a>
    <br>
</div>

<h1 align="center">
<p>🎃
<img src="Assets/quiz_01.png?raw=true" height="500">
<img src="Assets/quiz_02.png?raw=true" height="500">
<img src="Assets/quiz_03.png?raw=true" height="500">🎃
</p>
</h1>

<h3 align="center">🎃 Use this project to make your first contribution to an open source project on GitHub. Practice making your first pull request to
a public repository before doing the real thing! 🎃</h3>

This repository is open to all members of the GitHub community. Any member may contribute to this project without being a collaborator.

# Don't forget to give ⭐ ( To give star you can see on your screen on top right hand side Just smash it 💥 :)


<div align="left">
    <br>
<a href="https://github.com/Tc2r1/Hacktoberfest_Interview_App/issues">
        <img src="Assets/steps_for_contributing.svg" width="400px" height="200px" alt="Add Some Code!">
            </a>
</div> 


(Type **"!assign"** in a comment under issues to be assigned an issue)

**I have worked really hard to create a variety of ways in which everyone contribute to this project, there should be multiple directions any skill level can go in with this project.
Below are a few different ways all skill levels and programmer types can contribute.**


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

### Create a markdown.md file named `[language]_cheatsheet_[username].md`

Inside this file, create a cheatsheet that others can use to help them study for interviews.

### Create a document in the project `and-summit-22-notes` with your thoughts on what you found interesting that was discussed during [Android Summit 2022](https://developer.android.com/events/dev-summit/technical-talks#modern-android-development)

## Low Code Contributions

* Add Comments to at least 2 files in the project
  * comments should explain and detail what the code is doing to help newer developers.
* Helpful Links
  * Add at least 3 links to helpful free resources developers can use to the `readme.md` in the root folder.

[Click Here to Create a Pull Request](https://github.com/Tc2r1/Hacktoberfest_Interview_App/compare)

### 🎃🎃LEVEL 3 CONTRIBUTIONS🎃🎃 - BUILD A MODULE OF THE PROJECT :O!! YOU'RE A BOSS!

Want a challenge? Here you will rebuild the project with options to use the supplied UI. You will focus on showing off a few different libraries and
an architecture of your choice (MVP, MVC, MVVM, HILT, Coroutines, etc etc etc endless possibilities) To show other developers different ways in which
these things can be combined to build the quiz application. Please focus on and gain experience with the repository layer, dependency injection, view
models, and whatever else you like!
Lets see how many different modules we can create!

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

<br>
<br>
<br>

### 🎃🎃LEVEL 2 CONTRIBUTIONS🎃🎃 - RESOLVE A SMALL "ISSUE" TICKET!

Want to get your hands wet with some programming? Look at the open issues and find one that allows you to contribute to one of the modules! These will
vary but should be easy enough.

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

<br>
<br>
<br>

### 🎃🎃Level 1 Contributions🎃🎃 - Add a minimal of 3 objects to the questions or answers json of your choice.

We are using Json to create a list of frequently given interview questions and answers for different languages!
In every directory, you will find two files `questions` and `answers`

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

4. Open Contributors.md file and add your name and relevant information.
5. Make Pull Request.

<div align="left">
    <br>
<a href="https://github.com/Tc2r1/Hacktoberfest_Interview_App/issues">
        <img src="Assets/what_is_hacktoberfest.svg" width="400px" height="200px" alt="What Is HacktoberFest?">
            </a>
    <br>
</div>
<div align="center">
A month-long celebration from October 1st - 31st sponsored by [Digital Ocean](https://hacktoberfest.digitalocean.com/) and [GitHub](https://github.com/blog/2433-celebrate-open-source-this-october-with-hacktoberfest) to get people involved in [Open Source](https://github.com/open-source). Create your very first pull request to any public repository on GitHub and contribute to the open source developer community.
</div>



<h1 align="center"> Hacktoberfest 2022 🎉</h1>

<div align="center">
<img src="https://img.shields.io/badge/hacktoberfest-2022-blueviolet" alt="Hacktober Badge"/>
<img src="https://img.shields.io/badge/hacktoberfest-2021-blueviolet" alt="Hacktober Badge"/>
 <img src="https://img.shields.io/static/v1?label=%F0%9F%8C%9F&message=If%20Useful&style=style=flat&color=BC4E99" alt="Star Badge"/>
 <a href="https://github.com/Tc2r1" ><img src="https://img.shields.io/badge/Contributions-welcome-violet.svg?style=flat&logo=git" alt="Contributions"/></a>

</div>

### 🗣 Hacktoberfest encourages participation in the open source community, which grows bigger every year. Complete the 2021 challenge and earn a limited edition T-shirt.

📢 **Register [here](https://hacktoberfest.com/auth/) for Hacktoberfest and make four pull requests (PRs) between October 1st-31st to grab free SWAGS
🔥.**

## Rules

- Don't use filthy words and be welcome for beginners and other people in this community.

---

## Github Contribution Rules

- Pull requests can be submitted to any opted-in repository on GitHub or GitLab.
- The pull request must contain commits you made yourself.
- If a maintainer reports your pull request as spam, it will not be counted toward your participation in Hacktoberfest.
- If a maintainer reports behavior that’s not in line with the project’s code of conduct, you will be ineligible to participate.
- To get a shirt, you must make four approved pull requests (PRs) on opted-in projects between October 1-31 in any time zone.
- This year, the first 40,000 participants (maintainers and contributors) who complete Hacktoberfest can elect to receive one of two prizes: a tree planted in their     name, or the Hacktoberfest 2022 t-shirt.

---

Contributions of any kind welcome!

-Best of luck ✌️

# Don't forget to give ⭐ 
## ( To give star you can see on your screen on top right hand side Just smash it 💥 :) )

<div align="center">
    <br>
<a href="https://github.com/Tc2r1/Hacktoberfest_Interview_App/issues">
        <img src="Assets/contributors_list.svg" width="400px" height="200px" alt="Thanks For Your Help!?">🏆
            </a>
    <br>


🏆🙏 Thanks🙏🏆

<a href="https://github.com/Tc2r1/DevInterview_Questions/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=Tc2r1/DevInterview_Questions" />
</a>

Made with [contrib.rocks](https://contrib.rocks).

> NOTE: if you should be on the list of contributors but we forgot you, don't be shy and let us know!
</div> 
<br>
<br>

## License

[![By-nc-nd](https://licensebuttons.net/l/by-nc-nd/4.0/88x31.png)](http://creativecommons.org/licenses/by-nc-nd/4.0/)

[Nudennie White](https://www.linkedin.com/in/nudennie-w-99411075/)
