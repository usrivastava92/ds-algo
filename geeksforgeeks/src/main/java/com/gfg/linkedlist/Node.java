package com.gfg.linkedlist;

public class Node {

    public int data;
    public Node next;

    Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "" + data;
    }
}
