package com.leet.daysofcode.june.week1;

import com.ds.utils.ArrayUtils;

import java.util.Arrays;

public class TwoCityScheduling {

    public static void main(String[] args) {
        int[][][] inputs = {{{10, 20}, {30, 200}, {400, 50}, {30, 20}}};
        int[] outputs = {110};
        TwoCityScheduling twoCityScheduling = new TwoCityScheduling();
        for (int i = 0; i < inputs.length; i++) {
            System.out.println("Input : " + ArrayUtils.toString(inputs[i]));
            System.out.println("Output : " + twoCityScheduling.twoCitySchedCost(inputs[i]));
            System.out.println("Expected : " + outputs[i]);
            System.out.println("###############################################");
        }
    }

    public int twoCitySchedCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        Arrays.sort(costs, (i, j) -> Integer.compare(j[1] - j[0],i[1] - i[0]));
        int sum = 0;
        int n = costs.length/2;
        for(int i=0;i<n;i++){
            sum += costs[i][0];
        }
        for(int i=n;i<costs.length;i++){
            sum += costs[i][1];
        }
        return sum;
    }

}
