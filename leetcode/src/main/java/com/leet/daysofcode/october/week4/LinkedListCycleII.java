package com.leet.daysofcode.october.week4;

import com.leet.ds.linkedlist.LinkedListUtils;
import com.leet.ds.linkedlist.ListNode;

import java.util.stream.IntStream;

public class LinkedListCycleII {

    public static void main(String[] args) {
        ListNode[] inputs = {LinkedListUtils.createCyclicList(1, 3, 2, 0, -4), LinkedListUtils.createCyclicList(0, 1, 2), LinkedListUtils.createCyclicList(-1, 1)};
        ListNode[] outputs = {LinkedListUtils.get(inputs[0], 1), LinkedListUtils.get(inputs[1], 0), null};
        LinkedListCycleII linkedListCycleII = new LinkedListCycleII();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + inputs[i]);
            System.out.println("Output : " + linkedListCycleII.detectCycle(inputs[i]));
            System.out.println("Expected : " + outputs[i]);
        });
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode curr = head;
                while (curr != slow) {
                    curr = curr.next;
                    slow = slow.next;
                }
                return curr;
            }
        }
        return null;
    }

}
