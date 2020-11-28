package com.app;

import java.util.*;

public class LengthPaths {
    public static void main(String... args) {
        int[][] A = new int[][]{
                new int[]{4, 1},
                new int[]{9, 7},
                new int[]{3, 5},
                new int[]{6, 9},
                new int[]{8, 9},
                new int[]{1, 8},
                new int[]{9, 3},
                new int[]{2, 9}
        };

        Map<Integer, Node> nodeCollection = new HashMap<>();
        int len = A.length;
        int distinctColor = 0;
        for (int i = 0; i < len; i++) {
            int from = A[i][0];
            int to = A[i][1];
            Node toNode = null;
            Node fromNode = null;
            if (nodeCollection.containsKey(from)) {
                fromNode = nodeCollection.get(from);
            } else {
                fromNode = new Node(from);
            }
            if (nodeCollection.containsKey(to)) {
                toNode = nodeCollection.get(to);
            } else {
                toNode = new Node(to);
            }
            fromNode.addChild(toNode);
            toNode.addParent(fromNode);
            nodeCollection.put(to, toNode);
            nodeCollection.put(from, fromNode);
        }

        for (Map.Entry<Integer, Node> n : nodeCollection.entrySet()) {
            System.out.println(n.getKey());
        }
        System.out.println("##############");
        System.out.println(nodeCollection.get(4));
        System.out.println(nodeCollection.get(9).parents);
        System.out.println("##############");
        levelOrderTraverse(nodeCollection.get(A[0][0]));
        System.out.println("##############");
        int res = iterateLevels(nodeCollection.get(A[0][0]), 1);
        System.out.println("##############");
        System.out.println(res);
    }

    public static int iterateLevels(Node node, int level) {
        int distColor = 1;
        node.visited = true;
        if (level <= 4) {
            for (Node parent : node.getParents()) {
                if (!parent.visited) {
                    parent.visited = true;
                    distColor++;
                }
            }
        }
        if (level <= 3) {
            for (Node child : node.getChildrens()) {
                distColor += iterateLevels(child, level + 1);
            }
        }
        return distColor;
    }


    public static void levelOrderTraverse(Node node) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.addLast(node);
        while (!queue.isEmpty()) {
            Node n = queue.removeFirst();
            System.out.println(n.data);
            for (Node child : n.getChildrens()) {
                queue.addLast(child);
            }
        }
    }


}

class Node {

    int data;
    boolean visited;
    List<Node> children = new ArrayList<>();
    List<Node> parents = new ArrayList<>();

    public Node(int data) {
        this.data = data;
    }

    public void addChild(Node node) {
        children.add(node);
    }



    public void addParent(Node node) {
        this.parents.add(node);
    }

    public List<Node> getParents() {
        return parents;
    }

    public List<Node> getChildrens() {
        return children;
    }

    @Override
    public int hashCode() {
        return data;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Node)) {
            return false;
        }
        Node n = (Node) obj;
        return n.data == this.data;
    }

    @Override
    public String toString() {
        return "Node{data:" + data + ", childs: " + children + "}";
    }
}
