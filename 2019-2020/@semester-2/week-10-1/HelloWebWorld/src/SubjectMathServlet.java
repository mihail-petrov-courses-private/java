import db.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

@WebServlet(value = "/subjects/math")
public class SubjectMathServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("Init math servlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {

        HttpSession session = req.getSession();
        System.out.println("Session key math_servlet_total_count : ");
        System.out.println(session.getAttribute("math_servlet_total_count"));
        System.out.println("======================================");

        session.setAttribute("math_servlet_total_count", "10");

        // req.setAttribute("math_servlet_total_count", "10");

        try {
            Database.getInstance().insert("redirect_statistics", new HashMap<String, Object>(){{
                put("redirect_key", "'math'");
                put("redirect_value", 1);
            }}).queryDebug().execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("math.jsp");
    }
}
