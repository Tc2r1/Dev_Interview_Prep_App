package com.interviewprep.kotlinretrofit.repository.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Created by Tc2r on 5/19/2017.
 *
 *
 * Description:
 */
@Parcelize
data class Answer(
    @SerializedName("answer")
    var answer: String? = null,
    @SerializedName("details")
    var details: String? = null
) : Parcelable
