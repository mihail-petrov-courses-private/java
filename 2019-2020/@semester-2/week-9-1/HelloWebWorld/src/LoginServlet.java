import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet( value = "/login")
public class LoginServlet extends HttpServlet {


    @Override
    public void init() throws ServletException {


    }

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