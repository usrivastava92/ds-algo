package com.gfg.linkedlist;

import java.util.Arrays;

public class LinkedListUtils {

    public static Node generateList(int... nodes) {
        Node curr = new Node(nodes[0]);
        Node head = curr;
        for (int i = 1, size = nodes.length; i < size; i++) {
            curr.next = new Node(nodes[i]);
            curr = curr.next;
        }
        return head;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }

}
