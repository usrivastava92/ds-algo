package com.leet.ds.dp;


import java.util.HashMap;
import java.util.Map;

public class DivisorGame {

    public static void main(String[] args) {
        DivisorGame divisorGame = new DivisorGame();
        System.out.println(divisorGame.divisorGame(15));
    }

    public boolean divisorGame(int N) {
        Map<Integer, Boolean> dp = new HashMap<>();
        dp.put(0, false);
        dp.put(1, false);
        dp.put(2, true);
        dp.put(3, false);
        for (int i = 3; i <= N; i++) {
            for (int j = (int) Math.sqrt(i); j > 0; j--) {
                if (i % j == 0 && !dp.get(i - j)) {
                    dp.put(i, true);
                    break;
                }
            }
            if (!dp.containsKey(i)) {
                dp.put(i, false);
            }
        }
        return dp.get(N);
    }
}
