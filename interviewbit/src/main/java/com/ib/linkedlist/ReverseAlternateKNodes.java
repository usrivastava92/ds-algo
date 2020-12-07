package com.ib.linkedlist;

import org.junit.Assert;

import java.util.stream.IntStream;

public class ReverseAlternateKNodes {

    public static void main(String[] args) {
        ListNode[] As = {LinkedListUtils.generateLinkedList(3, 4, 7, 5, 6, 6, 15, 61, 16), LinkedListUtils.generateLinkedList(1, 4, 6, 6, 4, 10)};
        int[] Bs = {3, 2};
        ListNode[] outputs = {LinkedListUtils.generateLinkedList(7, 4, 3, 5, 6, 6, 16, 61, 15), LinkedListUtils.generateLinkedList(4, 1, 6, 6, 10, 4)};
        ReverseAlternateKNodes reverseAlternateKNodes = new ReverseAlternateKNodes();
        IntStream.range(0, As.length).forEachOrdered(i -> {
            System.out.println("Input : A : ");
            LinkedListUtils.printLinkedList(As[i]);
            ListNode output = reverseAlternateKNodes.solve(As[i], Bs[i]);
            System.out.println("Output : ");
            LinkedListUtils.printLinkedList(output);
            Assert.assertEquals(LinkedListUtils.toString(outputs[i]), LinkedListUtils.toString(output));
        });
    }

    public ListNode solve(ListNode A, int B) {
        return solve(A, B, true);
    }

    public ListNode solve(ListNode A, int B, boolean reverse) {
        if (A == null || A.next == null) {
            return A;
        }
        ListNode head = null;
        if (reverse) {
            ListNode curr = A;
            ListNode prev = null;
            for (int i = 0; i < B; i++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            A.next = solve(curr, B, !reverse);
            head = prev;
        } else {
            head = A;
            ListNode curr = A;
            for (int i = 0; i < B - 1; i++) {
                curr = curr.next;
            }
            curr.next = solve(curr.next, B, !reverse);
        }
        return head;
    }

}
