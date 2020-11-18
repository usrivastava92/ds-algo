package com.leet.ds.dp;

public class FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK {

    public static void main(String[] args) {
        FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK find = new FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK();
        int k = 5;
        int x = 1836311903;
        System.out.println(find.findMinFibonacciNumbers(k));
    }

    int[] fibArr = new int[47];
    int maxIndex = 1;

    public int findMinFibonacciNumbers(int k) {
        fibArr[0] = 1;
        fibArr[1] = 1;
        if (fibArr[maxIndex] < k) {
            generateTillNumLessThanK(k);
        }
        int count = 0;
        while (k != 0) {
            int closestMin = getClosestMin(k);
            k -= closestMin;
            count++;
        }
        return count;
    }

    private int getClosestMin(int target) {
        int low = 0;
        int high = maxIndex;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            long midVal = fibArr[mid];
            if (midVal < target)
                low = mid + 1;
            else if (midVal > target)
                high = mid - 1;
            else
                return fibArr[mid];
        }
        return fibArr[high];
    }

    private void generateTillNumLessThanK(int k) {
        while (fibArr[maxIndex] < k) {
            fibArr[maxIndex + 1] = fibArr[maxIndex] + fibArr[maxIndex - 1];
            maxIndex++;
        }
    }

}
