package com.cos.photogramstart.handler.ex;

import java.util.Map;

public class CustomValidationException extends RuntimeException{
	
	// 객체를 구분할 때 씀. 중요한거 아님.
	private static final long serialVersionUID = 1L;

	private Map<String, String> errorMap;
	
	public CustomValidationException(String message, Map<String, String> errorMap) {
		super(message); // 부모한테 던짐.
		this.errorMap = errorMap;
	}
	
	public Map<String, String> getErrorMap() {
		return errorMap;
	}
}
