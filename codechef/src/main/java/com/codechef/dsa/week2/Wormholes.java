package com.codechef.dsa.week2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Wormholes {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();

        int[][] contests = new int[n][2];
        int[] V = new int[p];
        int[] W = new int[q];

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            contests[i] = new int[]{a, b};
        }

        for (int i = 0; i < p; i++) {
            V[i] = sc.nextInt();
        }
        for (int i = 0; i < q; i++) {
            W[i] = sc.nextInt();
        }

        Arrays.sort(V);
        Arrays.sort(W);

        int min = Integer.MAX_VALUE;
        for (int[] contest : contests) {
            if ((contest[1] - contest[0] + 1) <= min) {
                int vi = p - 1;
                int wi = 0;
                while (vi > -1 && V[vi] > contest[0]) {
                    vi--;
                }
                if (vi != -1) {
                    while (wi < q && W[wi] < contest[1]) {
                        wi++;
                    }
                    if (wi != q) {
                        int temp = W[wi] - V[vi] + 1;
                        if (temp < min) {
                            min = temp;
                        }
                    }
                }
            }
        }
        System.out.println(min);
        sc.close();
    }

}