package com.codechef.dsa.week2;

import java.util.Scanner;

public class ChefAndStreetFood {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int n = sc.nextInt();
            int max = 0;
            while (n-- > 0) {
                int s = sc.nextInt();
                int p = sc.nextInt();
                int v = sc.nextInt();
                int profit = 0;
                int includingChefShop = s + 1;
                profit = (p / includingChefShop) * v;
                if (profit > max) {
                    max = profit;
                }
            }
            System.out.println(max);
        }
        sc.close();
    }
}
