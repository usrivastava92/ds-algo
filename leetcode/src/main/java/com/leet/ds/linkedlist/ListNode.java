package com.leet.ds.linkedlist;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class ListNode {

    @NonNull
    public int val;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    public ListNode next;

}