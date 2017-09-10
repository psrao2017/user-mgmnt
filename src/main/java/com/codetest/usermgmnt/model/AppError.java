package com.codetest.usermgmnt.model;

public class AppError {

	private String code;

	private String message;

	public AppError() {
	}

	public AppError(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "AppError [code=" + code + ", message=" + message + "]";
	}

}
