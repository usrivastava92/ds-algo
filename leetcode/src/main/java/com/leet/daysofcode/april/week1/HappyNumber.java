package com.leet.daysofcode.april.week1;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> nums = new HashSet<>();
        nums.add(n);
        while (true) {
            int num = 0;
            while (n > 0) {
                int x = n % 10;
                num += (x * x);
                n = n / 10;
            }
            if (num == 1) {
                return true;
            } else {
                if (nums.contains(num)) {
                    return false;
                } else {
                    n = num;
                    nums.add(num);
                }
            }
        }
    }


    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        System.out.println(happyNumber.isHappy(10));
    }
}
