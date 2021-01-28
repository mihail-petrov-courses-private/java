import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/init")
public class InitServlet extends HttpServlet {

    private ArrayList<String> webAppCollection;
    public String message;

    @Override
    public void init() throws ServletException {
        System.out.println("Init servlet init on page load");

        this.message = "Web Collection";


        this.webAppCollection = new ArrayList<String>(){{
            add("http://google.com");
            add("http://bing.com");
        }};
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {

        System.out.println("INIT GET REQUEST");

        req.setAttribute("message", this.message);
        req.setAttribute("web_collection", this.webAppCollection);
    }
}
