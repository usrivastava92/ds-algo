package com.ib.bitmanipulation;

public class ReverseBits {

    public static void main(String... args) {
        ReverseBits reverseBits = new ReverseBits();
        System.out.println(reverseBits.reverse(3));
    }


    public long reverse(long a) {
        String bits = Long.toBinaryString(a);
        String pad0 = "00000000000000000000000000000000";
        bits = pad0.substring(0, pad0.length() - bits.length()) + bits;
        String reverse = new StringBuilder(bits).reverse().toString();
        long result = 0;
        int indexOf1 = reverse.indexOf('1');
        while (indexOf1 != -1) {
            result += Math.pow(2, reverse.length() - indexOf1);
            reverse = reverse.substring(indexOf1 + 1);
            indexOf1 = reverse.indexOf('1');
        }
        return result / 2;
    }

}
