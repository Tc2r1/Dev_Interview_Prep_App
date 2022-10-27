package com.interviewprep.kotlinviewbinding.repository.models

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
data class Question(
    @SerializedName("id")
    var id: Int,
    @SerializedName("questionType")
    val questionType: String,
    @SerializedName("question")
    val question: String,
    @SerializedName("details")
    val details: String,
    @SerializedName("shortAns")
    val shortAns: String,
    @SerializedName("trueOrFalse")
    val trueOrFalse: String? = null
) : Parcelable
