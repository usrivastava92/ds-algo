package com.leet.ds.linkedlist;

public class RemoveLinkedListElements {

    public static void main(String[] args) {
        ListNode head = LinkedListUtils.createList(6, 6, 1, 2, 6, 3, 4, 5, 6);
        int val = 6;
        RemoveLinkedListElements removeLinkedListElements = new RemoveLinkedListElements();
        System.out.println(removeLinkedListElements.removeElements(head, val));
    }


    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode returnNode = head;
        ListNode prev = head;
        if (head != null) {
            head = head.next;
        }
        while (head != null) {
            if (head.val != val) {
                prev.next = head;
                prev = prev.next;
            }
            head = head.next;
        }
        if (prev != null) {
            prev.next = null;
        }
        return returnNode;
    }

}
