package com.cos.photogramstart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;

import com.cos.photogramstart.config.oauth.OAuth2DetailsService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity // 해당 파일로 security를 활성화 시킴.
@Configuration // IoC
public class SecurityConfig  extends WebSecurityConfigurerAdapter{

	private final OAuth2DetailsService oAuth2DetailsService;
	
	@Bean
	public BCryptPasswordEncoder encoded() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// super 삭제 - 기존 security가 가지고 있던 기능이 다 비활성화됨.
		http.csrf().disable();
		http.authorizeRequests()
			.antMatchers("/", "/user/**", "image/**", "/subscribe/**", "/comment/**", "/api/**").authenticated() // 해당페이지로 들어오면 로그인 페이지로 이동. 
			.anyRequest().permitAll() // 나머지 페이지는 허용.
			.and()
			.formLogin()
			.loginPage("/auth/signin") // 이동되는 로그인 페이지. // GET
			.loginProcessingUrl("/auth/signin") // POST -> 스프링 시큐리티가 로그인 프로세스 진행.
			.defaultSuccessUrl("/") // 로그인을 성공하면 이동하는 페이지.
			.and()
			.oauth2Login() // form 로그인도 하는데, oauth2로그인도 할거야.
			.userInfoEndpoint() // oauth2로그인을 하면 최종 응답을 회원정보로 바로 받을 수 있다.
			.userService(oAuth2DetailsService); 
	}
}
