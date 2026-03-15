package com.gfg.linkedlist;

public class ReorderList {

    Node reorderList(Node head) {
        if (head == null) {
            return null;
        }
        Node front = head;
        Node last = reverseList(copyList(head));
        int size = listSize(head);
        int i = size / 2;
        Node prev = null;
        while (i-- > 0) {
            Node temp = front.next;
            front.next = new Node(last.data);
            front = front.next;
            front.next = temp;
            prev = front;
            front = front.next;
            last = last.next;
        }
        if (size % 2 == 0) {
            prev.next = null;
        } else {
            front.next = null;
        }
        return head;
    }

    private int listSize(Node head) {
        Node curr = head;
        int i = 0;
        while (curr != null) {
            curr = curr.next;
            i++;
        }
        return i;
    }

    private Node copyList(Node head) {
        Node curr = new Node(head.data);
        Node newHead = curr;
        while (curr != null && head.next != null) {
            curr.next = new Node(head.next.data);
            head = head.next;
            curr = curr.next;
        }
        return newHead;
    }

    private Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
