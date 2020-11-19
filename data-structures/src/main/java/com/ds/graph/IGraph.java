package com.ds.graph;

import javafx.util.Pair;

import java.util.Set;

public interface IGraph<Node> {

    Set<Node> getNeighbours(Node node);

    Set<Node> getAllNodes();

    boolean isConnected(Node node1, Node node2);

    boolean isEmpty();

    Set<Pair<Node, Node>> getAllEdges();


}
