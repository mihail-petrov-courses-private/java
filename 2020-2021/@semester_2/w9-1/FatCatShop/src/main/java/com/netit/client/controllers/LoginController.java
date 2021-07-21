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
import com.netit.vendor.database.Database;
import com.netit.vendor.database.DatabaseConfig;
import com.netit.vendor.translate.Translate;
import com.netit.vendor.controllers.Controller;

@WebServlet("/login")
public class LoginController extends Controller {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userEmail 	= req.getParameter("user_email");
		String userPass 	= req.getParameter("user_pass");
		HttpSession session = req.getSession();
		
		
		if(this.isAutneticatable(userEmail, userPass)) {

			session.setAttribute("is_authenticated", true);
			
			int[] roleCollection = this.getUserRoleCollection(userEmail, userPass);
			session.setAttribute("role_collection", roleCollection);
			
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
				.count("td_users");
		
		return userCount == 1;
	}
	
	
	private int[] getUserRoleCollection(String userEmail, String userPass) {
		
		ResultSet collection = Database.getInstance()
		.where("user_email", DatabaseConfig.colString(userEmail))
		.andWhere("user_password", DatabaseConfig.colString(userPass))
		.select("td_users", "id");
		
		try {
			collection.next();
			int userId = collection.getInt("id");
			
			ResultSet roleCollection = Database.getInstance()
			.where("user_email", userId + "")
			.select("td_user__role", "role_id");
			
			ArrayList<Integer> resultCollection = new ArrayList<>();
			while(roleCollection.next()) {
				resultCollection.add(roleCollection.getInt("role_id"));
			}
			
			int[] intCollection = new int[resultCollection.size()];
			for(int i = 0; i < resultCollection.size(); i++ ) {
				intCollection[i] = resultCollection.get(i);
			}
			
			return intCollection;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return null;
	}
}

