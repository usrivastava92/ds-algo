package com.leet.daysofcode.year2020.june.week1;

import com.leet.ds.linkedlist.LinkedListUtils;
import com.leet.ds.linkedlist.ListNode;

public class DeleteNodeInALinkedList {

    public static void main(String[] args) {
        ListNode[] inputs = {LinkedListUtils.createList(1, 2, 3, 4, 5, 6, 7, 8, 9)};
        DeleteNodeInALinkedList deleteNodeInALinkedList = new DeleteNodeInALinkedList();
        for (int i = 0; i < inputs.length; i++) {
            System.out.println("Input : " + inputs[i]);
            deleteNodeInALinkedList.deleteNode(inputs[i]);
            System.out.println("Output : " + inputs[i]);
            System.out.println("#####################################");
        }
    }

    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }
        ListNode prev = null;
        while (node.next != null) {
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }
        if (prev != null) {
            prev.next = null;
        }
    }
}
