package db;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Database {

    private String dbConnectionUrl  = "jdbc:mysql://localhost:3306/online_catshop";
    private String dbConnectionUser = "root";
    private String dbConnectionPass = "";

    private Statement dbStatment;
    private Connection dbConnection;

    private String queryBuilder;

    public static String stringValue(String element) {
        return "'" + element + "'";
    }

    public static int intValue(String element) {
        return Integer.parseInt(element);
    }

    public Database() {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            this.dbConnection   = DriverManager.getConnection(dbConnectionUrl, dbConnectionUser, dbConnectionPass);
            this.dbStatment     = dbConnection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Statement getStatment() {
        return this.dbStatment;
    }

    public Database insert(String tableName, HashMap<String, Object> insertInput) {

        String query = "INSERT INTO " + tableName;
        Set<Map.Entry<String, Object>> insertInputCollection =  insertInput.entrySet();

        String columnCollection = "(";
        String valueCollection  = "(";

        for(Map.Entry<String, Object> element : insertInputCollection) {
            columnCollection += element.getKey() + ",";
            valueCollection  += element.getValue() + ",";
        }

        columnCollection    = columnCollection.substring(0  , columnCollection.length() - 1) + ")";
        valueCollection     = valueCollection.substring(0   , valueCollection.length()  - 1) + ")";

        query = (query + columnCollection + " VALUES" + valueCollection);
        this.queryBuilder = query;

        return this;
        // return this.dbStatment.execute(query);
    }

    // UPDATE users SET username = 'Manol' WHERE username = 'MANOL'
    public Database update(String tableName, HashMap<String, Object> updateInput) {

        String query = "UPDATE " + tableName + " SET ";
        for(Map.Entry<String, Object> element : updateInput.entrySet()) {

           String key   = element.getKey();
           Object value = element.getValue();
           query += key + " = " + value + ",";
        }

        query = query.substring(0, query.length() - 1);
        this.queryBuilder = query;

        return this;
    }

    public Database select(String tableName){

        this.queryBuilder = "SELECT * FROM " + tableName;
        return this;
    }

    public Database select(String tableName, String[] columnNameCollection){

        String query = "SELECT ";
        for(String columnName : columnNameCollection) {
            query += columnName + ",";
        }

        query = query.substring(0, query.length() - 1) + " FROM " + tableName;
        this.queryBuilder = query;

        return this;
    }

    public Database select(String tableName, HashMap<String, String> columnNameWithAliasCollection){

        String query = "SELECT ";
        for(Map.Entry<String, String> columnWithAlias : columnNameWithAliasCollection.entrySet()) {

            String columnName = columnWithAlias.getKey();
            String columnAlias = columnWithAlias.getValue();

            if(columnAlias == null || columnAlias.trim().isEmpty()) {

                query += columnName + ",";
                continue;
            }

            query += columnName + " AS " + columnAlias;
        }

        query = query.substring(0, query.length() - 1) + " FROM " + tableName;
        this.queryBuilder = query;

        return this;
    }

    public Database where(HashMap<String, Object> whereStatment) {

        String query = " WHERE ";
        for(Map.Entry<String, Object> element : whereStatment.entrySet()) {
            String key  =  element.getKey();
            Object value =  element.getValue();

            query += " " + key + "=" + value + "AND";
        }

        query = query.substring(0, query.length() - 3);
        this.queryBuilder += query;
        return this;
    }

//    public boolean execute() throws SQLException {
//        return this.dbStatment.execute(this.queryBuilder);
//    }

    public String execute(){
        return this.queryBuilder;
    }
}
