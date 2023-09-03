package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxHeap {
    private HeapNode head;
    private List<HeapNode> heapNodes;


    public List<HeapNode> getHeapNodes() {
        return heapNodes;
    }

    public void setHeapNodes(List<HeapNode> heapNodes) {
        this.heapNodes = heapNodes;
    }

    public HeapNode getHead() {
        return head;
    }

    public void setHead(HeapNode head) {
        this.head = head;
    }

    public void push(int value) {
        HeapNode newNode = new HeapNode(value);
        if (getHead()==null) {
            setHead(newNode);
            List<HeapNode> newHeapNodes = new ArrayList<>();
            newHeapNodes.add(newNode);
            setHeapNodes(newHeapNodes);
            return;
        }

        getHeapNodes().add(newNode);

        int currentIndex = getHeapNodes().size()-1;
        HeapNode parentNode = getParent(currentIndex);
        int parentIndex = getParentIndex(currentIndex);
        if (newNode.getValue() > parentNode.getValue()) {
            do {
                //swap
                parentNode = getParent(currentIndex);
                getHeapNodes().set(currentIndex, parentNode);
                getHeapNodes().set(parentIndex, newNode);

                currentIndex = getParentIndex(currentIndex);
                parentIndex = getParentIndex(currentIndex);
            } while (hasParent(currentIndex) && newNode.getValue()>parentNode.getValue());
        }
    }

    public HeapNode pop() {
        HeapNode node = getHeapNodes().get(0);
        setHead(getHeapNodes().get(1));
        getHeapNodes().remove(0);
        return node;
    }

    public int peek() {
        return getHead().getValue();
    }


    public int getLeftChildIndex(int parentNodeIndex) {
        return 2 * parentNodeIndex + 1;
    }

    public int getRightChildIndex(int parentNodeIndex) {
        return 2 * parentNodeIndex + 2;
    }

    public int getParentIndex(int childIndex) {
        if ((childIndex-1)<0) {
            return -1;
        }
        return (childIndex-1)/2;
    }

    public boolean hasLeftChild(int parentNodeIndex) {
        return getLeftChildIndex(parentNodeIndex) < getHeapNodes().size();
    }

    public boolean hasRightChild(int parentNodeIndex) {
        return getRightChildIndex(parentNodeIndex) < getHeapNodes().size();
    }

    public boolean hasParent(int childIndex) {
        return getParentIndex(childIndex) >= 0;
    }

    public HeapNode getLeftChild(int parentIndex) {
        return getHeapNodes().get(getLeftChildIndex(parentIndex));
    }

    public HeapNode getRightChild(int parentIndex) {
        return getHeapNodes().get(getRightChildIndex(parentIndex));
    }

    public HeapNode getParent(int childIndex) {
        return getHeapNodes().get(getParentIndex(childIndex));
    }
}
