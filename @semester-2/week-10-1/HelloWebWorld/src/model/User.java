package model;

import db.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class User {

    private String username;
    private String email;
    private int age;
    private int role;

    private static final String TABLE = "users";

    public User(String username, String email, int age, int role) {
        this.username   = username;
        this.email      = email;
        this.age        = age;
        this.role       = role;
    }

    public static User fetch(String username) throws SQLException {

        ResultSet dbCollection  = Database.getInstance().select(TABLE, new String[]{
                "username",
                "email",
                "age",
                "role"
        }).where("username", Database.operation(Database.stringValue(username),
                Database.WhereOperationEnum.EQUAL)).fetch();

        return transform(dbCollection);
    }

    public static ArrayList<User> fetchAll() throws SQLException {

        ArrayList<User> collection = new ArrayList<>();

        ResultSet dbCollection  = Database.getInstance().select(TABLE, new String[]{
                "username",
                "email",
                "age",
                "role"
        }).fetch();

        while(dbCollection.next()) {
            collection.add(transform(dbCollection));
        }

        return collection;
    }


    private static User transform(ResultSet reference) throws SQLException {

        return new User(reference.getString("username"),
                reference.getString("email"),
                reference.getInt("age"),
                reference.getInt("role"));
    }

    // DELETE

    // UPDATE


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
