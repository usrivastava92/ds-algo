package com.leet.daysofcode.october.week2;

import com.leet.ds.linkedlist.LinkedListUtils;
import com.leet.ds.linkedlist.ListNode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SortList {

    public static void main(String[] args) {
        ListNode[] inputs = {LinkedListUtils.createList(4, 2, 1, 3), LinkedListUtils.createList(-1, 5, 3, 4, 0), null};
        int[][] outputs = {{1, 2, 3, 4}, {-1, 0, 3, 4, 5}, {}};
        SortList sortList = new SortList();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("input : " + LinkedListUtils.getTraversalAsList(inputs[i]));
            System.out.println("output : " + LinkedListUtils.getTraversalAsList(sortList.sortList(inputs[i])));
            System.out.println("expected : " + Arrays.toString(outputs[i]));
        });
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode midNode = midNode(head);
        ListNode firstHalfHead = head;
        ListNode secondHalfHead = midNode.next;
        midNode.next = null;

        ListNode sortedFirstHalf = sortList(firstHalfHead);
        ListNode sortedSecondHalf = sortList(secondHalfHead);
        return merge(sortedFirstHalf, sortedSecondHalf);
    }

    private ListNode midNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (fastNode != null && fastNode.next != null && fastNode.next.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return slowNode;
    }

    private ListNode merge(ListNode sortedList1, ListNode sortedList2) {
        if (sortedList1 == null && sortedList2 == null) {
            return null;
        }
        if (sortedList1 == null || sortedList2 == null) {
            return sortedList1 != null ? sortedList1 : sortedList2;
        }
        // dummy head
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        while (sortedList1 != null && sortedList2 != null) {
            if (sortedList1.val < sortedList2.val) {
                curr.next = sortedList1;
                sortedList1 = sortedList1.next;
            } else {
                curr.next = sortedList2;
                sortedList2 = sortedList2.next;
            }
            curr = curr.next;
        }
        while (sortedList1 != null) {
            curr.next = sortedList1;
            sortedList1 = sortedList1.next;
            curr = curr.next;
        }
        while (sortedList2 != null) {
            curr.next = sortedList2;
            sortedList2 = sortedList2.next;
            curr = curr.next;
        }
        return head.next;
    }


}
