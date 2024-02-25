package com.in28minutes.learnspringframework.examples.e1;

import java.util.Arrays;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//싱글톤 스코프와 프로토타입 스코프에 대해 배운다.


@Component
//Singleton (싱글톤 스코프)
//디폴트 값, Spring IoC 컨테이너당 객체 인스턴스 하나
//stateless bean 생성 시 사용
//java singleton vs Spring singleton
// java 싱글톤 - java 가상 머신 하나 당 객체 인스턴스 하나 / 걍 똑같다고 생각하자 ~ 
class NormalClass{
	
}


@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
//Prototype (프로토타입 스코프)
//scope를 추가하여 value를 prototype로 지정하여 프로토타입클래스로 만들었다.
//빈을 참조할 때 마다 새로운 인스턴스를 생성하고 싶은 경우 프로토타입을 사용한다. 
//Spring IoC 컨테이너당 객체 인스턴스가 여러 개 
//사용자 정보가 유지되는 Bean을 만들고자 할 때 사용한다.
class PrototypeClass{
	
}

@Configuration
@ComponentScan 
public class BeanScopesLauncherApplication {
	
	public static void main(String[] args) {
		
		try(var context = 
				new AnnotationConfigApplicationContext
				(BeanScopesLauncherApplication.class)) {
			
			System.out.println(context.getBean(NormalClass.class));
			System.out.println(context.getBean(NormalClass.class));
			//똑같은 해시코드가 출력됨 -> 인스턴스가 항상 같다. 
			
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
			//프로토타입 클래스는 빈을 호출할 때마다 새로운 해시코드 값이 나타남 
			//호출할 때마다 새로운 인스턴스가 들어온다 
		}
	}
}

//+ web-aware SpringApplicationContext 스코프 종류들 
//Request - HTTP 요청 당 객체 인스턴스 하나 생성 
//Session - 사용자 HTTP 세션당 객체 인스턴스 하나 생성
//Application - 웹 애플리케이션 전체에 객체 인스턴스 하나
//Websocket - 웹소캣 인스턴스당 객체 인스턴스 하나 



