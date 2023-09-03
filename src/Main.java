import Heap.HeapNode;
import Heap.MaxHeap;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    public void heapTest() {

        MaxHeap maxHeap = new MaxHeap();
        maxHeap.push(2);
        maxHeap.push(3);
        maxHeap.push(4);
        maxHeap.push(5);
        maxHeap.push(6);

        List<HeapNode> heapNodes = maxHeap.getHeapNodes();
        for (HeapNode heapNode:heapNodes) {
            System.out.println(heapNode.getValue());
        }
    }
}