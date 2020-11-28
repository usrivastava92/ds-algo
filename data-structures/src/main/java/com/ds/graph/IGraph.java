package com.ds.graph;


import java.util.Set;

public interface IGraph<Node> {

    Set<Node> getNeighbours(Node node);

    Set<Node> getAllNodes();

    boolean isConnected(Node node1, Node node2);

    boolean isEmpty();

    Set<Edge<Node>> getAllEdges();

    void deleteNode(Node node);


}
