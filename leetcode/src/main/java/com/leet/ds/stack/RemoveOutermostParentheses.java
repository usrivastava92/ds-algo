package com.leet.ds.stack;

public class RemoveOutermostParentheses {

    public static void main(String[] args) {
        String s1 = "(()())(())(()(()))";
        String s2 = "(()())(())";
        RemoveOutermostParentheses removeOutermostParentheses = new RemoveOutermostParentheses();
        System.out.println(removeOutermostParentheses.removeOuterParentheses(s1));
    }


    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (Character ch : S.toCharArray()) {
            if (ch == '(') {
                if (sum != 0) {
                    sb.append(ch);
                }
                sum++;
            } else {
                sum--;
                if (sum != 0) {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }

}
