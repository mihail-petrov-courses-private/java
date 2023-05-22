package framework.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public abstract class WebController {

    private String absolutePath = "http://localhost:8182/JavaWebShop2_war_exploded";

    public HashMap<String, String> getQueryMap(HttpServletRequest req) {

        HashMap<String, String> queryMap = new HashMap<>();
        String reqQueryString = req.getQueryString();

        if(reqQueryString == null) {
            return queryMap;
        }

        String[] queryCollection = reqQueryString.split("&");
        for(int i = 0; i < queryCollection.length; i++) {
            String[]  queryPair = queryCollection[i].split("=");
            queryMap.put(queryPair[0], queryPair[1]);
        }
        return queryMap;
    }

    public String getQueryValue(HttpServletRequest req, String key) {
        return this.getQueryMap(req).get(key);
    }

    public boolean hasQuery(HttpServletRequest req, String key) {
        return this.getQueryMap(req).containsKey(key);
    }

    /**
     * @author Mihail Petrov
     * @param resp
     * @param path
     * @throws IOException
     */
    public void redirect(HttpServletResponse resp, String path)
    throws IOException {

        String redirectPath = absolutePath + path;
        resp.sendRedirect(redirectPath);
    }

    /**
     *
     * @param req
     * @param resp
     * @param jspPage
     * @throws ServletException
     * @throws IOException
     */
    public void display(HttpServletRequest req, HttpServletResponse resp, String jspPage)
    throws ServletException, IOException {

        String viewPath = "/" + jspPage;
        req.getRequestDispatcher(viewPath).forward(req, resp);
    }

    /**
     *
     * @param req
     * @param key
     * @param value
     */
    public void session(HttpServletRequest req, String key, Object value) {
        req.getSession().setAttribute(key, value);
    }
}