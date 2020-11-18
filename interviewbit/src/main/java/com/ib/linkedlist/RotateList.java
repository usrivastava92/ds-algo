package com.ib.linkedlist;

public class RotateList {


    public static void main(String... args) {

        RotateList rotateList = new RotateList();
        ListNode l1 = LinkedListUtils.generateLinkedList(91, 34, 18, 83, 38, 82, 21, 69);
        LinkedListUtils.printLinkedList(rotateList.rotateRight(l1, 89));

    }

    public ListNode rotateRight(ListNode A, int B) {
        int len = 0;
        ListNode first = A;
        ListNode current = A;
        ListNode last = null;
        while (current != null) {
            len++;
            last = current;
            current = current.next;
        }
        if (len == 1) {
            return A;
        }
        if (B >= len) {
            current = A;
            for (int i = 0; i < len - 2; i++) {
                current = current.next;
            }
            current.next = null;
            last.next = first;
            return last;
        }
        ListNode returnNode = null;
        current = A;
        for (int i = 0; i < len - B - 1; i++) {
            current = current.next;
        }
        returnNode = current.next;
        current.next = null;
        last.next = first;
        return returnNode;
    }


}
