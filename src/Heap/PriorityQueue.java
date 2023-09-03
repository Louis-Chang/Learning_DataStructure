package Heap;

public class PriorityQueue {

    private PriorityNode head;

    public PriorityNode getHead() {
        return head;
    }

    public void setHead(PriorityNode head) {
        this.head = head;
    }


    public void push(int value, int priority) {
        PriorityNode newNode = new PriorityNode(value, priority);
        if (getHead()==null) {
            setHead(newNode);
            return;
        }
        PriorityNode currentNode = getHead();
        if (newNode.getPriority() < getHead().getPriority()) {
            newNode.setNext(currentNode);
            setHead(newNode);
        } else {
            while (currentNode.getNext()!=null && newNode.getPriority()>currentNode.getNext().getPriority()) {
                currentNode = currentNode.getNext();
            }
            newNode.setNext(currentNode.getNext());
            currentNode.setNext(newNode);
        }
    }

    public PriorityNode pop() {
        PriorityNode node = getHead();
        if (node != null) {
            node.setNext(null);
            setHead(node.getNext());
        }
        return node;
    }

    public PriorityNode peek() {
        return getHead();
    }
}
