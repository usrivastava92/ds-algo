package com.ib.linkedlist;

public class SortBinaryLinkedList {

    public ListNode solve(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }
        int zeros = 0;
        ListNode curr = A;
        while (curr != null) {
            if (curr.val == 0) {
                zeros++;
            }
            curr = curr.next;
        }
        curr = A;
        while (zeros-- > 0) {
            curr.val = 0;
            curr = curr.next;
        }
        while (curr != null) {
            curr.val = 1;
            curr = curr.next;
        }
        return A;
    }

}
