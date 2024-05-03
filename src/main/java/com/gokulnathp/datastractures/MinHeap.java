package com.gokulnathp.datastractures;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {
    private final List<Integer> heap = new ArrayList<>();

    public void insert(int value) {
        heap.add(value);
        int current = heap.size() - 1;

        while(current > 0 && value < heap.get(parent(current))) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public Integer remove() {
        if(heap.isEmpty()) return null;

        if(heap.size() == 1) return heap.remove(0);

        int minValue = heap.get(0);

        heap.set(0, heap.remove(heap.size() - 1));
        sinkDown(0);

        return minValue;
    }

    private void sinkDown(int index) {
        int minIndex = index;

        while(true) {
            int leftIndex = leftChild(index);
            int rightIndex = rightChild(index);

            if(leftIndex < heap.size() && heap.get(leftIndex) < heap.get(minIndex)) {
                minIndex = leftIndex;
            }

            if(rightIndex < heap.size() && heap.get(rightIndex) < heap.get(minIndex)) {
                minIndex = rightIndex;
            }

            if(minIndex == index) return;

            swap(index, minIndex);
            index = minIndex;
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
}
