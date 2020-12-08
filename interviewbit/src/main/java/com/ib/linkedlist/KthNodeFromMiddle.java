package com.ib.linkedlist;

import org.junit.Assert;

import java.util.stream.IntStream;

public class KthNodeFromMiddle {

    public static void main(String[] args) {
        ListNode[] As = {LinkedListUtils.generateLinkedList(3, 4, 7, 5, 6, 16, 15, 61, 16), LinkedListUtils.generateLinkedList(3, 4, 7, 5, 6, 16, 15, 61, 16), LinkedListUtils.generateLinkedList(3, 4, 7, 5, 6, 16, 15, 61, 16), LinkedListUtils.generateLinkedList(1, 14, 6, 16, 4, 10), LinkedListUtils.generateLinkedList(1, 14, 6, 16, 4, 10)};
        int[] Bs = {0, 1, 3, 2, 10};
        int[] outputs = {6, 5, 4, 14, -1};
        KthNodeFromMiddle kthNodeFromMiddle = new KthNodeFromMiddle();
        IntStream.range(0, As.length).forEachOrdered(i -> {
            System.out.println("Input : A : " + LinkedListUtils.toString(As[i]) + " | B : " + Bs[i]);
            int output = kthNodeFromMiddle.solve(As[i], Bs[i]);
            System.out.println("Output : " + output);
            Assert.assertEquals(outputs[i], output);
        });
    }

    public int solve(ListNode A, int B) {
        if (A.next == null) {
            if (B > 0) {
                return -1;
            }
            return A.val;
        }
        ListNode slow = A;
        ListNode prev = null;
        ListNode fast = A;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        if (B == 0) {
            return slow.val;
        }
        for (int i = 1; i < B && prev != null; i++) {
            prev = prev.next;
        }
        return prev == null ? -1 : prev.val;
    }

}
