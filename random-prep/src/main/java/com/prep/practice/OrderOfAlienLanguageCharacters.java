package com.prep.practice;

import com.ds.graph.DirectedUnweightedGraph;
import com.ds.utils.GraphUtils;
import com.ds.utils.ArrayUtils;
import org.junit.Assert;

import java.util.*;
import java.util.stream.IntStream;

public class OrderOfAlienLanguageCharacters {

    public static void main(String[] args) {
        String[][] inputs = {{"baa", "abcd", "abca", "cab", "cad"}, {"caa", "aaa", "aab"}};
        char[][] outputs = {{'b', 'd', 'a', 'c'}, {'c', 'a', 'b'}};
        OrderOfAlienLanguageCharacters orderOfAlienLanguageCharacters = new OrderOfAlienLanguageCharacters();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(inputs[i]));
            List<Character> output = orderOfAlienLanguageCharacters.solve(inputs[i]);
            System.out.println("Output : " + output);
            Assert.assertEquals(ArrayUtils.deepAsList(outputs[i]), output);
        });
    }

    public List<Character> solve(String[] words) {
        if (words == null || words.length == 0) {
            return Collections.emptyList();
        }
        DirectedUnweightedGraph<Character> graph = new DirectedUnweightedGraph<>();
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
        return GraphUtils.applyTopologicalSort(graph);
    }

}
