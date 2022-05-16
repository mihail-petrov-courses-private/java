
public class Home extends AppController {

	public void init() {
		System.out.print("Init Home Controller");
	}

	@Override
	public void index() {
		System.out.print("Index page");
	}
}
