package com.company.project.response;


public class CommonResponse<T> {
	
	private String message;
	private Integer errorCode;
	private T body;

	public CommonResponse() {
	}

	public CommonResponse(T body) {
		this.body = body;
	}

	public CommonResponse(String message, int errorCode) {
		this.message = message;
		this.errorCode = errorCode;
	}

	public CommonResponse(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}


}
