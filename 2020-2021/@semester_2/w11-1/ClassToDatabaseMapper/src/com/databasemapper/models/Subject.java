package com.databasemapper.models;

import com.databasemapper.anotations.CustomColumn;
import com.databasemapper.anotations.CustomEntity;

@CustomEntity()
public class Subject {

	@CustomColumn()
	public int id;
	
	@CustomColumn()
	public String title;
}
