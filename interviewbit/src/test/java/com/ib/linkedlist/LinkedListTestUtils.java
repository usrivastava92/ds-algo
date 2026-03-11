package com.ib.linkedlist;

final class LinkedListTestUtils {

    private LinkedListTestUtils() {
    }

    static ListNode list(Integer... values) {
        if (values == null || values.length == 0) {
            return null;
        }
        return LinkedListUtils.generateLinkedList(values);
    }

    static String asString(ListNode node) {
        return LinkedListUtils.toString(node);
    }
}
