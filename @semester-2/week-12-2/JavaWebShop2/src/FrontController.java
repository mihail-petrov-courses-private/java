import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet( value ="/base/*")
public class FrontController extends HttpServlet {

    private String[] getHttpPath(String pathInfo) {

        String path             = pathInfo.substring(1);
        String[] pathCollection = path.split("/");
        return pathCollection;
    }

    private boolean isPathProcessable(String[] pathCollection) {

        try {
            String controllerHandler = pathCollection[0];
            if(controllerHandler.equals("style")) {
                return false;
            }
        }
        catch (Exception e) {
            return true;
        }

        return true;
    }


    private boolean isPathNotProcessable(String[] pathCollection) {
        return !this.isPathProcessable(pathCollection);
    }


    private String getController(String[] pathCollection) {

        try {
            String controllerHandler = pathCollection[0];
            String firstCapitalLetter = controllerHandler.substring(0, 1).toUpperCase();
            String controllerRestLetters = controllerHandler.substring(1);
            return String.format("controller.%s%sController", firstCapitalLetter, controllerRestLetters);
        }
        catch(Exception e) {
            return "controller.HomeController";
        }
    }

    private String getMethod(String[] pathCollection) {
        try {
            return pathCollection[1];
        }
        catch(Exception e) {
            return "index";
        }
    }

    private String getControllerMethod(String httpMethod, Method[] methodCollection, String controllerMethodId) {

        if(httpMethod.equals("GET")) {

            for(int i = 0; i < methodCollection.length; i++) {

                String methodName = methodCollection[i].getName();

                if(methodName.equals(controllerMethodId)) {
                    return methodName;
                }

                if(methodName.equals(("get_" + controllerMethodId))) {
                    return methodName;
                }
            }
        }

        if(httpMethod.equals("POST")) {

            for(int i = 0; i < methodCollection.length; i++) {

                if(methodCollection[i].getName().equals(("post_" + controllerMethodId))) {
                    return methodCollection[i].getName();
                }
            }
        }

        return null;
    }


    private void requestProcessor(String httpMethod, HttpServletRequest req, HttpServletResponse resp) {

        String[] pathCollection     = getHttpPath(req.getPathInfo());
        if(this.isPathNotProcessable(pathCollection)) {
            return;
        }

        String controllerClassId    = this.getController(pathCollection);
        String controllerMethodId   = this.getMethod(pathCollection);

        try {
            Class<?> classReference  = Class.forName(controllerClassId);
            Object newClassInstance  = classReference.newInstance();

            Method[] methodCollection   = classReference.getDeclaredMethods();
            String controllerMethod     = getControllerMethod(httpMethod, methodCollection, controllerMethodId);

            Method methodReference   = classReference.getDeclaredMethod(controllerMethod,
                    HttpServletRequest.class,
                    HttpServletResponse.class);
            methodReference.invoke(newClassInstance, req, resp);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
        this.requestProcessor("GET",req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
        this.requestProcessor("POST", req, resp);
    }
}