package com.leet.daysofcode.december.week3;

import org.junit.Assert;

import java.util.stream.IntStream;

public class DecodedStringAtIndex {


    public static void main(String[] args) {
        String[] Ss = {"leet2code3", "ha22", "a2345678999999999999999", "y959q969u3hb22odq595"};
        int[] Ks = {10, 5, 1, 222280369};
        String[] outputs = {"o", "h", "a", "y"};
        DecodedStringAtIndex decodedStringAtIndex = new DecodedStringAtIndex();
        IntStream.range(0, Ss.length).forEachOrdered(i -> {
            System.out.println("Input -> S : " + Ss[i] + " K : " + Ks[i]);
            String output = decodedStringAtIndex.decodeAtIndex(Ss[i], Ks[i]);
            System.out.println("Output : " + output);
            Assert.assertEquals(outputs[i], output);
        });
    }

    public String decodeAtIndex(String S, int K) {
        long size = 0;
        int N = S.length();

        // Find size = length of decoded string
        for (int i = 0; i < N; ++i) {
            char c = S.charAt(i);
            if (Character.isDigit(c)) {
                size *= c - '0';
            } else {
                size++;
            }
        }

        for (int i = N - 1; i >= 0; --i) {
            char c = S.charAt(i);
            K %= size;
            if (K == 0 && Character.isLetter(c)) {
                return Character.toString(c);
            }
            if (Character.isDigit(c)) {
                size /= c - '0';
            } else {
                size--;
            }
        }

        throw null;
    }
}
