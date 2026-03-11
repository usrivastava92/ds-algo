package com.ib.linkedlist;

public class EvenReverse {

    public ListNode solve(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }
        ListNode evenNodesHead = new ListNode(-1);
        ListNode evenNodesCurr = evenNodesHead;
        ListNode curr = A;
        while (curr != null) {
            ListNode next = curr.next;
            evenNodesCurr.next = next;
            if (next != null) {
                ListNode nextNext = curr.next.next;
                evenNodesCurr.next.next = null;
                curr.next = nextNext;
            }
            evenNodesCurr = evenNodesCurr.next;
            curr = curr.next;
        }
        curr = A;
        evenNodesHead = LinkedListUtils.reverse(evenNodesHead.next);
        evenNodesCurr = evenNodesHead;
        while (evenNodesCurr != null && curr != null) {
            ListNode next = curr.next;
            curr.next = evenNodesCurr;
            evenNodesCurr = evenNodesCurr.next;
            curr.next.next = next;
            curr = curr.next.next;
        }
        return A;
    }

}
