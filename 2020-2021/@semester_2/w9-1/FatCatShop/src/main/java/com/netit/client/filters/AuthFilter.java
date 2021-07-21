package com.netit.client.filters;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.netit.vendor.policy.AccessPolicy;
import com.netit.vendor.policy.UserRoles;

@WebFilter("*.jsp")
public class AuthFilter implements Filter {

	private HashMap<String, AccessPolicy> accessControllList = new HashMap<>(){{
		put("index.jsp"			, new AccessPolicy()  );
		put("login.jsp"			, new AccessPolicy()  );
		put("registration.jsp"	, new AccessPolicy()  );
		put("shop.jsp"			, new AccessPolicy(false, UserRoles.USER, UserRoles.ADMIN));
		put("admin.jsp"			, new AccessPolicy(true, UserRoles.USER, UserRoles.ADMIN ));
	}};

	private String[] requireAuthenticationCollection = {
		"shop.jsp", "index.jsp"	
	};
	
	@Override
	public void doFilter(
			ServletRequest request, 
			ServletResponse response, 
			FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest sessionRequest 	= (HttpServletRequest) request;
		HttpServletResponse sessionResponse = (HttpServletResponse) response;
		String requestPage 					= getRequestedPage(sessionRequest, sessionResponse);
		AccessPolicy policy 				= accessControllList.get(requestPage);
		
		// check for auth 
		boolean isAuthRequired 				= policy.isAuthenticatable() && 
											  !this.isAuthenticated(request);
		
		if(isAuthRequired) {
			sessionResponse.sendRedirect("login.jsp");
			return;
		}
		
		
		boolean areRolesAvailable 			= policy.areRolesAvailable(this.getRoles(request));
		
//		
//		boolean isAuthenticationNesesary = doesRequiresAuthentication(requestPage) &&
//										   !this.isAuthenticated(request);
//		
//		if(isAuthenticationNesesary) {
//			sessionResponse.sendRedirect("login.jsp");
//			return;
//		}
	}
	
	private String getRequestedPage(
			HttpServletRequest sessionRequest,
			HttpServletResponse sessionResponse) {
		
		String path = sessionRequest.getRequestURI();
		String[] collection = path.split("/");
		return collection[collection.length - 1];
	}
	
//	private boolean doesRequiresAuthentication(String page) {
//		
//		for(String pageIndex: requireAuthenticationCollection) {
//			if(pageIndex.equals(page)) {
//				return true;
//			}
//		}
//		
//		return false;
//	}

	private int[] getRoles(ServletRequest request) {
		
		HttpServletRequest sessionRequest 	= (HttpServletRequest) request;
		HttpSession session 				= sessionRequest.getSession();
		
		return (int[]) session.getAttribute("role_collection");
	}
	
	private boolean isAuthenticated(ServletRequest request) {
		
		HttpServletRequest sessionRequest 	= (HttpServletRequest) request;
		HttpSession session 				= sessionRequest.getSession();
		
		if(session.getAttribute("is_authenticated") != null) {
			return (boolean) session.getAttribute("is_authenticated");
		}
		
		return false;
	}

}
