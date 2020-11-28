package com.gfg.arrays;

public class MaxSumPathInTwoArrays {

    public static void main(String[] args) {
        int[][] As = {{1, 1, 1, 1, 2, 2, 4, 4, 5, 5, 5, 6, 7, 7, 8, 8, 9}};
        int[][] Bs = {{1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9}};
        MaxSumPathInTwoArrays maxSumPathInTwoArrays = new MaxSumPathInTwoArrays();
        for (int i = 0; i < As.length; i++) {
            System.out.println(maxSumPathInTwoArrays.maxPathSum(As[i], Bs[i]));
        }
    }

    private int maxPathSum(int A[], int B[]) {
        int i = 0;
        int j = 0;
        int l1 = A.length;
        int l2 = B.length;
        int sum = 0;
        while (i < l1 && j < l2) {
            System.out.print((A[i] > B[j] ? A[i] : B[j]) + " ");
            sum += (A[i] > B[j] ? A[i] : B[j]);
            i++;
            j++;
        }
        while (i < l1) {
            System.out.print(A[i] + " ");
            sum += A[i];
            i++;
        }
        while (j < l2) {
            System.out.print(B[j] + " ");
            sum += B[j];
            j++;
        }
        return sum;
    }

}
