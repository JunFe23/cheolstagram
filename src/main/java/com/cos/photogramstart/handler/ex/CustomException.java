package com.cos.photogramstart.handler.ex;

import java.util.Map;

public class CustomException extends RuntimeException{
	
	// 객체를 구분할 때 씀. 중요한거 아님.
	private static final long serialVersionUID = 1L;

	public CustomException(String message) {
		super(message); // 부모한테 던짐.
	}
}