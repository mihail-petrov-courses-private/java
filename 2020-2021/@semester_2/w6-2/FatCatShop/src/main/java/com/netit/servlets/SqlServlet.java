package com.netit.servlets;

import java.io.IOException;
import java.sql.*;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;
import com.netit.database.Database;

public class SqlServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		Database db 			= new Database();
		
		db.insert("users", new String[] {
				"first_name", "last_name"	
		}, new String[] {
				"'Alexander'", "'Nachev'"
		});
		
		// стандартен запис
		HashMap<String, String> relation = new HashMap<>();
		relation.put("first_name", "Grigori");
		relation.put("last_name", "Emilov");
		
		// кратък запис - обърнете внимание на {{ /  }}
		HashMap<String, String> shorthand = new HashMap<>() {{
			put("first_name", "Test");
		}};
		
		// кратък запис в контекста на метода
		db.insert("users", new HashMap<>() {{
			put("first_name", "'Grigori'");
			put("last_name", "'Emilov'");	
		}});
		
		
		db.update("users", new HashMap<>() {{
			put("first_name", "'Toshkata'");
		}});
		
		
		ResultSet collection 	= db.select("users");
		
		try {
			while(collection.next()) {
				System.out.print(collection.getString("first_name"));
				System.out.print(collection.getString("last_name"));
				System.out.println("*");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}	
}
