package com.gokulnathp.datastractures;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HeapTest {
    @Nested
    class Insert {
        @Test
        void shouldAddElementToEmptyHeap() {
            Heap heap = new Heap();

            heap.insert(2);

            assertEquals(List.of(2), heap.getHeap());
        }

        @Test
        void shouldAddElementToExistingHeap() {
            Heap heap = new Heap();
            heap.insert(2); // 2
            heap.insert(1); // 2 1
            heap.insert(9); // 9 1 2
            heap.insert(12); // 12 9 2 1
            heap.insert(3); // 12 9 2 1 3

            assertEquals(List.of(12, 9, 2, 1, 3), heap.getHeap());
        }
    }

    @Nested
    class Remove {
        @Test
        void shouldReturnNullWhenHeapIsEmpty() {
            Heap heap = new Heap();

            assertNull(heap.remove());
        }

        @Test
        void shouldEmptyHeap() {
            Heap heap = new Heap();
            heap.insert(2);

            assertEquals(2, heap.remove());
            assertEquals(List.of(), heap.getHeap());
        }

        @Test
        void shouldRemoveHeapWithTwoLastElement() {
            Heap heap = new Heap();
            heap.insert(2); // 2
            heap.insert(1); // 2 1
            heap.insert(9); // 9 1 2
            heap.insert(12); // 12 9 2 1
            heap.insert(3); // 12 9 2 1 3

            assertEquals(12, heap.remove());
            assertEquals(List.of(9, 3, 2, 1), heap.getHeap());
        }

        @Test
        void shouldRemoveHeapWithOneLastElement() {
            Heap heap = new Heap();
            heap.insert(2); // 2
            heap.insert(1); // 2 1
            heap.insert(9); // 9 1 2
            heap.insert(12); // 12 9 2 1

            assertEquals(12, heap.remove());
            assertEquals(List.of(9, 1, 2), heap.getHeap());
        }

        @Test
        void shouldRemoveHeapWithEqualElement() {
            Heap heap = new Heap();
            heap.insert(2); // 1
            heap.insert(1); // 2 1
            heap.insert(9); // 9 1 2

            assertEquals(9, heap.remove());
            assertEquals(List.of(2, 1), heap.getHeap());
        }
    }
}