package com.ds.graph;

public class Executor {

    public static void main(String args[]) {
        IUndirectedGraph<Integer> graph = GraphUtils.createRandomUndirectedUnweightedGraph(10);
        System.out.println(GraphUtils.hasCycle(graph));
    }

}
