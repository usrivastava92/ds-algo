package com.leet.ds.linkedlist;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Objects;

@ToString
@RequiredArgsConstructor
public class ListNode {

    @NonNull
    public int val;
    @ToString.Exclude
    public ListNode next;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return LinkedListUtils.getTraversal(this).equals(LinkedListUtils.getTraversal((ListNode) o));
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, LinkedListUtils.getTraversal(this));
    }

}