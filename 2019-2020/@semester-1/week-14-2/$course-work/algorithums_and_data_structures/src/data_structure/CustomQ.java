package data_structure;

import util.CustomCollectionUtil;

public class CustomQ<T> {

    private int baseCollectionLength = 10;
    private T[] baseCollection;

    private int frontIndex;
    private int backIndex;

    public CustomQ() {

        this.baseCollection = (T[]) new Object[this.baseCollectionLength];
        this.frontIndex = 0;
        this.backIndex  = 0;
    }


    public int getFrontIndex() {
        return this.frontIndex;
    }

    public int getBackIndex() {
        return this.backIndex;
    }

    // add new element
    public void enq(T element) {

        if(this.backIndex == this.baseCollectionLength) {
            // 1. new collection that contains the original
            T[] tmpCollection = (T[]) CustomCollectionUtil.copyCollection(this.baseCollection);
            this.baseCollectionLength = this.baseCollectionLength * 2;
            this.baseCollection = (T[]) new Object[this.baseCollectionLength];
            this.baseCollection = (T[]) CustomCollectionUtil.mergeCollections(this.baseCollection, tmpCollection);
        }

        this.baseCollection[this.backIndex] = element;
        this.backIndex++;
    }

    // NB :
    public Object deq() {

        Object qFrontElement = this.baseCollection[this.frontIndex];
        this.baseCollection[this.frontIndex]        = null;
        this.frontIndex++;

        if(this.frontIndex == this.backIndex) {
            this.frontIndex = this.backIndex = 0;
        }

        //return this.baseCollection[this.frontIndex];
        return qFrontElement;
    }
}
