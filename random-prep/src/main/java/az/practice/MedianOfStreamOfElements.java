package az.practice;

import com.ds.utils.ArrayUtils;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class MedianOfStreamOfElements {

    public static void main(String[] args) {
        int size = 10;
        int[][] inputs = {ArrayUtils.generateRandomArray(size), ArrayUtils.generateRandomArray(size)};
        IntStream.range(0, inputs.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.toString(inputs[i]));
            Arrays.sort(inputs[i]);
            float output = getMedian(inputs[i]);
            System.out.println("Sorted Input : " + Arrays.toString(inputs[i]));
            System.out.println("Output : " + output);
        });
    }

    private static float getMedian(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int size = arr.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Arrays.stream(arr).forEach(i -> minHeap.add(i));
        int mid = size / 2;
        for (int i = 1; i < mid; i++) {
            minHeap.poll();
        }
        if (size % 2 == 0) {
            Integer mid1 = minHeap.poll();
            Integer mid2 = minHeap.poll();
            return (mid1 + mid2) / 2.0f;
        }
        minHeap.poll();
        return minHeap.poll();
    }
}
