package com.in28minutes.springboot.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.model.*;


@RestController
public class UserLoginController {

	//  @RequestMapping(method = RequestMethod.POST, value="/register/student")
	//
	//  @ResponseBody
	@PostMapping("/login/user")
	public ResponseEntity<UserLoginReply> loginUser(@RequestBody UserLogin userLogin) {
		System.out.println("In loginUser");
		String registrationNumber = userLogin.getRegistrationNumber();
		String password = userLogin.getPassword();

		// System.out.println("RegNumber: "+ registrationNumber);
		// System.out.println();
		// System.out.println("password: "+ password);
		
		UserLoginReply userlogreply = new UserLoginReply();           
		//UserLogin.getInstance().add(user);
		//We are setting the below value just to reply a message back to the caller
		
		// UserLogin userLogin = new UserLogin();
		// String validPassword = userLogin.listaUsuariosLogin.get(registrationNumber);

		// UserLogin.getInstance().add(registrationNumber, password);
		// UserLogin.getInstance();
		String validPassword = UserLogin.getInstance().listaUsuariosLogin.get(registrationNumber);
		// UserLogin.getInstance();
		// System.out.println("listaUsuariosLogin: "+ UserLogin.listaUsuariosLogin);
		// System.out.println("correct password: "+ validPassword);

		if (validPassword == null){
			userlogreply.setLoginStatus("Invalid user");
		}
		else if (validPassword.equals(password)){
			UserLogin.getInstance().logIn(registrationNumber);
			userlogreply.setLoginStatus("Logged in");
			return new ResponseEntity<>(userlogreply, HttpStatus.OK);
		}
		else{
			userlogreply.setLoginStatus("Invalid password");
		}
		return new ResponseEntity<>(userlogreply, HttpStatus.BAD_REQUEST);
	}

}
