import demoweb.Status;
import webtools.WebAddress;

@WebAddress(url         = "http://localhost/login",
            status          = Status.NOT_FOUND,
            defaultStatus   = 404)
public class ServletWebPage extends WebPage {

    public Status getHttp(String url, String header) {
        return super.getHttp(url);
    }

    @Override
    public Status postHttp(String url) {
        return super.postHttp(url);
    }


    private Status login() {
        return Status.SUCCESS;
    }
}
