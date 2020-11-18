package com.ds.graph.representation;

import java.util.Map;
import java.util.Set;

public interface IWeightedGraph<Node, Weight extends Comparable<Weight>> {

    void addEdge(Node from, Node to, Weight weight);
    Set<Map<Node,Weight>> getNeighboursWithEdges(Node node);

}
