import webtools.JsonProperty;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JsonSerializerTool {

    public String serialize(Object object)
            throws IllegalAccessException {

        // { "fname" : "Ivan", "lname" : "Ivanov", "year" : 4}
        Class objectClass = object.getClass();

        HashMap<String, String> jsonOutput = new HashMap<>();
        Field[] fieldCollecion = objectClass.getFields();
        for(int i = 0; i < fieldCollecion.length; i++) {
            Field element = fieldCollecion[i];

            if(element.isAnnotationPresent(JsonProperty.class)) {

                String alternativeName = element.getAnnotation(JsonProperty.class).alternativeName();

                // jsonOutput.put(element.getName(), (String) element.get(object));
                jsonOutput.put(alternativeName, (String) element.get(object));
            }
        }

        return parseJsonOutput(jsonOutput);
    }

    private String parseJsonOutput(HashMap<String, String> jsonOutput) {

        String jsonStringBuilder;
        Set<String> keyCollection =  jsonOutput.keySet();

        Object[] collection = keyCollection.toArray();

        jsonStringBuilder = "{";
        for(int i = 0; i < collection.length; i++) {

            jsonStringBuilder += "\"" + collection[i] + "\" : " + jsonOutput.get(collection[i]);
            if(i < collection.length - 1) {
                jsonStringBuilder += ",";
            }
        }

        jsonStringBuilder += "}";

        return jsonStringBuilder;
    }
}
