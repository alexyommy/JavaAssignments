package com.alexyom.spring.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class NewQuestion {
	@NotBlank()
	private String question;
	
	@Pattern(regexp="^(([a-zA-Z\\s])+$|([a-zA-Z\\s]+,)[a-zA-Z\\s]+){1,2}$", message="Tags must be separated by commas. (Max 3)")
	private String tags;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
	
	public String[] splitTags() {
		return this.tags.split("\\s*,\\s*");
	}
}
