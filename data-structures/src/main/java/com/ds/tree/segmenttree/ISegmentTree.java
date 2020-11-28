package com.ds.tree.segmenttree;

public interface ISegmentTree {

    int rangeQuery(int start, int end);

    void updateNode(int i, int value);

}
