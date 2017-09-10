package com.codetest.usermgmnt.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ValidationError implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 314496267544939563L;

	public ValidationError() {
	}

	private List<AttributeError> errors = new ArrayList<AttributeError>();

	public void addError(String field, String message) {
		errors.add(new AttributeError(field, message));
	}

	public List<AttributeError> getErrors() {
		return errors;
	}

	public void setErrors(List<AttributeError> errors) {
		this.errors = errors;
	}

	@Override
	public String toString() {
		return "ValidationError [errors=" + errors + "]";
	}

}
