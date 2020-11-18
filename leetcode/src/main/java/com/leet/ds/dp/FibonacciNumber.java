package com.leet.ds.dp;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber {

    public static void main(String[] args) {
        int[] inputs = {2, 3, 4};
        FibonacciNumber fibonacciNumber = new FibonacciNumber();

        for (int i = 0; i < inputs.length; i++) {
            System.out.println(inputs[i] + " -> " + fibonacciNumber.fib(inputs[i]));
        }
    }

    Map<Integer, Integer> dp = new HashMap<>();

    {
        dp.put(0, 0);
        dp.put(1, 1);
        dp.put(2, 1);
    }

    public int fib(int N) {
        if (dp.containsKey(N)) {
            return dp.get(N);
        }
        int ans = fib(N - 1) + fib(N - 2);
        dp.put(N, ans);
        return ans;
    }

}
