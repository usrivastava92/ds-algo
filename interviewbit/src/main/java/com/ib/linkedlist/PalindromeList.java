package com.ib.linkedlist;

import org.junit.Assert;

import java.util.stream.IntStream;

public class PalindromeList {

    public static void main(String[] args) {
        ListNode[] As = {LinkedListUtils.generateLinkedList(1, 1), LinkedListUtils.generateLinkedList(1, 2, 1), LinkedListUtils.generateLinkedList(1, 2, 2, 1), LinkedListUtils.generateLinkedList(1, 2, 3, 2, 1), LinkedListUtils.generateLinkedList(1, 5, 3, 2, 1)};
        int[] outputs = {1, 1, 1, 1, 0};
        PalindromeList palindromeList = new PalindromeList();
        IntStream.range(0, As.length).forEachOrdered(i -> {
            System.out.println("Input : A : ");
            LinkedListUtils.printLinkedList(As[i]);
            int output = palindromeList.lPalin(As[i]);
            System.out.println("Output : " + output);
            Assert.assertEquals(outputs[i], output);
        });
    }

    public int lPalin(ListNode A) {
        if (A == null || A.next == null) {
            return 1;
        }
        int len = LinkedListUtils.lengthOf(A);
        ListNode curr = A;
        for (int i = 0, half = (len / 2) - 1; i < half; i++) {
            curr = curr.next;
        }
        ListNode revSecondHalf = null;
        if (len % 2 == 0) {
            revSecondHalf = LinkedListUtils.reverse(curr.next);
        } else {
            revSecondHalf = LinkedListUtils.reverse(curr.next.next);
        }
        curr.next = null;
        curr = A;
        while (curr != null && revSecondHalf != null && curr.val == revSecondHalf.val) {
            curr = curr.next;
            revSecondHalf = revSecondHalf.next;
        }
        return curr == null && revSecondHalf == null ? 1 : 0;
    }

}
