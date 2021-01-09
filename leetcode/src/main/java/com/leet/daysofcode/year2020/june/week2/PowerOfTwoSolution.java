package com.leet.daysofcode.year2020.june.week2;

public class PowerOfTwoSolution {

    public static void main(String[] args) {
        int[] inputs = {0, 1, 2, 4, 16, 15};
        boolean[] outputs = {false, true, true, true, true, false};
        PowerOfTwoSolution powerOfTwoSolution = new PowerOfTwoSolution();
        for (int i = 0; i < inputs.length; i++) {
            System.out.println("Input : " + inputs[i]);
            System.out.println("Output : " + powerOfTwoSolution.isPowerOfTwo(inputs[i]));
            System.out.println("Expected : " + outputs[i]);
            System.out.println("##########################################");
        }
    }


    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        while (n % 2 == 0) {
            n = n / 2;
        }
        return n == 1;
    }
}
