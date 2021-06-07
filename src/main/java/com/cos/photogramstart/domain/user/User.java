package com.cos.photogramstart.domain.user;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// JPA(Java Persistence API) - 자바로 데이터를 영구적으로 저장(DB에)할 수 있는 API

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity // DB에 테이블을 생성해줌.
public class User {
	@Id // primary key 역할
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 번호 증가 전략을 데이터베이스를 따라간다.
	private int id;
	
	private String username;
	private String password;
	
	private String name;
	private String website; // 웹사이트
	private String bio; // 자기소개
	private String email;
	private String phone;
	private String gender;
	
	private String profileImageUrl; // 사진
	private String role; // 권한
	
	private LocalDateTime createDate;
	
	@PrePersist // DB에 INSERT 되기 전에 실행.
	public void createDate() {
		this.createDate = LocalDateTime.now();
	}
	
}