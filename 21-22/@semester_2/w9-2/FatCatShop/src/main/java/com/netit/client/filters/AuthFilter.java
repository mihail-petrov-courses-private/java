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
import com.netit.vendor.policy.UserRoleEnum;

@WebFilter("*.jsp")
public class AuthFilter implements Filter {

	private HashMap<String, AccessPolicy> accessControllList = new HashMap<>(){{
		put("index.jsp"			, new AccessPolicy()  );
		put("login.jsp"			, new AccessPolicy()  );
		put("registration.jsp"	, new AccessPolicy()  );
		put("shop.jsp"			, new AccessPolicy(false, UserRoleEnum.USER, UserRoleEnum.ADMIN));
		put("admin.jsp"			, new AccessPolicy(true, UserRoleEnum.USER, UserRoleEnum.ADMIN ));
	}};

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
		
		if(policy.isPublic()) {
			chain.doFilter(request, response);
			return;
		}
		
		
		// check for auth 
		boolean isAuthRequired 				= policy.isAuthenticatable() && 
											  !this.isAuthenticated(request);
		
		if(isAuthRequired) {
			sessionResponse.sendRedirect("login.jsp");
			return;
		}
		
		boolean areRolesAvailable 			= policy.hasRoles(this.getRoles(request));
		if(!areRolesAvailable) {
			sessionResponse.sendRedirect("index.jsp");
			return;
		}
		
		chain.doFilter(request, response);
	}
	
	private String getRequestedPage(
			HttpServletRequest sessionRequest,
			HttpServletResponse sessionResponse) {
		
		String path = sessionRequest.getRequestURI();
		String[] collection = path.split("/");
		return collection[collection.length - 1];
	}
	

	private UserRoleEnum[] getRoles(ServletRequest request) {
		
		HttpServletRequest sessionRequest 	= (HttpServletRequest) request;
		HttpSession session 				= sessionRequest.getSession();
		
		return (UserRoleEnum[]) session.getAttribute("role_collection");
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
