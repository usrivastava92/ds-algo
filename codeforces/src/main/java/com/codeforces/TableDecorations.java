package com.codeforces;

import java.util.PriorityQueue;
import java.util.Scanner;

public class TableDecorations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int r = scanner.nextInt();
        int g = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(combinations(r, g, b));

        scanner.close();
    }

    public static int combinations(int r, int g, int b) {
        if (r == g && r == b) {
            return r;
        }
        int count = 0;
        if (r > 0 && g > 0 && b > 0) {
            int min = Math.min(r, Math.min(g, b));
            count = min;
            r -= min;
            g -= min;
            b -= min;
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((i, j) -> Integer.compare(j[0], i[0]));
        if (r > 0) {
            maxHeap.add(new int[]{r});
        }
        if (g > 0) {
            maxHeap.add(new int[]{g});
        }
        if (b > 0) {
            maxHeap.add(new int[]{b});
        }
        while (maxHeap.size() > 1) {
            int[] x = maxHeap.poll();
            int[] y = maxHeap.poll();
            int t = Math.min(x[0] - y[0], y[0]);
            if (t == 0) {
                int quo = x[0] / 3;
                int rem = x[0] % 3;
                count += (quo * 2) + (rem == 2 ? 1 : 0);
                break;
            }
            x[0] = x[0] - 2 * t;
            y[0] = y[0] - t;
            count += t;
            if (x[0] > 0) {
                maxHeap.add(x);
            }
            if (y[0] > 0) {
                maxHeap.add(y);
            }
        }
        return count;
    }


}
