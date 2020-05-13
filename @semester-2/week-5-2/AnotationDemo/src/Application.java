import models.Student;
import webtools.WebAddress;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Application {

    public static void main(String[] argrs) {

        //JsonSerializerTool jsonSerializer = new JsonSerializerTool();
        //String jsonResult = jsonSerializer.serialize(new Student("Ivan", "Ivanov", 4));
        //System.out.println(jsonResult);

//        HashMap<String, Integer> jsonOutput = new HashMap<>();
//        jsonOutput.put("Ivan", 26);
//        jsonOutput.put("Dragan", 26);
//        jsonOutput.put("Petkan", 26);

        //HashMap<String, Student> studentJsonOutput = new HashMap<>();
//        Map<String, Student> studentJsonOutput = new HashMap<>();

//        studentJsonOutput.put("9254545875", new Student("Mihail", "Petrov", 4));
//        studentJsonOutput.put("9254545875", new Student("Ivan", "Ivanov", 5));
//
//        System.out.println(studentJsonOutput.get("9254545875").getFname());

        Student student = new Student("Mihail", "Petrov", 4);
        JsonSerializerTool json = new JsonSerializerTool();

        try {
            System.out.println(json.serialize(student));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
