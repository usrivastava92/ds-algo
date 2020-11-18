package com.ib.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PrettyJson {

    public static void main(String... args) {
        PrettyJson prettyJson = new PrettyJson();
        String a = "{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}";
        String b = "[\"foo\", {\"bar\":[\"baz\",null,1.0,2]}]";
        ArrayList<String> arr = prettyJson.prettyJSON(b);


        for (String s : arr) {
            System.out.println(s);
        }
    }


    public ArrayList<String> prettyJSON(String A) {
        A = A.trim();
        ArrayList<String> result = new ArrayList<>();
        char[] chArr = A.trim().toCharArray();
        int whiteSpace = 0;
        String word = "";
        int len = chArr.length;
        for (int i = 0; i < len; i++) {
            char ch = chArr[i];
            if (ch == '{') {
                if (word.trim().length() > 0) {
                    result.add(createNSpace(whiteSpace) + word);
                    word = "";
                }
                result.add(createNSpace(whiteSpace) + ch);
                whiteSpace++;
            } else if (ch == '[') {
                if (word.trim().length() > 0) {
                    result.add(createNSpace(whiteSpace) + word);
                    word = "";
                }
                result.add(createNSpace(whiteSpace) + ch);
                whiteSpace++;
            } else if (ch == '}') {
                if (word.trim().length() > 0) {
                    result.add(createNSpace(whiteSpace) + word);
                    word = "";
                }
                whiteSpace--;
                String term = String.valueOf(ch);
                if (i < len - 1 && chArr[i + 1] == ',') {
                    term += ",";
                    i++;
                }
                result.add(createNSpace(whiteSpace) + term);
            } else if (ch == ']') {
                if (word.trim().length() > 0) {
                    result.add(createNSpace(whiteSpace) + word);
                    word = "";
                }
                whiteSpace--;
                String term = String.valueOf(ch);
                if (i < len - 1 && chArr[i + 1] == ',') {
                    term += ",";
                    i++;
                }
                result.add(createNSpace(whiteSpace) + term);
            } else if (ch == ',') {
                word += ch;
                if (word.trim().length() > 0) {
                    result.add(createNSpace(whiteSpace) + word);
                    word = "";
                }
            } else {
                word += ch;
            }
        }
        return result;
    }

    public String createNSpace(int n) {
        return new String(new char[n]).replace('\0', '\t');
    }
}
