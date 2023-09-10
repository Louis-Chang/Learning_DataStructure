import Graph.GraphTraveral;
import Graph.ListGraph;
import Heap.HeapNode;
import Heap.MaxHeap;
import Tree.BinarySearchTree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            treeTest();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void heapTest() {
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

    public static void treeTest() throws Exception {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(5);
        tree.insert(2);
        tree.insert(6);
        tree.insert(1);
        tree.insert(4);
        tree.insert(3);
        tree.insert(7);

        System.out.println("Pre-order");
        tree.traversePreOrder(tree.getRoot());
        System.out.println("\nIn-order");
        tree.traverseInOrder(tree.getRoot());
        System.out.println("\nPost-order");
        tree.traversePostOrder(tree.getRoot());
        System.out.println();
    }
}