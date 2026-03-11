package com.ib.linkedlist;

public class SwapListNodesInPairs {

    public ListNode swapPairs(ListNode A) {
        ListNode result = new ListNode(0);
        ListNode ans = result;
        ListNode curr = A;
        while (curr != null && curr.next != null) {
            ListNode second = curr.next;
            curr.next = curr.next.next;
            second.next = curr;
            result.next = second;
            result = result.next.next;
            curr = curr.next;
        }
        if (curr != null) {
            result.next = curr;
        }
        return ans.next;
    }

}
