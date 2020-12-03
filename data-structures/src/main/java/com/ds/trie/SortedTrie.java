package com.ds.trie;

import java.util.*;

public class SortedTrie<T extends Comparable<T>> extends Trie<T> {

    public SortedTrie() {
        super(new TreeMap<>());
    }

    private SortedTrie(T data) {
        super(data, new TreeMap<>());
    }

    @Override
    public void add(T[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        Trie<T> curr = this;
        for (int i = 0; i < arr.length; i++) {
            T element = arr[i];
            if (!curr.map.containsKey(element)) {
                curr.map.put(element, new SortedTrie<>(element));
            }
            curr = curr.map.get(element);
            if (i == arr.length - 1) {
                curr.isLeaf = true;
            }
        }
    }

}
