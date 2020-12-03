package com.ds.trie;

import java.util.*;

public class Trie<T> {

    protected T data;
    protected final Map<T, Trie<T>> map;
    protected boolean isLeaf;

    public Trie() {
        this.map = new HashMap<>();
    }

    protected Trie(Map<T, Trie<T>> map) {
        this.map = map;
    }

    protected Trie(T data, Map<T, Trie<T>> map) {
        this.data = data;
        this.map = map;
    }

    protected Trie(T data) {
        this.data = data;
        this.map = new HashMap<>();
    }

    public void add(T[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        Trie<T> curr = this;
        for (int i = 0; i < arr.length; i++) {
            T element = arr[i];
            if (!curr.map.containsKey(element)) {
                curr.map.put(element, new Trie<>(element));
            }
            curr = curr.map.get(element);
            if (i == arr.length - 1) {
                curr.isLeaf = true;
            }
        }
    }

    public List<String> get(T[] prefix, int limit) {
        Trie<T> curr = this;
        StringBuilder sb = new StringBuilder();
        for (T ch : prefix) {
            if (!curr.map.containsKey(ch)) {
                return Collections.emptyList();
            } else {
                curr = curr.map.get(ch);
            }
            sb.append(ch);
        }
        List<String> ans = new ArrayList<>();
        get(curr, sb.toString(), ans, limit);
        return ans;
    }

    public List<String> get(T[] prefix) {
        Trie<T> curr = this;
        StringBuilder sb = new StringBuilder();
        for (T ch : prefix) {
            if (!curr.map.containsKey(ch)) {
                return Collections.emptyList();
            } else {
                curr = curr.map.get(ch);
            }
            sb.append(ch);
        }
        List<String> ans = new ArrayList<>();
        getAll(curr, sb.toString(), ans);
        return ans;
    }

    public List<String> getAll() {
        List<String> ans = new ArrayList<>();
        getAll(this, "", ans);
        return ans;
    }

    private void getAll(Trie<T> trie, String path, List<String> arr) {
        if (trie.isLeaf) {
            arr.add(path);
        }
        trie.map.forEach((key, value) -> getAll(value, path + value.data.toString(), arr));
    }

    private void get(Trie<T> trie, String path, List<String> arr, final int limit) {
        if (trie.isLeaf) {
            if (arr.size() >= limit) {
                return;
            }
            arr.add(path);
        }
        trie.map.forEach((key, value) -> get(value, path + value.data.toString(), arr, limit));
    }

}

