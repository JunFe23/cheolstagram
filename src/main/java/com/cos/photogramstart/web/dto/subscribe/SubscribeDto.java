package com.cos.photogramstart.web.dto.subscribe;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubscribeDto {
	private int id; // 구독한 사용자들의 id.
	private String username; // 구독한 사용자의 유저네임.
	private String profileImageUrl; // 사진.
	private Integer subscribeState; // 구독한 상태인지.
	private Integer equalUserState; // 로그인 한 동일 아이디인지.
}
