package com.databasemapper.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

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
	
	public void createTable(String tableName, HashMap<String, String> columnConfig) {
		
		String[] columnName = columnConfig.keySet().toArray(new String[0]);
		String[] columnType = columnConfig.values().toArray(new String[0]);
		
		StringBuilder columnBuilder = new StringBuilder();
		columnBuilder.append("(");
		for(int i = 0; i < columnName.length; i++) {
			String endStatment = (i == columnName.length - 1) ? " NOT NULL" : " NOT NULL,";
			columnBuilder.append(columnName[i] + " " + columnType[i] + endStatment);
		}
		columnBuilder.append(");");
		
		String sqlCreateTable = "CREATE TABLE " + tableName + columnBuilder.toString();
		
		Statement statment;
		try {
			statment = this.connection.createStatement();
			statment.executeUpdate(sqlCreateTable);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
