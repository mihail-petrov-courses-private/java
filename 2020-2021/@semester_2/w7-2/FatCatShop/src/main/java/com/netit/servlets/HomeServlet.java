package com.netit.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HomeServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userName = req.getParameter("user_name");
		int userAge 	= Integer.parseInt(req.getParameter("user_age"));
		String color 	= req.getParameter("favorite_color");
		String userGender	= req.getParameter("user_gender");
		
		// 1. Session storage
		HttpSession session = req.getSession();
		session.setAttribute("user_name", userName);
		session.setAttribute("user_gender", userGender);
		session.setAttribute("is_greeted", "Y");
		req.setAttribute("user_age", 10);
		
		// 2. In memory 
		
		// req.getRequestDispatcher("shop.jsp").forward(req, resp);

		// resp.sendRedirect("shop.jsp");
		resp.sendRedirect("shop");
	}
}
