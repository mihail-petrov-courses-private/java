package service;

import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import java.io.Writer;

public class Form {

    public static void href(JspWriter instance, String linkPath, String linkTitle) throws IOException {

        String signoutHref         = Util.getFullPath(linkPath);
        String linkSignout     = "<a href='" + signoutHref + "'>" + linkTitle + "</a>";

        instance.print(linkSignout);
    }
}
