package com.system;

import java.lang.reflect.Method;

public class ControllerMethodPare {
	
	private Class clazz;
	private Method method;
	
	public ControllerMethodPare(Class clazz, Method method) {
		this.clazz 	= clazz;
		this.method = method;
	}
	
	public Class getController() {
		return this.clazz;
	}
	
	public Method getMethod() {
		return this.method;
	}
}
