package LinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<AnyType> implements Iterable<AnyType> {

    private Node<AnyType> head;

    public SinglyLinkedList() {
        this.head = null;
    }


    public void addFirst(AnyType element) {
        this.head = new Node(element, head);
    }

    public void addLast(AnyType element) {
        if(head==null) {
            addFirst(element);
            return;
        }
        Node<AnyType> currentNode = this.head;
        while (currentNode.next!=null) {
            currentNode = currentNode.next;
        }
        currentNode.next = new Node<>(element, null);;
    }

    public Object getFirst() {
        return this.head;
    }

    public Object getLast() {
        if(head==null) {
            return null;
        }
        Node<AnyType> currentNode = this.head;
        while (currentNode.next!=null) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    /**
     * Finds a node containing "key" and insert a new item after it.
     * @param key
     * @param item
     */
    public void insertAfter(AnyType key, AnyType item) {
        if(head==null) {
            return;
        }
        Node<AnyType> currentNode = this.head;
        while (currentNode!=null && !currentNode.data.equals(item)) {
            currentNode = currentNode.next;
        }
        if (currentNode!=null) {
            currentNode.next = new Node<>(item, currentNode.next);
        }
    }

    /**
     * Finds a node containing "key" and insert a new item before it.
     * @param key
     * @param item
     */
    public void insertBefore(AnyType key, AnyType item) {
        if(head==null) {
            return;
        }
        if(head.data.equals(key)) {
            addFirst(item);
            return;
        }

        /**
         * key is not in the head
         * Needs to keep track of previous node of current node.
         */
        Node<AnyType> currentNode = this.head;
        Node<AnyType> previousNode = null;
        while(currentNode!=null && !currentNode.data.equals(key)) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        previousNode = new Node<>(item, currentNode);
    }

    /**
     * Removes the first occurrence of a key from the list
     * @param key a key to be deleted
     */
    public void remove(AnyType key) {
        if(head==null) {
            return;
        }
        if(head.data.equals(key)) {
            this.head = head.next;
            return;
        }

        Node<AnyType> currentNode = this.head;
        Node<AnyType> previousNode = null;
        while(currentNode!=null && !currentNode.data.equals(key)) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        if(currentNode!=null) {
            previousNode.next = currentNode.next;
        }
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<AnyType> iterator() {
        return new LinkedListIterator();
    }


    private class Node<AnyType> {

        private AnyType data;
        private Node<AnyType> next;

        public Node(AnyType data, Node<AnyType> next) {
            this.data = data;
            this.next = next;
        }
    }

    private class LinkedListIterator implements Iterator<AnyType> {

        private Node<AnyType> nextNode;

        public LinkedListIterator() {
            this.nextNode = head;
        }

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public AnyType next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            AnyType result = nextNode.data;
            nextNode = nextNode.next;
            return result;
        }
    }
}
