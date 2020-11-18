package com.leet.daysofcode.november.week1;

import com.leet.ds.linkedlist.LinkedListUtils;
import com.leet.ds.linkedlist.ListNode;

import java.util.stream.IntStream;

public class AddTwoNumbersII {

    public static void main(String[] args) {
        ListNode[] l1s = {LinkedListUtils.createList(7, 2, 4, 3)};
        ListNode[] l2s = {LinkedListUtils.createList(5, 6, 4)};
        ListNode[] outputs = {LinkedListUtils.createList(7, 8, 0, 7)};
        AddTwoNumbersII addTwoNumbersII = new AddTwoNumbersII();
        IntStream.range(0, l1s.length).forEachOrdered(i -> {
            System.out.println("Input : l1 , " + LinkedListUtils.getTraversal(l1s[i]) + " | l2 , " + LinkedListUtils.getTraversal(l2s[i]));
            System.out.println("Output : " + LinkedListUtils.getTraversal(addTwoNumbersII.addTwoNumbers(l1s[i], l2s[i])));
            System.out.println("Expected : " + LinkedListUtils.getTraversal(outputs[i]));
        });
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        int carry = 0;
        ListNode ans = new ListNode(-1);
        ListNode curr = ans;
        while (l1 != null && l2 != null) {
            int digitSum = l1.val + l2.val + carry;
            curr.next = new ListNode(digitSum % 10);
            carry = digitSum / 10;
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int digitSum = l1.val + carry;
            curr.next = new ListNode(digitSum % 10);
            carry = digitSum / 10;
            curr = curr.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int digitSum = l2.val + carry;
            curr.next = new ListNode(digitSum % 10);
            carry = digitSum / 10;
            curr = curr.next;
            l2 = l2.next;
        }
        while (carry > 0) {
            curr.next = new ListNode(carry % 10);
            carry = carry / 10;
            curr = curr.next;
        }
        return reverse(ans.next);
    }

    private ListNode reverse(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode prev = null;
        ListNode curr = node;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

}
