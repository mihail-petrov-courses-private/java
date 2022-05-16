package data_structure;

public class CustomLinkedList<T> {

    private CustomLinkedListNode first;
    private CustomLinkedListNode last;
    private int listLength = 0;

    public CustomLinkedList() {

        //
        // this.first = new CustomLinkedListNode();
    }

    public void add(T element) {

        // Create new empty Linked List node
        CustomLinkedListNode node = new CustomLinkedListNode();
        node.value = element;

        if(this.first == null) {

            this.first      = this.last = node;
            node.prevNode   = null;
        }
        else {
            // connect back to new element
            CustomLinkedListNode lastNodeElement = this.last;
            node.prevNode = lastNodeElement;
            this.last = node;
        }

        // this.first.value = element;
        // this.first.next = new CustomLinkedListNode();
    }

    public void removeFirs() {

    }


    public void removeLast() {

        CustomLinkedListNode newLastNode = this.last.prevNode;
        this.last.prevNode               = null;

        this.last = newLastNode;
    }

    public T getElementByPosition(int position) {
        return null;
    }


    public T getFirst() {
        return null;
    }


    public T getLast() {
        return null;
    }
}
