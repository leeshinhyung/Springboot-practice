package com.in28minutes.springboot.learnspringboot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//currency-service.url=
//currency-service.username=
//currency-service.key=

//application.properties에 property 설정해둠 
//매핑하는 작업 


//ConfigurationProperties 사용법 - Spring 컴포넌트를 만들고 주석을 달면 됨
@ConfigurationProperties(prefix = "currency-service")
@Component
public class CurrencyServiceConfiguration {
	
	private String url;
	private String username;
	private String key;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	

}
