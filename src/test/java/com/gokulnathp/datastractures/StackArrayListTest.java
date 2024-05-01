package com.gokulnathp.datastractures;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackArrayListTest {
    @Nested
    class Push {
        @Test
        void shouldAddElementToEmptyList() {
            StackArrayList<Integer> integerStackArrayList = new StackArrayList<>();

            integerStackArrayList.push(1);

            assertArrayEquals(createArray(1), integerStackArrayList.toArray());
        }

        @Test
        void shouldAddElementToExistingList() {
            StackArrayList<Integer> integerStackArrayList = new StackArrayList<>();

            integerStackArrayList.push(1);
            integerStackArrayList.push(2);

            assertArrayEquals(createArray(1, 2), integerStackArrayList.toArray());
        }
    }

    @Nested
    class Pop {
        @Test
        void shouldReturnNullWhenListIsEmpty() {
            StackArrayList<Integer> integerStackArrayList = new StackArrayList<>();

            assertNull(integerStackArrayList.pop());
            assertArrayEquals(createArray(), integerStackArrayList.toArray());
        }

        @Test
        void shouldEmptyStack() {
            StackArrayList<Integer> integerStackArrayList = new StackArrayList<>();
            integerStackArrayList.push(1);

            assertEquals(1, integerStackArrayList.pop());
            assertArrayEquals(createArray(), integerStackArrayList.toArray());
        }

        @Test
        void shouldRemoveLastElement() {
            StackArrayList<Integer> integerStackArrayList = new StackArrayList<>();
            integerStackArrayList.push(1);
            integerStackArrayList.push(2);

            assertEquals(2, integerStackArrayList.pop());
            assertArrayEquals(createArray(1), integerStackArrayList.toArray());
        }
    }
    
    @Nested
    class ReverseString {
        @Test
        void shouldReverseEmptyString() {
            assertEquals("", StackArrayList.reverseString(""));
        }

        @Test
        void shouldReverseSingleCharString() {
            assertEquals("a", StackArrayList.reverseString("a"));
        }

        @Test
        void shouldReverseMultipleCharString() {
            assertEquals("olleH", StackArrayList.reverseString("Hello"));
        }

        @Test
        void shouldReverseTwoCharString() {
            assertEquals("ba", StackArrayList.reverseString("ab"));
        }
    }

    @Nested
    class IsBalancedParentheses {
        @Test
        void shouldReturnTrueWhenItIsBalanced() {
            assertTrue(StackArrayList.isBalancedParentheses("()"));
            assertTrue(StackArrayList.isBalancedParentheses("()()"));
            assertTrue(StackArrayList.isBalancedParentheses("(())"));
            assertTrue(StackArrayList.isBalancedParentheses("()()()"));
            assertTrue(StackArrayList.isBalancedParentheses("(()())"));
        }

        @Test
        void shouldReturnFalseWhenItIsNotBalanced() {
            assertFalse(StackArrayList.isBalancedParentheses(")()("));
            assertFalse(StackArrayList.isBalancedParentheses(")("));
            assertFalse(StackArrayList.isBalancedParentheses("(()"));
            assertFalse(StackArrayList.isBalancedParentheses("())"));
            assertFalse(StackArrayList.isBalancedParentheses("))"));
            assertFalse(StackArrayList.isBalancedParentheses("("));
            assertFalse(StackArrayList.isBalancedParentheses(")"));
        }
    }

    @Nested
    class SortStack {
        @Test
        void shouldDoNothingWhenStackIsEmpty() {
            StackArrayList<Integer> integerStackArrayList = new StackArrayList<>();

            assertArrayEquals(createArray(), integerStackArrayList.toArray());
        }

        @Test
        void shouldDoNothingWhenStackHasOnlyOneElement() {
            StackArrayList<Integer> integerStackArrayList = new StackArrayList<>();
            integerStackArrayList.push(2);

            StackArrayList.sortStack(integerStackArrayList);

            assertArrayEquals(createArray(2), integerStackArrayList.toArray());
        }

        @Test
        void shouldSortStackOfTwoElements() {
            StackArrayList<Integer> integerStackArrayList = new StackArrayList<>();
            integerStackArrayList.push(1);
            integerStackArrayList.push(2);

            StackArrayList.sortStack(integerStackArrayList);

            assertArrayEquals(createArray(2, 1), integerStackArrayList.toArray());
        }

        @Test
        void shouldSortStackOfThreeElements() {
            StackArrayList<Integer> integerStackArrayList = new StackArrayList<>();
            integerStackArrayList.push(1);
            integerStackArrayList.push(3);
            integerStackArrayList.push(2);

            StackArrayList.sortStack(integerStackArrayList);

            assertArrayEquals(createArray(3, 2, 1), integerStackArrayList.toArray());
        }

        @Test
        void shouldSortStackOfMultipleElements() {
            StackArrayList<Integer> integerStackArrayList = new StackArrayList<>();
            integerStackArrayList.push(3);
            integerStackArrayList.push(2);
            integerStackArrayList.push(5);
            integerStackArrayList.push(1);
            integerStackArrayList.push(4);

            StackArrayList.sortStack(integerStackArrayList);

            assertArrayEquals(createArray(5, 4, 3, 2, 1), integerStackArrayList.toArray());
        }
    }

    @SafeVarargs
    private <T> T[] createArray(T ... values) {
        return values;
    }
}