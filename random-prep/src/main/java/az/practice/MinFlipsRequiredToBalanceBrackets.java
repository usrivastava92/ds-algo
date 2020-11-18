package az.practice;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.IntStream;

public class MinFlipsRequiredToBalanceBrackets {

    public static void main(String[] args) {
        String[] inputs = {"}{", "{{{", "{{{{", "{{{{}}", "}{{}}{{{"};
        int[] outputs = {2, -1, 2, 1, 3};
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + inputs[i]);
            System.out.println("Output : " + minBracketFlips(inputs[i]));
            System.out.println("Expected : " + outputs[i]);
        });
    }

    private static int minBracketFlips(String s) {
        if (s == null) {
            return -1;
        }
        s = s.trim();
        if (s.length() == 0 || s.length() % 2 != 0) {
            return -1;
        }
        Deque<Character> stack = new ArrayDeque<>();
        int flips = 0;
        Character opening = '{';
        for (Character bracket : s.toCharArray()) {
            if (bracket == opening) {
                stack.push(bracket);
            } else {
                if (stack.isEmpty()) {
                    flips++;
                    stack.push(opening);
                } else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            flips++;
            stack.pop();
            stack.pop();
        }
        return flips;
    }

}
