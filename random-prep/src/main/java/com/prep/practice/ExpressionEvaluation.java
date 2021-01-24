package com.prep.practice;

import java.util.*;
import java.util.stream.IntStream;

public class ExpressionEvaluation {

    public static void main(String[] args) {
        String[][] expressions = {{"a = 10", "b = a++", "c = a + b", "d = c*b + a*c"}, {"z=1", "b=++z", "y=z+b"}};
        int[] outputs = {441,4};
        ExpressionEvaluation expressionEvaluation = new ExpressionEvaluation();
        IntStream.range(0, expressions.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(expressions[i]));
            System.out.println("Output : " + expressionEvaluation.evaluate(expressions[i]));
            System.out.println("Expected : " + outputs[i]);
        });
    }

    public int evaluate(String[] expressions) {
        Map<Character, Integer> map = new HashMap<>();
        Character var = null;
        String splitRegex = "=";
        String[] tokens = expressions[0].split(splitRegex);
        map.put(tokens[0].trim().charAt(0), Integer.parseInt(tokens[1].trim().trim()));
        for (int i = 1; i < expressions.length; i++) {
            String expression = expressions[i];
            tokens = expression.split(splitRegex);
            var = tokens[0].trim().charAt(0);
            map.put(var, evaluate(tokens[1].trim(), map));
        }
        return map.get(var);
    }

    private int evaluate(String expression, Map<Character, Integer> map) {
        Stack<Character> operators = new Stack<>();
        Stack<Integer> numbers = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                int nextIndex = i + 1;
                int secondNextIndex = i + 2;
                if (nextIndex < expression.length() && secondNextIndex < expression.length() &&
                        ((expression.charAt(nextIndex) == '+' && expression.charAt(secondNextIndex) == '+')
                                || (expression.charAt(nextIndex) == '-' && expression.charAt(secondNextIndex) == '-'))) {
                    if (expression.charAt(nextIndex) == '+') {
                        numbers.push(processUnaryOperation(map, "++", ch, false));
                        i += 2;
                    } else if (expression.charAt(nextIndex) == '-') {
                        numbers.push(processUnaryOperation(map, "--", ch, false));
                        i += 2;
                    }
                } else {
                    numbers.push(map.get(ch));
                }
            } else if (ch == '+') {
                int nextIndex = i + 1;
                int secondNextIndex = i + 2;
                if (nextIndex < expression.length() && secondNextIndex < expression.length()
                        && (expression.charAt(secondNextIndex) >= 'a' && expression.charAt(secondNextIndex) <= 'z')
                        && (expression.charAt(nextIndex) == '+')) {
                    numbers.push(processUnaryOperation(map, "++", expression.charAt(secondNextIndex), true));
                    i += 2;
                } else {
                    while (!operators.isEmpty() && (operators.peek() == '-' || operators.peek() == '*' || operators.peek() == '/')) {
                        int num2 = numbers.pop();
                        int num1 = numbers.pop();
                        numbers.push(processBinaryOperator(operators.pop(), num1, num2));
                    }
                    operators.push(ch);
                }
            } else if (ch == '-') {
                int nextIndex = i + 1;
                int secondNextIndex = i + 2;
                if (nextIndex < expression.length() && secondNextIndex < expression.length()
                        && expression.charAt(secondNextIndex) >= 'a' && expression.charAt(secondNextIndex) <= 'z'
                        && expression.charAt(nextIndex) == '-') {
                    numbers.push(processUnaryOperation(map, "--", expression.charAt(secondNextIndex), true));
                    i += 2;
                } else {
                    while (!operators.isEmpty() && (operators.peek() == '+' || operators.peek() == '*' || operators.peek() == '/')) {
                        int num2 = numbers.pop();
                        int num1 = numbers.pop();
                        numbers.push(processBinaryOperator(operators.pop(), num1, num2));
                    }
                    operators.push(ch);
                }
            } else if (ch == '*') {
                while (!operators.isEmpty() && operators.peek() == '/') {
                    int num2 = numbers.pop();
                    int num1 = numbers.pop();
                    numbers.push(processBinaryOperator(operators.pop(), num1, num2));
                }
                operators.push(ch);
            } else if (ch == '/') {
                while (!operators.isEmpty() && operators.peek() == '*') {
                    int num2 = numbers.pop();
                    int num1 = numbers.pop();
                    numbers.push(processBinaryOperator(operators.pop(), num1, num2));
                }
                operators.push(ch);
            }
        }
        while (!operators.isEmpty()) {
            int num2 = numbers.pop();
            int num1 = numbers.pop();
            numbers.push(processBinaryOperator(operators.pop(), num1, num2));
        }
        return numbers.pop();
    }

    private int processUnaryOperation(Map<Character, Integer> map, String operator, Character var, boolean isPrefix) {
        int initValue = map.get(var);
        if (operator.equals("++")) {
            map.put(var, initValue + 1);
            if (isPrefix) {
                return map.get(var);
            } else {
                return initValue;
            }
        } else if (operator.equals("--")) {
            map.put(var, initValue - 1);
            if (isPrefix) {
                return map.get(var);
            } else {
                return initValue;
            }
        }
        throw new IllegalArgumentException(operator + " is not unary");
    }

    private int processBinaryOperator(Character operator, Integer num1, Integer num2) {
        switch (operator) {
            case '+': {
                return num1 + num2;
            }
            case '-': {
                return num1 - num2;
            }
            case '*': {
                return num1 * num2;
            }
            case '/': {
                return num1 / num2;
            }
        }
        throw new IllegalArgumentException(operator + " is an invalid operator");
    }

}
