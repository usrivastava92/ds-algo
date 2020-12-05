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

    public static void printLinkedList(ListNode ln) {
        if (ln != null) {
            System.out.print("\n" + ln.val);
            while (ln.next != null) {
                ln = ln.next;
                System.out.print(" -> " + ln.val);
            }
        }
    }


}