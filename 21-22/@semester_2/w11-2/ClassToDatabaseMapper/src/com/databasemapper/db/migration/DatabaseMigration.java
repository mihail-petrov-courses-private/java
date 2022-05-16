package com.databasemapper.db.migration;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

import com.databasemapper.db.connection.Database;
import com.databasemapper.db.connection.DatabaseColumn;
import com.databasemapper.scanner.EntityScanner;

public class DatabaseMigration {
	
	private HashMap<String, DatabaseTypeEnum> classTypeToDatabaseTypeMapping;
	
	
	public DatabaseMigration() {
		this.classTypeToDatabaseTypeMapping = this.bootstrapTypeMapping();
	}
	
	/**
	 * 
	 * @param packageName
	 */
	public void migrate(String packageName) {
		
		try {
			ArrayList<Class> classCollection 		= EntityScanner.scannPackage(packageName);
			ArrayList<Class> entityClassCollection 	= extractDatabaseEntityClasses(classCollection);
			createMigration(entityClassCollection);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private ArrayList<Class> extractDatabaseEntityClasses(ArrayList<Class> classCollection) {
					
		ArrayList<Class> customEntityClassCollection = new ArrayList();
		
		for(Class classReference: classCollection) {
			
			if(classReference.isAnnotationPresent(com.databasemapper.anotations.CustomEntity.class)) {
				customEntityClassCollection.add(classReference);
			}
		}
		return customEntityClassCollection;
	}
	
	
	/**
	 * 
	 * @param entityFieldCollection
	 * @return
	 */
	private ArrayList<DatabaseColumn> extractEntityFields(Field[] entityFieldCollection) {
		
		ArrayList<DatabaseColumn> dataColumnCollection = new ArrayList<>();
		
		for(Field fieldReference : entityFieldCollection) {
			
			if(!fieldReference.isAnnotationPresent(com.databasemapper.anotations.MigrationColumn.class)) continue; 
				
			var columnAnotation 	= fieldReference.getAnnotation(com.databasemapper.anotations.MigrationColumn.class); 
			String columnName 		= this.extractColumnName(fieldReference	, columnAnotation.columnName());
			var columnType 			= this.extractColumnType(fieldReference	, columnAnotation.dbType());
			int columnTypeSize 		= columnAnotation.dbTypeSize();
			var columnModificator 	= columnAnotation.modificator();

			dataColumnCollection.add(
				new DatabaseColumn(columnName, columnType, columnTypeSize, columnModificator)
			);
		}
		
		return dataColumnCollection;
	}
		
	/**
	 * 
	 * @param entityCollection
	 */
	private void createMigration(ArrayList<Class> entityCollection) {
		
		for(Class entity : entityCollection) {
			
			String tableName 				= entity.getSimpleName().toLowerCase();
			Field[] entityFieldCollection 	= entity.getDeclaredFields();
			var columnCollection 			= extractEntityFields(entityFieldCollection);
			Database.getInstance().createTable(tableName, columnCollection);
			System.out.println("Table" + tableName + " successfuly created");
		}
	}
	
	/**
	 * 
	 * @return
	 */
	private HashMap<String, DatabaseTypeEnum> bootstrapTypeMapping() {
		
		HashMap<String, DatabaseTypeEnum> mapping = new HashMap<>();
		mapping.put("String", DatabaseTypeEnum.VARCHAR);
		mapping.put("int"	, DatabaseTypeEnum.INT);
		mapping.put("double", DatabaseTypeEnum.DOUBLE);
		mapping.put("float"	, DatabaseTypeEnum.FLOAT);
		
		return mapping;
	}
	
	private String extractColumnName(Field fieldReference, String anotationName) {
		return anotationName.equals("") 
				? fieldReference.getName().toLowerCase()
				: anotationName;
	}
	
	private DatabaseTypeEnum extractColumnType(Field fieldReference, DatabaseTypeEnum dbType) {
		
		if(dbType == DatabaseTypeEnum.EXTRACT_FROM_FIELD) {
			String typeName = fieldReference.getType().getSimpleName();
			return this.classTypeToDatabaseTypeMapping.get(typeName);			
		}
		
		return dbType;
	}
	
}
