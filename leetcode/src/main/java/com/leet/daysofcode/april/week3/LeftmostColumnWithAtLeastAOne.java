package com.leet.daysofcode.april.week3;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LeftmostColumnWithAtLeastAOne {


    public static void main(String[] args) {
        int[][] arr = {{0, 0, 0, 1}, {0, 0, 1, 1}, {0, 1, 1, 1}};
        BinaryMatrix binaryMatrix = new BinaryMatrix(arr);
        Scanner sc = new Scanner(System.in);
        LeftmostColumnWithAtLeastAOne leftmostColumnWithAtLeastAOne = new LeftmostColumnWithAtLeastAOne();
        System.out.println(leftmostColumnWithAtLeastAOne.leftMostColumnWithOne(binaryMatrix));
    }

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> sizeArr = binaryMatrix.dimensions();
        int n = sizeArr.get(0);
        int m = sizeArr.get(1);
        if (n == 0 || m == 0) {
            return -1;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int firstIndexOf1 = -1;
            int temp = m - 1;
            if (binaryMatrix.get(i, temp) == 1) {
                firstIndexOf1 = temp;
                temp = m - 2;
                if (temp > -1) {
                    int low = 0;
                    int high = result != Integer.MAX_VALUE ? result : temp;
                    int val = getFirstIndexOf1(binaryMatrix, i, low, high);
                    if (val != -1 && val < firstIndexOf1) {
                        firstIndexOf1 = val;
                    }
                }
            }
            if (firstIndexOf1 != -1 && firstIndexOf1 < result) {
                result = firstIndexOf1;
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int getFirstIndexOf1(BinaryMatrix binaryMatrix, int rowIndex, int low, int high) {
        int firstIndexOf1 = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid == low) {
                if (binaryMatrix.get(rowIndex, low) == 1) {
                    firstIndexOf1 = low;
                } else if (binaryMatrix.get(rowIndex, high) == 1) {
                    firstIndexOf1 = high;
                }
                break;
            }
            int val = binaryMatrix.get(rowIndex, mid);
            if (val == 0) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return firstIndexOf1;
    }

}

class BinaryMatrix {
    private int[][] arr;

    public BinaryMatrix(int[][] arr) {
        this.arr = arr;
    }

    public int get(int x, int y) {
        return arr[x][y];
    }

    public List<Integer> dimensions() {
        return Arrays.asList(arr.length, arr.length > 0 ? arr[0].length : 0);
    }
}
