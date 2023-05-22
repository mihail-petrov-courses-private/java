package framework.db;

import framework.config.DatabaseConfig;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Database {

    private String dbConnectionUrl  = DatabaseConfig.getUrl();
    private String dbConnectionUser = DatabaseConfig.getUser();
    private String dbConnectionPass = DatabaseConfig.getPass();

    private Statement dbStatment;
    private Connection dbConnection;

    private String queryBuilder;

    public static String stringValue(String element) {
        return "'" + element + "'";
    }

    public static int intValue(String element) {
        return Integer.parseInt(element);
    }

    public static long longValue(String element) {
        return Integer.parseInt(element);
    }

    private static Database instance = null;


    public static Database getInstance() {

        if(instance == null) {
            instance = new Database();
        }

        return instance;
    }

    private Database() {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            this.dbConnection   = DriverManager.getConnection(dbConnectionUrl, dbConnectionUser, dbConnectionPass);
            this.dbStatment     = dbConnection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static WhereOperation operation(String value,
                                           WhereOperationEnum operation,
                                           WhereNextOperationRelation nextOperationRelation) {
        return new WhereOperation(value, operation, nextOperationRelation);
    }

    public static WhereOperation operation( String value, WhereOperationEnum operation) {
        return new WhereOperation(value, operation, null);
    }

    public static WhereOperation operation(String value) {
        return new WhereOperation(value, WhereOperationEnum.EQUAL, null);
    }

    /**
     *
     * @return
     */
    public Statement getStatment() {
        return this.dbStatment;
    }


    public long getLastInsertedId() throws SQLException {

        ResultSet generatedKeyCollection = this.dbStatment.getGeneratedKeys();
        generatedKeyCollection.next();
        return generatedKeyCollection.getLong(1);
    }


    /**
     *
     * @param tableName
     * @param insertInput
     * @return
     */
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

    // WHERE field1 = value1 AND
    // field2 = value2      OR
    // field3 = value3 AND
    // field4 > 10 OR
    // field5 < 100

    // 1. Middle class with operation and next logic operator
    public Database where(HashMap<String, Object> whereStatment) {

        String query = " WHERE ";
        for(Map.Entry<String, Object> element : whereStatment.entrySet()) {
            String key  =  element.getKey();
            Object value =  element.getValue();

            query += " " + key + "=" + value + " AND ";
        }

        query = query.substring(0, query.length() - 4);
        this.queryBuilder += query;
        return this;
    }

    public Database whereComplex(HashMap<String, WhereOperation> whereStatment) {

        String query = " WHERE ";
        for(Map.Entry<String, WhereOperation> element : whereStatment.entrySet()) {
            String key  =  element.getKey();
            WhereOperation value =  element.getValue();

            query += " "                    +
                    key                     +
                    value.getOperation()    +
                    value.value             +
                    " "                     +
                    value.getNextOperationRelation();
        }

        this.queryBuilder += query;
        return this;
    }

    public Database where(String columnName, WhereOperation whereOperation) {

        this.queryBuilder += " WHERE " + columnName + whereOperation.getOperation() + " " + whereOperation.value;
        return this;
    }

    public Database andThen(String columnName, WhereOperation whereOperation) {

        this.queryBuilder += " AND " + columnName + whereOperation.getOperation() + " " + whereOperation.value;
        return this;
    }

    public Database orThen(String columnName, WhereOperation whereOperation) {

        this.queryBuilder += " OR " + columnName + whereOperation.getOperation() + " " + whereOperation.value;
        return this;
    }

    public Database limit(int limit) {

        this.queryBuilder += " LIMIT " + limit;
        return this;
    }

    public Database limit(int limit, int offset) {

        this.queryBuilder += " LIMIT " + offset + ", " + limit;
        return this;
    }

    public boolean execute() throws SQLException {
        return this.dbStatment.execute(this.queryBuilder, Statement.RETURN_GENERATED_KEYS);
    }

    public ResultSet fetch() throws SQLException {
        return this.dbStatment.executeQuery(this.queryBuilder);
    }

    public Database queryDebug() {

        System.out.println("@@@@@@@@@@@@@@@");
        System.out.println(this.queryBuilder);
        System.out.println("@@@@@@@@@@@@@@@");

        return this;
    }

    public static class WhereOperation {

        String value;
        WhereOperationEnum operation;
        WhereNextOperationRelation nextOperationRelation;

        public WhereOperation(String value, WhereOperationEnum operation) {

            this.value                  = value;
            this.operation              = operation;
        }

        public WhereOperation(String value, WhereOperationEnum operation, WhereNextOperationRelation nextOperationRelation) {

            this.value                  = value;
            this.operation              = operation;
            this.nextOperationRelation  = nextOperationRelation;
        }

        public String getOperation() {

            if(this.operation == WhereOperationEnum.GT      ) return ">";
            if(this.operation == WhereOperationEnum.LT      ) return "<";
            if(this.operation == WhereOperationEnum.EQUAL   ) return "=";
            if(this.operation == WhereOperationEnum.LIKE    ) return " LIKE ";

            return null;
        }

        public String getNextOperationRelation() {

            if(this.nextOperationRelation == WhereNextOperationRelation.AND ) return " AND ";
            if(this.nextOperationRelation == WhereNextOperationRelation.OR  ) return " OR ";

            return " ";
        }
    }

    public enum WhereOperationEnum {
        GT, LT, EQUAL, LIKE
    }

    public enum WhereNextOperationRelation {
        AND, OR
    }

}
