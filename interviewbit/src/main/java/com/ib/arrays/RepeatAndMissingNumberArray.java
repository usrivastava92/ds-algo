package com.ib.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RepeatAndMissingNumberArray {

    public static void main(String[] args) {
        int[][] inputs = {{3, 1, 2, 5, 3}};
        RepeatAndMissingNumberArray repeatAndMissingNumberArray = new RepeatAndMissingNumberArray();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(inputs[i]));
            System.out.println("output : " + repeatAndMissingNumberArray.repeatedNumber(Arrays.stream(inputs[i]).boxed().collect(Collectors.toList())));
        });
    }

    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (A == null || A.isEmpty()) {
            return ans;
        }
        long n = A.size();
        long sumTillN = (n * (n + 1)) / 2;
        long squareSumTillN = (n * (n + 1) * (2 * n + 1)) / 6;
        long sum = A.stream().mapToLong(i -> i).sum();
        long squareSum = A.stream().mapToLong(i -> {
            long num = i;
            return num * num;
        }).sum();
        long aMinusB = sumTillN - sum;
        long aSquareMinusBSquare = squareSumTillN - squareSum;
        long aPlusB = aSquareMinusBSquare / aMinusB;
        long a = (aPlusB + aMinusB) / 2;
        long b = aPlusB - a;
        if (A.contains((int) a)) {
            ans.add((int) a);
            ans.add((int) b);
        } else {
            ans.add((int) b);
            ans.add((int) a);
        }
        return ans;
    }

}
