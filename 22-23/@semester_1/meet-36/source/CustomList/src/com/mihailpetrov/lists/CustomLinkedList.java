package com.mihailpetrov.lists;

import com.mihailpetrov.contracts.List;

public class CustomLinkedList<T> implements List<T> {

    private CustomLinkedListNode head = null;
    private CustomLinkedListNode tail = null;

    @Override
    public void add(T element) {

        if(this.head == null) {

            this.head = new CustomLinkedListNode(element);
            this.tail = this.head;
            return;
        }

        CustomLinkedListNode node = new CustomLinkedListNode(element);
        this.tail.setNext(node);
        this.tail = node;
    }

    @Override
    public T get(int index) {

        if(index == 0) {
            return (T) this.head.getData();
        }

        int positionIndex = 1;
        CustomLinkedListNode element = this.head.getNext();
        while (element.hasNext()) {

            if(positionIndex == index) {
                return (T) element.getData();
            }

            element = element.getNext();
            positionIndex++;
        }

        return null;
    }

    @Override
    public void removeByIndex(int index) {

    }

    @Override
    public void remove() {

    }

    @Override
    public void render() {

        CustomLinkedListNode element = this.head;
        while (element.hasNext()) {

            System.out.println(element.getData());
            element = element.getNext();
        }
    }

    private class CustomLinkedListNode {

        private Object data;
        private CustomLinkedListNode next;
        private CustomLinkedListNode prev;

        public CustomLinkedListNode(Object data) {
            this.data = data;
        }

        public void setNext(CustomLinkedListNode node) {
            this.next = node;
        }

        public boolean hasNext() {
            return this.next != null;
        }

        public Object getData() {
            return this.data;
        }

        public CustomLinkedListNode getNext() {
            return this.next;
        }
    }

}
