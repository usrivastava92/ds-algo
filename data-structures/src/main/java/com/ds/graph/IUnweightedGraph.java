package com.ds.graph;

import javafx.util.Pair;

import java.util.Map;
import java.util.Set;

public interface IUnweightedGraph<Node> extends IGraph<Node> {

    void addEdge(Node from, Node to);

    Set<Pair<Node, Node>> getAllEdges();

    void removeEdge(Node from, Node to);

    Map<Node, Set<Node>> getAdjacencyList();

}
