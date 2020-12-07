package com.ib.linkedlist;

public class MergeTwoSortedLists {

    public static void main(String... args) {
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode m1 = LinkedListUtils.generateLinkedList(2, 4, 7, 9);
        ListNode l1 = LinkedListUtils.generateLinkedList(1, 4, 6, 8);
        LinkedListUtils.printLinkedList(m1);
        ListNode node = mergeTwoSortedLists.mergeTwoLists(l1, m1);
    }

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

