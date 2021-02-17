package com.ds.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

public class ArrayUtils {

    private ArrayUtils() {

    }

    public static <T> void printArr(T[] arr) {
        Arrays.stream(arr).forEachOrdered(System.out::println);
    }

    public static void printArr(char[][] arr) {
        Arrays.stream(arr).forEachOrdered(row -> System.out.println(Arrays.toString(row)));
    }

    public static void printArr(boolean[][] arr) {
        Arrays.stream(arr).forEachOrdered(row -> System.out.println(Arrays.toString(row)));
    }

    public static <T> void printArr(T[][] arr) {
        Arrays.stream(arr).forEachOrdered(row -> System.out.println(Arrays.toString(row)));
    }

    public static void printArr(int[][] arr) {
        Arrays.stream(arr).forEachOrdered(row -> System.out.println(Arrays.toString(row)));
    }

    public static List<List<Integer>> deepAsList(int[][] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            ans.add(new ArrayList<>());
            for (int j = 0; j < arr[i].length; j++) {
                ans.get(i).add(arr[i][j]);
            }
        }
        return ans;
    }

    public static <T> List<List<T>> deepAsList(T[][] arr) {
        List<List<T>> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            ans.add(new ArrayList<>());
            for (int j = 0; j < arr[i].length; j++) {
                ans.get(i).add(arr[i][j]);
            }
        }
        return ans;
    }

    public static List<Character> deepAsList(char[] arr) {
        List<Character> ans = new ArrayList<>();
        for (char ch : arr) {
            ans.add(ch);
        }
        return ans;
    }

    public static String toString(int[][] arr) {
        StringBuilder sb = new StringBuilder("[");
        if (arr != null && arr.length > 0) {
            Arrays.stream(arr).forEachOrdered(row -> sb.append(Arrays.toString(row)).append(", "));
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append("]");
        return sb.toString();
    }

    public static <T> String toString(T[][] arr) {
        StringBuilder sb = new StringBuilder("[");
        Arrays.stream(arr).forEachOrdered(row -> sb.append(Arrays.toString(row)).append(", "));
        sb.delete(sb.length() - 2, sb.length()).append("]");
        return sb.toString();
    }

    public static String toString(Collection<int[]> collection) {
        StringBuilder sb = new StringBuilder("[");
        collection.stream().forEachOrdered(row -> sb.append(Arrays.toString(row)).append(", "));
        sb.delete(sb.length() - 2, sb.length()).append("]");
        return sb.toString();
    }

    public static void standardSort2dArray(int[][] arr) {
        Arrays.sort(arr, (i, j) -> {
            int comp = Integer.compare(i[0], j[0]);
            if (comp == 0) {
                return Integer.compare(i[1], j[1]);
            }
            return comp;
        });
    }

    public static int[] generateRandomArray(int size) {
        return generateRandomArray(size, -100, 100);
    }

    public static int[] generateRandomArray(int size, int lowerLimit, int upperLimit) {
        if (size <= 0) {
            return new int[]{};
        }
        return IntStream.generate(() -> NumberUtils.getRandomInt(lowerLimit, upperLimit)).limit(size).toArray();
    }

    public static Integer[] generateRandomBoxedArray(int size) {
        return generateRandomBoxedArray(size, -100, 100);
    }

    public static Integer[] generateRandomBoxedArray(int size, int lowerLimit, int upperLimit) {
        if (size <= 0) {
            return new Integer[]{};
        }
        return IntStream.generate(() -> NumberUtils.getRandomInt(lowerLimit, upperLimit)).limit(size).boxed().toArray(Integer[]::new);
    }

    public static boolean isValidIndex(Object[] arr, int... indexes) {
        Object obj = null;
        for (int i = 0; i < indexes.length; i++) {
            int index = indexes[i];
            if (!NumberUtils.isInRangeStartInclusive(index, 0, arr.length)) {
                return false;
            }
            obj = arr[index];
            if (obj instanceof Object[]) {
                arr = (Object[]) obj;
            } else if (obj instanceof byte[]) {
                if (!isValidIndex((byte[]) obj, indexes[i + 1])) {
                    return false;
                }
                break;
            } else if (obj instanceof short[]) {
                if (!isValidIndex((short[]) obj, indexes[i + 1])) {
                    return false;
                }
                break;
            } else if (obj instanceof int[]) {
                if (!isValidIndex((int[]) obj, indexes[i + 1])) {
                    return false;
                }
                break;
            } else if (obj instanceof long[]) {
                if (!isValidIndex((long[]) obj, indexes[i + 1])) {
                    return false;
                }
                break;
            } else if (obj instanceof char[]) {
                if (!isValidIndex((char[]) obj, indexes[i + 1])) {
                    return false;
                }
                break;
            } else if (obj instanceof float[]) {
                if (!isValidIndex((float[]) obj, indexes[i + 1])) {
                    return false;
                }
                break;
            } else if (obj instanceof double[]) {
                if (!isValidIndex((double[]) obj, indexes[i + 1])) {
                    return false;
                }
                break;
            } else if (obj instanceof boolean[]) {
                if (!isValidIndex((boolean[]) obj, indexes[i + 1])) {
                    return false;
                }
                break;
            } else {
                return false;
            }
        }
        return true;
    }

    public static <T> void swap(T[] arr, int index1, int index2) {
        if (isValidIndex(arr, index1) && isValidIndex(arr, index2)) {
            T temp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = temp;
        }
    }

    public static void swap(int[] arr, int index1, int index2) {
        if (isValidIndex(arr, index1) && isValidIndex(arr, index2)) {
            int temp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = temp;
        }
    }

    public static boolean isValidIndex(int[] arr, int index) {
        return NumberUtils.isInRangeStartInclusive(index, 0, arr.length);
    }

    public static boolean isValidIndex(boolean[] arr, int index) {
        return NumberUtils.isInRangeStartInclusive(index, 0, arr.length);
    }

    public static boolean isValidIndex(double[] arr, int index) {
        return NumberUtils.isInRangeStartInclusive(index, 0, arr.length);
    }

    public static boolean isValidIndex(float[] arr, int index) {
        return NumberUtils.isInRangeStartInclusive(index, 0, arr.length);
    }

    public static boolean isValidIndex(char[] arr, int index) {
        return NumberUtils.isInRangeStartInclusive(index, 0, arr.length);
    }

    public static boolean isValidIndex(long[] arr, int index) {
        return NumberUtils.isInRangeStartInclusive(index, 0, arr.length);
    }

    public static boolean isValidIndex(short[] arr, int index) {
        return NumberUtils.isInRangeStartInclusive(index, 0, arr.length);
    }

    public static boolean isValidIndex(byte[] arr, int index) {
        return NumberUtils.isInRangeStartInclusive(index, 0, arr.length);
    }

}
