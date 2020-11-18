package com.ib.tree;

import java.util.ArrayList;
import java.util.Arrays;

public class ShortestUniquePrefix {

    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<>(Arrays.asList("zebra", "dog", "duck", "dove"));
        ShortestUniquePrefix shortestUniquePrefix = new ShortestUniquePrefix();
        System.out.println(shortestUniquePrefix.prefix(input));
    }

    public ArrayList<String> prefix(ArrayList<String> A) {
        TrieNode trieNode = new TrieNode(' ');
        for (String s : A) {
            TrieUtils.addString(s, trieNode);
        }
        ArrayList<String> ans = new ArrayList<>();
        for (String s : A) {
            ans.add(TrieUtils.getUniquePrefix(trieNode, s));
        }
        return ans;
    }

}
