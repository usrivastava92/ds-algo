package com.ds.graph;

import javafx.util.Pair;

import java.util.Map;
import java.util.Set;

public interface IWeightedGraph<Node, Weight extends Comparable<Weight>> extends IGraph<Node> {

    void addEdge(Node from, Node to, Weight weight);

    Map<Node, Weight> getNeighboursWithEdges(Node node);

    Set<Pair<Node, Node>> getAllEdges();

    void deleteEdge(Node from, Node to);

    Weight getEdgeWeight(Node from, Node to);

    Map<Node,Map<Node,Weight>> getAdjacencyList();


}
