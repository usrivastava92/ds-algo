package com.ib.linkedlist;

import org.junit.Assert;

import java.util.stream.IntStream;

public class ReorderList {

    public static void main(String[] args) {
        ListNode[] As = {LinkedListUtils.generateLinkedList(1, 2, 3, 4, 5, 6, 7, 8)};
        ListNode[] outputs = {LinkedListUtils.generateLinkedList(1, 8, 2, 7, 3, 6, 4, 5)};
        ReorderList reorderList = new ReorderList();
        IntStream.range(0, As.length).forEachOrdered(i -> {
            System.out.println("Input : A : ");
            LinkedListUtils.printLinkedList(As[i]);
            ListNode output = reorderList.reorderList(As[i]);
            System.out.println("\nOutput : ");
            LinkedListUtils.printLinkedList(output);
            LinkedListUtils.printLinkedList(outputs[i]);
            Assert.assertEquals(outputs[i], output);
        });
    }

    public ListNode reorderList(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }
        /*
        1, 2, 3, 4, 5, 6, 7, 8
        1, 8, 2, 7, 3, 6, 4, 5
        1 -> 2 -> 3 -> 4
        8 -> 7 -> 6 -> 5

        1, 2, 3, 4, 5, 6, 7
        1, 7, 2, 6, 3, 5, 4
        1 -> 2 -> 3 -> 4
        7 -> 6 -> 5

        1, 2, 3, 4, 5, 6, 7, 8, 9
        1, 9, 2, 8, 3, 7, 4, 6, 5
        1 -> 2 -> 3 -> 4 -> 5
        9 -> 8 -> 7 -> 6
        */
        int len = length(A);
        int b = len / 2;
        int a = len - b;
        ListNode curr = A;
        for (int i = 0; i < a - 1; i++) {
            curr = curr.next;
        }
        ListNode rev = reverse(curr.next);
        curr.next = null;
        curr = A;
        while (rev != null && curr != null) {
            ListNode currTemp = curr.next;
            ListNode secondTemp = rev.next;
            curr.next = rev;
            curr.next.next = currTemp;
            curr = currTemp;
            rev = secondTemp;
        }
        return A;
    }

    private ListNode reverse(ListNode curr) {
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private int length(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

}
