package com.ib.bitmanipulation;

public class NumberOf1Bits {
    public static void main(String... args) {
        NumberOf1Bits numberOf1Bits = new NumberOf1Bits();
        System.out.println(numberOf1Bits.numSetBits(11L));
    }

    public int numSetBits(Long a) {
        return Long.toBinaryString(a).replaceAll("0","").length();
    }
}
