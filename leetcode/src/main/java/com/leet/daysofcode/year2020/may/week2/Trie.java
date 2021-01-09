package com.leet.daysofcode.year2020.may.week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ImplementTrie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));  // returns true
        System.out.println(trie.search("app"));    // returns false
        System.out.println(trie.startsWith("app"));      // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }

}

public class Trie {

    private Map<Character, Trie> map;
    private boolean isEndOfWord;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        map = new HashMap<>();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Trie currTrie = this;
        for (Character ch : word.toCharArray()) {
            if (currTrie.map.containsKey(ch)) {
                currTrie = currTrie.map.get(ch);
            } else {
                currTrie.map.put(ch, new Trie());
                currTrie = currTrie.map.get(ch);
            }
        }
        currTrie.isEndOfWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie currTrie = this;
        for (Character ch : word.toCharArray()) {
            if (!currTrie.map.containsKey(ch)) {
                return false;
            } else {
                currTrie = currTrie.map.get(ch);
            }
        }
        return currTrie.isEndOfWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie currTrie = this;
        for (Character ch : prefix.toCharArray()) {
            if (!currTrie.map.containsKey(ch)) {
                return false;
            } else {
                currTrie = currTrie.map.get(ch);
            }
        }
        return currTrie.isEndOfWord || !currTrie.map.isEmpty();
    }

    public List<String> getWordsWithPrefix(String prefix) {
        List<String> words = new ArrayList<>();
        Trie currTrie = this;
        StringBuilder sb = new StringBuilder();
        for (Character ch : prefix.toCharArray()) {
            if (!currTrie.map.containsKey(ch)) {
                return words;
            } else {
                sb.append(ch);
                currTrie = currTrie.map.get(ch);
            }
        }
        getWordsWithPrefixHelper(words, currTrie, sb);
        return words;
    }

    private void getWordsWithPrefixHelper(List<String> words, Trie trie, StringBuilder sb) {
        if (trie.isEndOfWord) {
            words.add(sb.toString());
        }
        for (Map.Entry<Character, Trie> entry : trie.map.entrySet()) {
            sb.append(entry.getKey());
            getWordsWithPrefixHelper(words, entry.getValue(), sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    @Override
    public String toString() {
        return "Trie{" +
                "map=" + map.keySet() +
                ", isEndOfWord=" + isEndOfWord +
                '}';
    }

}