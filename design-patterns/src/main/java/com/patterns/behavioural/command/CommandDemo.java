package com.patterns.behavioural.command;

public class CommandDemo {

    public int executeAdd(int a, int b) {
        ArithmeticCommand addCommand = new AddCommand(a, b);
        return (Integer) addCommand.execute();
    }

    public int executeMultiply(int a, int b) {
        ArithmeticCommand multiplyCommand = new MultiplyCommand(a, b);
        return (Integer) multiplyCommand.execute();
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
