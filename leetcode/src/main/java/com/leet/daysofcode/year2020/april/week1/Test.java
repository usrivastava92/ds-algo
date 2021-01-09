package com.leet.daysofcode.year2020.april.week1;

public class Test {

    public static void main(String[] args) {
        String a = "a%4$+ bc431";
        String b = "a4!@$^ b)(c431 ";
        String regex = "[^A-Za-z0-9]";
        a = a.replaceAll(regex, "");
        b = b.replaceAll(regex, "");
        System.out.println(a + " : " + b);
    }
}
