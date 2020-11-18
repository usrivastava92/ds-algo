package com.ib.bitmanipulation;

import java.util.Arrays;
import java.util.List;

public class SingleNumber {


    public static void main(String... args) {
        SingleNumber singleNumber = new SingleNumber();
        System.out.println(singleNumber.singleNumber(Arrays.asList(new Integer[]{1, 2, 2, 3, 1})));
    }

    public int singleNumber(final List<Integer> A) {
        int num = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            System.out.println(Integer.toBinaryString(num)+"^"+Integer.toBinaryString(A.get(i))+"="+Integer.toBinaryString(num^A.get(i)));
            num ^= A.get(i);
        }
        return num;
    }

}
