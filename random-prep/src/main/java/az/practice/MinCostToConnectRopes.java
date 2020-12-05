package az.practice;

import org.junit.Assert;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class MinCostToConnectRopes {

    public static void main(String[] args) {
        int[][] inputs = {{8, 4, 6, 12}, {20, 4, 8, 2}, {1, 2, 5, 10, 35, 89}, {2, 2, 3, 3}};
        int[] outputs = {58, 54, 224, 20};
        MinCostToConnectRopes minCostToConnectRopes = new MinCostToConnectRopes();
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(inputs[i]));
            int output = minCostToConnectRopes.minCost(inputs[i]);
            System.out.println("Output : " + output);
            Assert.assertEquals(outputs[i], output);
        });
    }

    public int minCost(int[] ropes) {
        if (ropes == null || ropes.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Arrays.stream(ropes).forEach(minHeap::add);
        int sum = 0;
        while (minHeap.size() > 1) {
            int tempSum = minHeap.poll() + minHeap.poll();
            sum += tempSum;
            minHeap.add(tempSum);
        }
        return sum;
    }
}
