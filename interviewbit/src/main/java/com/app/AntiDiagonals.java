package com.app;

import java.util.ArrayList;

public class AntiDiagonals {

    public static void main(String... args) {
        AntiDiagonals antiDiagonals = new AntiDiagonals();
        antiDiagonals.createMatrix(4);
        antiDiagonals.createAntiDiagIdex(4);
    }

    public void createMatrix(int order) {
        for (int i = 0; i < order; i++) {
            for (int j = 0; j < order; j++) {
                System.out.print("(" + i + "," + j + ") ");
            }
            System.out.println();
        }
    }

    public void createAntiDiagIdex(int order) {
        for (int i = 0; i < order; i++) {
            for (int j = i; j >= 0; j--) {
                String index = i - j + "," + j;
                System.out.println(index);
            }
        }
        System.out.println("####################");
        for (int i = 1; i < order; i++) {
            int x = i;
            int y = order - 1;
            while (x < order && y > -1) {
                String index = x + "," + y;
                System.out.println(index);
                x++;
                y--;
            }
        }
    }

    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        int order = A.size();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < order; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = i; j >= 0; j--) {
                temp.add(A.get(i - j).get(j));
            }
            result.add(temp);
        }
        for (int i = 1; i < order; i++) {
            int x = i;
            int y = order - 1;
            ArrayList<Integer> temp = new ArrayList<>();
            while (x < order && y > -1) {
                temp.add(A.get(x).get(y));
                x++;
                y--;
            }
            result.add(temp);
        }
        return result;
    }
}
