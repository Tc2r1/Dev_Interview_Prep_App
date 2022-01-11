package com.dreams.androidquizapp.models

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import com.google.gson.annotations.SerializedName

/**
 * Created by Tc2r on 5/19/2017.
 *
 *
 * Description:
 */
class Answer : DomainObject, Parcelable {
    private var id: Int? = null

    @SerializedName("answer")
    var answer: String? = null
    @SerializedName("details")
    var details: String? = null

    constructor(answer: String, details: String) {
        this.answer = answer
        this.details = details
    }
    constructor(answer: String) {
        this.answer = answer
        this.details = ""
    }

    override fun getId(): Int {
        return id!!
    }

    override fun setId(id: Int?) {
        this.id = id
    }

    constructor() {}

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(answer)
        dest.writeString(details)
    }

    protected constructor(`in`: Parcel) {
        answer = `in`.readString()
        details = `in`.readString()
    }

    companion object {
        val CREATOR: Creator<Answer?> = object : Creator<Answer?> {
            override fun createFromParcel(source: Parcel): Answer? {
                return Answer(source)
            }

            override fun newArray(size: Int): Array<Answer?> {
                return arrayOfNulls(size)
            }
        }
    }
}
