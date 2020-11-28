package com.ds.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GraphTestCases {

    @Test
    public void topologicalSort() {
        DirectedUnweightedGraph<Integer> graph = new DirectedUnweightedGraph<>();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        Assert.assertEquals(GraphUtils.applyTopologicalSort(graph), Arrays.asList(0, 1, 2, 3, 4));
    }

    @Test
    public void dijkstra() {
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

        Map<Integer, Integer> ans = new HashMap<>();
        ans.put(0, 0);
        ans.put(1, 28);
        ans.put(2, 26);
        ans.put(3, 45);
        ans.put(4, 58);

        Assert.assertEquals(GraphUtils.applyDijkstra(graph, GraphUtils.getRandomNode(graph)), ans);
    }

    @Test
    public void kruskals() {
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

        Assert.assertEquals(GraphUtils.applyKruskal(graph), 92);
    }

    @Test
    public void prims() {
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

        Assert.assertEquals(GraphUtils.applyPrims(graph), 92);
    }
}
