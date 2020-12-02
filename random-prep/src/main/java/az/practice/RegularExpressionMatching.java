package az.practice;

import org.junit.Assert;

import java.util.stream.IntStream;

public class RegularExpressionMatching {

    public static void main(String[] args) {
        String[] s = {"aa", "aa", "ab", "aab", "mississippi"};
        String[] p = {"a", "a*", ".*", "c*a*b", "mis*is*p*."};
        boolean[] outputs = {false, true, true, true, false};
        RegularExpressionMatching regularExpressionMatching = new RegularExpressionMatching();
        IntStream.range(0, s.length).forEachOrdered(i -> {
            System.out.println("Input : s -> " + s[i] + " p -> " + p[i]);
            boolean output = regularExpressionMatching.isMatch(s[i], p[i]);
            System.out.println("Output : " + output);
            Assert.assertEquals(outputs[i], output);
        });
    }

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        if (s.equals(p)) {
            return true;
        }
        int lenS = s.length();
        int lenP = p.length();
        int i = 0;
        int j = 0;
        while (i < lenS && j < lenP) {
            if (p.charAt(j) == '*') {
                while (j < lenP && (p.charAt(j) == '*' || p.charAt(j) == '.')) {
                    j++;
                }
                if (j < lenP) {
                    while (i < lenS && s.charAt(i) != p.charAt(j)) {
                        i++;
                    }
                } else {
                    return true;
                }
            } else if (p.charAt(j) == '.') {
                int minChar = 0;
                boolean anyChar = false;
                while (j < lenP && (p.charAt(j) == '*' || p.charAt(j) == '.')) {
                    if (p.charAt(j) == '.') {
                        minChar++;
                    } else {
                        anyChar = true;
                    }
                    j++;
                }
                if (j < lenP) {
                    while (i < lenS && minChar-- > 0) {
                        i++;
                    }
                    if (minChar > 0 && i >= lenS) {
                        return false;
                    } else {
                        if (anyChar) {
                            while (i < lenS && s.charAt(i) != p.charAt(j)) {
                                i++;
                            }
                        }
                    }
                } else {
                    if (anyChar) {
                        return lenS - i >= minChar;
                    } else {
                        return lenS - i == minChar;
                    }
                }
            } else {
                if (s.charAt(i) != p.charAt(j)) {
                    return false;
                }
                i++;
                j++;
            }
        }
        if (i >= lenS && j < lenP) {
            while (j < lenP && (p.charAt(j) == '*' || p.charAt(j) == '.')) {
                j++;
            }
            return j >= lenP;
        }
        return p.charAt(j - 1) == '*';
    }
}
