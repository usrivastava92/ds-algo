package az.practice;

import java.util.function.IntConsumer;

public class Test {


    public IntConsumer getLambda() {
        return i -> {
            System.out.println(this);
        };
    }
}
