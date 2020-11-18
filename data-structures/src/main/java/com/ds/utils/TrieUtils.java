package com.ds.utils;

import com.ds.trie.TrieNode;

import java.util.Map;

public class TrieUtils {

    private TrieUtils() {

    }

    public static <T> TrieNode<T> createTrie(T[] args) {
        return createTrie(args, 0, args.length);
    }

    public static <T> TrieNode<T> createTrie(T[] args, int startIndex, int endIndex) {
        TrieNode<T> head = new TrieNode<>(args[startIndex]);
        TrieNode<T> prev = head;
        for (int i = startIndex + 1; i < endIndex; i++) {
            T curr = args[i];
            TrieNode<T> temp = new TrieNode<>(curr);
            prev.map.put(curr, temp);
            prev = temp;
            prev.isLeaf = i == (endIndex - 1);
        }
        return head;
    }

    public static <T> void printTrie(TrieNode<T> trieNode) {
        TrieNode<T> curr = trieNode;
        while (!curr.map.isEmpty()) {
            System.out.print(curr.data + " ");
            for (Map.Entry<T, TrieNode<T>> entry : curr.map.entrySet()) {
                curr = curr.map.get(entry.getKey());
            }
        }
        System.out.print(curr.data + " ");
    }


    public static <T> void addPathToTrie(TrieNode<T> trieNode, T[] arr) {
        T t = arr[0];
        TrieNode<T> curr = trieNode.map.get(t);
        if (curr == null) {
            trieNode.map.put(t, createTrie(arr));
        } else {
            int i = 1;
            int size = arr.length;
            while (i < size && curr.map.containsKey(arr[i])) {
                curr = curr.map.get(arr[i]);
                if (i == (size - 1)) {
                    curr.isLeaf = true;
                }
                i++;
            }
            if (i < size) {
                curr.map.put(arr[i], createTrie(arr, i, size));
            }
        }
    }

    public static <T> void display(TrieNode<T> root, String str) {
        if (root.isLeaf) {
            System.out.println(str);
        }
        for (Map.Entry<T, TrieNode<T>> entry : root.map.entrySet()) {
            display(entry.getValue(), str + entry.getValue().data);
        }
    }

}
