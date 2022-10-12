---
name: 🚀 Add To Question Or Answers Json. 
about: Add Quiz Question and Answers 
title: "[FEATURE NAME]"
labels: good first time, hacktoberfest-accepted, help-wanted
---

## Level 1 Contributions - Add a minimal of 3 objects to the questions or answers json of your choice. 

We are using Json to create a list of frequently given interview questions and answers for different languages!
In every directory, you will find two files `questions` and `answers`

## If you'd like to contribute to **questions.json**:
1. Fork this repo
2. Navigate to the language folder you would like to contribute to. 
3. Open Questions, here copy the last item in the list, and fill in each label. 
	 
	 **id**: incremental number.

	 **question**: An interview question.

	 **details**: An in depth answer of the question, **no more than 150 characters.**

	 **questionType**: "multi" for a multiple answer type question, or "bool" for a true or false type question.  

	 **trueOrFalse**: if your question is multi, leave this false. If your question is true or false, type the correct answer. 

	 **shortAns**: The One Sentence Answer to your question PLEASE DO NOT INCLUDE THE TERM/SUBJECT USED IN THE QUESTION HERE, also Prefix with **"it is"**, **Please keep these less than 60 Characters**

	 **tag**: A one word tag that specifies what part of a project your question is in reference to.
	
	Please make sure to match the syntax of the previous items. Questions should end with a punctuation mark.
	Example: Please Make sure to start "shortAns" with "It is" (ie if the answer is "a cat" then say "It is a cat."
	
    {
      "id": 0,
      
      "question": "What is Android?",
      
      "details": "Android is a stack of software for mobile devices which includes an Operating System, middleware and some key applications. The application executes within its own process and its own instance of Dalvik Virtual Machine.",
      
      "questionType": "multi",
      
      "trueOrFalse": false,
      
      "shortAns": "**It is** a stack of software for mobile devices.",
      
      "tag": "android"
      },
    
    {
    
      "id": 1,
      
      "question": "The Android Operating System runs on many different devices?",
      
      "details": "Android operating system devices — including computers, digital cameras, media players, notebooks, and smartphones. There are now more than 24,000 different Android devices.",
      
      "questionType": "bool",
      
      "trueOrFalse": true,
      
      "shortAns": "**NOTHING GOES HERE FOR BOOLEAN QUESTIONS" = "",
      
      "tag": "Operating System"
      
    }

4. Open Contributors.md file and add your name and relevant information. 

5. Make Pull Request.

Json Objects in the Answers.json are terms that will be used to hide the correct answer supplied by an item from Questions. json.  Please Make sure to start "Answer" with "It is" (ie if the answer is "a cat" then say "It is a cat." 


## If you'd like to contribute to **answers.json**:
1. Fork this repo
2. Navigate to the language folder you would like to contribute to. 
3. Open Answers.json, here copy the last item in the list, and fill in each label. 
	 
 **answer**: A topic with a basic small description. 
 **details**: Detailed Information on the subject supplied in Answer, **no more than 150 characters.**
	
Please make sure to match the syntax of the previous items. Answers should end with a punctuation mark.
Example: 

   {
   
      "answer": "**It is** everything you can see on the screen of the app.",
      
      "details": "Think of the individual UI elements like buttons, labels, and text fields."
      
   }, 
    
    {
    
      "answer": "**It is** a month-long celebration of open source software run by DigitalOcean.",
      
      "details": "Hacktoberfest encourages participation in the open source community, which grows bigger every year. Complete the 2021 challenge and earn a limited edition T-shirt."
      
    }

4. Open Contributers.md file and add your name and relevant information.
5. Make Pull Request.
