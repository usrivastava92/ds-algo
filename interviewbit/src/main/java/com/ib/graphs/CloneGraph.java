package com.ib.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return cloneGraph(node, new HashMap<>());
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(clone.label, clone);
        node.neighbors.forEach(neighbour -> {
            if (map.containsKey(neighbour.label)) {
                clone.neighbors.add(map.get(neighbour.label));
            } else {
                clone.neighbors.add(cloneGraph(neighbour, map));
            }
        });
        return clone;
    }

}

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }
};
