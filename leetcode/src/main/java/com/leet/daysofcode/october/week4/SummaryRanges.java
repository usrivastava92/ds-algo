package com.leet.daysofcode.october.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class SummaryRanges {

    public static void main(String[] args) {
        int[][] inputs = {{0, 1, 2, 4, 5, 7}, {0, 2, 3, 4, 6, 8, 9}, {-1}, {0}, {}, {-2147483648, -2147483647, 2147483647}};
        String[][] outputs = {{"0->2", "4->5", "7"}, {"0", "2->4", "6", "8->9"}, {"-1"}, {"0"}, {}, {"-2147483648->-2147483647", "2147483647"}};
        SummaryRanges summaryRanges = new SummaryRanges();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(inputs[i]));
            System.out.println("Output : " + summaryRanges.summaryRanges(inputs[i]));
            System.out.println("Expected : " + Arrays.toString(outputs[i]));
        });
    }

    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        List<String> ranges = new ArrayList<>();
        int start = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (Math.abs(nums[i] - nums[i - 1]) > 1) {
                if (start == nums[i - 1]) {
                    ranges.add(start + "");
                } else {
                    ranges.add(start + "->" + nums[i - 1]);
                }
                start = nums[i];
            }
        }
        if (start == nums[nums.length - 1]) {
            ranges.add(start + "");
        } else {
            ranges.add(start + "->" + nums[nums.length - 1]);
        }
        return ranges;
    }

}
