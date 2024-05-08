package com.gokulnathp.sorting;

public class QuickSort {
    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static int pivot(int[] array, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;

        for(int i = pivotIndex + 1; i < endIndex; i++) {
            if(array[i] < array[pivotIndex]) {
                swapIndex++;
                swap(array, swapIndex, i);
            }
        }
        swap(array, swapIndex, pivotIndex);

        return swapIndex;
    }

    public static void quickSort(int[] array, int left, int right) {
        if(left < right) {
            int pivotIndex = pivot(array, left, right);
            quickSort(array, left, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, right);
        }
    }

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length -1);
    }
}
