package com.interviewprep.template.repository.models

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator

// FIXME: Create Response objects to handle data returned from api.
// Consider using JSON to POJO plugin or website convertor.
class Answer(var answer: String? = "it is a cat", var details: String? = "A cat is a four legged feline belonging to the ...") : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(p0: Parcel, p1: Int) {
        TODO("Not yet implemented")
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
