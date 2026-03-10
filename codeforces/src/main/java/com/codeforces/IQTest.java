package com.leet.ds.codeforces;

import java.util.Scanner;

public class IQTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] nums = sc.nextLine().split(" ");
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(nums[i]);
        }
        System.out.println(new IQTest().findDifferentParityIndex(values));
        sc.close();
    }

    public int findDifferentParityIndex(int[] values) {
        int countEven = 0;
        int countOdd = 0;
        for (int value : values) {
            if (value % 2 == 0) {
                countEven++;
            } else {
                countOdd++;
            }
        }
        for (int i = 0; i < values.length; i++) {
            if (values[i] % 2 == 0 && countEven == 1) {
                return i + 1;
            }
            if (values[i] % 2 != 0 && countOdd == 1) {
                return i + 1;
            }
        }
        return -1;
    }

}
