package com.leet.ds.dp;

public class BestTimeToBuyAndSellStock {


    public static void main(String[] args) {
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(bestTimeToBuyAndSellStock.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {

        int max = 0;
        int minSoFar = Integer.MAX_VALUE;
        for (int i = 0, len = prices.length; i < len; i++) {
            if (prices[i] < minSoFar) {
                minSoFar = prices[i];
            } else {
                max = Math.max(max, prices[i] - minSoFar);
            }
        }
        return max;

    }
}
