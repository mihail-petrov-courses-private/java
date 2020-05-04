import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet init");
    }

//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp)
//    throws ServletException, IOException {
//
//        System.out.println("Run all the time : ");
//
////        String username = req.getParameter("user_name");
////        String userpass = req.getParameter("user_pass");
////
////        System.out.println("In service request");
////        System.out.println(username);
////        System.out.println(userpass);
//    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//    throws ServletException, IOException {
//
//        System.out.println("Serach for this user in public database");
//        String username = req.getParameter("user_name");
//        String userpass = req.getParameter("user_pass");
//
//        System.out.println("In service request");
//        System.out.println(username);
//        System.out.println(userpass);
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {

        String username = req.getParameter("user_name");
        String userpass = req.getParameter("user_pass");

        System.out.println(username);
        System.out.println(userpass);

        boolean isUsernameValid = username.equals("mihail");
        boolean isUserpassValid = userpass.equals("password");
        boolean isLoginValid     = isUsernameValid && isUserpassValid;

        // Redirect to diferent page
        // if(isLoginValid) {
        //     resp.sendRedirect("success.jsp");
        // }

        if(isLoginValid) {
            // TODO: NULL response
            req.setAttribute("message", "You loged in successfuly");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
        else {
            // TODO: NULL response
            req.setAttribute("message", "Wrong username or password");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
