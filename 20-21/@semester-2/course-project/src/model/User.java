package model;

import controller.ProductController;
import framework.anotation.PrazOrmColumn;
import framework.anotations.PrazOrmAutoIncrement;
import framework.anotations.PrazOrmPrimaryKey;
import framework.anotations.PrazOrmTable;
import framework.db.Database;
import framework.db.DatabaseOrm;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

@PrazOrmTable( tableName = "users")
public class User {

    @PrazOrmPrimaryKey()
    @PrazOrmAutoIncrement()
    public int userId;

    @PrazOrmColumn( columnName = "user_name" )
    private String userName;

    @PrazOrmColumn( columnName = "user_fname" )
    private String userFname;

    @PrazOrmColumn( columnName = "user_lname" )
    private String userlname;

    @PrazOrmColumn( columnName = "user_email" )
    private String userEmail;

    @PrazOrmColumn( columnName = "user_pass" )
    private String userPass;

    // User.fetch().fname // SELECT fname FROM users;
    // User.fetch()        // SELECT * FROM users


    //public static final String TABLE       = "users";
    //public static final String COL_ID      = "id";
    //public static final String COL_NAME    = "user_name";
    //public static final String COL_FNAME   = "user_fname";
    //public static final String COL_LNAME   = "user_lname";
    //public static final String COL_EMAIL   = "user_email";
    //public static final String COL_PASS    = "user_pass";

    public User(String userName, String userFname, String userlname, String userEmail) {

        this.userName   = userName;
        this.userFname  = userFname;
        this.userlname  = userlname;
        this.userEmail  = userEmail;
    }

    public static boolean create(String userName, String userPass, String userFname, String userLname, String userEmail)
    throws SQLException {
//
//        Database.getInstance().insert(TABLE, new HashMap<String, Object>(){{
//            put(COL_NAME     , Database.stringValue(userName));
//            put(COL_PASS     , Database.stringValue(userPass));
//            put(COL_FNAME    , Database.stringValue(userFname));
//            put(COL_LNAME    , Database.stringValue(userLname));
//            put(COL_EMAIL    , Database.stringValue(userEmail));
//        }}).execute();
//
//        long insertedId = Database.getInstance().getLastInsertedId();
//        int userRoleId  = 1;
//
//        if(insertedId > 0) {
//            return insertUserRole(insertedId, userRoleId);
//        }

        return false;
    }

    public static User fetch() {
        return null;

    }

    public static ArrayList<User> fetchAll() throws SQLException {

// Query builder
//        ResultSet userColection = Database.getInstance().select(TABLE).fetch();
//        ArrayList<User> resultUserCollection = new ArrayList<>();
//
//        while(userColection.next()) {
//            resultUserCollection.add(new User(  userColection.getString(COL_NAME),
//                                                userColection.getString(COL_FNAME),
//                                                userColection.getString(COL_LNAME),
//                                                userColection.getString(COL_EMAIL),
//                                                userColection.getString(COL_PASS)));
//        }
//        return resultUserCollection;


// ORM Builder

        // User element = DatabaseOrm.transform(User.class).fetch();
        // ArrayList<User> collection =  DatabaseOrm.transform(User.class).fetchAll();

        // Product element = DatabaseOrm.transform(Product.class).fetch();
        // ArrayList<Product> collection =  DatabaseOrm.transform(Product.class).fetchAll();


        return null;
    }



    private static boolean insertUserRole(long insertedId, int userRoleId) throws SQLException {

        Database.getInstance().insert("user_role", new HashMap<String, Object>(){{
            put("user_id"       , insertedId);
            put("role_id"       , userRoleId);
        }}).execute();

        long lastInsertedId = Database.getInstance().getLastInsertedId();
        return (lastInsertedId > 0);
    }

    public static User findActiveUser(String userEmail, String userPassword) {

        try {
            ResultSet collection = Database.getInstance().select("users").where(new HashMap<String, Object>(){{
                put("user_email"    , Database.stringValue(userEmail));
                put("user_pass"     , Database.stringValue(userPassword));
            }}).queryDebug().fetch();

            if(collection == null) {
                return null;
            }

            collection.next();
            return new User(collection.getString("user_name"),
                            collection.getString("user_fname"),
                            collection.getString("user_lname"),
                            collection.getString("user_email"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String getFullName() {
        return this.userFname + " " + this.userlname;
    }
}
