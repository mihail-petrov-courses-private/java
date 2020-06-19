import db.Database;
import util.StaticValidation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet(value = "/registration")
public class RegistrationServlet extends HttpServlet {

    private Database dbConnection;
    private ArrayList<String> dataValidationMessageCollection = new ArrayList<>();

    @Override
    public void init() throws ServletException {

        // this.dbConnection = new Database();
        dataValidationMessageCollection = new ArrayList<>();
        System.out.println("Registration servlet init");
    }

    private boolean isHTTPRequestValid(HttpServletRequest req) {

        String userName             = req.getParameter("user_name");
        String userEmail            = req.getParameter("user_email");
        String userPassword         = req.getParameter("user_pass");
        String userPasswordRepeat   = req.getParameter("user_pass_repeat");

        if(!StaticValidation.isStringSizeGreaterThan(userName, 3)) {
            dataValidationMessageCollection.add("The size of userName is lower than 3");
            return false;
        }

        if(!StaticValidation.isStringSizeGreaterThan(userPassword, 5)) {
            dataValidationMessageCollection.add("The size of userPassword is lower than 5");
            return false;
        }

        if(!StaticValidation.isEqualTo(userPassword, userPasswordRepeat)) {
            dataValidationMessageCollection.add("userPassword does not match serPasswordRepeat");
            return false;
        }

        return true;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Redirect servlet : Registration");

        req.setAttribute("forward_message", "Hi from RegistrationServlet");
        // resp.sendRedirect("registration.jsp");
        // resp.sendRedirect("registration");
        // resp.sendRedirect("demo");
        req.getRequestDispatcher("demo").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {


            String userName             = req.getParameter("user_name");
            String userEmail            = req.getParameter("user_email");
            String userPassword         = req.getParameter("user_pass");
            String userPasswordRepeat   = req.getParameter("user_pass_repeat");

            if(isHTTPRequestValid(req)) {
                // Database
            }
            else {
                req.setAttribute("messageCollection", this.dataValidationMessageCollection);
                // req.getRequestDispatcher("success.jsp").forward(req, resp);
                resp.sendRedirect("registration.jsp");
                //req.getRequestDispatcher("registration.jsp").forward(req, resp);
            }
    }
}
