package com.ib.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Combinations {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        int r = 3;
        int n = arr.length;
        int[] ans = new int[r];
//        bruteForce(arr, n, r, ans);
        //printCombinations(arr, n, r, 0, 0, ans);
        Combinations combinations = new Combinations();
        System.out.println(combinations.combine(4, 3));
    }

    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (B == 0) {
            return result;
        }
        if (B == 1) {
            for (int i = 1; i <= A; i++) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                result.add(temp);
            }
            return result;
        }
        printCombinations(A, B, 0, 0, new ArrayList<>(Arrays.asList(new Integer[B])), result);
        return result;
    }

    private void printCombinations(int n, int r, int c, int index, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> result) {
        if (c == r) {
            result.add(new ArrayList<>(ans));
            return;
        }
        for (int i = index; i <= n - r + c; i++) {
            ans.set(c, i + 1);
            printCombinations(n, r, c + 1, i + 1, ans, result);
        }
    }

    private static void printCombinations(final int[] arr, int n, int r, int c, int index, int[] ans) {
        if (c == r) {
            System.out.println(Arrays.toString(ans));
            return;
        }
        for (int i = index; i <= n - r + c; i++) {
            ans[c] = arr[i];
            printCombinations(arr, n, r, c + 1, i + 1, ans);
        }
    }

    private static void bruteForce(final int[] arr, int n, int r, int[] ans) {
        for (int i = 0; i <= n - r; i++) {
            for (int j = i + 1; j <= n - r + 1; j++) {
                for (int k = j + 1; k <= n - r + 2; k++) {
                    ans[0] = arr[i];
                    ans[1] = arr[j];
                    ans[2] = arr[k];
                    System.out.println(Arrays.toString(ans));
                }
            }
        }
    }


}
