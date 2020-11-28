package com.ib.tree;

import com.ds.utils.NumberUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.IntStream;

public class TreeUtils {

    public static TreeNode createBst(int... arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        TreeNode head = new TreeNode(arr[0]);
        IntStream.range(1, arr.length).forEachOrdered(i -> insertInBST(head, arr[i]));
        return head;
    }

    public static void insertInBST(TreeNode treeNode, int value) {
        if (treeNode == null) {
            return;
        }
        while (true) {
            if (treeNode.val > value) {
                if (treeNode.left == null) {
                    treeNode.left = new TreeNode(value);
                    return;
                }
                treeNode = treeNode.left;
            } else if (treeNode.val < value) {
                if (treeNode.right == null) {
                    treeNode.right = new TreeNode(value);
                    return;
                }
                treeNode = treeNode.right;
            } else {
                return;
            }
        }
    }

    public static ArrayList<Integer> preorderTraversal(TreeNode node) {
        ArrayList<Integer> traversal = new ArrayList<>();
        if (node == null) {
            return traversal;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                traversal.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return traversal;
    }

    public static ArrayList<Integer> postorderTraversal(TreeNode node) {
        ArrayList<Integer> traversal = new ArrayList<>();
        if (node == null) {
            return traversal;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (node == stack.peek()) {
                node = node.right;
            } else {
                traversal.add(node.val);
                node = null;
            }
        }
        return traversal;
    }

    public static ArrayList<Integer> inorderTraversal(TreeNode node) {
        ArrayList<Integer> traversal = new ArrayList<>();
        if (node == null) {
            return traversal;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            traversal.add(node.val);
            node = node.right;
        }
        return traversal;
    }

    public static TreeNode createTreeFromBfsArray(Integer... arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        TreeNode head = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(head);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (arr[i] != null) {
                node.left = new TreeNode(arr[i]);
                queue.add(node.left);
            }
            i++;
            if (arr[i] != null) {
                node.right = new TreeNode(arr[i]);
                queue.add(node.right);
            }
            i++;
        }
        return head;
    }

    public static ArrayList<ArrayList<Integer>> getLevelOrderTraverseListLevelWise(TreeNode node) {
        ArrayList<ArrayList<Integer>> levels = new ArrayList<>();
        if (node == null) {
            return levels;
        }
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(node);
        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            IntStream.range(0, queue.size()).forEach(i -> {
                TreeNode poll = queue.poll();
                level.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            });
            levels.add(level);
        }
        return levels;
    }

    public static ArrayList<Integer> levelOrderTraverse(TreeNode node) {
        ArrayList<Integer> traversal = new ArrayList<>();
        if (node == null) {
            return traversal;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            traversal.add(poll.val);
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
        return traversal;
    }

    public static void prettyPrintTree(TreeNode root) {
        if (root == null) {
            return;
        }
        int height = getHeight(root);
        int[] space = new int[height];
        space[height - 1] = 0;
        for (int i = height - 2; i > -1; i--) {
            int prev = i + 1;
            space[i] = (2 * space[prev]) + 1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        String blank = StringUtils.repeat(' ', String.valueOf(root.val).length());
        IntStream.range(0, height).forEachOrdered(i -> {
            List<String> level = new ArrayList<>();
            addNElementsInList(level, space[i], blank);
            int len = queue.size();
            IntStream.range(0, len).forEachOrdered(j -> {
                TreeNode poll = queue.poll();
                if (poll == null) {
                    level.add(blank);
                    queue.add(null);
                    queue.add(null);
                } else {
                    level.add(String.valueOf(poll.val));
                    queue.add(poll.left);
                    queue.add(poll.right);
                }
                int prev = i - 1;
                if (j != len - 1 && prev > -1) {
                    addNElementsInList(level, space[prev], blank);
                }
            });
            addNElementsInList(level, space[i], blank);
            System.out.println(String.join("", level));
        });
    }

    private static void addNElementsInList(List<String> list, int times, String element) {
        IntStream.range(0, times).forEach(i -> list.add(element));
    }

    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public static TreeNode createRandomBST(int numberOfNodes) {
        return createRandomBST(numberOfNodes, 10, 100);
    }

    public static TreeNode createRandomBST(int numberOfNodes, int lowerLimit, int upperLimit) {
        if (numberOfNodes <= 0)
            return null;
        TreeNode head = new TreeNode(NumberUtils.getRandomInt(lowerLimit, upperLimit));
        IntStream.generate(() -> NumberUtils.getRandomInt(lowerLimit, upperLimit)).limit(numberOfNodes - 1).forEach(i -> insertInBST(head, i));
        return head;
    }

    public static boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

}
