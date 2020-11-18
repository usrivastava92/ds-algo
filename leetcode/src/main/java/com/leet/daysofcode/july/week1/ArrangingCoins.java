package com.leet.daysofcode.july.week1;

public class ArrangingCoins {

    public static void main(String[] args) {
        Integer[] inputs = {-1, 5, 8, 1804289383};
        Integer[] outputs = {0, 2, 3, 60070};
        ArrangingCoins arrangingCoins = new ArrangingCoins();
        for (int i = 0, len = inputs.length; i < len; i++) {
            System.out.println("Input : " + inputs[i]);
            System.out.println("Output : " + arrangingCoins.arrangeCoins(inputs[i]));
            System.out.println("Expected Output : " + outputs[i]);
        }
    }

    public int arrangeCoins(int n) {
        if (n <= 0) {
            return 0;
        }
        return (int) (Math.sqrt(0.25 + (2 * (long) n)) - 0.5);
    }
}
