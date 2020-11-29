package com.leet.daysofcode.november.week5;

import org.junit.Assert;

import java.util.*;
import java.util.stream.IntStream;

public class JumpGameIII {

    public static void main(String[] args) {
        int[][] inputs = {{4, 2, 3, 0, 3, 1, 2}, {4, 2, 3, 0, 3, 1, 2}, {3, 0, 2, 1, 2}};
        int[] starts = {5, 0, 2};
        boolean[] outputs = {true, true, false};
        JumpGameIII jumpGameIII = new JumpGameIII();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(inputs[i]) + ", start : " + starts[i] + ", output : " + outputs[i]);
            Assert.assertEquals(outputs[i], jumpGameIII.canReach(inputs[i], starts[i]));
        });
    }

    public boolean canReach(int[] arr, int start) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        return canReach(arr, start, new HashMap<>(), new HashSet<>());
    }

    public boolean canReach(final int[] arr, final int start, Map<Integer, Boolean> dp, Set<Integer> visited) {
        if (start < 0 || start >= arr.length) {
            return false;
        }
        if (dp.containsKey(start)) {
            return dp.get(start);
        }
        if (arr[start] == 0) {
            return true;
        }
        visited.add(start);
        boolean ans = false;
        if (!visited.contains(start + arr[start])) {
            ans = canReach(arr, start + arr[start], dp, visited);
        }
        if (ans) {
            dp.put(start, true);
            return true;
        }
        if (!visited.contains(start - arr[start])) {
            ans = canReach(arr, start - arr[start], dp, visited);
        }
        dp.put(start, ans);
        return ans;
    }

}
