package com.ds.linkedlist;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
public class LinkedListNode<T> {

    @NonNull
    public T val;
    @ToString.Exclude
    public LinkedListNode<T> next;

}
