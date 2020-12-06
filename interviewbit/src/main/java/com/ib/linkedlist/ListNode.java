package com.ib.linkedlist;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class ListNode {
    public int val;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }
}