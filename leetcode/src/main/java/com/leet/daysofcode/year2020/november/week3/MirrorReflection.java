package com.leet.daysofcode.year2020.november.week3;

import java.util.stream.IntStream;

public class MirrorReflection {

    public static void main(String[] args) {
        int[] ps = {2, 4};
        int[] qs = {1, 2};
        int[] outputs = {2, 2};
        MirrorReflection mirrorReflection = new MirrorReflection();
        IntStream.range(0, ps.length).forEachOrdered(i -> {
            System.out.println("Input : p -> " + ps[i] + " q -> " + qs[i]);
            System.out.println("Output : " + mirrorReflection.mirrorReflection(ps[i], qs[i]));
            System.out.println("Expected : " + outputs[i]);
        });
    }

    public int mirrorReflection(int p, int q) {
        int gcd = gcd(p, q);
        boolean xIsEven = (p / gcd) % 2 == 0;
        boolean yIsEven = (q / gcd) % 2 == 0;
        if (xIsEven && !yIsEven) {
            return 2;
        }
        if (!xIsEven && !yIsEven) {
            return 1;
        }
        if (!xIsEven && yIsEven) {
            return 0;
        }
        return 3;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    private int getWinningIndex(float x, float y, int p) {
        if (x == 0 && y == p) {
            return 2;
        } else if (x == p && y == p) {
            return 1;
        } else if (x == p && y == 0) {
            return 0;
        }
        return -1;
    }

}
