package com.ib.dp;

import java.util.HashMap;
import java.util.Map;

public class Stairs {

    public static void main(String[] args) {
        Stairs stairs = new Stairs();
        System.out.println(stairs.climbStairs(10));
    }

    private Map<Integer, Integer> map = new HashMap<>();

    public int climbStairs(int A) {
        map.clear();
        map.put(A - 1, 1);
        map.put(A - 2, 2);
        return helper(0, A);
    }

    public int helper(int i, int A) {
        if (i > A) {
            return 0;
        }
        if (i == A) {
            return 1;
        }
        int nextStair = i + 1;
        int nextToNext = i + 2;
        Integer a = map.get(nextStair);
        Integer b = map.get(nextToNext);
        if (a == null) {
            a = helper(nextStair, A);
        }
        if (b == null) {
            b = helper(nextToNext, A);
        }
        int ans = a + b;
        map.put(i, ans);
        return ans;
    }

}
