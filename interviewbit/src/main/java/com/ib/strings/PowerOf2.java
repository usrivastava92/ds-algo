package com.ib.strings;

import org.junit.Assert;

import java.util.stream.IntStream;

public class PowerOf2 {

    public static void main(String[] args) {
        String[] inputs = {"128", "100"};
        int[] outputs = {1, 0};
        PowerOf2 powerOf2 = new PowerOf2();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + inputs[i]);
            int output = powerOf2.power(inputs[i]);
            System.out.println("output : " + output);
            Assert.assertEquals(outputs[i], output);
        });
    }

    public int power(String A) {
        if (A == null || A.length() == 0 || A.equals("1") || A.equals("0")) {
            return 0;
        }
        while (!A.equals("0") && !A.equals("1")) {
            String[] ans = divideBy2(A);
            String quotient = ans[0];
            String remainder = ans[1];
            if (remainder.equals("0")) {
                A = quotient;
            } else {
                return 0;
            }
        }
        return 1;
    }

    private String[] divideBy2(String num) {
        int len = num.length();
        StringBuilder quotient = new StringBuilder();
        int currNum = 0;
        for (int i = 0; i < len; i++) {
            int digit = Character.getNumericValue(num.charAt(i));
            currNum = (currNum * 10) + digit;
            if (currNum < 2) {
                quotient.append("0");
            } else {
                int div = currNum / 2;
                currNum = currNum % 2;
                quotient.append(div);
            }
        }
        while (quotient.length() > 0 && quotient.charAt(0) == '0') {
            quotient.deleteCharAt(0);
        }
        return new String[]{quotient.toString(), String.valueOf(currNum)};
    }

}
