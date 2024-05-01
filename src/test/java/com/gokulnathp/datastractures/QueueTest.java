package com.gokulnathp.datastractures;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    @Nested
    class ToArray {
        @Test
        void shouldCreateEmptyQueue() {
            Queue queue = new Queue();

            assertArrayEquals(createArray(), queue.toArray());
        }

        @Test
        void shouldCreateQueueWithOneNode() {
            Queue queue = new Queue(2);

            assertArrayEquals(createArray(2), queue.toArray());
        }
    }

    @Nested
    class Enqueue {
        @Test
        void shouldAddNodeToEmptyQueue() {
            Queue queue = new Queue();

            queue.enqueue(2);

            assertArrayEquals(createArray(2), queue.toArray());
        }

        @Test
        void shouldAddNodeToTheEndOfQueue() {
            Queue queue = new Queue(2);

            queue.enqueue(1);

            assertArrayEquals(createArray(2, 1), queue.toArray());
        }
    }

    @Nested
    class Dequeue {
        @Test
        void shouldReturnNullForEmptyQueue() {
            Queue queue = new Queue();

            assertNull(queue.dequeue());
        }

        @Test
        void shouldEmptyQueue() {
            Queue queue = new Queue(2);

            assertEquals(2, queue.dequeue().value);
            assertArrayEquals(createArray(), queue.toArray());
        }

        @Test
        void shouldRemoveFirstNode() {
            Queue queue = new Queue(2);
            queue.enqueue(1);

            assertEquals(2, queue.dequeue().value);
            assertArrayEquals(createArray(1), queue.toArray());
        }
    }

    private int[] createArray(int ... values) {
        return values;
    }
}