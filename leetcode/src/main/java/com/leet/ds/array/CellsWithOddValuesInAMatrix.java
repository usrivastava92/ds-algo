package com.leet.ds.array;

public class CellsWithOddValuesInAMatrix {

    public static void main(String[] args) {
        CellsWithOddValuesInAMatrix cellsWithOddValuesInAMatrix = new CellsWithOddValuesInAMatrix();
        int[][] indices = {{0, 1}, {1, 1}};
        int n = 2;
        int m = 3;
        System.out.println(cellsWithOddValuesInAMatrix.oddCells(n, m, indices));
    }


    public int oddCells(int n, int m, int[][] indices) {
        int[][] arr = new int[n][m];
        for (int[] index : indices) {
            for (int i = 0; i < m; i++) {
                arr[index[0]][i]++;
            }
            for (int i = 0; i < n; i++) {
                arr[i][index[1]]++;
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] % 2 == 1) {
                    count++;
                }
            }
        }

        return count;
    }

}
