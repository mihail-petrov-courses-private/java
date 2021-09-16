package com.netit.anotation.model;

import java.util.ArrayList;

public class Student {

	private GradeEnum grade;
	private ArrayList<Subject> attendSubjectCollection;
	private boolean isActive;
	
	public Student(GradeEnum grade) {
		this.grade = grade;
		this.attendSubjectCollection = new ArrayList<>();
		this.isActive = false;
	}
	
	public void signForSubject(Subject subjectReference) {
		
		if(!this.isActive) return;
		if(!subjectReference.isApplicableForThisGrade(this.grade)) return;
		
		this.attendSubjectCollection.add(subjectReference);	
	}
}
