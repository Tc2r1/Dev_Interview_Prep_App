package com.dreams.androidquizapp.models

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

/**
 * Created by Tc2r on 5/19/2017.
 *
 *
 * Description:
 */
@Parcelize
class Answer(
    @SerializedName("answer")
    var answer: String? = null,
    @SerializedName("details")
    var details: String? = null
) :  Parcelable