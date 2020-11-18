package com.ib.tree;

import java.util.HashMap;
import java.util.Map;

public class TrieUtils {

    public static boolean isLeafNode(TrieNode root) {
        return root != null && root.map.isEmpty();
    }

    public static boolean searchString(String pattern, TrieNode root) {
        if (pattern.isEmpty()) {
            return false;
        }
        TrieNode curr = root;
        for (char ch : pattern.toCharArray()) {
            if (curr.map.containsKey(ch)) {
                curr = curr.map.get(ch);
            } else {
                return false;
            }
        }
        return curr.endOfWord;
    }

    public static void printTrie(TrieNode node) {
        printTrieHelper(node, "");
    }

    private static void printTrieHelper(TrieNode node, String s) {
        s += node.ch;
        if (node.endOfWord) {
            System.out.println(s);
        }
        for (Map.Entry<Character, TrieNode> entry : node.map.entrySet()) {
            printTrieHelper(entry.getValue(), s);
        }
    }

    public static void addString(String s, TrieNode root) {
        TrieNode curr = root;
        for (char ch : s.toCharArray()) {
            if (curr.map.containsKey(ch)) {
                curr = curr.map.get(ch);
            } else {
                TrieNode node = new TrieNode(ch);
                curr.map.put(ch, node);
                curr = node;
            }
        }
        curr.endOfWord = true;
    }

    public static String getUniquePrefix(TrieNode root, String input) {
        TrieNode curr = root;
        String ans = "";
        String traversal = "";
        for (char ch : input.toCharArray()) {
            traversal += ch;
            if (curr.map.size() > 1) {
                ans = traversal;
            }
            curr = curr.map.get(ch);
        }
        return ans;
    }
}

class TrieNode {
    Character ch;
    Map<Character, TrieNode> map;
    boolean endOfWord = false;

    TrieNode(char ch) {
        this.ch = ch;
        this.map = new HashMap<>();
    }

    @Override
    public String toString() {
        return "TrieNode{" +
                "ch=" + ch +
                ", endOfWord=" + endOfWord +
                '}';
    }
}