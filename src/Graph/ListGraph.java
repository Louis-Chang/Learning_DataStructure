package Graph;

import java.util.ArrayList;
import java.util.List;

public class ListGraph {
    List<List<Integer>> graphs;

    public ListGraph(int v) {
        graphs = new ArrayList<>();
        for (int i=0; i<v; i++) {
            graphs.add(new ArrayList<>());
        }
    }

    public List<List<Integer>> getGraphs() {
        return graphs;
    }

    public void setGraphs(List<List<Integer>> graphs) {
        this.graphs = graphs;
    }

    public void addEdge (int start, int end) {
        graphs.get(start).add(end);
    }

    public void removeEdge (int start, int end) {
        graphs.get(start).remove(end);
    }
}
