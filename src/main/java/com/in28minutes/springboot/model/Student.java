package com.in28minutes.springboot.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Student{

	String registrationNumber;
    int age;
	String name;
	List<Subject> subjects;
	HashMap<String, Character> subjIdSchedule;
	
	public Student(String registrationNumber, String name, int age){
		this.registrationNumber = registrationNumber;
        this.name = name;
		this.age = age;
		this.subjects = new ArrayList<>();
		this.subjIdSchedule = new HashMap<>();
	}
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public HashMap<String, Character> getSubjIdSchedule() {
		return subjIdSchedule;
	}

	public void setSubjIdSchedule(HashMap<String, Character> subjIdSchedule) {
		this.subjIdSchedule = subjIdSchedule;
	}

	public void addSubject(Subject subject){
		this.subjects.add(subject);
	}

	public void addSchedule(String subjectId, Character sch){
		this.subjIdSchedule.put(subjectId, sch);
	}
	
	
}
