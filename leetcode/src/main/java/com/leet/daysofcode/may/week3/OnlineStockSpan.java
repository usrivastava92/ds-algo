package com.leet.daysofcode.may.week3;

import java.util.*;

public class OnlineStockSpan {

    public static void main(String[] args) {
        int[][] inputs = {{100, 80, 60, 70, 60, 75, 85}, {29, 91, 62, 76, 51}};
        int[][] outputs = {{1, 1, 1, 2, 1, 4, 6}, {1, 2, 1, 2, 1}};
        for (int i = 0; i < inputs.length; i++) {
            StockSpanner S = new StockSpanner();
            int[] input = inputs[i];
            boolean incorrect = false;
            int[] output = new int[input.length];
            for (int j = 0; j < input.length; j++) {
                output[j] = S.next(input[j]);
                if (output[j] != outputs[i][j]) {
                    incorrect = true;
                }
            }
            if (incorrect) {
                System.out.println(Arrays.toString(input) + " : Wrong");
                System.out.println("Correct Output : " + Arrays.toString(outputs[i]));
                System.out.println("Your Output : " + Arrays.toString(output));
            } else {
                System.out.println(Arrays.toString(input) + " : Correct");
            }
        }
    }

}

class StockSpanner {

    private Deque<Stock> stack;

    public StockSpanner() {
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int result = 1;
        while (!stack.isEmpty() && stack.peek().price <= price) {
            result += stack.pop().result;
        }
        stack.push(new Stock(price, result));
        System.out.println(stack);
        return result;
    }

}

class Stock {
    int price;
    int result;

    public Stock(int price, int result) {
        this.price = price;
        this.result = result;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "price=" + price +
                ", result=" + result +
                '}';
    }
}