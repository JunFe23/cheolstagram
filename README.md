# 철스타그램 - 인스타그램 클론 코딩(이지업 포토그램)

### STS 툴에 세팅하기 - 플러그인 설정
- https://blog.naver.com/getinthere/222322821611

### 의존성

- Sring Boot DevTools
- Lombok
- Spring Data JPA
- MariaDB Driver
- Spring Security
- Spring Web
- oauth2-client

```xml
<!-- 시큐리티 태그 라이브러리 -->
<dependency>
	<groupId>org.springframework.security</groupId>
	<artifactId>spring-security-taglibs</artifactId>
</dependency>

<!-- JSP 템플릿 엔진 -->
<dependency>
	<groupId>org.apache.tomcat</groupId>
	<artifactId>tomcat-jasper</artifactId>
	<version>9.0.43</version>
</dependency>

<!-- JSTL -->
<dependency>
	<groupId>javax.servlet</groupId>
	<artifactId>jstl</artifactId>
</dependency>
```

### 데이터베이스

```sql
create user 'cos'@'%' identified by 'cos1234';
GRANT ALL PRIVILEGES ON *.* TO 'cos'@'%';
create database photogram;
```

### yml 설정

```yml
server:
  port: 8080
  servlet:
    context-path: /
    encoding:
      charset: utf-8
      enabled: true
    
spring:
  mvc:
    view:
      prefix: /WEB-INF/views/
      suffix: .jsp
      
  datasource:
    driver-class-name: org.mariadb.jdbc.Driver
    url: jdbc:mariadb://10.211.55.7:3307/cheolgram?serverTimezone=Asia/Seoul
    username: cos
    password: cos1234
    
  jpa:
    open-in-view: true
    hibernate:
      ddl-auto: update
      naming:
        physical-strategy: org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
    show-sql: true
      
  servlet:
    multipart:
      enabled: true
      max-file-size: 2MB

  security:
    user:
      name: test
      password: 1234   

file:
  path: /Users/junfe/Desktop/Coding/웹프로젝트/개인/cheolstagram/workspace/springbootwork/upload/
```

### 태그라이브러리

```jsp
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
```


### 2021.06.04
- cheolstagram 프로젝트 생성.
- maria db 설치 및 설정.
- STS4와 maria db 연동

### 2021.06.05
- controller 동작 방식 이해
- http 4가지 요청 방식
- 쿼리스트링, 주소변수매핑
- http body 데이터 전송하기, json 응답 공부

### 2021.06.06
- html 응답

### 2021.06.07
- jsp파일에 java코드 사용.
- redirection 연습

- security config 생성
- CSFR 토큰 해제
- User model 만들기
- 기본 회원가입 완료!!!!

### 2021.06.08
- 비밀번호 해시
- 전처리 후처리
- 유효성 검사
- 글로벌 예외처리
- 공통 응답 DTO 만들기
- 공통 응답 script 만들기

### 2021.06.09
로그인 완료.
- view 연결
- 세션 정보 확인

### 2021.06.10
회원정보 수정
- 시큐리티 태그라이브러리
- ajax 사용

## 2021.06.11
- 회원정보수정 에러남. -> 미해결

## 2021.06.12
- 회원정보수정 완료.

## 2021.06.13
- 구독하기 완료

## 2021.06.14
프로필페이지
- Image 모델 만들기
- Image 서버에 업로드
- Image DB로 업로드
- Image 유효성 검사
