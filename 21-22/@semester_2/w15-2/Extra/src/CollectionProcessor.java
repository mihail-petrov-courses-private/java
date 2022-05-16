import java.util.function.Consumer;

public class CollectionProcessor implements Consumer<Integer> {

	@Override
	public void accept(Integer t) {
		System.out.println("Element render -> " + t);
	}
}
