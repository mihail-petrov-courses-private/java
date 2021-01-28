import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(value = "/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {

        String username         = req.getParameter("user_name");
        String userpass         = req.getParameter("user_pass");
        String userpassrepeat   = req.getParameter("user_pass_repeat");
        String nonexisting      = req.getParameter("nonexisting");

        Map<String, String[]> parameterCollection = req.getParameterMap();
        String parameterArray[] = parameterCollection.get("user_name");

        System.out.println("Registration Servlet Controller");
        System.out.println(username);
        System.out.println(userpass);
        System.out.println(userpassrepeat);
        System.out.println(parameterArray[0]);
    }
}
