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
import com.netit.database.DatabaseQueryoperatorEnum;

public class SqlServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		Database db 			= new Database();
		
		db.delete("users");
		
		db.insert("users", new HashMap<>() {{
			put("first_name", "'Grigori'");
			put("last_name", "'Emilov'");
			put("age", "49");
		}});
		
		db.insert("users", new HashMap<>() {{
			put("first_name", "'Mihail'");
			put("last_name", "'Petrov'");
			put("email", "'mail@mail.bg'");
			put("age", "29");
		}});
		
		db.insert("users", new HashMap<>() {{
			put("first_name", "'Todor'");
			put("last_name", "'Iliev'");
			put("department", "'IT'");
			put("age", "59");
			put("salary", "5000");
		}});		
		
//		db.where("last_name", "'Petrov'")
//		  .update("users", new HashMap<>() {{
//			  put("first_name", "'Admin'");
//		  }});
		
		
		ResultSet collection 	= db.where("last_name", "'Iliev'")
									.andWhere("first_name", "'Todor'")
									.andWhere("age", DatabaseQueryoperatorEnum.GD, "10")
									.andWhere("email", DatabaseQueryoperatorEnum.IS, "NULL")
									.select("users", new String[]{"first_name", "last_name"});
									
		
		try {
			while(collection.next()) {
				System.out.print(collection.getString("first_name") + " " + collection.getString("last_name"));
				System.out.println("*");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}	
}
