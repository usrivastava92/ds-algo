package com.leet.ds.codeforces;

import java.util.Scanner;

public class IQTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] nums = sc.nextLine().split(" ");
        int countEven = 0;
        int countOdd = 0;
        for (int i = 0; i < n; i++) {
            if (Integer.parseInt(nums[i]) % 2 == 0) {
                countEven++;
            } else {
                countOdd++;
            }
        }
        for (int i = 0; i < n; i++) {
            String num = nums[i];
            if (Integer.parseInt(num) % 2 == 0 && countEven == 1) {
                System.out.println(i + 1);
                break;
            } else if (Integer.parseInt(num) % 2 != 0 && countOdd == 1) {
                System.out.println(i + 1);
                break;
            }
        }
        sc.close();
    }

}
