package com.codechef.dsa.week3;

import com.codechef.utility.Reader;

import java.io.IOException;


public class DistinctPairs {

    public static void main(String[] args) throws IOException {

        Reader reader = new Reader();

        int n = reader.nextInt();
        int m = reader.nextInt();

        int minElementIndexA = 0;
        int minElementA = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int num = reader.nextInt();
            if (num < minElementA) {
                minElementA = num;
                minElementIndexA = i;
            }
        }

        int maxElementIndexB = 0;
        int maxElementB = Integer.MIN_VALUE;
        for (int j = 0; j < m; j++) {
            int num = reader.nextInt();
            if (num > maxElementB) {
                maxElementB = num;
                maxElementIndexB = j;
            }
            System.out.println(minElementIndexA + " " + j);
        }

        for (int i = 0; i < n; i++) {
            if (i != minElementIndexA) {
                System.out.println(i + " " + maxElementIndexB);
            }
        }

        reader.close();

    }

}