package com.in28minutes.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
	//"say-hello" => "Hello! What are you learning today?"
	
	// http://localhost:8080/say-hello
	// url 호출 시 리턴 
	@RequestMapping("say-hello")
	@ResponseBody		//return 한 것을 브라우저에 전송 
	public String sayHello() {
		return "Hello! What are you learning today?";
	}

	@RequestMapping("say-hello-html")
	@ResponseBody		//return 한 것을 브라우저에 전송 
	public String sayHelloHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title> My First HTML page - Changed </title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("My First HTML page - Changed");
		sb.append("</body>");
		sb.append("</html>");
		
	return sb.toString();
	}
	
	// "say-hello-jsp" => sayHello.jsp 로 리디렉션
	// /src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
	// /src/main/resources/META-INF/resources/WEB-INF/jsp/welcome.jsp
	// /src/main/resources/META-INF/resources/WEB-INF/jsp/login.jsp
	// /src/main/resources/META-INF/resources/WEB-INF/jsp/todos.jsp

	
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
		return "sayHello";
	}
	
}


