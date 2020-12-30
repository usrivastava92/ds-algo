package com.ds.utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortingUtils {

    private SortingUtils() {
    }

    public static <T extends Comparable<T>> void bubbleSort(List<T> list) {
        bubbleSort(list, Comparable::compareTo);
    }

    public static <T> void bubbleSort(List<T> list, Comparator<T> comparator) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = list.size() - 1; i > 0; i--) {
            boolean noSwap = true;
            for (int j = 0; j < i; j++) {
                if (comparator.compare(list.get(j), list.get(j + 1)) > 0) {
                    noSwap = false;
                    swap(list, j, j + 1);
                }
            }
            if (noSwap) {
                return;
            }
        }
    }

    public static <T extends Comparable<T>> void insertionSort(List<T> list) {
        insertionSort(list, Comparable::compareTo);
    }

    public static <T> void insertionSort(List<T> list, Comparator<T> comparator) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = 1; i < list.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (comparator.compare(list.get(j - 1), list.get(j)) > 0) {
                    swap(list, j - 1, j);
                }
            }
        }
    }

    public static <T extends Comparable<T>> void selectionSort(List<T> list) {
        selectionSort(list, Comparable::compareTo);
    }

    public static <T> void selectionSort(List<T> list, Comparator<T> comparator) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (comparator.compare(list.get(minIndex), list.get(j)) > 0) {
                    minIndex = j;
                }
            }
            swap(list, i, minIndex);
        }
    }

    public static <T extends Comparable<T>> void quickSort(List<T> list) {
        quickSort(list, Comparable::compareTo);

    }

    public static <T> void quickSort(List<T> list, Comparator<T> comparator) {
        if (list == null || list.isEmpty()) {
            return;
        }
        quickSort(list, comparator, 0, list.size() - 1);
    }

    public static <T> void quickSort(List<T> list, Comparator<T> comparator, int start, int end) {
        if (!CollectionUtils.isValidIndex(list, start) || !CollectionUtils.isValidIndex(list, end) || end <= start) {
            return;
        }
        int pivotIndex = movePivotToCorrectLocation(list, comparator, end, start, end);
        System.out.printf("list : %s | start : %s | end : %s | pivot : %s \n", list, start, end, pivotIndex);
        quickSort(list, comparator, start, pivotIndex - 1);
        quickSort(list, comparator, pivotIndex + 1, end);
    }

    private static <T> int movePivotToCorrectLocation(List<T> list, Comparator<T> comparator, int pivotIndex, int start, int end) {
        if (!CollectionUtils.isValidIndex(list, pivotIndex)) {
            throw new ArrayIndexOutOfBoundsException("pivot index in not valid");
        }
        T pivot = list.get(pivotIndex);
        int low = start;
        int high = end;
        while (NumberUtils.isInRangeInclusive(low, start, end) && NumberUtils.isInRangeInclusive(high, start, end) && high >= low) {
            if (comparator.compare(pivot, list.get(low)) < 0 && comparator.compare(pivot, list.get(high)) > 0) {
                swap(list, low, high);
                low++;
                high--;
            }
            if (CollectionUtils.isValidIndex(list, low) && comparator.compare(pivot, list.get(low)) >= 0) {
                low++;
            }
            if (CollectionUtils.isValidIndex(list, high) && comparator.compare(pivot, list.get(high)) <= 0) {
                high--;
            }
        }
        if (NumberUtils.isInRangeInclusive(low, start, end)) {
            swap(list, low, pivotIndex);
        }
        return low;
    }

    public static <T extends Comparable<T>> void mergeSort(List<T> list) {
        mergeSort(list, Comparable::compareTo);
    }

    public static <T> void mergeSort(List<T> list, Comparator<T> comparator) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int low = 0;
        int high = list.size() - 1;
        mergeSort(list, comparator, low, high);
    }

    private static <T> void mergeSort(List<T> list, Comparator<T> comparator, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSort(list, comparator, low, mid);
        mergeSort(list, comparator, mid + 1, high);
        merge(list, comparator, low, mid, high);
    }

    private static <T> void merge(List<T> list, Comparator<T> comparator, int low, int mid, int high) {
        List<T> merged = new ArrayList<>();
        int low1 = low;
        int high1 = mid;
        int low2 = mid + 1;
        int high2 = high;
        int temp1 = low1;
        int temp2 = low2;
        while (temp1 <= high1 && temp2 <= high2) {
            if (comparator.compare(list.get(temp1), list.get(temp2)) < 0) {
                merged.add(list.get(temp1));
                temp1++;
            } else {
                merged.add(list.get(temp2));
                temp2++;
            }
        }
        while (temp1 <= high1) {
            merged.add(list.get(temp1));
            temp1++;
        }
        while (temp2 <= high2) {
            merged.add(list.get(temp2));
            temp2++;
        }
        temp1 = low1;
        temp2 = 0;
        while (temp1 <= high2) {
            list.set(temp1, merged.get(temp2));
            temp1++;
            temp2++;
        }
    }

    public static <T extends Comparable<T>> void heapSort(List<T> list) {
        heapSort(list, Comparable::compareTo);
    }

    public static <T> void heapSort(List<T> list, Comparator<T> comparator) {
        if (list == null || list.isEmpty()) {
            return;
        }
    }

    public static <T extends Comparable<T>> void countingSort(List<T> list) {
        countingSort(list, Comparable::compareTo);
    }

    public static <T> void countingSort(List<T> list, Comparator<T> comparator) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = list.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (comparator.compare(list.get(j), list.get(j + 1)) > 0) {
                    swap(list, j, j + 1);
                }
            }
        }
    }

    public static <T> void swap(List<T> list, int index1, int index2) {
        if (!CollectionUtils.isValidIndex(list, index1) || !CollectionUtils.isValidIndex(list, index2)) {
            return;
        }
        T temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    public static <T> void swap(T[] arr, int index1, int index2) {
        if (!ArrayUtils.isValidIndex(arr, index1) || !ArrayUtils.isValidIndex(arr, index2)) {
            return;
        }
        T temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void swap(int[] arr, int index1, int index2) {
        if (!ArrayUtils.isValidIndex(arr, index1) || !ArrayUtils.isValidIndex(arr, index2)) {
            return;
        }
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }


}
