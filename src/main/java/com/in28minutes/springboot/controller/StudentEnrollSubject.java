package com.in28minutes.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.model.*;

@RestController
public class StudentEnrollSubject {
    
	@PostMapping("/enroll/student/{regdNum}")
	public ResponseEntity<String> registerStudent(@PathVariable("regdNum") String regdNum, @RequestBody SubjectEnrollment subject) {
		System.out.println("In enrollStudent");
		if (!UserLogin.getInstance().isSomeoneLogged()){
			System.out.println("Nenhum usuário logado.");
        	return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}

        //valida usuario
		Student student = StudentRegistration.getInstance().getStudent(regdNum);
        if (student == null){
			System.out.println("Usuário não encontrado.");
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        //valida materia
        Subject subj = SubjectRegistration.getInstance().getSubject(subject.getId());

        // -se existe com o codigo passado
        if (subj == null){
            return new ResponseEntity<>("Disciplina não encontrada.", HttpStatus.NOT_FOUND);
        }
        //   -se nome combina
        //   -se horario combina com um dos horarios disponiveis
        if (!subj.getName().equals(subject.getName()) || !subj.getSchedules().contains(subject.getSchedule())){
            return new ResponseEntity<>("Disciplina: informação incoerente.", HttpStatus.BAD_REQUEST);
        }

        student.addSubject(subj);
        student.addSchedule(subj.getId(), subject.getSchedule());

		return new ResponseEntity<>("Estudante matriculado com sucesso.", HttpStatus.OK);
	}
}
