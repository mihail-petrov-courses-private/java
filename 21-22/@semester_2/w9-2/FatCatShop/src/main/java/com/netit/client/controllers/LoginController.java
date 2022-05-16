package com.netit.client.controllers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.RowSet;

import com.netit.client.config.PageViewAggregator;
import com.netit.client.models.User;
import com.netit.vendor.database.Database;
import com.netit.vendor.database.DatabaseConfig;
import com.netit.vendor.policy.UserRoleEnum;
import com.netit.vendor.translate.Translate;
import com.netit.vendor.controllers.Controller;

@WebServlet("/login")
public class LoginController extends Controller {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userEmail 	= req.getParameter("user_email");
		String userPass 	= req.getParameter("user_pass");
		HttpSession session = req.getSession();
		
		if(User.doesExists(userEmail, userPass)) {

			session.setAttribute("is_authenticated", true);
			
			UserRoleEnum[] roleCollection = User.getRoles(userEmail, userPass);
			session.setAttribute("role_collection", roleCollection);
			
			resp.sendRedirect(PageViewAggregator.SHOP);
			return;
		}
		
		session.setAttribute("message", Translate.get(Translate.LOGIN_FAILD, "bg"));
		resp.sendRedirect(PageViewAggregator.LOGIN);		
	}
}

