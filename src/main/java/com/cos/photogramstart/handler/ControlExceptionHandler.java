package com.cos.photogramstart.handler;

import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.web.dto.CMRespDto;

@RestController
@ControllerAdvice // exception이 발생할 때 낚아챔.
public class ControlExceptionHandler {

	@ExceptionHandler(CustomValidationException.class) // runtimeexception이 발생하는 모든 exception을 함수가 가로챈다.
	public CMRespDto<?> validationException(CustomValidationException e) {
		return new CMRespDto<Map<String, String>> (-1,e.getMessage(), e.getErrorMap());
	}
}
