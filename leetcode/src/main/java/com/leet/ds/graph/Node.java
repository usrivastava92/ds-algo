package com.leet.ds.graph;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
public class Node {

    public int val;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }

    public Node(int val, List<Node> neighbors) {
        this.val = val;
        if (neighbors == null) {
            this.neighbors = new ArrayList<>();
        }
        this.neighbors = neighbors;
    }

}
