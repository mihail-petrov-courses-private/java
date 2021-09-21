package com.databasemapper.models;

import java.awt.datatransfer.SystemFlavorMap;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

import com.databasemapper.anotations.CustomColumn;
import com.databasemapper.db.Database;

public class Application {

	public static ArrayList<Class> scannPackage(String packageName) 
			throws IOException, ClassNotFoundException {
		
		// Array List aggregators
		ArrayList<File> classFileCollection = new ArrayList<>();
		
		
		// Package path adress
		String packagePath = packageName.replace('.', '/');
		
		// Class loader
		ClassLoader loader 				 	= Thread.currentThread().getContextClassLoader();
		Enumeration<URL> classUrlCollection = loader.getResources(packagePath);
		
		// Get every single Class Reference
		while(classUrlCollection.hasMoreElements()) {

			URL classUrl =  classUrlCollection.nextElement();
			File classFileRepresentation = new File(classUrl.getFile());
			return extractClassFromFile(classFileRepresentation, packageName);
			
			// classFileCollection.add(classFileRepresentation);
		}
		
		return null;
	}
	
	private static ArrayList<Class> extractClassFromFile(
			File classFileRepresentation, 
			String packageName) 
			throws ClassNotFoundException {
		
		ArrayList<Class> classCollection = new ArrayList();
		File[] fileCollection 			 = classFileRepresentation.listFiles();
		
		for(File filePointer : fileCollection) {
			String className 		= packageName + "." + filePointer.getName().replaceAll(".class", "");
			Class classReference 	= Class.forName(className);
			classCollection.add(classReference);
		}
		
		return classCollection;
	}
	
	public static ArrayList<Class> extractDatabaseEntityClasses(
			ArrayList<Class> classCollection
			) {
					
		ArrayList<Class> customEntityClassCollection = new ArrayList();
		
		for(Class classReference: classCollection) {
			
			if(classReference.isAnnotationPresent(com.databasemapper.anotations.CustomEntity.class)) {
				customEntityClassCollection.add(classReference);
			}
		}
		return customEntityClassCollection;
	}
	
	
	public static HashMap<String, String> extractEntityFields(Field[] entityFieldCollection) {
		
		HashMap<String, String> fieldConfig = new HashMap();
		
		for(Field fieldReference : entityFieldCollection) {
			if(fieldReference.isAnnotationPresent(com.databasemapper.anotations.CustomColumn.class)) {
				fieldConfig.put(fieldReference.getName(), "VARCHAR(50)");
			}
		}
		
		return fieldConfig;
	}
	
	public static void createMigration(ArrayList<Class> entityCollection) {
		
		for(Class entity : entityCollection) {
			
			String tableName 					= entity.getSimpleName().toLowerCase();
			Field[] entityFieldCollection 		= entity.getDeclaredFields();
			HashMap<String, String> fieldConfig = extractEntityFields(entityFieldCollection);
			Database.getInstance().createTable(tableName, fieldConfig);
			System.out.println("Table" + tableName + " successfuly created");
		}
	}
	
	public static void main(String[] args) {
		
		try {
			ArrayList<Class> classCollection 		= scannPackage("com.databasemapper.models");
			ArrayList<Class> entityClassCollection 	= extractDatabaseEntityClasses(classCollection);
			createMigration(entityClassCollection);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
	}
}
