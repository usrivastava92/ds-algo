package com.leet.daysofcode.year2020.december.week1;


import com.ds.utils.NumberUtils;
import com.leet.ds.tree.TreeNode;
import com.leet.ds.tree.TreeUtils;
import org.junit.Assert;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.IntStream;

public class PopulatingNextRightPointersInEachNodeII {

    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNodeII populatingNextRightPointersInEachNodeII = new PopulatingNextRightPointersInEachNodeII();
        IntStream.range(0, 10).forEachOrdered(i -> {
            System.out.println("Input : ");
            TreeNode input = TreeUtils.createRandomBST(NumberUtils.getRandomInt(1, 100));
            TreeUtils.prettyPrintTree(input);
            Assert.assertEquals(populatingNextRightPointersInEachNodeII.connectBfs(convert(input)), populatingNextRightPointersInEachNodeII.connect(convert(input)));
        });
    }

    public Node connect(Node root) {
        connect(root, null);
        return root;
    }

    public void connect(Node root, Node parent) {
        if (root == null) {
            return;
        }
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
        }
        if (parent != null) {
            Node curr = parent.next;
            while (curr != null && root.next == null) {
                if (curr.left != null || curr.right != null) {
                    root.next = curr.left != null ? curr.left : curr.right;
                    break;
                }
                curr = curr.next;
            }
        }
        connect(root.right, root);
        connect(root.left, root);
    }


    public Node connectBfs(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size() - 1;
            Node prev = queue.poll();
            if (prev.left != null) {
                queue.add(prev.left);
            }
            if (prev.right != null) {
                queue.add(prev.right);
            }
            for (int i = 0; i < len; i++) {
                Node poll = queue.poll();
                prev.next = poll;
                prev = poll;
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
        return root;
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return val == node.val &&
                    Objects.equals(left, node.left) &&
                    Objects.equals(right, node.right) &&
                    Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, left, right, next);
        }

        @Override
        public String toString() {
            return "Node{" + "val=" + val + ", next=" + (next == null ? null : next.val) + ", left=" + (left == null ? null : left.val) + ", right=" + (right == null ? null : right.val) + '}';
        }
    }

    private static Node convert(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        Node node = new Node(treeNode.val);
        node.left = convert(treeNode.left);
        node.right = convert(treeNode.right);
        return node;
    }

}
