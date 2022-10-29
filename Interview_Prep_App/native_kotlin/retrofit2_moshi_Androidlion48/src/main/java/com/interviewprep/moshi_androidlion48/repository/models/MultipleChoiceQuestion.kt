package com.interviewprep.moshi_androidlion48.repository.models

/**
 * Description: After gaining the data from the api request, create a class to store said relevant * to multiple choice questions. * @param question = The question that will be presented to the user. * @param answers = a list of answers the user will be able to choose from. The correct answer should
 * always be the first object in this list. */
// FIXME: Flesh out this object to suit the needs of your project.
class MultipleChoiceQuestion constructor(
    val question: String,
    val answers: List<Answer>
)
