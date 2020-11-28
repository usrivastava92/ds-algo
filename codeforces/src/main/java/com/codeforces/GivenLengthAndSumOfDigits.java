package com.leet.ds.codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class GivenLengthAndSumOfDigits {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int s = sc.nextInt();

        if (m == 1 && s == 0) {
            System.out.println(0 + " " + 0);
        } else if (s < 1 || s > (m * 9)) {
            System.out.println(-1 + " " + -1);
        } else {
            int[] maxNum = new int[m];
            int[] minNum = new int[m];

            int tempSum = s;
            for (int i = 0; i < m; i++) {
                for (int j = 9; j > -1; j--) {
                    if (tempSum - j >= 0) {
                        tempSum -= j;
                        maxNum[i] = j;
                        break;
                    }
                }
            }

            tempSum = s;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < 10; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    if (tempSum - j >= 0 && tempSum - j <= (9 * (m - i - 1))) {
                        tempSum -= j;
                        minNum[i] = j;
                        break;
                    }
                }
            }


            for (int i : minNum) {
                System.out.print(i);
            }
            System.out.print(" ");
            for (int i : maxNum) {
                System.out.print(i);
            }
            System.out.println();
        }

        sc.close();
    }

}
