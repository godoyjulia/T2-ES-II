package com.in28minutes.springboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.model.*;

@RestController
public class StudentRetrieveController {

	//	@RequestMapping(method = RequestMethod.GET, value="/student/allstudent")
	//
	//	@ResponseBody
	@GetMapping("/student/allstudent")
	public ResponseEntity<List<Student>> getAllStudents() {
		System.out.println("In getAllStudents");   
		if (!UserLogin.getInstance().isSomeoneLogged()){
			System.out.println("Nenhum usuário logado.");
        	return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>(StudentRegistration.getInstance().getStudentRecords(), HttpStatus.OK);
	}

	@GetMapping("/student/id/{regdNum}")
	public ResponseEntity<Student> getStudentById(@PathVariable("regdNum") String regdNum) {
		System.out.println("In getStudentById");   
		if (!UserLogin.getInstance().isSomeoneLogged()){
			System.out.println("Nenhum usuário logado.");
        	return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		Student student = StudentRegistration.getInstance().getStudent(regdNum);

        if (student == null){
			System.out.println("Usuário não encontrado.");
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
	@GetMapping("/student/name/{name}")
	public ResponseEntity<List<Student>> getStudentByName(@PathVariable("name") String name) {
		if (!UserLogin.getInstance().isSomeoneLogged()){
			System.out.println("Nenhum usuário logado.");
        	return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}

		List<Student> students = StudentRegistration.getInstance().getStudentRecords();
		List<Student> matches = new ArrayList<>();

		String regex = ".*"+name+".*";
		for (Student s: students){
			if(Pattern.matches(regex, s.getName())){
				matches.add(s);
			}
		}

		return new ResponseEntity<>(matches, HttpStatus.OK);
	}
}
