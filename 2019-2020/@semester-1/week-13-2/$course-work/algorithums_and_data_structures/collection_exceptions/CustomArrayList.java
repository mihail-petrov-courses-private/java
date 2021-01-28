package data_structure;

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
            Object[] temporalCollection = copyCollection(this.baseCollection);
            // 2. Create new base collection with double base size
            this.baseSize       = (this.baseSize * 2);
            this.baseCollection = new Object[this.baseSize];
            this.baseCollection = this.mergeCollections(this.baseCollection, temporalCollection);

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

    private Object[] copyCollection(Object[] collection) {

        int collectionLength = collection.length;
        Object[] newCollection = new Object[collectionLength];

        for(int i = 0; i < collectionLength; i++) {
            newCollection[i] = collection[i];
        }

        return newCollection;
    }

    // baseCollection.lenght > mergableCollection.length
    private Object[] mergeCollections(Object[] baseCollection, Object[] mergableCollection) {

        Object[] newCollection = copyCollection(baseCollection);

        for(int i = 0; i < mergableCollection.length; i++) {
            newCollection[i] = mergableCollection[i];
        }
        return newCollection;
    }

    public Object getByIndex(int index) {
        return this.baseCollection[index];
    }

    public Object getElementByIndex(int index) {

        if(this.baseCollection[index] == null) {
            throw new NullPointerException();
        }

        return this.baseCollection[index];
    }
}
