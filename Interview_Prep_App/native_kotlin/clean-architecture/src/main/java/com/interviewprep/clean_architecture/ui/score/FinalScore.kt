package com.interviewprep.clean_architecture.ui.score

import android.os.Parcelable

@kotlinx.parcelize.Parcelize
data class FinalScore(
    val questionsCount: Int,
    val correctAnswersCount: Int,
) : Parcelable {
    val percentageScore: Int
        get() = correctAnswersCount / questionsCount * 100
}