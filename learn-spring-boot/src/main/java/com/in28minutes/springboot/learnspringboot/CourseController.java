package com.in28minutes.springboot.learnspringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//REST API 만들기 

@RestController
public class CourseController {
	
	@RequestMapping("/courses") 
	// /courses를 입력하면 코드 목록을 반환한다 
	public List<Course> retrieveAllCourses() {
		return Arrays.asList(
				new Course(1, "Learn AWS", "in28minutes"),
				new Course(2, "Learn DevOps", "in28minutes"),
				new Course(3, "Learn Azure", "in28minutes"),
				new Course(4, "Learn Azure", "in28minutes")

				);
	}
	//Spring boot devTools - 개발자의 생산성을 높임
	//애플리케이션의 재시작을 자동으로 트리거함 
	//pom.xml - 모든 의존성을 정의하는 곳, DevTools는 pom.xml의 변경사항을 처리할 수 X 
}
