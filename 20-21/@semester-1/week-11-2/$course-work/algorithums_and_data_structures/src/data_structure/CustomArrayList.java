package data_structure;

import java.util.Objects;

public class CustomArrayList<T> {

    private  T[] baseArray;
    private final int BASE_ARRAY_SIZE   = 10;
    private int currentIndex            = 0;

    public CustomArrayList() {
        this.baseArray = (T[]) new Object[BASE_ARRAY_SIZE];
    }

    // add
    public void add(T element) {

        // 1. Check if baseArray length / 2
        // 2. Transfer all of the element to the new array

        this.baseArray[this.currentIndex] = element;
        this.currentIndex++;
    }

    // get
    public T get(int index) {
        return this.baseArray[index];
    }
}
