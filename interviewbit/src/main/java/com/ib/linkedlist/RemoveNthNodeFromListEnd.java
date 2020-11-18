package com.ib.linkedlist;

public class RemoveNthNodeFromListEnd {

    public static void main(String... args) {
        RemoveNthNodeFromListEnd removeNthNodeFromListEnd = new RemoveNthNodeFromListEnd();

        ListNode l1 = LinkedListUtils.generateLinkedList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        ListNode re = removeNthNodeFromListEnd.removeNthFromEnd(l1, 9);

        LinkedListUtils.printLinkedList(re);


    }

    public ListNode removeNthFromEnd(ListNode A, int B) {
        ListNode returnNode = A;
        int len = 0;
        ListNode current = A;
        while (current != null) {
            len++;
            current = current.next;
        }
        if (len < B) {
            return A.next;
        }
        int elementFromLast = len;
        current = A;
        ListNode past = null;
        while (elementFromLast > B + 1) {
            current = current.next;
            elementFromLast--;
        }
        if (current.next != null) {
            past = current;
            current.next = current.next.next;
        } else {
            if (past == null) {
                return past;
            }
            past.next = null;
        }
        return returnNode;
    }
}
