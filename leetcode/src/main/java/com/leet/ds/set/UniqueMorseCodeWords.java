package com.leet.ds.set;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {

    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        UniqueMorseCodeWords uniqueMorseCodeWords = new UniqueMorseCodeWords();
        System.out.println(uniqueMorseCodeWords.uniqueMorseRepresentations(words));
    }


    private String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> encoded = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char ch : word.toCharArray()) {
                int index = ch - 97;
                sb.append(morse[index]);
            }
            encoded.add(sb.toString());
        }
        return encoded.size();
    }


}
