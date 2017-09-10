package com.codetest.usermgmnt.common;

public class AuthException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8810338314401715158L;
	
	public AuthException() {
		// TODO Auto-generated constructor stub
	}
	
	public AuthException(String errorCode,String errorMsg){
		super(errorCode,errorMsg);
	}
	
	public AuthException(String errorCode,String errorMsg,Throwable th){
		super(errorCode,errorMsg,th);
	}

}
