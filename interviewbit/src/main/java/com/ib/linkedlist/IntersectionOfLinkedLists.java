package com.ib.linkedlist;

public class IntersectionOfLinkedLists {

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
