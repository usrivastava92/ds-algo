package com.ib.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        combinationSum.combinationSum(new ArrayList<>(Arrays.asList(8, 10, 6, 11, 1, 16, 8)), 28);
    }

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int size = A.size();
        for (int i = B; i > 0; i--) {
            combinations(A, A.size(), i, 0, new ArrayList<Integer>(Arrays.asList(new Integer[i])), 0, B, result);
        }
        System.out.println(result);
        return result;
    }

    private void combinations(final ArrayList<Integer> A, final int n, final int r, int c, ArrayList<Integer> ans, int sum, final int target, ArrayList<ArrayList<Integer>> result) {
        if (c == r) {
            if (sum == target) {
                Collections.sort(ans);
                if (!result.contains(ans)) {
                    result.add(new ArrayList<>(ans));
                }
            }
            return;
        }
        for (int i = 0; i <= n - r + c; i++) {
            int tempSum = sum + A.get(i);
            if (tempSum <= target) {
                ans.set(c, A.get(i));
                combinations(A, n, r, c + 1, ans, tempSum, target, result);
            }
        }
    }
}
