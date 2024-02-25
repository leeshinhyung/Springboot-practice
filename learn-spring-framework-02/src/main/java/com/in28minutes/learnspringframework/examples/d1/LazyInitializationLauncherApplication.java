package com.in28minutes.learnspringframework.examples.d1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA{
	
}

@Component
@Lazy 
//@Lazy의 역할 : 지연 초기화. Bean이 사용되는 순간 초기화 된다. 
//기본적으로 Spring Bean은 애플리케이션이 시작되거나 Spring context가 실행될 때 즉시 초기화된다. (some ~ logic이 먼저 출력되겠지)
//항상 즉시 초기화가 권장된다. lazily 초기화는 권장되지는 않고, 자주 사용되지도 않는다.
//@Lazy -> 복잡한 초기화 논리가 많고, 시작 시 지연시키고 싶지 않은 상황에 고려
//@Lazy는 @Component, @Bean, @Configuration에 사용 가능하다
//지연 초기화를 사용하는 경우, 애플리케이션이 시작될 때 Spring 구성 오류는 발견되지 X, 런타임 오류 발생 

class ClassB{
	
	private ClassA classA;
	
	public ClassB(ClassA classA) {
		System.out.println("Some Initialization logic"); 
		this.classA = classA; //초기화 (Bean이 load됨)
	}
	
	public void doSomething() {
		System.out.println("Do Something");
	}
}

@Configuration
@ComponentScan 
public class LazyInitializationLauncherApplication {
	
	public static void main(String[] args) {
		
		try(var context = 
				new AnnotationConfigApplicationContext
				(LazyInitializationLauncherApplication.class)) {
		
			System.out.println("Initialization of context is completed");
			
			context.getBean(ClassB.class).doSomething();
		}
	}

}
