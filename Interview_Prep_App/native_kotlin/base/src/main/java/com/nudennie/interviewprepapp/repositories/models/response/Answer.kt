package com.nudennie.interviewprepapp.repositories.models.response

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator

/**
 * Created by Tc2r on 5/19/2017.
 *
 *
 * Description:
 */
class Answer @JvmOverloads constructor(var answer: String? = "", var details: String? = "") : DomainObject, Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(answer)
        dest.writeString(details)
    }

    override fun getId(): Int? {
        return getId()
    }

    override fun setId(id: Int?) {
        this.setId(id)
    }

    companion object CREATOR : Creator<Answer> {
        override fun createFromParcel(parcel: Parcel): Answer {
            return Answer(parcel)
        }

        override fun newArray(size: Int): Array<Answer?> {
            return arrayOfNulls(size)
        }
    }
}
