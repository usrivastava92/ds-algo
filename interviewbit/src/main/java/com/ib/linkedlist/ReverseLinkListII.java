package com.ib.linkedlist;

public class ReverseLinkListII {

    public static void main(String... args) {
        ReverseLinkListII reverseLinkListII = new ReverseLinkListII();
        ListNode ln = LinkedListUtils.generateLinkedList(1, 2, 3);
        LinkedListUtils.printLinkedList(reverseLinkListII.reverseBetween(ln, 1, 2));
    }

    public ListNode reverseBetween(ListNode A, int B, int C) {
        ListNode prev = null;
        ListNode curr = A;
        int i = 0;
        while (i++ < B - 1) {
            prev = curr;
            curr = curr.next;
        }
        ListNode rev = reverseNnodes(C - B + 1, curr);
        if (prev == null) {
            return rev;
        }
        prev.next = rev;
        return A;
    }

    private ListNode reverseNnodes(int n, ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        int i = 0;
        ListNode start = curr;
        while (i++ < n && curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        start.next = curr;
        return prev;
    }

}
