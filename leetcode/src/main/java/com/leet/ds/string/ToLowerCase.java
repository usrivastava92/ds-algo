package com.leet.ds.string;

public class ToLowerCase {


    public static void main(String[] args) {
        ToLowerCase toLowerCase = new ToLowerCase();
        System.out.println(toLowerCase.toLowerCase("Hello"));
    }

    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            int ascii = ch;
            if (ascii >= 65 && ascii <= 90) {
                sb.append((char) (ascii + 32));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
