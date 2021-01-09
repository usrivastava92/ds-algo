package com.leet.daysofcode.year2020.november.week4;

import java.util.Stack;
import java.util.stream.IntStream;

public class BasicCalculatorII {

    public static void main(String[] args) {
        String[] inputs = {"3+2*2", " 3/2 ", " 3+5 / 2 ", "42", "1-1+1", "0*0"};
        int[] outputs = {7, 1, 5, 42, 1, 0};
        BasicCalculatorII basicCalculatorII = new BasicCalculatorII();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + inputs[i]);
            System.out.println("Output : " + basicCalculatorII.calculate(inputs[i]));
            System.out.println("Expected : " + outputs[i]);
        });
    }

    public int calculate(String s) {
        if (s == null || s.trim().length() == 0) {
            return 0;
        }
        s = s.replaceAll("[ ]+", "");
        Stack<Character> operators = new Stack<>();
        Stack<Integer> numbers = new Stack<>();
        int num = 0;
        for (Character ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = (num * 10) + Character.getNumericValue(ch);
            } else {
                numbers.push(num);
                num = 0;
                if (ch == '+' || ch == '-') {
                    while (!operators.isEmpty() && (operators.peek() == '*' || operators.peek() == '/' || operators.peek() == '-' || operators.peek() == '+')) {
                        int num2 = numbers.pop();
                        int num1 = numbers.pop();
                        numbers.push(applyOperation(operators.pop(), num1, num2));
                    }
                } else if (ch == '*' || ch == '/') {
                    while (!operators.isEmpty() && (operators.peek() == '/' || operators.peek() == '*')) {
                        int num2 = numbers.pop();
                        int num1 = numbers.pop();
                        numbers.push(applyOperation(operators.pop(), num1, num2));
                    }
                }
                operators.push(ch);
            }
        }
        numbers.push(num);
        while (!operators.isEmpty()) {
            int num2 = numbers.pop();
            int num1 = numbers.pop();
            numbers.push(applyOperation(operators.pop(), num1, num2));
        }
        return numbers.pop();
    }

    public int applyOperation(char operator, int num1, int num2) {
        switch (operator) {
            case '*': {
                return num1 * num2;
            }
            case '+': {
                return num1 + num2;
            }
            case '-': {
                return num1 - num2;
            }
            case '/': {
                return num1 / num2;
            }
        }
        throw new IllegalArgumentException("invalid operator : " + operator);
    }

}
