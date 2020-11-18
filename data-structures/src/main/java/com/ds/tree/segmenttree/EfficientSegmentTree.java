package com.ds.tree.segmenttree;

public class EfficientSegmentTree implements SegmentTree {
    private int N = 100000;
    private int n;
    private int[] tree = new int[2 * N];

    public EfficientSegmentTree(int[] arr) {
        for (int i = 0; i < n; i++) {
            tree[n + i] = arr[i];
        }
        for (int i = n - 1; i > 0; --i) {
            tree[i] = tree[i << 1] + tree[i << 1 | 1];
        }
    }

    @Override
    public void updateNode(int p, int value) {
        tree[p + n] = value;
        p = p + n;
        for (int i = p; i > 1; i >>= 1) {
            tree[i >> 1] = tree[i] + tree[i ^ 1];
        }
    }

    @Override
    public int rangeQuery(int l, int r) {
        int res = 0;
        for (l += n, r += n; l < r; l >>= 1, r >>= 1) {
            if ((l & 1) > 0) {
                res += tree[l++];
            }
            if ((r & 1) > 0) {
                res += tree[--r];
            }
        }
        return res;
    }
}
