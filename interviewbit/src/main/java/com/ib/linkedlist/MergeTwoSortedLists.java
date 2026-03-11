package com.ib.linkedlist;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode pointerA = A;
        ListNode pointerB = B;
        ListNode returnHead = new ListNode(-1);
        ListNode current = returnHead;
        while (pointerA != null && pointerB != null) {
            if (pointerA.val < pointerB.val) {
                current.next = pointerA;
                pointerA = pointerA.next;
            } else {
                current.next = pointerB;
                pointerB = pointerB.next;
            }
            current = current.next;
        }
        while (pointerA != null) {
            current.next = pointerA;
            pointerA = pointerA.next;
            current = current.next;
        }
        while (pointerB != null) {
            current.next = pointerB;
            pointerB = pointerB.next;
            current = current.next;
        }
        return returnHead.next;
    }


}
