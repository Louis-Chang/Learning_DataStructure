package Stack;

import java.util.EmptyStackException;

public class ArrayStack<AnyType> implements StackInterface<AnyType> {
    private static final int DEFAULT_CAPACITY = 10;
    private int top; // the index of the top of the stack
    private Object[] elements;

    public ArrayStack(int initialCapacity) {
        if (initialCapacity<=0) {
            elements = new Object[DEFAULT_CAPACITY];
        } else {
            elements = new Object[initialCapacity];
        }

        // Set the top to be -1, indicating that the stack is empty.
        top = -1;
    }

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void push(AnyType item) {
        if(top == elements.length-1) {
            throw new StackOverflowError("Full");
        }
        elements[top] = item;
    }

    @Override
    public AnyType pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        AnyType topElement = (AnyType) elements[top];
        elements[top] = null;
        top--; // reduce the top variable
        return topElement;
    }

    @Override
    public AnyType peek() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        AnyType topElement = (AnyType) elements[top];
        return topElement;
    }

    @Override
    public boolean isEmpty() {
        return elements.length==0;
    }
}
