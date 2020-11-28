package com.ib.heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ArrayList<ListNode> a) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });
        for (ListNode node : a) {
            while (node != null) {
                pq.add(node);
                node = node.next;
            }
        }
        ListNode head = pq.poll();
        ListNode curr = head;

        while (!pq.isEmpty()) {
            curr.next = pq.poll();
            curr = curr.next;
        }

        curr.next = null;

        return head;
    }
}

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}