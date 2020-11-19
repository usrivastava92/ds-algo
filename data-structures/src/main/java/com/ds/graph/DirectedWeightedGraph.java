package com.ds.graph;

import javafx.util.Pair;

import java.util.*;

public class DirectedWeightedGraph<Node, Weight extends Comparable<Weight>> implements IDirectedGraph<Node>, IWeightedGraph<Node, Weight> {

    private final Map<Node, Map<Node, Weight>> map;
    private final Set<Pair<Node, Node>> edges;

    public DirectedWeightedGraph() {
        this.map = new HashMap<>();
        this.edges = new HashSet<>();
    }

    @Override
    public Set<Node> getNeighbours(Node node) {
        return map.getOrDefault(node, Collections.emptyMap()).keySet();
    }

    @Override
    public Set<Node> getAllNodes() {
        return map.keySet();
    }

    @Override
    public boolean isConnected(Node node1, Node node2) {
        return map.getOrDefault(node1, Collections.emptyMap()).containsKey(node2);
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public Map<Node, Map<Node, Weight>> getAdjacencyList() {
        return map;
    }

    @Override
    public void addEdge(Node from, Node to, Weight weight) {
        edges.add(new Pair<>(from, to));
        Map<Node, Weight> neighbours = map.getOrDefault(from, new HashMap<>());
        neighbours.put(to, weight);
        map.put(from, neighbours);
    }

    @Override
    public Map<Node, Weight> getNeighboursWithEdges(Node node) {
        return map.getOrDefault(node, Collections.emptyMap());
    }

    @Override
    public Set<Pair<Node, Node>> getAllEdges() {
        return edges;
    }

    @Override
    public void deleteEdge(Node from, Node to) {
        edges.remove(new Pair<>(from, to));
        map.getOrDefault(from, Collections.emptyMap()).remove(to);
    }

    @Override
    public Weight getEdgeWeight(Node from, Node to) {
        return map.getOrDefault(from, Collections.emptyMap()).get(to);
    }
}
