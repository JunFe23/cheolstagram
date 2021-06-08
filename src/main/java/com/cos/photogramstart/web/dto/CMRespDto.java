package com.cos.photogramstart.web.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CMRespDto<T> { // 제네릭을 사용해서 다형성에 이용.
	private int code; // 1(성공), -1(실패)
	private String message;
	private T data;
	
}
