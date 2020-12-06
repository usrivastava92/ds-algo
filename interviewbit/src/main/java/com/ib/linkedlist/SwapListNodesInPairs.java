package com.ib.linkedlist;

import org.junit.Assert;

import java.util.stream.IntStream;

public class SwapListNodesInPairs {

    public static void main(String[] args) {
        ListNode[] As = {LinkedListUtils.generateLinkedList(1, 2, 3, 4)};
        ListNode[] outputs = {LinkedListUtils.generateLinkedList(2, 1, 4, 3)};
        SwapListNodesInPairs swapListNodesInPairs = new SwapListNodesInPairs();
        IntStream.range(0, As.length).forEachOrdered(i -> {
            System.out.println("Input : A : ");
            LinkedListUtils.printLinkedList(As[i]);
            ListNode output = swapListNodesInPairs.swapPairs(As[i]);
            System.out.println("\nOutput : ");
            LinkedListUtils.printLinkedList(output);
            LinkedListUtils.printLinkedList(outputs[i]);
            Assert.assertEquals(outputs[i], output);
        });
    }

    public ListNode swapPairs(ListNode A) {
        ListNode result = new ListNode(0);
        ListNode ans = result;
        ListNode curr = A;
        while (curr != null && curr.next != null) {
            ListNode second = curr.next;
            curr.next = curr.next.next;
            second.next = curr;
            result.next = second;
            result = result.next.next;
            curr = curr.next;
        }
        if (curr != null) {
            result.next = curr;
        }
        return ans.next;
    }

}
