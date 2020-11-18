package com.leet.ds.misc;

import java.util.HashMap;
import java.util.Map;

public class IntegerToEnglishWords {

    public static void main(String[] args) {
        int[] inputs = {0, 123, 12345, 1234567, 1234567891, Integer.MAX_VALUE, 111, 100,1000,100000};
        String[] outputs = {
                "Zero",
                "One Hundred Twenty Three",
                "Twelve Thousand Three Hundred Forty Five",
                "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven",
                "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One",
                "Two Billion One Hundred Forty Seven Million Four Hundred Eighty Three Thousand Six Hundred Forty Seven",
                "One Hundred Eleven",
                "One Hundred",
                "One Thousand",
                "One Hundred Thousand"
        };
        IntegerToEnglishWords integerToEnglishWords = new IntegerToEnglishWords();
        for (int i = 0; i < inputs.length; i++) {
            System.out.println("Input : " + inputs[i]);
            System.out.println("Output : " + integerToEnglishWords.numberToWords(inputs[i]));
            System.out.println("Expected : " + outputs[i]);
            System.out.println("######################################");
        }
    }

    Map<Integer, String> words = new HashMap<>();

    {
        words.put(0, "Zero");
        words.put(1, "One");
        words.put(2, "Two");
        words.put(3, "Three");
        words.put(4, "Four");
        words.put(5, "Five");
        words.put(6, "Six");
        words.put(7, "Seven");
        words.put(8, "Eight");
        words.put(9, "Nine");
        words.put(10, "Ten");
        words.put(11, "Eleven");
        words.put(12, "Twelve");
        words.put(13, "Thirteen");
        words.put(14, "Fourteen");
        words.put(15, "Fifteen");
        words.put(16, "Sixteen");
        words.put(17, "Seventeen");
        words.put(18, "Eighteen");
        words.put(19, "Nineteen");
        words.put(20, "Twenty");
        words.put(30, "Thirty");
        words.put(40, "Forty");
        words.put(50, "Fifty");
        words.put(60, "Sixty");
        words.put(70, "Seventy");
        words.put(80, "Eighty");
        words.put(90, "Ninety");
    }


    Map<Integer, String> segmentMap = new HashMap<>();

    {
        segmentMap.put(0, "Billion");
        segmentMap.put(1, "Million");
        segmentMap.put(2, "Thousand");
    }

    public String numberToWords(int num) {
        if (words.containsKey(num)) {
            return words.get(num);
        }
        int[] segments = new int[4];
        StringBuilder sb = new StringBuilder();
        int temp = 0;
        int counter = 1;
        int segmentIndex = 3;
        int multiplier = 1;
        while (num > 0) {
            int digit = num % 10;
            temp += digit * multiplier;
            multiplier *= 10;
            num = num / 10;
            if (counter == 3) {
                segments[segmentIndex--] = temp;
                counter = 0;
                temp = 0;
                multiplier = 1;
            }
            counter++;
        }
        segments[segmentIndex--] = temp;
        for (int i = 0, len = segments.length - 1; i < len; i++) {
            if (segments[i] != 0) {
                sb.append(getHundredsValue(segments[i]));
                sb.append(" ");
                sb.append(segmentMap.get(i));
                sb.append(" ");
            }
        }
        if (segments[3] != 0) {
            sb.append(getHundredsValue(segments[3]));
        }
        return sb.toString().trim();
    }

    private String getHundredsValue(int n) {
        if (words.containsKey(n)) {
            return words.get(n);
        }
        int hundreds = n / 100;
        n = n % 100;
        StringBuilder sb = new StringBuilder();
        if (hundreds > 0) {
            sb.append(words.get(hundreds));
            sb.append(" Hundred");
        }
        if (n == 0) {
            return sb.toString();
        }
        if (words.containsKey(n)) {
            sb.append(" ");
            sb.append(words.get(n));
            return sb.toString();
        }
        int tens = n / 10;
        n = n % 10;
        int ones = n;
        if (tens > 0) {
            sb.append(" ");
            sb.append(words.get(tens * 10));
        }
        if (ones > 0) {
            sb.append(" ");
            sb.append(words.get(ones));
        }
        return sb.toString().trim();
    }
}
