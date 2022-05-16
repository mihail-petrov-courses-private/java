package com.netit.logic.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EncodingFilter implements Filter {

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
		String requestPage = getRequestedPage(sessionRequest, sessionResponse);
		
		boolean isAuthenticationNesesary = doesRequiresAuthentication(requestPage) &&
										   !this.isAuthenticated(request);
		
		if(isAuthenticationNesesary) {
			sessionResponse.sendRedirect("login.jsp");
			return;
		}
				
		response.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
	}
	
	private String getRequestedPage(
			HttpServletRequest sessionRequest,
			HttpServletResponse sessionResponse) {
		
		String path = sessionRequest.getRequestURI();
		String[] collection = path.split("/");
		return collection[collection.length - 1];
	}
	
	private boolean doesRequiresAuthentication(String page) {
		
		for(String pageIndex: requireAuthenticationCollection) {
			if(pageIndex.equals(page)) {
				return true;
			}
		}
		
		return false;
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
