package az.practice;

import java.util.*;
import java.util.stream.IntStream;

public class OrderOfAlienLanguageCharacters {

    public static void main(String[] args) {
        String[][] inputs = {{"baa", "abcd", "abca", "cab", "cad" }, {"caa", "aaa", "aab" }};
        char[][] outputs = {{'b', 'd', 'a', 'c'}, {'c', 'a', 'b'}};
        OrderOfAlienLanguageCharacters orderOfAlienLanguageCharacters = new OrderOfAlienLanguageCharacters();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(inputs[i]));
            System.out.println("Output : " + orderOfAlienLanguageCharacters.solve(inputs[i]));
            System.out.println("Expected : " + Arrays.toString(outputs[i]));
        });
    }

    public List<Character> solve(String[] words) {
        if (words == null || words.length == 0) {
            return Collections.emptyList();
        }
        DirectedGraph<Character> graph = new DirectedGraph<>();
        for (int i = 1; i < words.length; i++) {
            String word1 = words[i - 1];
            String word2 = words[i];
            for (int j = 0, len = Math.min(word1.length(), word2.length()); j < len; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    graph.addEdge(word1.charAt(j), word2.charAt(j));
                    break;
                }
            }
        }
        return graph.applyTopologicalSort();
    }

    private static class DirectedGraph<T> {

        private final Map<T, DirectedGraphNode<T>> map;

        DirectedGraph() {
            this.map = new HashMap<>();
        }

        public void addEdge(T from, T to) {
            DirectedGraphNode<T> fromNode = map.getOrDefault(from, new DirectedGraphNode<>(from));
            DirectedGraphNode<T> toNode = map.getOrDefault(to, new DirectedGraphNode<>(to));
            fromNode.addConnection(toNode);
            map.put(from, fromNode);
            map.put(to, toNode);
        }

        public List<T> applyTopologicalSort() {
            List<T> topoSort = new ArrayList<>();
            while (!map.isEmpty()) {
                DirectedGraphNode<T> nodeWithNoIncomingConnection = null;
                for (Map.Entry<T, DirectedGraphNode<T>> entry : map.entrySet()) {
                    if (entry.getValue().getIncomingConnections() == 0) {
                        nodeWithNoIncomingConnection = entry.getValue();
                        break;
                    }
                }
                if (nodeWithNoIncomingConnection != null) {
                    nodeWithNoIncomingConnection.delete();
                    topoSort.add(nodeWithNoIncomingConnection.getValue());
                    map.remove(nodeWithNoIncomingConnection.getValue());
                }else{
                    throw new RuntimeException("Graph is not a DAG, topological sort is not possible");
                }
            }
            return topoSort;
        }

        @Override
        public String toString() {
            return "DirectedGraph{" +
                    "map=" + map +
                    '}';
        }
    }

    private static class DirectedGraphNode<T> {

        private final T value;
        private final List<DirectedGraphNode<T>> connections;
        private int incomingConnections;

        public DirectedGraphNode(T character) {
            this.value = character;
            this.connections = new ArrayList<>();
            this.incomingConnections = 0;
        }

        public T getValue() {
            return value;
        }

        public int getIncomingConnections() {
            return Math.max(incomingConnections, 0);
        }

        public void addConnection(DirectedGraphNode<T> to) {
            connections.add(to);
            to.incomingConnections++;
        }

        public void delete() {
            for (DirectedGraphNode<T> connection : connections) {
                connection.incomingConnections--;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DirectedGraphNode<T> that = (DirectedGraphNode<T>) o;
            return value == that.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        @Override
        public String toString() {
            return "DirectedGraphNode{" +
                    "value=" + value +
                    ", incomingConnections=" + incomingConnections +
                    '}';
        }
    }

}
