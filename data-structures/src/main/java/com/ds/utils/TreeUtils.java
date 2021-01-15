package com.ds.utils;

import com.ds.tree.BinaryTreeNode;
import com.ds.tree.TreeNode;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.IntStream;

public class TreeUtils {

    private TreeUtils() {
    }

    public static TreeNode<Integer> createRandomTree(int numberOfNodes) {
        if (numberOfNodes <= 0) {
            return null;
        }
        TreeNode<Integer> head = new TreeNode<>(NumberUtils.getRandomInt(10, 100));
        numberOfNodes--;
        Queue<TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.add(head);
        while (numberOfNodes > 0 && !queue.isEmpty()) {
            TreeNode<Integer> node = queue.poll();
            for (int i = 0, len = NumberUtils.getRandomInt(0, numberOfNodes); i < len; i++) {
                TreeNode<Integer> child = new TreeNode<>(NumberUtils.getRandomInt(10, 100));
                node.addChild(child);
                queue.add(child);
                numberOfNodes--;
            }
        }
        return head;
    }

    public static <T extends Comparable<T>> BinaryTreeNode<T> createBst(T... arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) {
            return null;
        }
        BinaryTreeNode<T> head = new BinaryTreeNode<>(arr[0]);
        IntStream.range(1, arr.length).forEachOrdered(i -> insertInBST(head, arr[i]));
        return head;
    }

    public static <T extends Comparable<T>> void insertInBST(BinaryTreeNode<T> binaryTreeNode, T value) {
        if (value == null || binaryTreeNode == null) {
            return;
        }
        while (true) {
            if (binaryTreeNode.val.compareTo(value) > 0) {
                if (binaryTreeNode.getLeft() == null) {
                    binaryTreeNode.setLeft(new BinaryTreeNode<>(value));
                    ;
                    return;
                }
                binaryTreeNode = binaryTreeNode.getLeft();
            } else if (binaryTreeNode.val.compareTo(value) < 0) {
                if (binaryTreeNode.getRight() == null) {
                    binaryTreeNode.setRight(new BinaryTreeNode<>(value));
                    return;
                }
                binaryTreeNode = binaryTreeNode.getRight();
            } else {
                return;
            }
        }
    }

    public static <T extends Comparable<T>> List<T> preorderTraversal(BinaryTreeNode<T> node) {
        if (node == null) {
            return Collections.emptyList();
        }
        List<T> traversal = new ArrayList<T>();
        Deque<BinaryTreeNode<T>> stack = new ArrayDeque<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                traversal.add(node.val);
                stack.push(node);
                node = node.getLeft();
            }
            node = stack.pop();
            node = node.getRight();
        }
        return traversal;
    }

    public static <T extends Comparable<T>> List<T> postorderTraversal(BinaryTreeNode<T> node) {
        if (node == null) {
            return Collections.emptyList();
        }
        List<T> traversal = new ArrayList<T>();
        Deque<BinaryTreeNode<T>> stack = new ArrayDeque<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                stack.push(node);
                node = node.getLeft();
            }
            node = stack.pop();
            if (node == stack.peek()) {
                node = node.getRight();
            } else {
                traversal.add(node.val);
                node = null;
            }
        }
        return traversal;
    }

    public static <T extends Comparable<T>> List<T> inorderTraversal(BinaryTreeNode<T> node) {
        if (node == null) {
            return Collections.emptyList();
        }
        List<T> traversal = new ArrayList<T>();
        Deque<BinaryTreeNode<T>> stack = new ArrayDeque<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.getLeft();
            }
            node = stack.pop();
            traversal.add(node.val);
            node = node.getRight();
        }
        return traversal;
    }

    public static <T extends Comparable<T>> BinaryTreeNode<T> createTreeFromBfsArray(T... arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        BinaryTreeNode<T> head = new BinaryTreeNode<>(arr[0]);
        Deque<BinaryTreeNode<T>> queue = new ArrayDeque<>();
        queue.add(head);
        int i = 1;
        while (!queue.isEmpty()) {
            BinaryTreeNode<T> node = queue.poll();
            if (arr[i] != null) {
                node.setLeft(new BinaryTreeNode<>(arr[i]));
                queue.add(node.getLeft());
            }
            i++;
            if (arr[i] != null) {
                node.setRight(new BinaryTreeNode<>(arr[i]));
                queue.add(node.getRight());
            }
            i++;
        }
        return head;
    }

    public static <T extends Comparable<T>> List<List<T>> getLevelOrderTraverseListLevelWise(TreeNode<T> node) {
        if (node == null) {
            return Collections.emptyList();
        }
        List<List<T>> levels = new ArrayList<>();
        Deque<TreeNode<T>> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            List<T> level = new ArrayList<T>();
            IntStream.range(0, queue.size()).forEach(i -> {
                TreeNode<T> poll = queue.poll();
                level.add(poll.val);
                if (poll instanceof BinaryTreeNode) {
                    BinaryTreeNode<T> binaryTreeNode = (BinaryTreeNode<T>) poll;
                    if (binaryTreeNode.getLeft() != null) {
                        queue.add(binaryTreeNode.getLeft());
                    }
                    if (binaryTreeNode.getRight() != null) {
                        queue.add(binaryTreeNode.getRight());
                    }
                } else {
                    poll.getChildren().stream().filter(Objects::nonNull).forEachOrdered(queue::add);
                }
            });
            levels.add(level);
        }
        return levels;
    }

    public static <T extends Comparable<T>> List<T> levelOrderTraverse(TreeNode<T> node) {
        if (node == null) {
            return Collections.emptyList();
        }
        List<T> traversal = new ArrayList<T>();
        Deque<TreeNode<T>> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode<T> poll = queue.poll();
            traversal.add(poll.val);
            if (poll instanceof BinaryTreeNode) {
                BinaryTreeNode<T> binaryTreeNode = (BinaryTreeNode<T>) poll;
                if (binaryTreeNode.getLeft() != null) {
                    queue.add(binaryTreeNode.getLeft());
                }
                if (binaryTreeNode.getRight() != null) {
                    queue.add(binaryTreeNode.getRight());
                }
            } else {
                poll.getChildren().stream().filter(Objects::nonNull).forEachOrdered(queue::add);
            }
        }
        return traversal;
    }

    public static <T extends Comparable<T>> List<T> levelOrderTraverseIncludingNulls(TreeNode<T> node) {
        if (node == null) {
            return Collections.emptyList();
        }
        List<T> traversal = new ArrayList<T>();
        Deque<TreeNode<T>> queue = new ArrayDeque<>();

        BinaryTreeNode<T> nullNode = new BinaryTreeNode<>(node.val);
        nullNode.val = null;

        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode<T> poll = queue.poll();
            traversal.add(poll.val);
            if (poll instanceof BinaryTreeNode) {
                BinaryTreeNode<T> binaryTreeNode = (BinaryTreeNode<T>) poll;
                queue.add(binaryTreeNode.getLeft() != null ? binaryTreeNode.getLeft() : nullNode);
                queue.add(binaryTreeNode.getRight() != null ? binaryTreeNode.getRight() : nullNode);
            } else {
                poll.getChildren().forEach(child -> queue.add(child != null ? child : nullNode));
            }
        }
        return traversal;
    }

    public static <T extends Comparable<T>> void prettyPrintTree(BinaryTreeNode<T> root) {
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
        Deque<BinaryTreeNode<T>> queue = new LinkedList<BinaryTreeNode<T>>();
        queue.add(root);
        String blank = StringUtils.repeat(' ', String.valueOf(root.val).length());
        List<List<String>> printList = new ArrayList<>();
        IntStream.range(0, height).forEachOrdered(i -> {
            List<String> level = new ArrayList<String>();
            addNElementsInList(level, space[i], blank);
            int len = queue.size();
            IntStream.range(0, len).forEachOrdered(j -> {
                BinaryTreeNode<T> poll = queue.poll();
                if (poll == null) {
                    level.add(blank);
                    queue.add(null);
                    queue.add(null);
                } else {
                    level.add(poll.val.toString());
                    queue.add(poll.getLeft());
                    queue.add(poll.getRight());
                }
                int prev = i - 1;
                if (j != len - 1 && prev > -1) {
                    addNElementsInList(level, space[prev], blank);
                }
            });
            addNElementsInList(level, space[i], blank);
            printList.add(level);
        });
        for (List<String> lev : printList) {
            System.out.println(String.join("", lev));
        }
    }

    public static <T extends Comparable<T>> void prettyPrintTreeWithToString(BinaryTreeNode<T> root) {
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
        Deque<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.add(root);
        String blank = StringUtils.repeat(' ', String.valueOf(root).length());
        List<List<String>> printList = new ArrayList<>();
        IntStream.range(0, height).forEachOrdered(i -> {
            List<String> level = new ArrayList<>();
            addNElementsInList(level, space[i], blank);
            int len = queue.size();
            IntStream.range(0, len).forEachOrdered(j -> {
                BinaryTreeNode<T> poll = queue.poll();
                if (poll == null) {
                    level.add(blank);
                    queue.add(null);
                    queue.add(null);
                } else {
                    level.add(poll.toString());
                    queue.add(poll.getLeft());
                    queue.add(poll.getRight());
                }
                int prev = i - 1;
                if (j != len - 1 && prev > -1) {
                    addNElementsInList(level, space[prev], blank);
                }
            });
            addNElementsInList(level, space[i], blank);
            printList.add(level);
        });
        for (List<String> lev : printList) {
            System.out.println(String.join("", lev));
        }
    }

    private static <T extends Comparable<T>> void addNElementsInList(List<T> list, int times, T element) {
        IntStream.range(0, times).forEach(i -> list.add(element));
    }

    public static <T extends Comparable<T>> int getHeight(TreeNode<T> root) {
        if (root == null) {
            return 0;
        }
        OptionalInt childMaxHeight = root.getChildren().stream().mapToInt(TreeUtils::getHeight).max();
        if (childMaxHeight.isPresent()) {
            return 1 + childMaxHeight.getAsInt();
        }
        return 1;
    }

    public static BinaryTreeNode<Integer> createRandomBST(int numberOfNodes) {
        return createRandomBST(numberOfNodes, 10, 100);
    }

    public static BinaryTreeNode<Integer> createRandomBST(int numberOfNodes, int lowerLimitInclusive, int upperLimitInclusive) {
        if (numberOfNodes <= 0)
            return null;
        BinaryTreeNode<Integer> head = new BinaryTreeNode<>(NumberUtils.getRandomInt(lowerLimitInclusive, upperLimitInclusive));
        IntStream.generate(() -> NumberUtils.getRandomInt(lowerLimitInclusive, upperLimitInclusive)).limit(numberOfNodes - 1).forEach(i -> insertInBST(head, i));
        return head;
    }

    public static <T extends Comparable<T>> boolean isLeaf(TreeNode<T> node) {
        return Objects.nonNull(node) && node.getChildren().isEmpty();
    }

}