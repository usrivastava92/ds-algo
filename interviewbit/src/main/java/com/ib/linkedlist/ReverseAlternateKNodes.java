package com.ib.linkedlist;

public class ReverseAlternateKNodes {

    public ListNode solve(ListNode A, int B) {
        return solve(A, B, true);
    }

    public ListNode solve(ListNode A, int B, boolean reverse) {
        if (A == null || A.next == null) {
            return A;
        }
        ListNode head = null;
        if (reverse) {
            ListNode curr = A;
            ListNode prev = null;
            for (int i = 0; i < B; i++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            A.next = solve(curr, B, !reverse);
            head = prev;
        } else {
            head = A;
            ListNode curr = A;
            for (int i = 0; i < B - 1; i++) {
                curr = curr.next;
            }
            curr.next = solve(curr.next, B, !reverse);
        }
        return head;
    }

}
