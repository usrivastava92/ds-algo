package com.leet.daysofcode.year2020.november.week3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class NumbersAtMostNGivenDigitSet {

    public static void main(String[] args) {
        String[][] digits = {{"1", "3", "5", "7"}, {"1", "4", "9"}, {"7"}, {"0", "1", "2", "3", "4", "5", "6", "7", "8"}, {"0", "1", "2", "3", "4", "5", "7", "8"}, {"5", "7", "8"}, {"3", "4", "5", "6"}, {"1", "2", "3", "4", "6", "7", "9"}};
        int[] n = {100, 1000000000, 8, 6, 6, 59, 64, 333};
        int[] outputs = {20, 29523, 1, 7, 6, 6, 18, 171};
        NumbersAtMostNGivenDigitSet numbersAtMostNGivenDigitSet = new NumbersAtMostNGivenDigitSet();
        IntStream.range(0, digits.length).forEachOrdered(i -> {
            System.out.println("Input : digits -> " + Arrays.toString(digits[i]) + " n -> " + n[i]);
            System.out.println("Output : " + numbersAtMostNGivenDigitSet.atMostNGivenDigitSet(digits[i], n[i]));
            System.out.println("Expected : " + outputs[i]);
        });
    }

    public int atMostNGivenDigitSet(String[] digits, int n) {
        if (digits == null || digits.length == 0) {
            return 0;
        }
        Comparator<String> comparator = Comparator.comparingInt(Integer::parseInt);
        Arrays.sort(digits, comparator);
        boolean contains0 = digits[0].equals("0");
        String[] targetDigits = String.valueOf(n).split("");
        int len = targetDigits.length;
        int count = 0;
        for (int i = 1; i <= len; i++) {
            if (i == len) {
                int numsLessOrEqualToFinalDigit = getNumberOfDigitsLessThanOrEqualTo(digits, comparator, targetDigits[0]);
                if (numsLessOrEqualToFinalDigit > 0) {
                    boolean containsFirstDigit = Arrays.binarySearch(digits, targetDigits[0], comparator) >= 0;
                    if (containsFirstDigit) {
                        if (contains0) {
                            count += (numsLessOrEqualToFinalDigit - 2) * (Math.pow(digits.length, i - 1));
                        } else {
                            count += (numsLessOrEqualToFinalDigit - 1) * Math.pow(digits.length, i - 1);
                        }
                        int lastNum = 1;
                        for (int temp = 1; temp < i; temp++) {
                            lastNum *= getNumberOfDigitsLessThanOrEqualTo(digits, comparator, targetDigits[temp]);
                            if (lastNum == 0) {
                                break;
                            }
                        }
                        count += lastNum;
                    } else {
                        if (contains0) {
                            count += (numsLessOrEqualToFinalDigit - 1) * (Math.pow(digits.length, i - 1));
                        } else {
                            count += numsLessOrEqualToFinalDigit * Math.pow(digits.length, i - 1);
                        }
                    }
                }
            } else if (i == 1) {
                count += digits.length;
            } else {
                if (contains0) {
                    count += (digits.length - 1) * (Math.pow(digits.length, i - 1));
                } else {
                    count += Math.pow(digits.length, i);
                }
            }
        }
        return count;
    }

    private <T> int getNumberOfDigitsLessThanOrEqualTo(T[] digits, Comparator<T> comparator, T target) {
        int index = Arrays.binarySearch(digits, target, comparator);
        if (index < 0) {
            index = -(index + 1);
        } else {
            index++;
        }
        return index;
    }

}
