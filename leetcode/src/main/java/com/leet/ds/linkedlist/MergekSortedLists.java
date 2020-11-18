package com.leet.ds.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedLists {

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[]{LinkedListUtils.createList(1, 4, 5), LinkedListUtils.createList(1, 3, 4), LinkedListUtils.createList(2, 6)};
        MergekSortedLists mergekSortedLists = new MergekSortedLists();
        System.out.println(mergekSortedLists.mergeKLists(lists));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        for (ListNode node : lists) {
            minHeap.add(node);
        }

        ListNode head = minHeap.poll();
        ListNode node = head;
        if (node.next != null) {
            minHeap.add(node.next);
        }
        while (!minHeap.isEmpty()) {
            node.next = minHeap.poll();
            node = node.next;
            if (node.next != null) {
                minHeap.add(node.next);
            }
            node.next = null;
        }
        if (node != null) {
            node.next = null;
        }
        return head;
    }
}
