package com.gokulnathp.datastractures;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class MinHeapTest {
    @Nested
    class Insert {
        @Test
        void shouldAddElementToEmptyHeap() {
            MinHeap heap = new MinHeap();

            heap.insert(2);

            assertEquals(List.of(2), heap.getHeap());
        }

        @Test
        void shouldAddElementToExistingHeap() {
            MinHeap heap = new MinHeap();
            heap.insert(9); // 9
            heap.insert(3); // 3 9
            heap.insert(12); // 3 9 12
            heap.insert(2); // 2 3 12 9
            heap.insert(1); // 1 2 12 9 3

            assertEquals(List.of(1, 2, 12, 9, 3), heap.getHeap());
        }
    }

    @Nested
    class Remove {
        @Test
        void shouldReturnNullWhenHeapIsEmpty() {
            MinHeap heap = new MinHeap();

            assertNull(heap.remove());
        }

        @Test
        void shouldEmptyHeap() {
            MinHeap heap = new MinHeap();
            heap.insert(2);

            assertEquals(2, heap.remove());
            assertEquals(List.of(), heap.getHeap());
        }

        @Test
        void shouldRemoveHeapWithTwoLastElement() {
            MinHeap heap = new MinHeap();
            heap.insert(9); // 9
            heap.insert(3); // 3 9
            heap.insert(12); // 3 9 12
            heap.insert(2); // 2 3 12 9
            heap.insert(1); // 1 2 12 9 3

            assertEquals(1, heap.remove());
            assertEquals(List.of(2, 3, 12, 9), heap.getHeap());
        }

        @Test
        void shouldRemoveHeapWithOneLastElement() {
            MinHeap heap = new MinHeap();
            heap.insert(9); // 9
            heap.insert(3); // 3 9
            heap.insert(12); // 3 9 12
            heap.insert(2); // 2 3 12 9

            assertEquals(2, heap.remove());
            assertEquals(List.of(3, 9, 12), heap.getHeap());
        }

        @Test
        void shouldRemoveHeapWithEqualElement() {
            MinHeap heap = new MinHeap();
            heap.insert(9); // 9
            heap.insert(3); // 3 9
            heap.insert(12); // 3 9 12

            assertEquals(3, heap.remove());
            assertEquals(List.of(9, 12), heap.getHeap());
        }
    }
}