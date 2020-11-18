package com.ib.stackqueue;

import java.util.Arrays;
import java.util.List;

public class RainWaterTrapped {

    public static void main(String... args) {
        RainWaterTrapped rainWaterTrapped = new RainWaterTrapped();
        System.out.println(rainWaterTrapped.trap(Arrays.asList(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)));
    }

    public int trap(final List<Integer> A) {
        int maxToLeft = 0;
        int maxToRight = A.stream().max(Integer::compareTo).get();
        int len = A.size();
        int totalWater = 0;
        for (int i = 0; i < len; i++) {
            Integer curr = A.get(i);
            if (curr < maxToLeft && curr < maxToRight) {
                int temp = maxToLeft < maxToRight ? maxToLeft : maxToRight;
                totalWater += temp- curr;
            }
            if (curr > maxToLeft) {
                maxToLeft = curr;
            }
            if(curr == maxToRight){
                try {
                    maxToRight = A.subList(i+1,len).stream().max(Integer::compareTo).get();
                }catch (Exception e){

                }
            }
        }
        return totalWater;
    }

}
