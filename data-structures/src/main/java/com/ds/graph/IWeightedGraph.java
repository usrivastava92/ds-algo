package com.ds.graph;

import javafx.util.Pair;

import java.util.Map;
import java.util.Set;

public interface IWeightedGraph<Node, Weight extends Comparable<Weight>> extends IGraph<Node> {

    void addEdge(Node from, Node to, Weight weight);

    Map<Node, Weight> getNeighboursWithWeights(Node node);

    Set<Pair<Node, Pair<Node, Weight>>> getAllEdgesWithWeights();

    void deleteEdge(Node from, Node to);

    Weight getEdgeWeight(Node from, Node to);

}
