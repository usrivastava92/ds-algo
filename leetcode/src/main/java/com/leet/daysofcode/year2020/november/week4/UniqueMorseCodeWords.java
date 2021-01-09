package com.leet.daysofcode.year2020.november.week4;

import java.util.*;
import java.util.stream.IntStream;

public class UniqueMorseCodeWords {


    private static final Map<Character, String> morseMap = new HashMap<>();

    static {
        morseMap.put('a', ".-");
        morseMap.put('b', "-...");
        morseMap.put('c', "-.-.");
        morseMap.put('d', "-..");
        morseMap.put('e', ".");
        morseMap.put('f', "..-.");
        morseMap.put('g', "--.");
        morseMap.put('h', "....");
        morseMap.put('i', "..");
        morseMap.put('j', ".---");
        morseMap.put('k', "-.-");
        morseMap.put('l', ".-..");
        morseMap.put('m', "--");
        morseMap.put('n', "-.");
        morseMap.put('o', "---");
        morseMap.put('p', ".--.");
        morseMap.put('q', "--.-");
        morseMap.put('r', ".-.");
        morseMap.put('s', "...");
        morseMap.put('t', "-");
        morseMap.put('u', "..-");
        morseMap.put('v', "...-");
        morseMap.put('w', ".--");
        morseMap.put('x', "-..-");
        morseMap.put('y', "-.--");
        morseMap.put('z', "--..");
    }

    public static void main(String[] args) {
        String[][] inputs = {{"gin", "zen", "gig", "msg"}};
        int[] outputs = {2};
        UniqueMorseCodeWords uniqueMorseCodeWords = new UniqueMorseCodeWords();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(inputs[i]));
            System.out.println("Output : " + uniqueMorseCodeWords.uniqueMorseRepresentations(inputs[i]));
            System.out.println("Expected : " + outputs[i]);
        });
    }

    public int uniqueMorseRepresentations(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Character character : word.toCharArray()) {
                stringBuilder.append(morseMap.get(character));
            }
            set.add(stringBuilder.toString());
        }
        return set.size();
    }

}
