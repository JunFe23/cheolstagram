package com.cos.photogramstart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;

@EnableWebSecurity // 해당 파일로 security를 활성화 시킴.
@Configuration // IoC
public class SecurityConfig  extends WebSecurityConfigurerAdapter{

	@Bean
	public BCryptPasswordEncoder encoded() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// super 삭제 - 기존 security가 가지고 있던 기능이 다 비활성화됨.
		http.csrf().disable();
		http.authorizeRequests()
			.antMatchers("/", "/user/**", "image/**", "/subscribe/**", "/comment/**").authenticated() // 해당페이지로 들어오면 로그인 페이지로 이동. 
			.anyRequest().permitAll() // 나머지 페이지는 허용.
			.and()
			.formLogin()
			.loginPage("/auth/signin") // 이동되는 로그인 페이지.
			.defaultSuccessUrl("/"); // 로그인을 성공하면 이동하는 페이지.
	}
}
