package com.netit.client.controllers;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netit.vendor.database.Database;
import com.netit.vendor.database.DatabaseConfig;
import com.netit.vendor.controllers.Controller;

@WebServlet("/registration")
public class RegistrationController extends Controller {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String userEmail 	= (String) req.getParameter("user_email");
		String userName 	= (String) req.getParameter("user_name");
		String userPass 	= (String) req.getParameter("user_pass");
		String userFname 	= (String) req.getParameter("user_first_name");
		String userLname 	= (String) req.getParameter("user_last_name");
		String userAge 		= (String) req.getParameter("user_age");
		
		String userCity 	= (String) req.getParameter("user_city");
		String userAddress 	= (String) req.getParameter("user_address");
		
		Database.getInstance().insert("td_users", new HashMap<String, String>() {{
			put("user_email"	, DatabaseConfig.colString(userEmail));
			put("user_name"		, DatabaseConfig.colString(userName));
			put("user_password"	, DatabaseConfig.colString(userPass));
			put("first_name"	, DatabaseConfig.colString(userFname));
			put("last_name"		, DatabaseConfig.colString(userLname));
			put("age"			, userAge);
			put("city"			, DatabaseConfig.colString(userCity));
			put("address"		, DatabaseConfig.colString(userAddress));
		}});
		
		Database.getInstance().insert("td_user__role", new HashMap<String, String>() {{
			put("user_id", Database.getInstance().getLastInsertedId());
			put("role_id", "1");
		}});
		
		resp.sendRedirect("login.jsp");
	}
}
