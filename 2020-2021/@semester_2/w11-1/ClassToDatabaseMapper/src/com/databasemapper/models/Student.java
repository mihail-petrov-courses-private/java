package com.databasemapper.models;

import com.databasemapper.anotations.CustomColumn;
import com.databasemapper.anotations.CustomEntity;

@CustomEntity()
public class Student {
	
	@CustomColumn()
	public String fname;
	
	@CustomColumn()
	public String lname;
	public int age;
}
