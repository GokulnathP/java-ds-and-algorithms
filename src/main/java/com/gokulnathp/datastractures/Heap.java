package com.gokulnathp.datastractures;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    private final List<Integer> heap = new ArrayList<>();

    public void insert(int value) {
        heap.add(value);
        int current = heap.size() - 1;

        while (current > 0 && value > heap.get(parent(current))) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public Integer remove() {
        if(heap.isEmpty()) return null;

        if(heap.size() == 1) return heap.remove(0);

        int maxValue = heap.get(0);

        heap.set(0, heap.remove(heap.size() - 1));
        sinkDown(0);

        return maxValue;
    }

    private void sinkDown(int index) {
        int maxIndex = index;

        while(true) {
            int leftIndex = leftChild(index);
            int rightIndex = rightChild(index);

            if (leftIndex < heap.size() && heap.get(leftIndex) > heap.get(maxIndex)) {
                maxIndex = leftIndex;
            }

            if (rightIndex < heap.size() && heap.get(rightIndex) > heap.get(maxIndex)) {
                maxIndex = rightIndex;
            }

            if (maxIndex == index) return;

            swap(index, maxIndex);
            index = maxIndex;
        }
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public List<Integer> getHeap() {
        return new ArrayList<>(heap);
    }

    public static int findKthSmallest(int[] nums, int k) {
        Heap heap = new Heap();

        for(int number: nums) {
            heap.insert(number);
            if(heap.getHeap().size() > k) heap.remove();
        }

        return heap.remove();
    }

    public static List<Integer> streamMax(int[] nums) {
        Heap heap = new Heap();
        List<Integer> stream = new ArrayList<>();

        for(int number: nums) {
            heap.insert(number);
            stream.add(heap.getHeap().get(0));
        }

        return stream;
    }

    public static List<Integer> streamMaxV1(int[] nums) {
        List<Integer> stream = new ArrayList<>();
        int maxNumber = Integer.MIN_VALUE;

        for(int number: nums) {
            maxNumber = Math.max(maxNumber, number);
            stream.add(maxNumber);
        }

        return stream;
    }
}
