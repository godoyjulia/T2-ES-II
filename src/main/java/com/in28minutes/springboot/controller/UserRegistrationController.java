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
public class UserRegistrationController {

	//  @RequestMapping(method = RequestMethod.POST, value="/register/student")
	//
	//  @ResponseBody
	@PostMapping("/register/user")
	public ResponseEntity<UserRegistrationReply> registerUser(@RequestBody User user) {
		System.out.println("In registerUser");
		
		UserRegistrationReply userregreply = new UserRegistrationReply();           
		String usuarioExiste = UserRegistration.listaUsuariosReg.get(user.getRegistrationNumber());

		if (usuarioExiste != null){
			System.out.println("Usuário com id já existente.");
			userregreply.setRegistrationStatus("Unsuccessful");
			return new ResponseEntity<>(userregreply, HttpStatus.BAD_REQUEST);
		}
		UserRegistration.getInstance().add(user);
		UserLogin.getInstance().add(user.getRegistrationNumber(), user.getPassword());

		//We are setting the below value just to reply a message back to the caller
		userregreply.setName(user.getName());
		userregreply.setRegistrationNumber(user.getRegistrationNumber());
		userregreply.setRegistrationStatus("Successful");

		return new ResponseEntity<>(userregreply, HttpStatus.OK);
	}

}
