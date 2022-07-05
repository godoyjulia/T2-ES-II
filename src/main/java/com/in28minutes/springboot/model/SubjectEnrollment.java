package com.in28minutes.springboot.model;

public class SubjectEnrollment {
    
    String name;
    String id;
    Character schedule;
    

    public SubjectEnrollment(String name, String id, Character schedule) {
        this.name = name;
        this.id = id;
        this.schedule = schedule;
    }
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
    public Character getSchedule() {
        return schedule;
    }
    public void setSchedule(Character schedule) {
        this.schedule = schedule;
    }
   

}
