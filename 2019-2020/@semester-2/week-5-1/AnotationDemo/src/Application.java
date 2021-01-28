import webtools.WebAddress;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Application {

    public static void main(String[] argrs) {

        ServletWebPage page = new ServletWebPage();
        Class pageReference = page.getClass();
        Annotation annotationReference  = pageReference.getAnnotation(WebAddress.class);
        WebAddress webAdressAnotation   = (WebAddress) annotationReference;
        System.out.println("Call url " + webAdressAnotation.url());
        Method[] collection = pageReference.getMethods();
        for(int i = 0; i < collection.length; i++) {
            System.out.println(collection[i].getModifiers());
            System.out.println("**");
        }
    }

}
