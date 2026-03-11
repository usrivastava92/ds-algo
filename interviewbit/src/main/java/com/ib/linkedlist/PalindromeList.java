package com.ib.linkedlist;

public class PalindromeList {

    public int lPalin(ListNode A) {
        if (A == null || A.next == null) {
            return 1;
        }
        int len = LinkedListUtils.lengthOf(A);
        ListNode curr = A;
        for (int i = 0, half = (len / 2) - 1; i < half; i++) {
            curr = curr.next;
        }
        ListNode revSecondHalf = null;
        if (len % 2 == 0) {
            revSecondHalf = LinkedListUtils.reverse(curr.next);
        } else {
            revSecondHalf = LinkedListUtils.reverse(curr.next.next);
        }
        curr.next = null;
        curr = A;
        while (curr != null && revSecondHalf != null && curr.val == revSecondHalf.val) {
            curr = curr.next;
            revSecondHalf = revSecondHalf.next;
        }
        return curr == null && revSecondHalf == null ? 1 : 0;
    }

}
