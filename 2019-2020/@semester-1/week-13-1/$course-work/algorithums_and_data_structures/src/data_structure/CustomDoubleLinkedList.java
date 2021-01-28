package data_structure;

public class CustomDoubleLinkedList<M> {

    // start point of the list
    private LinkedListNode<M> first;
    private LinkedListNode<M> last;

    public LinkedListNode<M> getHead() {
        return this.first;
    }

    public LinkedListNode<M> getLast() {
        return this.last;
    }

    public class LinkedListNode<T> {

        public T data;
        public LinkedListNode next;
        public LinkedListNode prev;

        public LinkedListNode(T externalData) {
            this.data = externalData;
        }
    }

    public void addNodeToTheFront(M data) {

        // 1. create new Node
        LinkedListNode<M> newListNode = new LinkedListNode<>(data);

        // 2. link node properties
        newListNode.next = this.first; // NULL
        newListNode.prev = null;

        // 3 : current
        if(this.first != null) {
            this.first.prev = newListNode;
        }

        if(this.last == null) {
            this.last = newListNode;
        }

        // 4. Promote new List node to be the first element
        this.first = newListNode;


    }
}
