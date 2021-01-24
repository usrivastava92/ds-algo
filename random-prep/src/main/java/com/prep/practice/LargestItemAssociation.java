package com.prep.practice;

import com.ds.graph.Edge;
import com.ds.utils.GraphUtils;
import org.junit.Assert;

import java.util.*;

public class LargestItemAssociation {

    public static void main(String[] args) {
        List<Edge<String>> input = Arrays.asList(new Edge<>("a", "b"), new Edge<>("c", "d"), new Edge<>("d", "e"),new Edge<>("c", "a"));
        List<String> outputs = Arrays.asList("c", "d", "e","a","b");
        LargestItemAssociation largestItemAssociation = new LargestItemAssociation();
        Assert.assertEquals(outputs, largestItemAssociation.largestItemAssociation(input));
    }

    public List<String> largestItemAssociation(List<Edge<String>> itemAssociation) {
        Map<String, String> parents = new HashMap<>();
        Map<String, Integer> ranks = new HashMap<>();
        itemAssociation.forEach(edge -> {
            String from = getFrom(edge);
            String to = getTo(edge);
            ranks.putIfAbsent(from, 1);
            ranks.putIfAbsent(to, 1);
            parents.putIfAbsent(from, from);
            parents.putIfAbsent(to, to);
            GraphUtils.union(parents, from, to, ranks);
        });
        System.out.println(parents);
        System.out.println(ranks);
        int max = 0;
        String maxParent = "";
        for (Map.Entry<String, String> entry : parents.entrySet()) {
            if (entry.getKey().equals(entry.getValue())) {
                if (ranks.get(entry.getKey()) > max) {
                    max = ranks.get(entry.getKey());
                    maxParent = entry.getKey();
                } else if (ranks.get(entry.getKey()) == max && entry.getKey().compareTo(maxParent) < 0) {
                    maxParent = entry.getKey();
                }
            }
        }
        List<String> ans = new ArrayList<>();
        String finalMaxParent = maxParent;
        parents.forEach((child, parent) -> {
            if (parent.equals(finalMaxParent)) {
                ans.add(child);
            }
        });
        return ans;
    }

    public String getFrom(Edge<String> edge) {
        if (edge.getFrom().compareTo(edge.getTo()) > 0) {
            return edge.getFrom();
        }
        return edge.getTo();
    }

    public String getTo(Edge<String> edge) {
        if (edge.getFrom().compareTo(edge.getTo()) > 0) {
            return edge.getTo();
        }
        return edge.getFrom();
    }

}
