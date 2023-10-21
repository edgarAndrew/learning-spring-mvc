package com.in28minutes.springboot.myfirstwebapp.login;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	public boolean authenticate(String email,String password) {
		
		boolean isValidPassword = password.equals("test123");
		return isValidPassword;
	}
}
