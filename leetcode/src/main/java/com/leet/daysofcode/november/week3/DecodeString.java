package com.leet.daysofcode.november.week3;

import java.util.Stack;
import java.util.stream.IntStream;

public class DecodeString {

    public static void main(String[] args) {
        String[] inputs = {"3[a]2[bc]", "3[a2[c]]", "2[abc]3[cd]ef", "abc3[cd]xyz", "100[leetcode]"};
        String[] outputs = {"aaabcbc", "accaccacc", "abcabccdcdcdef", "abccdcdcdxyz", "leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode"};
        DecodeString decodeString = new DecodeString();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + inputs[i]);
            System.out.println("Output : " + decodeString.decodeString(inputs[i]));
            System.out.println("Expected : " + outputs[i]);
        });
    }

    public String decodeString(String s) {
        if (s == null || s.trim().length() == 0) {
            return "";
        }
        Stack<Integer> numberStack = new Stack<>();
        Stack<Character> characterStack = new Stack<>();
        int num = 0;
        for (Character ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = (num * 10) + Character.getNumericValue(ch);
            } else if (ch.equals('[')) {
                numberStack.push(num);
                num = 0;
                characterStack.push(ch);
            } else if (ch >= 'a' && ch <= 'z') {
                characterStack.push(ch);
            } else if (ch.equals(']')) {
                StringBuilder temp = new StringBuilder();
                while (characterStack.peek() != '[') {
                    temp.insert(0, characterStack.pop());
                }
                characterStack.pop();
                int times = numberStack.pop();
                StringBuilder multipleString = new StringBuilder();
                while (times-- > 0) {
                    multipleString.append(temp);
                }
                for (Character tempCh : multipleString.toString().toCharArray()) {
                    characterStack.push(tempCh);
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!characterStack.isEmpty()) {
            ans.insert(0, characterStack.pop());
        }
        return ans.toString();
    }

}
