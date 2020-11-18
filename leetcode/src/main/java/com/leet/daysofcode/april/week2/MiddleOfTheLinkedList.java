package com.leet.daysofcode.april.week2;

import com.leet.ds.linkedlist.ListNode;

public class MiddleOfTheLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode sin = head;
        ListNode dou = head;
        while (dou != null && dou.next != null) {
            sin = sin.next;
            dou = dou.next.next;
        }
        return sin;
    }
}
