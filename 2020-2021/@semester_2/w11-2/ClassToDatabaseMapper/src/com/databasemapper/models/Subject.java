package com.databasemapper.models;

import com.databasemapper.anotations.MigrationColumn;
import com.databasemapper.anotations.CustomEntity;

@CustomEntity()
public class Subject {

	@MigrationColumn()
	public int id;
	
	@MigrationColumn()
	public String title;
}
