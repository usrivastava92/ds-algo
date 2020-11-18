package com.gfg.arrays;

import java.util.Scanner;

public class SortedMatrix {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while(testCases-- > 0){
            int len = sc.nextInt();
            int[][] matrix = new int[len][len];
            for(int i=0;i<len;i++){
                for(int j=0;j<len;j++){
                    matrix[i][j] = sc.nextInt();
                }
            }
            for(int i=0,size=len*len;i<size;i++){
                System.out.print(getMin(matrix,len)+" ");
            }
        }
        sc.close();
    }
    private static int getMin(int[][] matrix,int size) {
        int min = matrix[0][0];
        pullMin(matrix,0,0,size);
        return min;
    }

    private static void pullMin(int[][] matrix, int i, int j, int size) {
        int right = j + 1 < size ? matrix[i][j + 1] : Integer.MAX_VALUE;
        int down = i + 1 < size ? matrix[i + 1][j] : Integer.MAX_VALUE;
        if (right == Integer.MAX_VALUE && down == Integer.MAX_VALUE) {
            return;
        }
        if (right < down) {
            matrix[i][j] = right;
            pullMin(matrix, i, j + 1, size);
        } else {
            matrix[i][j] = down;
            pullMin(matrix, i + 1, j, size);
        }
    }
}
