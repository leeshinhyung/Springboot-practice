package com.in28minutes.learnspringframework.examples.h1;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.in28minutes.learnspringframework.game.GameRunner;

//java configuration에서 수행한 작업이 XML 설정에서도 가능하다는 점을 배워보자 

public class XmlConfigurationContextLauncherApplication {
	
	public static void main(String[] args) {
		
		try(var context = 
				new ClassPathXmlApplicationContext("contextConfiguration.xml")) {
		
			Arrays.stream(context.getBeanDefinitionNames())
			.forEach(System.out::println);
			
			System.out.println(context.getBean("name"));
			System.out.println(context.getBean("age"));
			
			context.getBean(GameRunner.class).run();

		}
	}

}
