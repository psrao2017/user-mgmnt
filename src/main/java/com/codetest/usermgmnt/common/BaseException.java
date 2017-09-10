package com.codetest.usermgmnt.common;

@SuppressWarnings("serial")
public abstract class BaseException extends RuntimeException {
	
	private String errorCode;
	
	public BaseException(){
		
	}
	
	public BaseException(String errorCode){
		this.errorCode = errorCode;
	}
	
	public BaseException(String errorCode,String errorMessage){
		super(errorMessage);
		this.errorCode = errorCode;
	}
	
	public BaseException(String errorCode,String errorMessage,Throwable th){
		super(errorMessage,th);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
}
