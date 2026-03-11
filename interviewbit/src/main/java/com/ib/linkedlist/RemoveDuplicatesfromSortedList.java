package com.ib.linkedlist;

public class RemoveDuplicatesfromSortedList {

    public ListNode deleteDuplicates(ListNode A) {
        ListNode current = A;
        while (current != null) {
            if (current.next != null && current.next.val == current.val) {
                current.next = current.next.next;
                continue;
            }
            current = current.next;
        }
        return A;
    }

}
