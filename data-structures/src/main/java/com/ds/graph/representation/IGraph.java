package com.ds.graph.representation;

import java.util.Set;

public interface IGraph<Node> {

    Set<Node> getNeighbours(Node node);
    Set<Node> getAllNodes();

}
