import java.sql.*;

public class DbConnection {

    private static final String CONNECTION_URL  = "jdbc:mysql://localhost:3306/online_catshop";
    private static final String USERNAME        = "root";
    private static final String PASSWORD        = "";

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection dbConnection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
            Statement dbStatement   = dbConnection.createStatement();

            ResultSet dbQueryResult = dbStatement.executeQuery("SELECT * FROM users");

            while(dbQueryResult.next()) {
                System.out.print(dbQueryResult.getString("username") + " : ");
                System.out.print(dbQueryResult.getString("email"));
                System.out.println();
            }

            dbConnection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
