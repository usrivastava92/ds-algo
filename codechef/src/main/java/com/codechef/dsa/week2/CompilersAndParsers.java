package com.codechef.dsa.week2;

import java.util.ArrayDeque;
import java.util.Scanner;

public class CompilersAndParsers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while (n-- > 0) {
            String expression = sc.nextLine();
            int max = 0;
            int run = 0;
            for (int i = 0, len = expression.length(); i < len; i++) {
                char ch = expression.charAt(i);
                if (ch == '<') {
                    run += 1;
                } else {
                    run -= 1;
                }
                if (run < 0) {
                    break;
                } else if (run == 0) {
                    max = i;
                }
            }
            if (max != 0) {
                max++;
            }
            System.out.println(max);
        }
        sc.close();
    }
}
