package com.mihailpetrov.contracts;

public interface List<T> {

    // добавяне на нова стойност към списъка
    void add(T element);

    // връща елемент от списъка
    T get(int index);


    // премахва елемент по индекс
    void removeByIndex(int index);

    // премахва конкретен елемент
    void remove();

    void render();
}
