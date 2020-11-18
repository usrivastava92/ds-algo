package com.codechef.dsa.week2;

import java.math.BigInteger;
import java.util.*;

public class ChefsInQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().trim().split(" ");
        int n = Integer.parseInt(input[0]);
        int ord = Integer.parseInt(input[1]);
        long mod = 1000000007;
        long ans = 1;
        Stack<long[]> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            long[] element = new long[]{sc.nextLong(), i};
            while (!s.empty() && s.peek()[0] > element[0]) {
                ans = (ans * (i - s.pop()[1] + 1)) % mod;
            }
            s.push(element);
        }
        System.out.println(ans);
        sc.close();
    }


}