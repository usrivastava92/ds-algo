package com.prep.complexity;

import java.util.Comparator;

public class TimeComplexity {


    public static void main(String[] args) {

    }

    // O(1)
    private int add(int a, int b) {
        return a + b;
    }

    // O(n)
    private int add(int[] arr) {
        int sum = 0; // O(1)
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]; // O(1)*O(n) -> O(n)
        }
        return sum; // O(1)
        // O(1) + O(n) + O(1) -> O(n)
    }

    // O(n^2)
    private int addRep(int[] arr) {
        int sum = 0; // O(1)
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                sum += arr[i];
            } // O(n)*O(n) -> O(n^2)
        }
        return sum; // O(1)
    }

    // O(log2(n))
    private int binarySearch(int[] arr, int target, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return binarySearch(arr, target, low, mid - 1);
        }
        return binarySearch(arr, target, mid + 1, high);
    }

    // O(2^n)
    private int fibonacy(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacy(n - 1) + fibonacy(n - 2);
    }
    /*
             5
        3          4
      1   2     2     3
         0  1  0 1   1  2
                        0 1

      t = O(2^n)

     */

/*
O(1)
O(log(n))
O(n)
O(n*logn)
O(n2)
O(2^n)
*/



/*
    time as function of input :
    1) input ->
    t = f(input)
    x -> x2
    ---------------------
    O - big o
    O(1) -> constant complex
    O(n) ->
    O(n^2) ->
    ---------------------
    int[] arr = new int[4];
    int -> 4 byte
    int array[2] -> 2
    | | | | | | | | | | | | | | | | | | | | | | | | |
    var &* x -> array first index -> 0 + (2*4) -> O(1)

    4GB -> 4*1000*1000*1000*8 -> transistors -> 0/1


    */


}
