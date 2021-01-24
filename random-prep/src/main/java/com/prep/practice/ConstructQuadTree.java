package com.prep.practice;

import com.ds.utils.ArrayUtils;

import java.util.stream.IntStream;

public class ConstructQuadTree {

    public static void main(String[] args) {
        int[][][] grids = {{{0, 1}, {1, 0}}, {{1, 1}, {1, 1}}, {{0}}, {{1, 1, 0, 0}, {1, 1, 0, 0}, {0, 0, 1, 1}, {0, 0, 1, 1}}, {{1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}}};
        ConstructQuadTree constructQuadTree = new ConstructQuadTree();
        IntStream.range(0, grids.length).forEachOrdered(i -> {
            System.out.println("Input : ");
            ArrayUtils.printArr(grids[i]);
            System.out.println(constructQuadTree.construct(grids[i]));
        });
    }

    public Node construct(int[][] grid) {
        return getNode(grid, 0, 0, grid.length - 1, grid.length - 1);
    }

    public Node getNode(int[][] grid, int x1, int y1, int x2, int y2) {
        if (x2 == x1 && y1 == y2) {
            return new Node(grid[x1][y1] == 1, true);
        }
        int tempX = x1 + (x2 - x1) / 2;
        int tempY = y1 + (y2 - y1) / 2;
        Node topLeft = getNode(grid, x1, y1, tempX, tempY);
        Node topRight = getNode(grid, tempX + 1, y1, x2, tempY);
        Node bottomLeft = getNode(grid, x1, tempY + 1, tempX, y2);
        Node bottomRight = getNode(grid, tempX + 1, tempY + 1, x2, y2);
        Node node = new Node(topLeft.val, false);
        if (topLeft.val == topRight.val && topLeft.val == bottomLeft.val && topLeft.val == bottomRight.val
                && topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf) {
            node.isLeaf = true;
        } else {
            node.topLeft = topLeft;
            node.topRight = topRight;
            node.bottomLeft = bottomLeft;
            node.bottomRight = bottomRight;
        }
        return node;
    }


    private static final class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", isLeaf=" + isLeaf +
                    '}';
        }
    }

}
