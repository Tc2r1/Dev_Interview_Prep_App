package com.tc2r.javatemplate.repositories.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.tc2r.javatemplate.repositories.models.response.DomainObject;

// FIXME: Create Response objects to handle data returned from api.
// Consider using JSON to POJO plugin or website convertor.

public class Answer implements DomainObject, Parcelable {


    private Integer id;
    private String answer;
    private String details;


    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Answer() {
    }

    public Answer(String answer, String details) {
        this.answer = answer;
        this.details = details;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.answer);
        dest.writeString(this.details);
    }

    protected Answer(Parcel in) {
        this.answer = in.readString();
        this.details = in.readString();
    }

    public static final Creator<Answer> CREATOR = new Creator<Answer>() {
        @Override
        public Answer createFromParcel(Parcel source) {
            return new Answer(source);
        }

        @Override
        public Answer[] newArray(int size) {
            return new Answer[size];
        }
    };
}
