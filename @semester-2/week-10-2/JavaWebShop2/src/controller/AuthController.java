package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthController {

    public void index(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    public void signin(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {

        req.getRequestDispatcher("/signin.jsp").forward(req, resp);
    }

    public void post_signin(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String userEmail    = req.getParameter("user_email");
        String userPassword = req.getParameter("user_password");
        System.out.println(userEmail);
        System.out.println(userPassword);

        // req.getRequestDispatcher("/signin.jsp").forward(req, resp);
        this.signin(req, resp);
    }

    public void signup(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {

        req.getRequestDispatcher("/signup.jsp").forward(req, resp);
    }

    private void processUserSignIn() {

    }

    private void processUserSignUp() {

    }
}
