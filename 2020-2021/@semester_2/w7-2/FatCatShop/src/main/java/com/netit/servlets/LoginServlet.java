package com.netit.servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.RowSet;

import com.netit.database.Database;
import com.netit.database.DatabaseConfig;

public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userEmail 	= req.getParameter("user_email");
		String userPass 	= req.getParameter("user_pass");		
		
		int userCount = Database.getInstance()
				.where("user_email", DatabaseConfig.colString(userEmail))
				.andWhere("user_password", DatabaseConfig.colString(userPass))
				.count("users");
		
		if(userCount == 1) {
			resp.sendRedirect("shop.jsp");
		}
		else {
			req.setAttribute("message", "Потребителя не е намерен в системата");
		}		
	}
}

