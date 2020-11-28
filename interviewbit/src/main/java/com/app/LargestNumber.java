package com.app;

import java.util.*;
import java.util.stream.Collectors;

public class LargestNumber {

    public static void main(String... args) {
        LargestNumber largestNumber = new LargestNumber();
        Integer[] arr = new Integer[]{0,0,0,0};
        System.out.println(largestNumber.largestNumber(Arrays.asList(arr)));
    }

    public String largestNumber(final List<Integer> A, String a) {
        String num = "";
        int size = A.size();
        List<Integer> indexAttended = new ArrayList<>();
        Integer largestIndex = -1;
        Integer largestElement = -1;
        while (indexAttended.size() != size) {
            for (Integer i = 0; i < size; i++) {
                if (!indexAttended.contains(i)) {
                    Integer element = A.get(i);
                    if (i == 0) {
                        largestIndex = i;
                        largestElement = element;
                    } else {
                        if (compareNos(String.valueOf(largestElement), String.valueOf(element)) < 0) {
                            largestIndex = i;
                            largestElement = element;
                        }
                    }
                }
            }
            indexAttended.add(largestIndex);
            num += largestElement;
        }
        return num;
    }

    public String largestNumber(final List<Integer> A) {
        List<String> temp = new ArrayList<>();
        for (Integer a : A) {
            temp.add(String.valueOf(a));
        }
        Collections.sort(temp, new Comparator<String>() {
            public int compare(String X, String Y) {
                String XY = X + Y;
                String YX = Y + X;
                return XY.compareTo(YX) > 0 ? -1 : 1;
            }
        });
        return formatNumber(String.join("", temp));
    }

    public String formatNumber(String A) {
        while (A.charAt(0) == '0' && A.length() > 1) {
            A = A.substring(1);
        }
        return A;
    }

    private int comparator(String a, String b) {
        String ab = a + b;
        String ba = b + a;
        return ab.compareTo(ba) > 0 ? -1 : 1;
    }

    private int compareNos(String a, String b) {

        if (a.charAt(0) == '+') {
            a = a.substring(1);
        }

        if (b.charAt(0) == '+') {
            b = b.substring(1);
        }
        int multiplier = 1;
        if (a.charAt(0) == '-' && b.charAt(0) != '-') {
            return -1;
        } else if (a.charAt(0) != '-' && b.charAt(0) == '-') {
            return 1;
        } else if (a.charAt(0) == '-' && b.charAt(0) == '-') {
            a = a.substring(1);
            b = b.substring(1);
            multiplier = -1;
        }

        while (a.charAt(0) == '0' && a.length() > 1) {
            a = a.substring(1);
        }

        while (b.charAt(0) == '0' && b.length() > 1) {
            b = b.substring(1);
        }

        int aLen = a.length();
        int bLen = b.length();

        if (aLen > bLen) {
            return multiplier * 1;
        } else if (bLen > aLen) {
            return multiplier * -1;
        } else {
            for (int i = 0; i < aLen; i++) {
                int aVal = Integer.parseInt(a.substring(i, i + 1));
                int bVal = Integer.parseInt(b.substring(i, i + 1));
                if (aVal > bVal) {
                    return multiplier * 1;
                } else if (bVal > aVal) {
                    return multiplier * -1;
                }
            }
            return multiplier * 0;
        }
    }
}
