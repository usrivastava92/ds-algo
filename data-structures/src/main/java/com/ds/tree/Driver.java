package com.ds.tree;

import com.ds.tree.segmenttree.ISegmentTree;
import com.ds.tree.segmenttree.SegmentTree;

public class Driver {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ISegmentTree segmentTree = new SegmentTree(arr);
        System.out.println(segmentTree);
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            System.out.println("setting value : i ->" + (len - i));
            System.out.println(segmentTree);
            segmentTree.updateNode(i, len - i);
            System.out.println(i + " -> " + segmentTree.rangeQuery(i, i));
        }
    }

}
