package com.mihailpetrov;

import java.sql.*;

public class Database {

    private Connection dbConnection = null;
    private Statement statement;

    private static Database instance = null;

    private String buildQuery = "";
    private String tableColumn = "";
    private String tableValue  = "";

    private String tableKeyValue = "";

    private String tableWhere = "";

    private String processableTable = "";

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
            System.out.println("@@@@");
            System.out.println(sql);
            System.out.println("@@@@");
            this.statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            this.reset();
        }
    }

    public ResultSet queryResult(String sql) {
        try {
            System.out.println("@@@@");
            System.out.println(sql);
            System.out.println("@@@@");
            return this.statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            this.reset();
        }
    }

    public void into(String table) {
        // INSERT INTO td_users(id, username) VALUES(8, 'SPECIAL')

        String tableColumnResult = "(" + this.tableColumn + ") ";
        tableColumnResult        = tableColumnResult.replace(",)", ")");

        String tableValueResult  = "VALUES(" + this.tableValue + ");";
        tableValueResult         = tableValueResult.replace(",)", ")");

        this.buildQuery = "INSERT INTO " + table + tableColumnResult + tableValueResult;
        this.query(this.buildQuery);
    }

    public Database insert(String key, int value) {

        this.tableColumn += key + ",";
        this.tableValue  += value + ",";

        return this;
    }

    public Database insert(String key, String value) {

        this.tableColumn += key + ",";
        this.tableValue  += "'" + value + "',";

        return this;
    }

    public Database set(String column, String value) {

        this.tableKeyValue += column + "='" + value + "',";
        return this;
    }

    public Database set(String column, int value) {

        this.tableKeyValue += column + "=" + value + ",";
        return this;
    }

    public Database where(String column, int value) {

        this.tableWhere = "WHERE " + column + "=" + value;
        return this;
    }

    public Database where(String column, String value) {

        this.tableWhere = " WHERE " + column + "=" + value;
        return this;
    }

    public void update(String table) {

        this.buildQuery = "UPDATE " + table
                + " SET " +this.tableKeyValue.substring(0, this.tableKeyValue.length() - 1)
                + this.tableWhere;

        this.query(this.buildQuery);
    }

    public void delete(String table) {

        this.buildQuery = "DELETE FROM " + table + " "
                + this.tableWhere;

        this.query(this.buildQuery);
    }

    public Database from(String table) {
        this.processableTable = table;
        return this;
    }

    public ResultSet select() {
        return this.buildSelect("*");
    }

    public ResultSet select(String ...columns) {

        String columResult = String.join(", ",columns);
        return this.buildSelect(columResult);
    }

    private ResultSet buildSelect(String columnResult) {

        this.buildQuery = "SELECT "  +  columnResult + " FROM "
                + this.processableTable
                + " "
                + this.tableWhere;

        return this.queryResult(this.buildQuery);
    }

    private void reset() {
        this.buildQuery     = "";
        this.tableColumn    = "";
        this.tableValue     = "";
        this.tableKeyValue  = "";
        this.tableWhere     = "";
        this.processableTable = "";
    }
}
