package com.prep.practice;

import java.util.stream.IntStream;

public class CreateJumpingNumbers {


    public static void main(String[] args) {
        int[] inputs = {20, 10, 100};
        CreateJumpingNumbers createJumpingNumbers = new CreateJumpingNumbers();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + inputs[i]);
            System.out.println("Output : ");
            createJumpingNumbers.generateJumpingNumbers(inputs[i]);
            System.out.println("############################");
        });
    }

    public void generateJumpingNumbers(int num) {
        System.out.println(0);
        for (int i = 1; i < 10; i++) {
            generate(i, num);
        }
    }

    public void generate(int start, final int limit) {
        if (start > limit) {
            return;
        }
        System.out.println(start);
        int lastDigit = start % 10;
        if (lastDigit != 9) {
            generate((start * 10) + (lastDigit + 1), limit);
        }
        if (lastDigit != 0) {
            generate((start * 10) + (lastDigit - 1), limit);
        }
    }


}
