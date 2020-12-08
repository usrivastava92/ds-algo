package com.ib.linkedlist;

import org.junit.Assert;


public class IntersectionOfLinkedLists {

    public static void main(String[] args) {
        ListNode common = LinkedListUtils.generateLinkedList(4, 5, 6);
        ListNode A = LinkedListUtils.generateLinkedList(1, 2, 3);
        LinkedListUtils.getLast(A).next = common;
        ListNode B = LinkedListUtils.generateLinkedList(5);
        LinkedListUtils.getLast(B).next = common;
        IntersectionOfLinkedLists intersectionOfLinkedLists = new IntersectionOfLinkedLists();
        System.out.println("A : ");
        LinkedListUtils.printLinkedList(A);
        System.out.println("B : ");
        LinkedListUtils.printLinkedList(B);
        Assert.assertEquals(common, intersectionOfLinkedLists.getIntersectionNode(A, B));
    }

    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return null;
        }
        int lenA = LinkedListUtils.lengthOf(a);
        int lenB = LinkedListUtils.lengthOf(b);
        if (lenB > lenA) {
            for (int i = 0, len = lenB - lenA; i < len; i++) {
                b = b.next;
            }
        } else {
            for (int i = 0, len = lenA - lenB; i < len; i++) {
                a = a.next;
            }
        }
        while (a != null && b != null && !a.equals(b)) {
            a = a.next;
            b = b.next;
        }
        return a;
    }

}
