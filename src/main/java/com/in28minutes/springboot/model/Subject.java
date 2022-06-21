package com.in28minutes.springboot.model;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    String name;
    String id;
    List<Character> schedules;
    

    public Subject(String name, String id, ArrayList<Character> schedules) {
        this.name = name;
        this.id = id;
        this.schedules = schedules;
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
    public List<Character> getSchedules() {
        return schedules;
    }
    public void setSchedules(List<Character> schedules) {
        this.schedules = schedules;
    }
   


    
}
