import Graph.GraphTraveral;
import Graph.ListGraph;
import Heap.HeapNode;
import Heap.MaxHeap;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        graphTest();
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

    public static void graphTest() {
        ListGraph listGraph = new ListGraph(7);
        listGraph.addEdge(0, 1);
        listGraph.addEdge(1, 2);
        listGraph.addEdge(1, 3);
        listGraph.addEdge(1, 4);
        listGraph.addEdge(1, 5);
        listGraph.addEdge(2, 5);
        listGraph.addEdge(3, 2);
        listGraph.addEdge(4, 1);
        listGraph.addEdge(4, 3);
        listGraph.addEdge(5, 6);

        GraphTraveral graphTraveral = new GraphTraveral(listGraph);
        graphTraveral.BFS();
    }
}