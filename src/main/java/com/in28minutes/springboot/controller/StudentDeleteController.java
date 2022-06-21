package com.in28minutes.springboot.controller;

//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.model.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class StudentDeleteController {

//	@RequestMapping(method = RequestMethod.DELETE, value="/delete/student/{regdNum}")
//
//	@ResponseBody
	@DeleteMapping("/delete/student/{regdNum}")
	public ResponseEntity<String> deleteStudentRecord(@PathVariable("regdNum") String regdNum) {
		System.out.println("In deleteStudentRecord");   
		if (!UserLogin.getInstance().isSomeoneLogged()){
			System.out.println("Nenhum usuário logado.");
        	return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>(StudentRegistration.getInstance().deleteStudent(regdNum), HttpStatus.OK);
	}

}
