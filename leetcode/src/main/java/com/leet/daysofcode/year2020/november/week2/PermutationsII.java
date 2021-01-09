package com.leet.daysofcode.year2020.november.week2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PermutationsII {

    public static void main(String[] args) {
        int[][] inputs = {{1, 1, 2}, {1, 2, 3}};
        int[][][] outputs = {{{1, 1, 2}, {1, 2, 1}, {2, 1, 1}}, {{1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1}}};
        PermutationsII permutationsII = new PermutationsII();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(inputs[i]));
            System.out.println("Output : " + permutationsII.permuteUnique(inputs[i]));
            System.out.println("Expected : " + Arrays.deepToString(outputs[i]));
        });
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        Set<List<Integer>> ans = new HashSet<>();
        helper(ans, nums, 0);
        return new ArrayList<>(ans);
    }

    private void helper(Set<List<Integer>> lists, int[] nums, int i) {
        if (nums.length - i <= 1) {
            lists.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for (int j = i ; j < nums.length; j++) {
            swap(nums, i, j);
            helper(lists, nums, i + 1);
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
