package com.ib.linkedlist;

public class RemoveDuplicatesfromSortedList {

    public static void main(String... args) {
        RemoveDuplicatesfromSortedList removeDuplicatesfromSortedList = new RemoveDuplicatesfromSortedList();
        removeDuplicatesfromSortedList.deleteDuplicates(new ListNode(1));
    }

    public ListNode deleteDuplicates(ListNode A) {
        ListNode current = A;
        while (current != null) {
            if (current.next != null && current.next.val == current.val) {
                current.next = current.next.next;
            }
            current = current.next;
        }
        return A;
    }

}