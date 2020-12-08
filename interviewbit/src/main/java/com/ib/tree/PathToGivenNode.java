package com.ib.tree;

import java.util.ArrayList;

public class PathToGivenNode {

    public static void main(String[] args) {

    }

    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> ans = new ArrayList<>();
        solve(A, B, ans);
        return ans;
    }

    public boolean solve(TreeNode A, int B, ArrayList<Integer> ans) {
        if (A == null) {
            return false;
        }
        int index = ans.size();
        ans.add(A.val);
        if (A.val == B || solve(A.left, B, ans) || solve(A.right, B, ans)) {
            return true;
        }
        ans.remove(index);
        return false;
    }

}
