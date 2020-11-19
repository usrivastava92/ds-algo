package com.ds.graph;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class UndirectedWeightedGraph<Node, Weight extends Comparable<Weight>> implements IWeightedGraph<Node, Weight>, IUndirectedGraph<Node> {

    private final Map<Node, Map<Node, Weight>> map;
    private final Set<Pair<Node, Node>> edges;

    public UndirectedWeightedGraph() {
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
    public void addEdge(Node from, Node to, Weight weight) {
        edges.add(new Pair<>(from, to));
        Map<Node, Weight> neighbours1 = map.getOrDefault(from, new HashMap<>());
        Map<Node, Weight> neighbours2 = map.getOrDefault(to, new HashMap<>());
        neighbours1.put(to, weight);
        neighbours2.put(from, weight);
        map.put(from, neighbours1);
        map.put(to, neighbours2);
    }

    @Override
    public Map<Node, Weight> getNeighboursWithWeights(Node node) {
        return map.getOrDefault(node, Collections.emptyMap());
    }

    @Override
    public Set<Pair<Node, Pair<Node, Weight>>> getAllEdgesWithWeights() {
        return edges.stream().map(edge -> new Pair<>(edge.getKey(), new Pair<>(edge.getValue(), getEdgeWeight(edge.getKey(), edge.getValue())))).collect(Collectors.toSet());
    }

    @Override
    public Set<Pair<Node, Node>> getAllEdges() {
        return edges;
    }

    @Override
    public void deleteEdge(Node from, Node to) {
        edges.remove(new Pair<>(from, to));
        map.getOrDefault(from, Collections.emptyMap()).remove(to);
        map.getOrDefault(to, Collections.emptyMap()).remove(from);
    }

    @Override
    public Weight getEdgeWeight(Node from, Node to) {
        return map.getOrDefault(from, Collections.emptyMap()).get(to);
    }

    @Override
    public String toString() {
        return "UndirectedWeightedGraph{" +
                "map=" + map +
                '}';
    }

}
