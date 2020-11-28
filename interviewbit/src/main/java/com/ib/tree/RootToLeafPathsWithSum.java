package com.ib.tree;

import java.util.ArrayList;
import java.util.Arrays;

public class RootToLeafPathsWithSum {

    public static void main(String[] args) {

    }

    public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        helper(A, B, result, new ArrayList<>(), 0);
        return result;
    }


    public void helper(TreeNode A, int B, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path, int sum) {
        if (A == null) {
            return;
        }
        path.add(A.val);
        sum += A.val;
        if (A.right == null && A.left == null) {
            if (sum == B) {
                result.add(path);
            }
            return;
        }
        if (A.right != null) {
            helper(A.right, B, result, (ArrayList<Integer>)path.clone(), sum);
        }
        if (A.left != null) {
            helper(A.left, B, result, (ArrayList<Integer>)path.clone(), sum);
        }
    }
}
