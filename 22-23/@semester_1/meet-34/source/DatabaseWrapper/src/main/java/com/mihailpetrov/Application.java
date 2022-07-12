package com.mihailpetrov;

import java.sql.*;

public class Application {

    public static void main(String[] args) {

        // Query Builder - еквивалент
        Database.getInstance().query("INSERT INTO td_users(id, username) VALUES(8, 'SPECIAL')");

// Стандартен JDBC подход
//        String url      = "jdbc:mysql://localhost:3306/sample_db";
//        String user     = "root";
//        String password = "";
//
//        try {
//            Connection dbConnection = DriverManager.getConnection(url, user, password);
//            Statement sqlStatement  = dbConnection.createStatement();
//
//            sqlStatement.executeUpdate("INSERT INTO td_users(id, username) VALUES(3, 'petar')");
//
//            ResultSet row           = sqlStatement.executeQuery("SELECT * FROM td_users");
//
//            while(row.next()) {
//                String result = row.getInt("id") + " " + row.getString("username");
//                System.out.println(result);
//            }
//        }
//        catch (SQLException ex) {
//            ex.printStackTrace();
//        }

    }
}


















