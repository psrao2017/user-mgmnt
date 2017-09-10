package com.codetest.usermgmnt.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class EmailMessage {

	private String content;

	@JsonProperty("email")
	private String toMail;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getToMail() {
		return toMail;
	}

	public void setToMail(String toMail) {
		this.toMail = toMail;
	}

	@Override
	public String toString() {
		return "EmailMessage [content=" + content + ", toMail=" + toMail + "]";
	}

}
