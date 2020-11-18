package com.leet.ds.string;

public class Maximum69Number {

    public static void main(String[] args) {
        Maximum69Number maximum69Number = new Maximum69Number();
        int num = 9669;
        System.out.println(maximum69Number.maximum69Number(num));
    }

    public int maximum69Number(int num) {
        StringBuilder sb = new StringBuilder();
        boolean changed = false;
        for (char ch : String.valueOf(num).toCharArray()) {
            if (changed) {
                sb.append(ch);
            } else {
                if (ch == '6') {
                    sb.append('9');
                    changed = true;
                } else {
                    sb.append(ch);
                }
            }
        }
        return Integer.parseInt(sb.toString());
    }
}
