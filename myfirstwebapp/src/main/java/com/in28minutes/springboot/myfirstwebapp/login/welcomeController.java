package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

//private Logger logger = LoggerFactory.getLogger(getClass());

// "login" => login.jsp 로 리디렉션 / redirect controller to view 
	
//http://localhost:8080/login?name=Ranga
//URL에서 값을 받아서 Controller 에 전달 
//Model - controller -> jsp 로 전달 

@Controller
@SessionAttributes("name")
public class welcomeController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String gotoWelcomePage(ModelMap model) {
		model.put("name", "in28minutes");
		return "welcome";
	}
}


