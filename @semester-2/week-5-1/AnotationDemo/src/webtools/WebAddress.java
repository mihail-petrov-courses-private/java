package webtools;
import demoweb.Status;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface WebAddress {

    // String url() default "";
    String url();
    int defaultStatus() default 200;
    Status status() default Status.SUCCESS;
}
