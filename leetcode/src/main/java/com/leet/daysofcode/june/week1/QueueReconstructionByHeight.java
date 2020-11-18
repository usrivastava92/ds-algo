package com.leet.daysofcode.june.week1;


import com.ds.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class QueueReconstructionByHeight {

    public static void main(String[] args) {
        int[][][] inputs = {{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}}};
        int[][][] outputs = {{{5, 0}, {7, 0}, {5, 2}, {6, 1}, {4, 4}, {7, 1}}};
        QueueReconstructionByHeight queueReconstructionByHeight = new QueueReconstructionByHeight();
        for (int i = 0; i < inputs.length; i++) {
            System.out.println("Input : " + ArrayUtils.toString(inputs[i]));
            System.out.println("Output : " + ArrayUtils.toString(queueReconstructionByHeight.reconstructQueue(inputs[i])));
            System.out.println("Expected : " + ArrayUtils.toString(outputs[i]));
            System.out.println("#######################################################");
        }
    }

    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }
        int n = people.length;
        Arrays.sort(people, (a, b) -> {
            if (b[0] == a[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });
        ArrayList<int[]> list = new ArrayList<>();
        System.out.println(ArrayUtils.toString(people));
        for (int[] person : people) {
            list.add(person[1], person);
            System.out.println(ArrayUtils.toString(list));
        }
        int[][] ans = new int[n][2];
        for (int i = 0; i < n; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

}
