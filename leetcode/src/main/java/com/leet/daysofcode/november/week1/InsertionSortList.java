package com.leet.daysofcode.november.week1;

import com.leet.ds.linkedlist.LinkedListUtils;
import com.leet.ds.linkedlist.ListNode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class InsertionSortList {

    public static void main(String[] args) {
        int[][] inputs = {{4, 2, 1, 3}, {-1, 5, 3, 4, 0}, {}};
        int[][] output = {{1, 2, 3, 4}, {-1, 0, 3, 4, 5}, {}};
        InsertionSortList insertionSortList = new InsertionSortList();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(inputs[i]));
            System.out.println("Output : " + LinkedListUtils.getTraversalAsList(insertionSortList.insertionSortList(LinkedListUtils.createList(inputs[i]))));
            System.out.println("Expected : " + Arrays.toString(output[i]));
        });
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode ret = head;
        ListNode curr = head.next;
        head.next = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = null;
            ret = insertAtRightPlace(ret, curr);
            curr = temp;
        }
        return ret;
    }

    public ListNode insertAtRightPlace(ListNode head, ListNode node) {
        if (head == node) {
            return head;
        }
        if (node == null) {
            return head;
        }
        if (head == null) {
            return node;
        }
        if (node.val < head.val) {
            node.next = head;
            return node;
        }
        ListNode ret = head;
        while (head.next != null && head.next.val < node.val) {
            head = head.next;
        }
        ListNode temp = head.next;
        head.next = node;
        node.next = temp;
        return ret;
    }

}
