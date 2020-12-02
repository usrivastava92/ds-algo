package com.ib.arrays;

import java.util.ArrayList;

public class ArrayUtils {

    public static ArrayList<ArrayList<Integer>> toArrayList(int[][] arr) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            ans.add(new ArrayList<>());
            for (int j = 0; j < arr[i].length; j++) {
                ans.get(i).add(arr[i][j]);
            }
        }
        return ans;
    }

    public static int[][] toArray(ArrayList<ArrayList<Integer>> list) {
        int[][] ans = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = new int[list.get(i).size()];
            for (int j = 0; j < list.get(i).size(); j++) {
                ans[i][j] = list.get(i).get(j);
            }
        }
        return ans;
    }

}
