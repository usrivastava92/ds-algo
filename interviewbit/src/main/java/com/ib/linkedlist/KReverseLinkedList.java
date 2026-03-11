package com.ib.linkedlist;

public class KReverseLinkedList {

    public ListNode reverseList(ListNode A, int B) {
        if (A == null || A.next == null) {
            return A;
        }
        ListNode curr = A;
        ListNode prev = null;
        for (int i = 0; i < B; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        A.next = reverseList(curr, B);
        return prev;
    }


}
