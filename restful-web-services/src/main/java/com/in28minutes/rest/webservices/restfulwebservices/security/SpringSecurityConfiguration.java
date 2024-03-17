package com.in28minutes.rest.webservices.restfulwebservices.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

//1. 모든 Request를 보낼 시, 자격 증명을 받도록 함
//2. 증명이 안될 시, 웹 페이지가 보여지도록 함.
//3. CSRF(POST와 PUT 요청에 영향을 줌)를 해제하여 POST 요청을 보낼 수 있도록 함
@Configuration
public class SpringSecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        //모든 요청이 인증을 받게 함
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );

        //기본 인증 사용 설정 -> 인증 팝업창이 뜨도록 함
        http.httpBasic(withDefaults());

        //csrf 비활성화 -> POST 요청 가능
        http.csrf().disable();

        return http.build();
    }

}
