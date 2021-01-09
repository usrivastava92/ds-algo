package com.leet.daysofcode.year2021.january.week2;

import org.junit.Assert;

import java.util.*;
import java.util.stream.IntStream;

public class WordLadder {

    public static void main(String[] args) {
        String[] beginWords = {"hit", "hit"};
        String[] endWords = {"cog", "cog"};
        String[][] wordLists = {{"hot", "dot", "dog", "lot", "log", "cog"}, {"hot", "dot", "dog", "lot", "log"}};
        int[] outputs = {5, 0};
        WordLadder wordLadder = new WordLadder();
        IntStream.range(0, beginWords.length).forEachOrdered(i -> {
            System.out.printf("beginWord : %s , endWord : %s , wordList : %s\n", beginWords[i], endWords[i], Arrays.toString(wordLists[i]));
            int output = wordLadder.ladderLength(beginWords[i], endWords[i], Arrays.asList(wordLists[i]));
            System.out.println("output : " + output);
            Assert.assertEquals(outputs[i], output);
        });
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.add(beginWord);
        visited.add(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            for (int i = 0, len = queue.size(); i < len; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return level;
                }
                wordList.forEach(word2 -> {
                    if (!visited.contains(word2) && isSingleDist(word, word2)) {
                        visited.add(word2);
                        queue.add(word2);
                    }
                });
            }
            level++;
        }
        return 0;
    }

    private boolean isSingleDist(String a, String b) {
        if (a.length() != b.length() || a.equals(b)) {
            return false;
        }
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
            if (diff > 1) {
                return false;
            }
        }
        return true;
    }
}
