package com.netit.anotation.model;

import java.util.ArrayList;

public class Subject {

	private ArrayList<GradeEnum> applicableCollection;
	
	public Subject(ArrayList<GradeEnum> collection) {
		
		this.applicableCollection = collection;
	}
	
	public boolean isApplicableForThisGrade(GradeEnum grade) {
		return this.applicableCollection.contains(grade);
	}
}
