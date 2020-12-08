package com.ib.graphs;

import org.junit.Assert;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.stream.IntStream;

public class SmallestMultipleWith0And1 {

    public static void main(String[] args) {
        int[] inputs = {55, 2};
        String[] outputs = {"110", "10"};
        SmallestMultipleWith0And1 smallestMultipleWith0And1 = new SmallestMultipleWith0And1();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + inputs[i]);
            String output = smallestMultipleWith0And1.multiple(inputs[i]);
            System.out.println("Output : " + output);
            Assert.assertEquals(outputs[i], output);
        });
    }

    public String multiple(int A) {
        if (A <= 1) {
            return String.valueOf(A);
        }
        Queue<Pair> queue = new ArrayDeque<>();
        boolean[] checked = new boolean[A];
        queue.add(new Pair("1", 1));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            String append0 = pair.str + "0";
            int append0Remainder = (pair.remainder * (10 % A)) % A;
            if (append0Remainder == 0) {
                return append0;
            } else {
                if (!checked[append0Remainder]) {
                    checked[append0Remainder] = true;
                    queue.add(new Pair(append0, append0Remainder));
                }
            }

            String append1 = pair.str + "1";
            int append1Remainder = ((pair.remainder * (10 % A)) + (1 % A)) % A;
            if (append1Remainder == 0) {
                return append1;
            } else {
                if (!checked[append1Remainder]) {
                    checked[append1Remainder] = true;
                    queue.add(new Pair(append1, append1Remainder));
                }
            }
        }
        return "";
    }

    private static class Pair {
        String str;
        int remainder;

        public Pair(String str, int remainder) {
            this.str = str;
            this.remainder = remainder;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "str='" + str + '\'' +
                    ", remainder=" + remainder +
                    '}';
        }
    }

}
/*
1 % 55 = 1
10 % 55 = 10
(1*10)

11 % 55 = 11
(1*10) + 1
 */