import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormProcessor extends HttpServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.print("Create new form processor");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// service специализиран за GET заявки
	}

	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// гробална логика за обратка на заявки
		
		try {
			String name = req.getParameter("user_name");
			int age		= Integer.parseInt(req.getParameter("user_age")) ;
			
			boolean isOwner 	= (name.equals("Mihail") && age == 29);
			boolean isMaster 	= name.equals("Mihail");
			String redirect		= "error.jsp";

			if(isMaster) {
				redirect = "master.jsp";
				// resp.sendRedirect("master.jsp");
			}
			
			if(isOwner) { 
				redirect = "success.jsp";
				// resp.sendRedirect("success.jsp");	
			}
			
			resp.sendRedirect(redirect);			
			
		}
		catch(Exception e) {
			resp.sendRedirect("index.jsp");
		}
		
		// forward to different Resource
//		RequestDispatcher requestDispatcher = req.getRequestDispatcher("success.jsp");
//		requestDispatcher.forward(req, resp);
		
		// redirect to different URL
		
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		System.out.print("Remove form processor");
	}

}





