package com.gokulnathp.datastractures;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    @Nested
    class ToArray {
        @Test
        void shouldCreateEmptyStack() {
            Stack stack = new Stack();

            assertArrayEquals(createArray(), stack.toArray());
        }

        @Test
        void shouldCreateStackWithOneNode() {
            Stack stack = new Stack(1);

            assertArrayEquals(createArray(1), stack.toArray());
        }
    }

    @Nested
    class Push {
        @Test
        void shouldAddNodeToEmptyStack() {
            Stack stack = new Stack();

            stack.push(2);

            assertArrayEquals(createArray(2), stack.toArray());
        }

        @Test
        void shouldAddNodeAtTheStart() {
            Stack stack = new Stack(2);

            stack.push(1);

            assertArrayEquals(createArray(1, 2), stack.toArray());
        }
    }

    @Nested
    class Pop {
        @Test
        void shouldReturnNullWhenStackIsEmpty() {
            Stack stack = new Stack();

            assertNull(stack.pop());
        }

        @Test
        void shouldEmptyStack() {
            Stack stack = new Stack(2);

            assertEquals(2, stack.pop().value);
            assertArrayEquals(createArray(), stack.toArray());
        }

        @Test
        void shouldRemoveTopNode() {
            Stack stack = new Stack(2);
            stack.push(1);

            assertEquals(1, stack.pop().value);
            assertArrayEquals(createArray(2), stack.toArray());
        }
    }

    private int[] createArray(int ... values) {
        return values;
    }
}