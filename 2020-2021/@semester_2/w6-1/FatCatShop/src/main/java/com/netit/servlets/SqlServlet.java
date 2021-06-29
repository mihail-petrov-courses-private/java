package com.netit.servlets;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;

public class SqlServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		// 0. Ръчно зареждане на драйвъра за MySQL
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		// 1. Да направя връзка към базата
		try {
			Connection databaseConnection = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/bank_of_tommoroy", "root", "");
			
			// 2. Създаване на SQL statment
			Statement queryManager = databaseConnection.createStatement();
			
			// 3. Изпълнение на заявката
			ResultSet collection = queryManager.executeQuery(
					"SELECT first_name, last_name \r\n"
					+ "FROM users"
			);
			
			while(collection.next()) {
				
				String firstName =  collection.getString("first_name");
				String lastName =  collection.getString("last_name");
				
				System.out.print(firstName + lastName);
				System.out.print("*");	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
