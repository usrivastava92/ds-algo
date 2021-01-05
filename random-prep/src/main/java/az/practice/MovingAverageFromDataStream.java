package az.practice;

import org.junit.Assert;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.stream.IntStream;

public class MovingAverageFromDataStream {


    public static void main(String[] args) {
        int[][] inputs = {{1, 10, 3, 5}};
        int[] windowSizes = {3};
        double[][] outputs = {{1, 5.5, 4.6, 6}};
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(inputs[i]));
            MovingAverage movingAverageFromDataStream = new MovingAverage(windowSizes[i]);
            double[] output = new double[inputs[i].length];
            IntStream.range(0, inputs[i].length).forEachOrdered(j -> {
                output[j] = movingAverageFromDataStream.next(inputs[i][j]);
            });
            System.out.println("Output : " + Arrays.toString(output));
            Assert.assertArrayEquals(outputs[i], output, 0.1);
        });
    }


    private static final class MovingAverage {

        private final int windowSize;
        private final Queue<Integer> queue;
        private long currentSum;

        public MovingAverage(int windowSize) {
            this.windowSize = windowSize;
            this.queue = new ArrayDeque<>();
            this.currentSum = 0;
        }

        public double next(int num) {
            currentSum += num;
            queue.add(num);
            if (!queue.isEmpty() && queue.size() > windowSize) {
                currentSum -= queue.poll();
            }
            return (currentSum * 1.0d) / queue.size();
        }

    }


}
