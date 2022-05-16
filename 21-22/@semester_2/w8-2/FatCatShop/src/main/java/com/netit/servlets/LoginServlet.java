package com.netit.servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.RowSet;

import com.netit.database.Database;
import com.netit.database.DatabaseConfig;
import com.netit.logic.PageViewAggregator;
import com.netit.logic.translate.Translate;

public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userEmail 	= req.getParameter("user_email");
		String userPass 	= req.getParameter("user_pass");
		HttpSession session = req.getSession();
		
		
		if(this.isAutneticatable(userEmail, userPass)) {

			session.setAttribute("is_authenticated", true);
			resp.sendRedirect(PageViewAggregator.SHOP);
			return;
		}
		
		
		session.setAttribute("message", Translate.get(Translate.LOGIN_FAILD, "bg"));
		resp.sendRedirect(PageViewAggregator.LOGIN);		
	}
	
	private boolean isAutneticatable(String userEmail, String userPass) {

		int userCount = Database.getInstance()
				.where("user_email", DatabaseConfig.colString(userEmail))
				.andWhere("user_password", DatabaseConfig.colString(userPass))
				.count("users");
		
		return userCount == 1;
	}
}

