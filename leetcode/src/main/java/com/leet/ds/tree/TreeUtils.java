package com.leet.ds.tree;

import java.util.*;

public class TreeUtils {

    public static TreeNode createBst(Integer... arr) {
        if (arr[0] == null) {
            return null;
        }
        TreeNode head = new TreeNode(arr[0]);
        for (int i = 1, len = arr.length; i < len; i++) {
            insertInBST(head, arr[i]);
        }
        return head;
    }

    public static void insertInBST(TreeNode treeNode, int value) {
        while (true) {
            if (value > treeNode.val) {
                if (treeNode.right == null) {
                    treeNode.right = new TreeNode(value);
                    break;
                } else {
                    treeNode = treeNode.right;
                }
            } else if (value < treeNode.val) {
                if (treeNode.left == null) {
                    treeNode.left = new TreeNode(value);
                    break;
                } else {
                    treeNode = treeNode.left;
                }
            } else {
                break;
            }
        }
    }


    public static String preorderTraversal(TreeNode node) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (node != null) {
            Deque<TreeNode> stack = new ArrayDeque<>();
            while (node != null || !stack.isEmpty()) {
                while (node != null) {
                    arrayList.add(node.val);
                    stack.push(node);
                    node = node.left;
                }
                node = stack.pop();
                node = node.right;
            }
        }
        return arrayList.toString();
    }

    public static List<Integer> postorderTraversal(TreeNode node) {
        List<Integer> traversal = new ArrayList<>();
        if (node != null) {
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
        }
        return traversal;
    }

    public static List<Integer> inorderTraversal(TreeNode node) {
        if (node == null) {
            return Collections.emptyList();
        }
        List<Integer> traversal = new ArrayList<>();
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
        if (arr == null || arr.length == 0 || arr[0] == null) {
            return null;
        }
        TreeNode head = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(head);
        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            TreeNode node = queue.poll();
            if (arr[i] != null) {
                node.left = new TreeNode(arr[i]);
                queue.add(node.left);
            }
            i++;
            if (i < arr.length && arr[i] != null) {
                node.right = new TreeNode(arr[i]);
                queue.add(node.right);
            }
            i++;
        }
        return head;
    }


    public static List<List<Integer>> getLevelOrderTraverseListLevelWise(TreeNode node) {
        List<List<Integer>> traversal = new ArrayList<>();
        if (node != null) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(node);
            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                for (int i = 0, len = queue.size(); i < len; i++) {
                    TreeNode poll = queue.poll();
                    level.add(poll.val);
                    if (poll.left != null) {
                        queue.add(poll.left);
                    }
                    if (poll.right != null) {
                        queue.add(poll.right);
                    }
                }
                traversal.add(level);
            }
        }
        return traversal;
    }

    public static List<Integer> levelOrderTraverse(TreeNode node) {
        List<Integer> traversal = new ArrayList<>();
        if (node != null) {
            Queue<TreeNode> queue = new ArrayDeque<>();
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
        }
        return traversal;
    }

    public static boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
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
        String blank = " ";
        List<List<String>> printList = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            List<String> level = new ArrayList<>();
            addNElementsInList(level, space[i], blank);
            for (int j = 0, len = queue.size(); j < len; j++) {
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
            }
            addNElementsInList(level, space[i], blank);
            printList.add(level);
        }
        for (List<String> lev : printList) {
            System.out.println(String.join("", lev));
        }
    }

    private static <T> void addNElementsInList(List<T> list, int times, T element) {
        for (int i = 0; i < times; i++) {
            list.add(element);
        }
    }

    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

}
