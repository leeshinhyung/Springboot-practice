package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

//private Logger logger = LoggerFactory.getLogger(getClass());

// "login" => login.jsp 로 리디렉션 / redirect controller to view 
	
//http://localhost:8080/login?name=Ranga
//URL에서 값을 받아서 Controller 에 전달 
//Model - controller -> jsp 로 전달 

@Controller
@SessionAttributes("name")
public class LoginController {
	
	private AuthenticationService authenticationService;
	
	public LoginController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}

	@RequestMapping(value="login", method=RequestMethod.GET)
	public String gotoLoginPage() {
		return "login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String gotoWelcomePage(@RequestParam String name, 
			@RequestParam String password, ModelMap model) {
		
		if(authenticationService.authenticate(name, password)) {
		model.put("name", name);	
		
		//Authentication (인증)
		//name - in28minutes
		//password - dummy 
		
		return "welcome";
		}
		
		model.put("error", "Invalid Credentials! Please try again.");
		return "login";
	}
}


