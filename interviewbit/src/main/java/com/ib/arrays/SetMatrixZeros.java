package com.ib.arrays;

import java.util.ArrayList;

public class SetMatrixZeros {

    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        if (a == null || a.isEmpty()) {
            return;
        }
        int rowLen = a.size();
        int colLen = a.get(0).size();
        boolean firstRow = false;
        boolean firstColumn = false;
        for (int i = 0; i < rowLen; i++) {
            if (a.get(i).get(0) == 0) {
                firstColumn = true;
                break;
            }
        }
        for (int j = 0; j < colLen; j++) {
            if (a.get(0).get(j) == 0) {
                firstRow = true;
                break;
            }
        }
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (a.get(i).get(j) == 0) {
                    a.get(0).set(j, 0);
                    a.get(i).set(0, 0);
                }
            }
        }
        for (int i = 1; i < rowLen; i++) {
            for (int j = 1; j < colLen; j++) {
                if (a.get(i).get(0) == 0 || a.get(0).get(j) == 0) {
                    a.get(i).set(j, 0);
                }
            }
        }
        if (firstColumn) {
            for (int i = 0; i < rowLen; i++) {
                a.get(i).set(0, 0);
            }
        }
        if (firstRow) {
            for (int j = 0; j < colLen; j++) {
                a.get(0).set(j, 0);
            }
        }
    }


}
