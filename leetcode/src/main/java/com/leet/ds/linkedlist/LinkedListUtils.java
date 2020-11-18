package com.leet.ds.linkedlist;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkedListUtils {

    public static ListNode get(ListNode head, int index) {
        if (index >= size(head)) {
            throw new IllegalArgumentException("Invalid index : " + index);
        }
        int i = 0;
        while (head != null) {
            if (i == index) {
                return head;
            }
            head = head.next;
            i++;
        }
        return null;
    }

    public static int size(ListNode head) {
        int size = 0;
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return size;
            }
            set.add(head);
            size++;
            head = head.next;
        }
        return size;
    }

    public static ListNode createCyclicList(int cycleIndex, int... arr) {
        ListNode head = createList(arr);
        if (cycleIndex > -1) {
            ListNode cycleIndexNode = null;
            ListNode last = null;
            ListNode current = head;
            int i = 0;
            while (current != null) {
                if (i == cycleIndex) {
                    cycleIndexNode = current;
                }
                if (current.next == null) {
                    last = current;
                }
                current = current.next;
                i++;
            }
            last.next = cycleIndexNode;
        }
        return head;
    }

    public static ListNode createList(int... arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        for (int i = 1, len = arr.length; i < len; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        return head;
    }


    public static String getTraversal(ListNode node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val);
            if (node.next != null) {
                sb.append(" -> ");
            }
            node = node.next;
        }
        return sb.toString();
    }

    public static int[] getTraversalAsArray(ListNode node) {
        return getTraversalAsList(node).stream().mapToInt(i -> i).toArray();
    }

    public static List<Integer> getTraversalAsList(ListNode node) {
        List<Integer> traversal = new ArrayList<>();
        while (node != null) {
            traversal.add(node.val);
            node = node.next;
        }
        return traversal;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

}
