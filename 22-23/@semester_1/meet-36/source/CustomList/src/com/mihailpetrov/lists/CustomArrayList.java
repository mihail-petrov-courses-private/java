package com.mihailpetrov.lists;

import com.mihailpetrov.contracts.List;

public class CustomArrayList<T> implements List<T> {

    private int size         = 5;
    private Object[] collection = new Object[size];
    private int index        = 0;

    @Override
    public void add(T element) {

        try {
            this.collection[this.index++] = element;
        }
        catch (ArrayIndexOutOfBoundsException ex) {

            this.expand();
            this.collection[--this.index] = element;
            this.index++;
        }
    }

    @Override
    public T get(int index) {
        return (T) this.collection[index];
    }

    @Override
    public void removeByIndex(int index) {

    }

    @Override
    public void remove() {

    }

    @Override
    public void render() {

        for(int i = 0; i < this.index; i++) {
            System.out.println(this.collection[i]);
        }
    }

    private void expand() {

        // копирам всички елеменети в новата колекция
        Object[] temporalCollection = new Object[this.size];
        for(int i = 0; i < size; i++) {
            temporalCollection[i] = collection[i];
        }

        // увеличавам двойно размера на collection
        this.size       = this.size * 2;
        this.collection = new Object[this.size];

        // връщаме всички елементи в оригиналния collection масив
        for(int i = 0; i < temporalCollection.length; i++) {
            this.collection[i] = temporalCollection[i];
        }
    }
}
