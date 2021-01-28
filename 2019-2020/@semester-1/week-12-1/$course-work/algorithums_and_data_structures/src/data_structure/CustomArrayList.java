package data_structure;

import collection_exception.NoElementOverThisIndexInCollection;
import util.CustomCollectionUtil;

import java.util.Objects;

public class CustomArrayList<T> {

    // base object collection to T (generic type)
    private Object[] baseCollection;
    private int baseSize            = 10;
    private int baseCollectionIndex = 0;

    public CustomArrayList() {
        this.baseCollection = new Object[this.baseSize];
    }

    public void add(Object element) {

        try {
            this.baseCollection[this.baseCollectionIndex] = element;
            // this.baseCollectionIndex++;
        }
        catch (ArrayIndexOutOfBoundsException exception) {
            // baseCollection.clone();

            // 1. Copy collection from original array collection to temporal collection
            Object[] temporalCollection = CustomCollectionUtil.copyCollection(this.baseCollection);
            // 2. Create new base collection with double base size
            this.baseSize       = (this.baseSize * 2);
            this.baseCollection = new Object[this.baseSize];
            this.baseCollection = CustomCollectionUtil.mergeCollections(this.baseCollection, temporalCollection);

            // 3. Maintaine class base properties
            this.baseCollection[this.baseCollectionIndex] = element;
            // this.baseCollectionIndex++;
        }
        finally {
            this.baseCollectionIndex++;
        }
    }

    /**
     * #Bad comment : example
     * Return all of active elements over the collection
     * @return
     */
    public int size() {
        return this.baseCollectionIndex;
    }

    /**
     * #Bad comment : example
     * Return the length of the collection
     * @return
     */
    public int length() {
        return this.baseCollection.length;
    }

    public Object getByIndex(int index) {
        return this.baseCollection[index];
    }

    public Object getElementByIndex(int index) {

        if(this.baseCollection[index] == null) {
            // throw new NullPointerException();
            throw new NoElementOverThisIndexInCollection();
        }

        return this.baseCollection[index];
    }
}
