package com.in28minutes.springboot.model;

public class User {

    String name;
    String registrationNumber;
	String password;
    
	public User(String registrationNumber, String name, String password){
        this.registrationNumber = registrationNumber;
        this.name = name;
		this.password = password;
    }

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

	public String toString(){
		return "Student name: " + this.getName() +
				"\nRegNumber: " + this.getRegistrationNumber() +
				"\nPassword: " + this.getPassword();
	}
}
