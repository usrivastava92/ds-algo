package com.ib.linkedlist;

public class LinkedListUtils {

    public static ListNode generateLinkedList(Integer... arr) {
        ListNode l1 = new ListNode(arr[0]);
        ListNode prev = l1;
        for (int i = 1; i < arr.length; i++) {
            ListNode current = new ListNode(arr[i]);
            prev.next = current;
            prev = current;
        }
        return l1;
    }

    public static void printLinkedList(ListNode node) {
        if (node != null) {
            System.out.print(node.val);
            while (node.next != null) {
                node = node.next;
                System.out.print(" -> " + node.val);
            }
        }
        System.out.println();
    }

    public static String toString(ListNode node) {
        StringBuilder stringBuilder = new StringBuilder();
        if (node != null) {
            stringBuilder.append(node.val);
            while (node.next != null) {
                node = node.next;
                stringBuilder.append(" -> ").append(node.val);
            }
        }
        return stringBuilder.toString();
    }

    public static ListNode getLast(ListNode node) {
        ListNode last = node;
        while (node != null) {
            last = node;
            node = node.next;
        }
        return last;
    }

    public static ListNode reverse(ListNode node) {
        ListNode prev = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

    public static int lengthOf(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }

}