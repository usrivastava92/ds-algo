package com.ds.graph;

import javafx.util.Pair;

import java.util.*;

public class DirectedUnweightedGraph<Node> implements IDirectedGraph<Node>, IUnweightedGraph<Node> {

    private final Map<Node, Set<Node>> map;
    private final Set<Pair<Node, Node>> edges;

    public DirectedUnweightedGraph() {
        this.map = new HashMap<>();
        edges = new HashSet<>();
    }

    @Override
    public Set<Node> getNeighbours(Node node) {
        return map.getOrDefault(node, Collections.emptySet());
    }

    @Override
    public Set<Node> getAllNodes() {
        return map.keySet();
    }

    @Override
    public boolean isConnected(Node node1, Node node2) {
        return map.getOrDefault(node1, Collections.emptySet()).contains(node2);
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public Set<Pair<Node, Node>> getAllEdges() {
        return edges;
    }

    @Override
    public void removeEdge(Node from, Node to) {
        edges.remove(new Pair<>(from, to));
        map.getOrDefault(from, new HashSet<>()).remove(to);
    }

    @Override
    public Map<Node, Set<Node>> getAdjacencyList() {
        return map;
    }

    @Override
    public void addEdge(Node from, Node to) {
        edges.add(new Pair<>(from, to));
        Set<Node> neighbours = map.getOrDefault(from, new HashSet<>());
        neighbours.add(to);
        map.put(from, neighbours);
    }
}
