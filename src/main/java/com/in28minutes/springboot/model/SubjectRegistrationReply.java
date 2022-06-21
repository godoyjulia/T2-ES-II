package com.in28minutes.springboot.model;

import java.util.List;

public class SubjectRegistrationReply {
    String name;
    String id;
    List<Character> schedules;
	String registrationStatus;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public List<Character> getSchedules() {
        return schedules;
    }
    public void setSchedules(List<Character> schedules) {
        this.schedules = schedules;
    }
	public String getRegistrationStatus() {
		return registrationStatus;
	}
	public void setRegistrationStatus(String registrationStatus) {
		this.registrationStatus = registrationStatus;
	}
}
