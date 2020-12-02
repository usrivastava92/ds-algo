package com.leet.ds.array;

import org.junit.Assert;

import java.util.stream.IntStream;

public class MaximumRepeatingSubstring {

    public static void main(String[] args) {
        String[] sequences = {"ababc", "bbaabaabaabaaabbbaaabaababbabbaabbabbbabbabbabbbbabaababbbaaaababbbabbaababababbabbbaabbaabbbb", "bbaa", "ababc", "ababc"};
        String[] words = {"ab", "bba", "ba", "ba", "ac"};
        int[] outputs = {2, 3, 1, 1, 0};
        MaximumRepeatingSubstring maximumRepeatingSubstring = new MaximumRepeatingSubstring();
        IntStream.range(0, sequences.length).forEachOrdered(i -> {
            System.out.println("Input : sequence -> " + sequences[i] + ", word -> " + words[i]);
            System.out.println("Output : " + outputs[i]);
            Assert.assertEquals(outputs[i], maximumRepeatingSubstring.maxRepeating(sequences[i], words[i]));
        });
    }

    public int maxRepeating(String sequence, String word) {
        int max = 0;
        if (sequence == null || sequence.trim().length() == 0) {
            return 0;
        }
        sequence = sequence.trim();
        int seqLen = sequence.length();
        int wordLen = word.length();
        char[] seqChar = sequence.toCharArray();
        char[] wordChar = word.toCharArray();
        int i = 0;
        int j = 0;
        while (i < seqLen) {
            int temp = 0;
            int nextStart = -1;
            while (i < seqLen && seqChar[i] == wordChar[j]) {
                if (seqChar[i] == wordChar[0] && j != 0 && nextStart == -1) {
                    nextStart = i;
                }
                i++;
                j++;
                if (j == wordLen) {
                    j = 0;
                    temp++;
                }
            }
            j = 0;
            if (nextStart == -1) {
                if (i < seqLen && seqChar[i] != wordChar[j]) {
                    i++;
                }
            } else {
                i = nextStart;
            }
            max = Math.max(temp, max);
        }
        return max;
    }

}
