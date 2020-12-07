package com.ib.linkedlist;

import org.junit.Assert;

import java.util.stream.IntStream;

public class KReverseLinkedList {


    public static void main(String[] args) {
        ListNode[] As = {LinkedListUtils.generateLinkedList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0), LinkedListUtils.generateLinkedList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)};
        int[] Bs = {2, 5};
        ListNode[] outputs = {LinkedListUtils.generateLinkedList(2, 1, 4, 3, 6, 5, 8, 7, 0, 9), LinkedListUtils.generateLinkedList(5, 4, 3, 2, 1, 0, 9, 8, 7, 6)};
        KReverseLinkedList kReverseLinkedList = new KReverseLinkedList();
        IntStream.range(0, As.length).forEachOrdered(i -> {
            System.out.println("Input : A : ");
            LinkedListUtils.printLinkedList(As[i]);
            ListNode output = kReverseLinkedList.reverseList(As[i], Bs[i]);
            System.out.println("Output : ");
            LinkedListUtils.printLinkedList(output);
            Assert.assertEquals(LinkedListUtils.toString(outputs[i]), LinkedListUtils.toString(output));
        });
    }

    public ListNode reverseList(ListNode A, int B) {
        if (A == null || A.next == null) {
            return A;
        }
        ListNode curr = A;
        ListNode prev = null;
        for (int i = 0; i < B; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        A.next = reverseList(curr, B);
        return prev;
    }


}
