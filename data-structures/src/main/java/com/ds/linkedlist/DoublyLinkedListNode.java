package com.ds.linkedlist;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
public class DoublyLinkedListNode<T> {

    @NonNull
    public T val;
    @ToString.Exclude
    public DoublyLinkedListNode<T> prev;
    @ToString.Exclude
    public DoublyLinkedListNode<T> next;

}
