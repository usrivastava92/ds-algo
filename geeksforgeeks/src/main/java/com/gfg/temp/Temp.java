package com.gfg.temp;

import java.util.Arrays;

public class Temp {

    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        int sum1 = Arrays.stream(h1).sum();
        int sum2 = Arrays.stream(h2).sum();
        int sum3 = Arrays.stream(h3).sum();
        int len1 = 0;
        int len2 = 0;
        int len3 = 0;
        while (!(sum1 == sum2 && sum2 == sum3)) {
            if (sum1 <= 0 || sum2 <= 0 || sum3 <= 0 || len1 >= h1.length || len2 >= h2.length || len2 >= h2.length) {
                return 0;
            }
            if (sum1 > sum2 && sum1 > sum3) {
                sum1 = sum1 - h1[len1++];
            } else if (sum2 > sum3 && sum2 > sum1) {
                sum2 = sum2 - h2[len2++];
            } else {
                sum3 = sum3 - h3[len3++];
            }
        }
        return sum1;
    }

}
