package com.databasemapper.models;

import com.databasemapper.anotations.MigrationColumn;
import com.databasemapper.anotations.CustomEntity;
import com.databasemapper.db.migration.DatabaseColumnModificatorEnum;
import com.databasemapper.db.migration.DatabaseTypeEnum;

@CustomEntity()
public class Student {
	
	@MigrationColumn(
			dbType 		= DatabaseTypeEnum.TEXT,
			modificator = DatabaseColumnModificatorEnum.NOT_NULLABLE,
			columnName 	= "student_first_name")
	public String fname;
	
	@MigrationColumn(
			dbType 		= DatabaseTypeEnum.VARCHAR, 
			dbTypeSize 	= 256,
			modificator = DatabaseColumnModificatorEnum.NOT_NULLABLE,
			columnName 	= "student_last_name")
	public String lname;
	
	@MigrationColumn()
	public int age;
	
	@MigrationColumn(columnName = "student_weight")
	public double weight;
	
	@MigrationColumn(columnName = "student_height")
	public double height;
	
	@MigrationColumn(columnName = "student_address")
	public String address;
}
