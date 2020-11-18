package com.leet.daysofcode.april.week4;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheMain {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* capacity */);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}


class LRUCache {

    private Node start = null;
    private Node end = null;
    private final int capacity;
    private final Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int val = evict(key);
            put(key, val);
            return val;
        }
        return -1;
    }

    private int evict(int key) {
        Node node = map.get(key);
        map.remove(key);
        if (start == node && end == node) {
            start = null;
            end = null;
        } else if (start == node) {
            start = start.next;
        } else if (end == node) {
            end = end.prev;
        } else {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
        }
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = new Node(key, value);
        if (start == null) {
            end = node;
        } else if (map.containsKey(key)) {
            evict(key);
        } else if (map.size() >= capacity) {
            evict(end.key);
        }
        addInBeginning(key, node);
    }

    private void addInBeginning(int key, Node node) {
        node.next = start;
        if (start != null) {
            start.prev = node;
        }
        start = node;
        map.put(key, node);
    }
}


class Node {
    int key;
    int val;
    Node next;
    Node prev;

    Node(int key, int val) {
        this.val = val;
        this.key = key;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", val=" + val +
                '}';
    }
}