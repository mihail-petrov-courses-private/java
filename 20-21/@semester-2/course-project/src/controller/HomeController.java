package controller;
import config.PageMap;
import framework.controller.WebController;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeController extends WebController {


    public void index(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
        req.getRequestDispatcher(PageMap.DEMO).forward(req, resp);
    }

    public void list() {
        System.out.println("LIST ");
    }

    public void create() {
        System.out.println("create data ");
    }

    public void remove() {
        System.out.println("Remove somethong ");
    }
}
