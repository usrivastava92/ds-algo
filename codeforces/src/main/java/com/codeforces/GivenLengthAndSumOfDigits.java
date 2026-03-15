package com.codeforces;

import java.util.Scanner;

public class GivenLengthAndSumOfDigits {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int m = sc.nextInt();
    int s = sc.nextInt();
    System.out.println(new GivenLengthAndSumOfDigits().findMinAndMax(m, s));
    sc.close();
  }

  public String findMinAndMax(int m, int s) {
    if (m == 1 && s == 0) {
      return "0 0";
    }
    if (s < 1 || s > (m * 9)) {
      return "-1 -1";
    }

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

    StringBuilder min = new StringBuilder();
    StringBuilder max = new StringBuilder();
    for (int i : minNum) {
      min.append(i);
    }
    for (int i : maxNum) {
      max.append(i);
    }
    return min + " " + max;
  }
}
