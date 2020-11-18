package com.codechef.dsa.week1;/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

public class Lapindrome {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while (n-- > 0) {
            String input = sc.nextLine();
            System.out.println(checkLapindrome(input) ? "YES" : "NO");
        }
        sc.close();
    }

    private static boolean checkLapindrome(String input) {
        int len = input.length();
        int midIndex = len / 2;
        Map<Character, Integer> firstHalf = new HashMap<>();
        Map<Character, Integer> secondHalf = new HashMap<>();
        for (int i = 0; i < midIndex; i++) {
            firstHalf.put(input.charAt(i), firstHalf.getOrDefault(input.charAt(i), 0) + 1);
        }
        if (input.length() % 2 == 0) {
            for (int i = midIndex; i < len; i++) {
                secondHalf.put(input.charAt(i), secondHalf.getOrDefault(input.charAt(i), 0) + 1);
            }
        } else {
            for (int i = midIndex + 1; i < len; i++) {
                secondHalf.put(input.charAt(i), secondHalf.getOrDefault(input.charAt(i), 0) + 1);
            }
        }
        System.out.println("firstHalf -> "+firstHalf);
        System.out.println("secondHalf -> "+secondHalf);
        return firstHalf.equals(secondHalf);
    }
}
