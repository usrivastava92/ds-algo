package com.ds.trie;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.HashMap;

@ToString
@RequiredArgsConstructor
public class TrieNode<T> {

    @NonNull
    public T data;
    @ToString.Exclude
    public HashMap<T, TrieNode<T>> map = new HashMap<>();
    public boolean isLeaf;

}
