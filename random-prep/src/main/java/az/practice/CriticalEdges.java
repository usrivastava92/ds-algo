package az.practice;

import com.ds.graph.GraphUtils;
import com.ds.graph.UndirectedUnweightedGraph;

public class CriticalEdges {

    public static void main(String[] args) {
        UndirectedUnweightedGraph<Integer> graph = new UndirectedUnweightedGraph<>();
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 3);
        graph.addEdge(1, 3);
        System.out.println(GraphUtils.getCriticalEdges(graph));
    }

}
