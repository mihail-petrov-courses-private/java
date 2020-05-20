import db.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet(value = "/registration")
public class RegistrationServlet extends HttpServlet {

    private Database dbConnection;

    @Override
    public void init() throws ServletException {
        this.dbConnection = new Database();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {

        String insertQuery = this.dbConnection.insert("users", new HashMap<String, Object>() {{
                put("username"  , Database.stringValue("Mihail"));
                put("email"     , Database.stringValue("mail@mail.bg"));
                put("password"  , Database.stringValue("password"));
                put("age"       , Database.intValue("10"));
                put("role"      , "0");
            }}).execute();

        System.out.println("1. Insert");
        System.out.println(insertQuery);

        String updateQuery = this.dbConnection.update("users", new HashMap<String, Object>() {{
            put("username"  , Database.stringValue("Mihail"));
            put("email"     , Database.stringValue("mail@mail.bg"));
            put("password"  , Database.stringValue("password"));
            put("age"       , Database.intValue("10"));
            put("role"      , "0");
        }}).execute();

        System.out.println("2. Update");
        System.out.println(updateQuery);

        String updateQueryWithWhere = this.dbConnection.update("users", new HashMap<String, Object>() {{
            put("username"  , Database.stringValue("Mihail"));
            put("email"     , Database.stringValue("mail@mail.bg"));
            put("password"  , Database.stringValue("password"));
            put("age"       , Database.intValue("10"));
            put("role"      , "0");
        }}).where(new HashMap<String, Object>() {{
            put("username"  , "Mihail");
        }}).execute();

        System.out.println("3. Update with Where");
        System.out.println(updateQueryWithWhere);

        String selectAllQuery = this.dbConnection.select("users").execute();

        System.out.println("4. Select All");
        System.out.println(selectAllQuery);

        String[] columns = new String[] {
            "username", "password"
        };
        String selectWithColumnsQuery = this.dbConnection.select("users", columns).execute();

        System.out.println("5. Select With columns");
        System.out.println(selectWithColumnsQuery);

        String selectWithAliasQuery = this.dbConnection.select("users", new HashMap<String, String>() {{
            put("username"  , "user_full_name");
        }}).execute();

        System.out.println("6. Select With alias");
        System.out.println(selectWithAliasQuery);

        String selectWithWhereQuery = this.dbConnection.select("users", columns).where(new HashMap<String, Object>() {{
            put("username"  , "user_full_name");
        }}).execute();

        System.out.println("7. Select With where");
        System.out.println(selectWithWhereQuery);


//        String username         = req.getParameter("user_name");
//        String useremail        = req.getParameter("user_email");
//        String userpass         = req.getParameter("user_pass");
//        String userpassrepeat   = req.getParameter("user_pass_repeat");
//        String userage          = req.getParameter("user_age");
//
//        try {
//
//            this.dbConnection.insert("users", new HashMap<String, Object>() {{
//                put("username"  , Database.stringValue(username));
//                put("email"     , Database.stringValue(useremail));
//                put("password"  , Database.stringValue(userpass));
//                put("age"       , Database.intValue(userage));
//                put("role"      , "0");
//            }}).execute();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
