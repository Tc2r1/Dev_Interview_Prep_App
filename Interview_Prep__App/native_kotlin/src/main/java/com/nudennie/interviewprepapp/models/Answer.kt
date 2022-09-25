package com.nudennie.interviewprepapp.models

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator

/**
 * Created by Tc2r on 5/19/2017.
 *
 *
 * Description:
 */
class Answer : DomainObject, Parcelable {
    private var id: Int? = null

    // 	public Answer(String answer, String details) {
    // 		this.answer = answer;
    // 		this.details = details;
    // 	}
    // 	public Answer(String answer) {
    // 		this.answer = answer;
    // 		this.details = "";
    // 	}
    var answer: String? = null
    var details: String? = null
    override fun getId(): Int {
        return id!!
    }

    override fun setId(id: Int?) {
        this.id = id
    }

    constructor()

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
        @JvmField
        val CREATOR: Creator<Answer?> = object : Creator<Answer?> {
            override fun createFromParcel(source: Parcel): Answer {
                return Answer(source)
            }

            override fun newArray(size: Int): Array<Answer?> {
                return arrayOfNulls(size)
            }
        }
    }
}
