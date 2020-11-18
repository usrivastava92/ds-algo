package com.ib.arrays;

import com.ds.utils.ArrayUtils;

import java.util.ArrayList;

public class RotateMatrix {

    public static void main(String... args) {
        RotateMatrix rotateMatrix = new RotateMatrix();
        ArrayList<ArrayList<Integer>> sampleMatrix = rotateMatrix.createSampleArrList(4);
        printArrayList(sampleMatrix);
        System.out.println("###########################");
        rotateMatrix.rotate(sampleMatrix);
        printArrayList(sampleMatrix);
        System.out.println("###########################");
        ArrayUtils.printArr(rotateMatrix.sampleResult());
    }

    private static void printArrayList(ArrayList<ArrayList<Integer>> matrix) {
        for(ArrayList<Integer> row : matrix){
            System.out.println(row);
        }
    }

    public ArrayList<ArrayList<Integer>> createSampleArrList(int order) {
        int count = 1;
        ArrayList<ArrayList<Integer>> sampleMatrix = new ArrayList<>();
        for (int i = 0; i < order; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < order; j++) {
                row.add(count);
                count++;
            }
            sampleMatrix.add(row);
        }
        return sampleMatrix;
    }


    public int[][] createSampleMatrix(int order) {
        int count = 1;
        int[][] sampleMatrix = new int[order][order];
        for (int i = 0; i < order; i++) {
            for (int j = 0; j < order; j++) {
                sampleMatrix[i][j] = count;
                count++;
            }
        }
        return sampleMatrix;
    }

    public int[][] sampleResult() {
        return new int[][]{new int[]{13, 9, 5, 1}, new int[]{14, 10, 6, 2}, new int[]{15, 11, 7, 3}, new int[]{16, 12, 8, 4}};
    }


    public void rotate(ArrayList<ArrayList<Integer>> a) {
        int order = a.size();
        for (int i = 0; i < order / 2; i++) {
            for (int j = i; j < order - i - 1; j++) {
                int temp = a.get(i).get(j);
                a.get(i).set(j, a.get(order - 1 - j).get(i));
                a.get(order - 1 - j).set(i, a.get(order - 1 - i).get(order - 1 - j));
                a.get(order - 1 - i).set(order - 1 - j, a.get(j).get(order - 1 - i));
                a.get(j).set(order - 1 - i, temp);
                System.out.println("(" + i + "," + j + ") -> (" + (j) + "," + (order - 1 - i) + ") -> (" + (order - 1 - i) + "," + (order - 1 - j) + ") -> (" + (order - 1 - j) + "," + i + ")");
            }
        }
    }

    //Your Input:4 4 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6
    //[3 9 5 1][4 0 6 2][5 1 7 3][6 2 8 4]

}
