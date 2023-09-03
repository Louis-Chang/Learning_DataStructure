package Heap;

public class PriorityNode {
    private int value;
    private int priority;   //small number for higher priority
    private PriorityNode next;

    public PriorityNode(int value, int priority) {
        this.value = value;
        this.priority = priority;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public PriorityNode getNext() {
        return next;
    }

    public void setNext(PriorityNode next) {
        this.next = next;
    }
}
