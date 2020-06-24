package framework.db;

import framework.anotation.PrazOrmColumn;
import framework.anotations.PrazOrmTable;
import framework.db.exception.PrazOrmException;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    private static Object columnMapper(Class classReference, ResultSet databaseObject)
        throws IllegalAccessException, InstantiationException, SQLException {

        Object classInstance = classReference.newInstance();

        Field[] collection = classReference.getDeclaredFields();

        for(int i = 0; i < collection.length; i++) {

            Field fieldElement = collection[i];

            if(fieldElement.isAnnotationPresent(PrazOrmColumn.class)) {
                PrazOrmColumn annotationReference = fieldElement.getAnnotation(PrazOrmColumn.class);
                String columnNameReference = annotationReference.columnName(); // user_name
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
}
