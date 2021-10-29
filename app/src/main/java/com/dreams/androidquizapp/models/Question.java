package com.dreams.androidquizapp.models;

/**
 * Created by Tc2r on 5/19/2017.
 * <p>
 * Description:
 */

public class Question {
	private final int id;
	private final String question;
	private final String details;
	private final String questionType;
	private final String shortAns;
	private final String trueOrFalse;

	public int getId() {
		return id;
	}

	public String getQuestionType() {
		return questionType;
	}

	public String getQuestion() {
		return question;
	}

	public String getDetails() {
		return details;
	}

	public String getShortAns() {
		return shortAns;
	}

	public String getTrueOrFalse() {
		return trueOrFalse;
	}


	public static class Builder {
		// Required Parameters
		private final int id;
		private final String questionType;
		private final String question;
		private final String details;

		// Optional Parameters - Initialized to default variables.
		private String shortAns = "";
		private String trueOrFalse = "false";

		public Builder(int id, String questionType, String question, String details) {
			this.id = id;
			this.questionType = questionType;
			this.question = question;
			this.details = details;

		}

		public Builder shortAns(String val) {
			shortAns = val;
			return this;
		}

		public Builder trueOrFalse(String val) {
			trueOrFalse = val;
			return this;
		}

		public Question build() {
			return new Question(this);
		}
	}

	private Question(Builder builder) {
		id = builder.id;
		questionType = builder.questionType;
		question = builder.question;
		details = builder.details;
		shortAns = builder.shortAns;
		trueOrFalse = builder.trueOrFalse;
	}
}
