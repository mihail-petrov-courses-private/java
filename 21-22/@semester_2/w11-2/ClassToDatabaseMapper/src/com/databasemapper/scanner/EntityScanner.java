package com.databasemapper.scanner;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;

public class EntityScanner {

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
}
