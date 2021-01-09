package com.leet.daysofcode.year2020.july.week1;

public class HammingDistance {

    public static void main(String[] args) {
        int[] xs = {1,3};
        int[] ys = {4,1};
        int[] outputs = {2,1};
        HammingDistance hammingDistance = new HammingDistance();
        for (int i = 0; i < xs.length; i++) {
            System.out.println("Input : x->" + xs[i] + " y->" + ys[i]);
            System.out.println("Output : " + hammingDistance.hammingDistance(xs[i], ys[i]));
            System.out.println("Expected : " + outputs[i]);
        }
    }

    public int hammingDistance(int x, int y) {
        int distance = 0;
        while (x > 0 && y > 0) {
            int bitx = x % 2;
            int bity = y % 2;
            if (bitx != bity) {
                distance++;
            }
            x = x / 2;
            y = y / 2;
        }
        while (x > 0) {
            int bitx = x % 2;
            if (bitx != 0) {
                distance++;
            }
            x = x / 2;
        }
        while (y > 0) {
            int bity = y % 2;
            if (bity != 0) {
                distance++;
            }
            y = y / 2;
        }
        return distance;
    }

}
