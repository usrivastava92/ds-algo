package com.ds.graph;

import javafx.util.Pair;

import java.util.Set;

public interface IUnweightedGraph<Node> extends IGraph<Node> {

    void addEdge(Node from, Node to);

    void removeEdge(Node from, Node to);

}
