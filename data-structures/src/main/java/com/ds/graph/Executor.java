package com.ds.graph;

public class Executor {

    public static void main(String args[]) {
        IWeightedGraph<Integer, Integer> graph = new UndirectedWeightedGraph<>();
        graph.addEdge(0, 1, 28);
        graph.addEdge(0, 2, 26);
        graph.addEdge(0, 3, 70);
        graph.addEdge(1, 3, 78);
        graph.addEdge(1, 2, 50);
        graph.addEdge(1, 4, 89);
        graph.addEdge(2, 3, 19);
        graph.addEdge(2, 4, 32);
        graph.addEdge(3, 4, 19);

        System.out.println(graph);
        System.out.println(GraphUtils.applyDijkstra(graph, GraphUtils.getRandomNode(graph)));
        System.out.println(GraphUtils.applyKruskal(graph));
        System.out.println(GraphUtils.applyPrims(graph));
    }

}
