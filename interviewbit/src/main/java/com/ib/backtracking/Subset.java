package com.ib.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Subset {

    public static void main(String... args) {
        Subset subset = new Subset();
        ArrayList<Integer> input = new ArrayList(Arrays.asList(1, 2, 3));
        System.out.println(subset.subsets(input));
    }


    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 0, len = A.size(); i < len; i++) {
            ArrayList<Integer> ans = new ArrayList<>();
            createSubset(result, A, i, ans);
        }
        return result;
    }

    public void createSubset(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> A, int index, ArrayList<Integer> ans) {
        if (index < A.size()) {
            ans.add(A.get(index));
            result.add(new ArrayList<>(ans));
            createSubset(result, A, index+1, ans);
        }
    }
}
