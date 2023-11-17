package Queue;

import java.util.NoSuchElementException;

public class ArrayQueue<AnyType> implements QueueInterface<AnyType> {

    private static final int DEFAULT_CAPACITY = 6;
    private Object[] elements;
    private int front;
    private int back;
    private int nItems;

    public ArrayQueue() {
        elements = new Object[DEFAULT_CAPACITY];
        front = 0;
        /**
         * When the first element is added to the queue, the back index is incremented (from -1 to 0) before inserting the element, which means the first element will be placed at index 0 of the array.
         * If back were initialized to 0, after adding the first element, you would need to insert it at back + 1, which would leave an unused space at the beginning of the array.
         */
        back = -1; // means that the Queue is empty
        nItems = 0;
    }

    /**
     * Inserts a new item into the back of the queue
     * @param item a new item to be inserted
     */
    @Override
    public void enqueue(AnyType item) {
        if(isFull()) {
            throw new RuntimeException("Queue is Full");
        }
        back++;
        elements[back % elements.length] = item;
        nItems++;
    }

    /**
     * Returns and removes the item at the front.
     * @return the item at the front of the queue
     * @throws java.util.NoSuchElementException if it's empty
     */
    @Override
    public AnyType dequeue() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        int index = front % elements.length;
        AnyType result = (AnyType) elements[index];
        elements[index] = null;
        front++;
        nItems--;
        return result;
    }

    @Override
    public AnyType peekFront() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        int index = front % elements.length;
        AnyType result = (AnyType) elements[index];
        return result;
    }

    @Override
    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == elements.length;
    }
}
