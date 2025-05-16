package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;


public class QuickSort {

    static long iteration = 0;

    public static void main(String[] args) throws IOException {
        int[] arr = {123,4,132,4,1324,324,213,3213,4,33,54345,6352,3423345,34234,2334};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
            iteration++;
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];
        int temp = arr[middle];
        arr[middle] = arr[high];
        arr[high] = temp;
        iteration++;
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                iteration++;
            }
        }
        temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        iteration++;
        return i + 1;
    }

    public static int[] readArrayFromFile(File file) throws IOException {
        String content = file.toString();
        return Arrays.stream(content.trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
