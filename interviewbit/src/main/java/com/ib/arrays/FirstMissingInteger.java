package com.ib.arrays;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstMissingInteger {

    public static void main(String... args) {
        FirstMissingInteger firstMissingInteger = new FirstMissingInteger();
        Integer[] nums = new Integer[]{1, 2, 0};
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(1);
        arr.add(0);
        System.out.println(firstMissingInteger.firstMissingPositive(Arrays.asList(nums)));
    }


    public int firstMissingPositive(List<Integer> A) {
       return 1;
    }
}
