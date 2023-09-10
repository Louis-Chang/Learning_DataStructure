package Graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class GraphTraveral {

    private ListGraph listGraph;
    private boolean[] visited;

    public GraphTraveral(ListGraph listGraph) {
        this.listGraph = listGraph;
        visited = new boolean[listGraph.getGraphs().size()];
    }

    public ListGraph getListGraph() {
        return listGraph;
    }

    public void setListGraph(ListGraph listGraph) {
        this.listGraph = listGraph;
    }

    public boolean[] getVisited() {
        return visited;
    }

    public void setVisited(boolean[] visited) {
        this.visited = visited;
    }

    public void DFS() {
        for (int i=0; i<listGraph.getGraphs().size(); i++) {
            if (!visited[i]) {
                DFSTraversal(i);
            }
        }
    }
    private void DFSTraversal(int v) {
        if (visited[v]) {
            return;
        }
        visited[v] = true;
        System.out.println("dfs vertice: " + v);

        List<Integer> currentSubList = listGraph.getGraphs().get(v);
        Iterator iterator = currentSubList.iterator();
        while (iterator.hasNext()) {
            String nextNodeString = iterator.next().toString();
            Integer nextNode = Integer.valueOf(nextNodeString);
            if (!visited[nextNode]) {
                DFSTraversal(nextNode);
            }
        }
    }

    public void BFS() {
        for (int i=0; i<listGraph.getGraphs().size(); i++) {
            if (!visited[i]) {
                BFSTraversal(i);
            }
        }
    }
    private void BFSTraversal(int v) {
        visited[v] = true;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(v);

        while (!deque.isEmpty()) {
            Integer current = deque.removeFirst();
            List<Integer> currentNeighbors = listGraph.getGraphs().get(current);
            Iterator currentNeighborsIterator = currentNeighbors.iterator();
            while (currentNeighborsIterator.hasNext()) {
                String nextNodeString = currentNeighborsIterator.next().toString();
                Integer nextNode = Integer.valueOf(nextNodeString);
                if (!visited[nextNode]) {
                    deque.addLast(nextNode);
                    visited[nextNode] = true;
                }
            }
        }
    }
}
