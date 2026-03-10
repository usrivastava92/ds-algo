package com.ib.arrays;

import java.util.ArrayList;
import java.util.List;

public class RepeatAndMissingNumberArray {

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
