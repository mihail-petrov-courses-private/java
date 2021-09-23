package com.databasemapper.db.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringJoiner;

public class Database {

	private Connection connection;
	private static Database instance = null;
	
	public static Database getInstance() {
		
		if(instance == null) {
			instance = new Database();
		}
		
		return instance;
	}
	
	private Database() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		
		try {
			this.connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/custom_migration", "root", "");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void createTable(String tableName, ArrayList<DatabaseColumn> databaseColumnCollection) {
		
		StringJoiner migrationBuilder = new StringJoiner(",");
		for(DatabaseColumn columnReference : databaseColumnCollection) {
			String migrationRow = 	columnReference.getColumnName() 			+ " " + 
									columnReference.getCannonicalTypeWithSize() + " " + 
									columnReference.getCannonicalModificator();
			
			migrationBuilder.add(migrationRow);
		}
		
		String sqlCreateTable = "CREATE TABLE " + tableName + 
								"("+ migrationBuilder.toString() + ");";
		System.out.println("***");
		System.out.println(sqlCreateTable);
		System.out.println("***");
		this.query(sqlCreateTable);
	}
	
	public void query(String query) {

		Statement statment;
		try {
			statment = this.connection.createStatement();
			statment.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
