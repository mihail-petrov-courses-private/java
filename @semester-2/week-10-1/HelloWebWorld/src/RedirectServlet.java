import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value="/demo")
public class RedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {

        System.out.println("Redirect servlet : DEMO");
        req.setAttribute("demo_message", "This is from Demo servlet");
        //req.getRequestDispatcher("redirect.jsp").forward(req, resp);
        //resp.sendRedirect("registration.jsp");
    }
}
