package com.leet.ds.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class FindCommonCharacters {

    public static void main(String[] args) {
        String[][] inputs = {{"bella", "label", "roller"}, {"cool", "lock", "cook"}};
        List<List<String>> outputs = new ArrayList<>();
        outputs.add(Arrays.asList("e", "l", "l"));
        outputs.add(Arrays.asList("c", "o"));

        FindCommonCharacters findCommonCharacters = new FindCommonCharacters();
        for (int i = 0; i < inputs.length; i++) {
            System.out.println(Arrays.toString(inputs[i]) + " -> " + findCommonCharacters.commonChars(inputs[i]));
        }

    }

    public List<String> commonChars(String[] A) {
        List<String> list = new ArrayList<>();
        if (A == null || A.length == 0) {
            return list;
        }

        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);

        for (String s : A) {
            int[] cnt = new int[26];
            s.chars().forEach(i -> cnt[i - 'a']++);
            IntStream.range(0, 26).forEach(i -> count[i] = Math.min(count[i], cnt[i]));
        }

        for (int i = 0; i < 26; i++) {
            String ch = String.valueOf((char) (i + 'a'));
            while (count[i]-- > 0) {
                list.add(ch);
            }
        }

        return list;
    }


}
