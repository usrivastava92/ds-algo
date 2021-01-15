package com.leet.daysofcode.year2021.january.week2;

import com.ds.tree.BinaryTreeNode;
import com.ds.utils.TreeUtils;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static com.leet.ds.utility.TestCaseUtils.*;

public class CreateSortedArrayThroughInstructions {

    public static void main(String[] args) {
        String testCaseFile = "/Users/utkarsh/Downloads/testCase";
        int[][] inputs = {{1, 3, 3, 3, 2, 4, 2, 1, 2}, getIntArray(extractTextFromFile(testCaseFile))};
        int[] outputs = {4, 188426454};
        CreateSortedArrayThroughInstructions createSortedArrayThroughInstructions = new CreateSortedArrayThroughInstructions();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(inputs[i]));
            long startTime = System.currentTimeMillis();
            int output = createSortedArrayThroughInstructions.createSortedArray(inputs[i]);
            System.out.println("output " + output + " time " + (System.currentTimeMillis() - startTime) + " ms");
            Assert.assertEquals(outputs[i], output);
        });
    }

    private static final int MOD = 1000000007;

    public int createSortedArray(int[] instructions) {
        return createSortedArrayUsingBst(instructions);
    }

    public int createSortedArrayUsingArray(int[] instructions) {
        List<Integer> list = new ArrayList<>();
        int cost = 0;
        for (int i : instructions) {
            cost = ((cost % MOD) + (getCost(list, i) % MOD)) % MOD;
        }
        return cost;
    }

    public int createSortedArrayUsingBst(int[] instructions) {
        if (instructions == null || instructions.length == 0) {
            return 0;
        }
        int cost = 0;
        Node head = new Node(instructions[0]);
        head.count++;
        for (int i = 1; i < instructions.length; i++) {
            int curr = ((cost % MOD) + (getCostFromBst(head, instructions[i], i + 1, 0) % MOD)) % MOD;
            System.out.println(instructions[i] + " -> " +curr);
            cost += curr;
        }
        TreeUtils.prettyPrintTreeWithToString(head);
        return cost;
    }

    private int getCostFromBst(Node head, final int val, final int totalNodes, int smalls) {
        if (head == null) {
            return 0;
        }
        if (head.val == val) {
            head.count++;
            return Math.min(head.smallCount, totalNodes - head.smallCount - head.count);
        }
        if (val < head.val) {
            head.smallCount++;
            if (head.getLeft() == null) {
                head.setLeft(new Node(val));
                head.getLeft().smallCount = smalls;
            }
            return getCostFromBst(head.getLeft(), val, totalNodes, smalls);
        }
        if (head.getRight() == null) {
            head.setRight(new Node(val));
            head.getRight().smallCount = smalls + head.smallCount + head.count;
        }
        return getCostFromBst(head.getRight(), val, totalNodes, smalls + head.smallCount + head.count);
    }

    private int getCost(List<Integer> list, int element) {
        int index = strictlyLessCount(list, element);
        int maxCount = strictlyGreaterCount(list, element);
        list.add(index, element);
        return Math.min(index, maxCount);
    }

    private int strictlyLessCount(List<Integer> list, int element) {
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) >= element) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private int strictlyGreaterCount(List<Integer> list, int element) {
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) <= element) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return list.size() - low;
    }

    private static final class Node extends BinaryTreeNode<Integer> {
        int smallCount;
        int count;

        public Node(int val) {
            super(val);
        }

        public void setLeft(Node node) {
            super.setLeft(node);
        }

        public void setRight(Node node) {
            super.setRight(node);
        }

        public Node getLeft() {
            return (Node) super.getLeft();
        }

        public Node getRight() {
            return (Node) super.getRight();
        }

        @Override
        public String toString() {
            return "Node{ val=" + val +
                    ", smallCount=" + smallCount +
                    ", count=" + count +
                    '}';
        }
    }

}
