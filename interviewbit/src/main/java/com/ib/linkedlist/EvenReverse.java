package com.ib.linkedlist;

import org.junit.Assert;

import java.util.stream.IntStream;

public class EvenReverse {

    public static void main(String[] args) {
        ListNode[] As = {LinkedListUtils.generateLinkedList(1, 2, 3, 4), LinkedListUtils.generateLinkedList(1, 2, 3)};
        ListNode[] outputs = {LinkedListUtils.generateLinkedList(1, 4, 3, 2), LinkedListUtils.generateLinkedList(1, 2, 3)};
        EvenReverse evenReverse = new EvenReverse();
        IntStream.range(0, As.length).forEachOrdered(i -> {
            System.out.println("Input :  " + LinkedListUtils.toString(As[i]));
            ListNode output = evenReverse.solve(As[i]);
            System.out.println("Output : " + LinkedListUtils.toString(output));
            Assert.assertEquals(LinkedListUtils.toString(outputs[i]), LinkedListUtils.toString(output));
        });
    }

    public ListNode solve(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }
        ListNode evenNodesHead = new ListNode(-1);
        ListNode evenNodesCurr = evenNodesHead;
        ListNode curr = A;
        while (curr != null) {
            ListNode next = curr.next;
            evenNodesCurr.next = next;
            if (next != null) {
                ListNode nextNext = curr.next.next;
                evenNodesCurr.next.next = null;
                curr.next = nextNext;
            }
            evenNodesCurr = evenNodesCurr.next;
            curr = curr.next;
        }
        curr = A;
        evenNodesHead = LinkedListUtils.reverse(evenNodesHead.next);
        evenNodesCurr = evenNodesHead;
        while (evenNodesCurr != null && curr != null) {
            ListNode next = curr.next;
            curr.next = evenNodesCurr;
            evenNodesCurr = evenNodesCurr.next;
            curr.next.next = next;
            curr = curr.next.next;
        }
        return A;
    }

}
