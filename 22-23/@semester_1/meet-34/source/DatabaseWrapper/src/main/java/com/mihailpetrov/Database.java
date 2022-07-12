package com.mihailpetrov;

import javax.xml.crypto.Data;
import java.sql.*;

public class Database {

    private Connection dbConnection = null;
    private Statement statement;

    private static Database instance = null;

    public static Database getInstance() {

        if(instance == null) {
            instance = new Database();
        }

        return instance;
    }

    private Database() {

        String url      = "jdbc:mysql://localhost:3306/sample_db";
        String user     = "root";
        String password = "";

        try {
            this.dbConnection = DriverManager.getConnection(url, user, password);
            this.statement = this.dbConnection.createStatement();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void query(String sql) {

        try {
            this.statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
