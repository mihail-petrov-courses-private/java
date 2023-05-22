package framework.db;

import framework.anotation.PrazOrmColumn;
import framework.anotations.PrazOrmTable;
import framework.db.exception.PrazOrmException;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class DatabaseOrm {

    public static ArrayList<Object> fetchAll(Class classReference) {

        try {
            String tableName = getORMTable(classReference);
            ResultSet databaseObjectCollection  = Database.getInstance().select(tableName).fetch();
            ArrayList<Object> resultObjectCollection  = new ArrayList<>();

            while(databaseObjectCollection.next()) {
                resultObjectCollection.add(columnMapper(classReference, databaseObjectCollection));
            }

            return resultObjectCollection;

        } catch (PrazOrmException | SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return null;
    }

    //
    //    String insertQuery = Database.getInstance().insert("users", new HashMap<String, Object>() {{
    //        put("username"  , Database.stringValue("Mihail"));
    //        put("email"     , Database.stringValue("mail@mail.bg"));
    //        put("password"  , Database.stringValue("password"));
    //        put("age"       , Database.intValue("10"));
    //        put("role"      , "0");
    //    }}).execute();

    ////            this.dbConnection.insert("users", new HashMap<String, Object>() {{
    ////                put("username"  , Database.stringValue(username));
    ////                put("email"     , Database.stringValue(useremail));
    ////                put("password"  , Database.stringValue(userpass));
    ////                put("age"       , Database.intValue(userage));
    ////                put("role"      , "0");
    ////            }}).execute();

    public static void insert(Object reference) {

        Class classReference = reference.getClass();
        try {

            String table = getORMTable(classReference);
            HashMap<String, Object> insertColumnCollectionMap = new HashMap<>();

            Field[] collection = classReference.getDeclaredFields();
            for(int i = 0; i < collection.length; i++) {
                Field fieldReference = collection[i];

                if(fieldReference.isAnnotationPresent(PrazOrmColumn.class)) {
                    PrazOrmColumn annotationReference = fieldReference.getAnnotation(PrazOrmColumn.class);
                    String columnNameReference = annotationReference.columnName(); //
                    fieldReference.setAccessible(true);
                    Object fieldfValue = fieldReference.get(reference);
                    insertColumnCollectionMap.put(columnNameReference, Database.stringValue((String) fieldfValue));
                }
            }

            boolean isExecutedSuccessfuly = Database.getInstance().insert(table, insertColumnCollectionMap).queryDebug().execute();

        } catch (PrazOrmException | IllegalAccessException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static Object columnMapper(Class classReference, ResultSet databaseObject)
        throws IllegalAccessException, InstantiationException, SQLException {

        Object classInstance = classReference.newInstance();

        Field[] collection = classReference.getDeclaredFields();

        for(int i = 0; i < collection.length; i++) {

            Field fieldElement = collection[i];

            if(fieldElement.isAnnotationPresent(PrazOrmColumn.class)) {
                PrazOrmColumn annotationReference = fieldElement.getAnnotation(PrazOrmColumn.class);
                String columnNameReference = annotationReference.columnName(); // user_name
                fieldElement.setAccessible(true);
                fieldElement.set(classInstance, databaseObject.getString(columnNameReference));
            }
        }

        return classInstance;
    }

    private static String getORMTable(Class classReference) throws PrazOrmException {

        if(classReference.isAnnotationPresent(PrazOrmTable.class)) {
            PrazOrmTable annotationReference = (PrazOrmTable) classReference.getAnnotation(PrazOrmTable.class);
            return annotationReference.tableName();
        }

        throw new PrazOrmException("Annotation @PrazOrmTable is required in order to use fetchAll");
    }

    public static Object fetch(Class classRefernce) {
        return null;
    }
}
