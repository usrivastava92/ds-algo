package com.ds.utils;

import java.util.Random;

public class NumberUtils {

    public static final Random RANDOM = new Random();

    private NumberUtils() {

    }

    public static boolean isInRangeInclusive(int num, int startInclusive, int endInclusive) {
        return num >= startInclusive && num <= endInclusive;
    }

    public static boolean isInRangeExclusive(int num, int startExclusive, int endExclusive) {
        return num > startExclusive && num < endExclusive;
    }

    public static boolean isInRangeStartInclusive(int num, int startInclusive, int endExclusive) {
        return num >= startInclusive && num < endExclusive;
    }

    public static boolean isInRangeEndInclusive(int num, int startExclusive, int endInclusive) {
        return num > startExclusive && num <= endInclusive;
    }

    public static int getRandomInt() {
        return RANDOM.nextInt();
    }

    public static int getRandomInt(int upperLimitInclusive) {
        return RANDOM.nextInt(++upperLimitInclusive);
    }

    public static int getRandomInt(int lowerLimitInclusive, int upperLimitInclusive) {
        return RANDOM.nextInt((++upperLimitInclusive) - lowerLimitInclusive) + lowerLimitInclusive;
    }

    public static long getRandomLong(long upperLimitInclusive) {
        return (long) (Math.random() * upperLimitInclusive);
    }

    public static long getRandomLong(long lowerLimitInclusive, long upperLimitInclusive) {
        return lowerLimitInclusive + (long) (Math.random() * upperLimitInclusive);
    }

    public static double getRandomDouble(double lowerLimitInclusive, double upperLimitInclusive) {
        return lowerLimitInclusive + new Random().nextDouble() * (upperLimitInclusive - lowerLimitInclusive);
    }

    public static long getNcR(int n, int r) {
        if (n == r || r == 0) {
            return 1;
        }
        long p = 1;
        long k = 1;
        r = Math.min(r, n - r);
        while (r > 0) {
            p *= (n--);
            k *= (r--);
            long gcd = gcd(p, k);
            p /= gcd;
            k /= gcd;
        }
        return p;
    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static int max(int... mins) {
        if (mins.length < 2) {
            throw new IllegalArgumentException("args length can't be less than 2");
        }
        int max = Math.max(mins[0], mins[1]);
        int len = mins.length;
        for (int i = 2; i < len; i++) {
            max = Math.max(max, mins[i]);
        }
        return max;
    }


    public static int min(int... mins) {
        if (mins.length < 2) {
            throw new IllegalArgumentException("args length can't be less than 2");
        }
        int min = Math.min(mins[0], mins[1]);
        int len = mins.length;
        for (int i = 2; i < len; i++) {
            min = Math.min(min, mins[i]);
        }
        return min;
    }

}
