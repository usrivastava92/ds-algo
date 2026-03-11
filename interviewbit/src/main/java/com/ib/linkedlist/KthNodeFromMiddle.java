package com.ib.linkedlist;

public class KthNodeFromMiddle {

    public int solve(ListNode A, int B) {
        if (A.next == null) {
            if (B > 0) {
                return -1;
            }
            return A.val;
        }
        ListNode slow = A;
        ListNode prev = null;
        ListNode fast = A;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        if (B == 0) {
            return slow.val;
        }
        for (int i = 1; i < B && prev != null; i++) {
            prev = prev.next;
        }
        return prev == null ? -1 : prev.val;
    }

}
