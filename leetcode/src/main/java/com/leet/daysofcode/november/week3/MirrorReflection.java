package com.leet.daysofcode.november.week3;

import java.util.stream.IntStream;

public class MirrorReflection {

    public static void main(String[] args) {
        int[] ps = {2};
        int[] qs = {1};
        int[] outputs = {2};
        MirrorReflection mirrorReflection = new MirrorReflection();
        IntStream.range(0, ps.length).forEachOrdered(i -> {
            System.out.println("Input : p -> " + ps[i] + " q -> " + qs[i]);
            System.out.println("Output : " + mirrorReflection.mirrorReflection(ps[i], qs[i]));
            System.out.println("Expected : " + outputs[i]);
        });
    }

    public int mirrorReflection(int p, int q) {
        int x = 0;
        int y = 0;
        int tx = p;
        int ty = q;
        while (x % p != 0 || y % p != 0 || (x == 0 && y == 0)) {
            x = x + tx;
            y = y + ty;
            tx *= -1;
            if (y > p || y < 0) {
                ty *= -1;
                if (y > p) {
                    y = p + p - y;
                }
                if (y < 0) {
                    y = -y;
                }
            }
        }
        return getWinningIndex(x, y, p);
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
