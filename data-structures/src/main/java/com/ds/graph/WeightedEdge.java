package com.ds.graph;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class WeightedEdge<Node, Weight extends Comparable<Weight>> extends Edge<Node> implements Comparable<WeightedEdge<Node, Weight>> {

    private final Weight weight;

    public WeightedEdge(Node from, Node to, Weight weight) {
        super(from, to);
        this.weight = weight;
    }

    @Override
    public int compareTo(WeightedEdge<Node, Weight> o) {
        return this.weight.compareTo(o.getWeight());
    }

}
