import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/*")
public class FrontController extends HttpServlet {

	@Override
	protected void doGet(
			HttpServletRequest req, 
			HttpServletResponse resp
			) throws ServletException, IOException {
		
		// 1. get Request Infromation
		String requestUrl 				= req.getPathInfo();
		String[] urlSegmentCollection 	= requestUrl.split("/");
		String requestController 		= this.getController(urlSegmentCollection); 
		String requestMethod 			= this.getMethod(urlSegmentCollection);
		
		// 2. Load request controller class
		try {
			
			this.loadController(requestController, requestMethod);
			
		} catch (ClassNotFoundException e) {

			try {
				this.loadController("NotFound", "index");
			} catch (Exception e1) { }
		} catch (NoSuchMethodException e) {
			try {
				this.loadController(requestController, "index");
			} catch (Exception e1) { }
		}
		catch ( InstantiationException 		| 
				IllegalAccessException 		| 
				IllegalArgumentException 	| 
				InvocationTargetException 	| 
				SecurityException e) {
			e.printStackTrace();
		} 
	}
	
	private void loadController(String requestController, String requestMethod) 
			throws 	ClassNotFoundException, 
					NoSuchMethodException, 
					SecurityException, 
					InstantiationException, 
					IllegalAccessException, 
					IllegalArgumentException, 
					InvocationTargetException {
		
		Class<?> classReference 	=  Class.forName(requestController);
		Method classReferenceMethod =  classReference.getMethod(requestMethod, null);
		
		Object controllerInstrance 	= classReference.getConstructor().newInstance();
		classReferenceMethod.invoke(controllerInstrance);
	}
	
	private String getController(String[] urlSegmentCollection) {
		
		try {
			String controllerSegment 		= urlSegmentCollection[1]; 
			return controllerSegment.substring(0, 1).toUpperCase() + controllerSegment.substring(1);	
		}
		catch(Exception e) {
			return "NotFound";
		}
	}
	
	private String getMethod(String[] urlSegmentCollection) {
		
		try {
			return urlSegmentCollection[2];
		}
		catch(Exception e) {
			return "index";
		}
	}
}
