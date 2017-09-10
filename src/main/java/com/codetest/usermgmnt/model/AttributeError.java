package com.codetest.usermgmnt.model;

import java.io.Serializable;

public class AttributeError implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4899647314333118361L;

	private String field;

	private String message;

	public AttributeError() {

	}

	public AttributeError(String field, String message) {
		this.field = field;
		this.message = message;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "AttributeError [field=" + field + ", message=" + message + "]";
	}

}
