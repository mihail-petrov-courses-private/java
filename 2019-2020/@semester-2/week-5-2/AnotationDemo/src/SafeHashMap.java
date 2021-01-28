import java.util.HashMap;

public class SafeHashMap<K, V> {

    private HashMap<K, V> collection;

    public SafeHashMap() {
        this.collection = new HashMap<>();
    }
    
    public void put(K key, V value) {

        if(this.collection.containsKey(key)) {
            throw new RuntimeException("This key alreadye exists");
        }

        this.collection.put(key, value);
    }

    public void forcePut(K key, V value) {
        this.collection.put(key, value);
    }
}
