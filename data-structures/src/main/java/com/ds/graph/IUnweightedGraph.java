package com.ds.graph;

public interface IUnweightedGraph<Node> extends IGraph<Node> {

    void addEdge(Node from, Node to);

    void deleteEdge(Node from, Node to);

}
