package com.patterns.behavioural.command;

public class CommandDemo {

    public static void main(String[] args) {
        int a = 3;
        int b = 4;

        ArithmeticCommand addCommand = new AddCommand(a, b);
        ArithmeticCommand multiplyCommand = new MultiplyCommand(a, b);

        System.out.println(addCommand.execute());
        System.out.println(multiplyCommand.execute());
    }

    private interface ArithmeticCommand {
        Object execute();
    }

    private static final class AddCommand implements ArithmeticCommand {
        private final int a;
        private final int b;

        public AddCommand(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public Integer execute() {
            return a + b;
        }
    }

    private static final class MultiplyCommand implements ArithmeticCommand {
        private final int a;
        private final int b;

        public MultiplyCommand(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public Integer execute() {
            return a * b;
        }
    }

}
