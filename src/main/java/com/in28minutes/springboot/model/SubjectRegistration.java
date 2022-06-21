package com.in28minutes.springboot.model;

import java.util.ArrayList;
import java.util.List;

public class SubjectRegistration {
    
	private List<Subject> subjectRecords;

	private static SubjectRegistration subjReg = null;

	private SubjectRegistration(){
		subjectRecords = new ArrayList<Subject>();
	}

	public static SubjectRegistration getInstance() {

		if(subjReg == null) {
			subjReg = new SubjectRegistration();
			return subjReg;
		}
		else {
			return subjReg;
		}
	}

	public void add(Subject subject) {
		subjectRecords.add(subject);
	}

	public String upDateSubject(Subject subject) {

		for(int i=0; i<subjectRecords.size(); i++)
		{
			Subject subj = subjectRecords.get(i);
			if(subj.getId().equals(subject.getId())) {
				subjectRecords.set(i, subject);//update the new record
				return "Update successful";
			}
		}
		return "Update un-successful";
	}

	public String deleteSubject(String registrationNumber) {

		for(int i=0; i<subjectRecords.size(); i++)
		{
			Subject subj = subjectRecords.get(i);
			if(subj.getId().equals(registrationNumber)){
				subjectRecords.remove(i);//update the new record
				return "Delete successful";
			}
		}
		return "Delete un-successful";
	}

	public Subject getSubject(String registrationNumber){
		for(int i=0; i<subjectRecords.size(); i++)
		{
			Subject subj = subjectRecords.get(i);
			if(subj.getId().equals(registrationNumber)){
				return subjectRecords.get(i);
			}
		}
		return null;
	}

	public List<Subject> getSubjectRecords() {
		return subjectRecords;
	}
}
