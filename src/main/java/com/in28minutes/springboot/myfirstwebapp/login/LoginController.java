package com.in28minutes.springboot.myfirstwebapp.login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("email")
public class LoginController {
	
//	@Autowired
//	private AuthenticationService authenticationService;
	
	
//	@RequestMapping(value="login",method=RequestMethod.GET)
//	public String showLogin(ModelMap model) {
//		return "login";
//	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String gotoWelcomePage(ModelMap model) {
		//model.put("email", "edgarcamelo03");
		
		model.put("email", getLoggedInUser());
		return "welcome";
	}
	
	// spring security will handle this for us
	
//	@RequestMapping(value="login",method=RequestMethod.POST)
//	public String recieveCredentials(@RequestParam String email,@RequestParam String password,ModelMap model) {
//		model.put("email", email);
//		model.put("password", password);
//		
//		
//		if(authenticationService.authenticate(email, password)) {
//			return "welcome";
//		}
//		model.put("message", "Wrong password");
//		return "login";
//	}
	private String getLoggedInUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}
