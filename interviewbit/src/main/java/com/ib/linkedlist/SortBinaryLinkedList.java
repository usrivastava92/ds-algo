package com.ib.linkedlist;

import org.junit.Assert;

import java.util.stream.IntStream;

public class SortBinaryLinkedList {

    public static void main(String[] args) {
        ListNode[] As = {LinkedListUtils.generateLinkedList(1, 0, 0, 1), LinkedListUtils.generateLinkedList(0, 0, 1, 1, 0)};
        ListNode[] outputs = {LinkedListUtils.generateLinkedList(0, 0, 1, 1), LinkedListUtils.generateLinkedList(0, 0, 0, 1, 1)};
        SortBinaryLinkedList sortBinaryLinkedList = new SortBinaryLinkedList();
        IntStream.range(0, As.length).forEachOrdered(i -> {
            System.out.println("Input : A : ");
            LinkedListUtils.printLinkedList(As[i]);
            ListNode output = sortBinaryLinkedList.solve(As[i]);
            System.out.println("Output : ");
            LinkedListUtils.printLinkedList(output);
            Assert.assertEquals(LinkedListUtils.toString(outputs[i]), LinkedListUtils.toString(output));
        });
    }

    public ListNode solve(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }
        int zeros = 0;
        ListNode curr = A;
        while (curr != null) {
            if (curr.val == 0) {
                zeros++;
            }
            curr = curr.next;
        }
        curr = A;
        while (zeros-- > 0) {
            curr.val = 0;
            curr = curr.next;
        }
        while (curr != null) {
            curr.val = 1;
            curr = curr.next;
        }
        return A;
    }

}
