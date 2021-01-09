package com.leet.daysofcode.year2020.april.week1;


public class BestTimeToBuyAndSellStockII {

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        BestTimeToBuyAndSellStockII bestTimeToBuyAndSellStockII = new BestTimeToBuyAndSellStockII();
        System.out.println(bestTimeToBuyAndSellStockII.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i=0,len=prices.length-1;i<len;i++){
            if(prices[i]<prices[i+1]){
                profit += prices[i+1]-prices[i];
            }
        }
        return profit;
    }
}
