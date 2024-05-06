package com.gokulnathp.datastractures;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {
    @Nested
    class ToArray {
        @Test
        void shouldReturnAllNodes() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(2);
            doublyLinkedList.append(3);
            doublyLinkedList.append(4);

            assertArrayEquals(createArray(2, 3, 4), doublyLinkedList.toArray());
        }
    }

    @Nested
    class Append {
        @Test
        void shouldAddNodeToEmptyList() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

            doublyLinkedList.append(1);

            assertArrayEquals(createArray(1), doublyLinkedList.toArray());
        }

        @Test
        void shouldAddNodeToExistingList() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(2);

            doublyLinkedList.append(3);

            assertArrayEquals(createArray(2, 3), doublyLinkedList.toArray());
        }
    }

    @Nested
    class RemoveLast {
        @Test
        void shouldReturnNullWhenListIsEmpty() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

            assertNull(doublyLinkedList.removeLast());
        }

        @Test
        void shouldEmptyListWhenThereIsOnlyOneNode() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(2);

            assertEquals(2, doublyLinkedList.removeLast().value);
            assertArrayEquals(createArray(), doublyLinkedList.toArray());
        }

        @Test
        void shouldRemoveLastNode() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(2);
            doublyLinkedList.append(3);

            assertEquals(3, doublyLinkedList.removeLast().value);
            assertArrayEquals(createArray(2), doublyLinkedList.toArray());
        }
    }

    @Nested
    class Prepend {
        @Test
        void shouldAddNewNodeToEmptyList() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

            doublyLinkedList.prepend(2);

            assertArrayEquals(createArray(2), doublyLinkedList.toArray());
        }

        @Test
        void shouldAddNewNodeToExistingList() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(2);

            doublyLinkedList.prepend(1);

            assertArrayEquals(createArray(1, 2), doublyLinkedList.toArray());
        }
    }

    @Nested
    class RemoveFirst {
        @Test
        void shouldReturnNullWhenListIsEmpty() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

            assertNull(doublyLinkedList.removeFirst());
        }

        @Test
        void shouldEmptyListWhenThereIsOnlyOneNode() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(2);

            assertEquals(2, doublyLinkedList.removeFirst().value);
            assertArrayEquals(createArray(), doublyLinkedList.toArray());
        }

        @Test
        void shouldRemoveFirstNode() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(2);
            doublyLinkedList.prepend(1);
            doublyLinkedList.append(3);


            assertEquals(1, doublyLinkedList.removeFirst().value);
            assertArrayEquals(createArray(2, 3), doublyLinkedList.toArray());
        }
    }

    @Nested
    class Get {
        @Test
        void shouldReturnNullWhenIndexIsLessThanZero() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(2);

            assertNull(doublyLinkedList.get(-1));
        }

        @Test
        void shouldReturnNullWhenIndexIsGreaterThanLength() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(2);

            assertNull(doublyLinkedList.get(3));
        }

        @Test
        void shouldReturnNullWhenIndexIsEqualToLength() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(2);

            assertNull(doublyLinkedList.get(1));
        }

        @Test
        void shouldReturnNullWhenListIsEmpty() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

            assertNull(doublyLinkedList.get(0));
        }

        @Test
        void shouldReturnNodeFromStart() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(2);
            doublyLinkedList.prepend(1);
            doublyLinkedList.append(3);

            assertEquals(1, doublyLinkedList.get(0).value);
        }

        @Test
        void shouldReturnNodeFromMiddle() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(2);
            doublyLinkedList.append(3);
            doublyLinkedList.prepend(1);

            assertEquals(2, doublyLinkedList.get(1).value);
        }

        @Test
        void shouldReturnNodeFromEnd() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(2);
            doublyLinkedList.prepend(1);
            doublyLinkedList.append(3);

            assertEquals(3, doublyLinkedList.get(2).value);
        }
    }

    @Nested
    class Set {
        @Test
        void shouldReturnFalseWhenNodeIsMissing() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

            assertFalse(doublyLinkedList.set(0, 1));
        }

        @Test
        void shouldUpdateValue() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(2);

            assertTrue(doublyLinkedList.set(0, 1));
            assertEquals(1, doublyLinkedList.get(0).value);
        }
    }

    @Nested
    class Insert {
        @Test
        void shouldReturnFalseWhenIndexIsLessThanZero() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(2);

            assertFalse(doublyLinkedList.insert(-1, 2));
        }

        @Test
        void shouldReturnFalseWhenIndexIsGreaterThanLength() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(2);

            assertFalse(doublyLinkedList.insert(2, 1));
        }

        @Test
        void shouldPrependNewNodeWhenIndexIsZero() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(2);

            assertTrue(doublyLinkedList.insert(0, 1));
            assertArrayEquals(createArray(1, 2), doublyLinkedList.toArray());
        }

        @Test
        void shouldAppendNewNodeWhenIndexIsEqualToLength() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(2);

            assertTrue(doublyLinkedList.insert(1, 3));
            assertArrayEquals(createArray(2, 3), doublyLinkedList.toArray());
        }

        @Test
        void shouldInsertNodeInTheMiddle() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(3);
            doublyLinkedList.prepend(1);

            assertTrue(doublyLinkedList.insert(1, 2));
            assertArrayEquals(createArray(1, 2, 3), doublyLinkedList.toArray());
        }
    }

    @Nested
    class Remove {
        @Test
        void shouldReturnNullWhenIndexIsLessThanZero() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(1);

            assertNull(doublyLinkedList.remove(-1));
        }

        @Test
        void shouldReturnNullWhenIndexIsEqualToLength() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(2);

            assertNull(doublyLinkedList.remove(1));
        }

        @Test
        void shouldReturnNullWhenIndexIsGreaterThanLength() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(2);

            assertNull(doublyLinkedList.remove(3));
        }

        @Test
        void shouldRemoveFirstNode() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(2);
            doublyLinkedList.prepend(1);
            doublyLinkedList.append(3);

            assertEquals(1, doublyLinkedList.remove(0).value);
            assertArrayEquals(createArray(2, 3), doublyLinkedList.toArray());
        }

        @Test
        void shouldRemoveNodeFromMiddle() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(2);
            doublyLinkedList.prepend(1);
            doublyLinkedList.append(3);

            assertEquals(2, doublyLinkedList.remove(1).value);
            assertArrayEquals(createArray(1, 3), doublyLinkedList.toArray());
        }

        @Test
        void shouldRemoveLastNode() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(2);
            doublyLinkedList.append(3);
            doublyLinkedList.prepend(1);

            assertEquals(3, doublyLinkedList.remove(2).value);
            assertArrayEquals(createArray(1, 2), doublyLinkedList.toArray());
        }
    }

    @Nested
    class SwapFirstLast {
        @Test
        void shouldDoNothingWhenListIsEmpty() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

            doublyLinkedList.swapFirstLast();

            assertArrayEquals(createArray(), doublyLinkedList.toArray());
        }

        @Test
        void shouldDoNothingWhenListHasOnlyOneNode() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(2);

            doublyLinkedList.swapFirstLast();

            assertArrayEquals(createArray(2), doublyLinkedList.toArray());
        }

        @Test
        void shouldSwapTwoNodeValue() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(2);
            doublyLinkedList.append(3);

            doublyLinkedList.swapFirstLast();

            assertArrayEquals(createArray(3, 2), doublyLinkedList.toArray());
        }

        @Test
        void shouldSwapFirstAndLastNodeValue() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(2);
            doublyLinkedList.prepend(1);
            doublyLinkedList.append(3);

            doublyLinkedList.swapFirstLast();

            assertArrayEquals(createArray(3, 2, 1), doublyLinkedList.toArray());
        }
    }

    @Nested
    class Reverse {
        @Test
        void shouldDoNothingWhenListIsEmpty() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

            doublyLinkedList.reverse();

            assertArrayEquals(createArray(), doublyLinkedList.toArray());
        }

        @Test
        void shouldDoNothingWhenListHasOnlyOneNode() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(2);

            doublyLinkedList.reverse();

            assertArrayEquals(createArray(2), doublyLinkedList.toArray());
        }

        @Test
        void shouldSwapTwoNodes() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(2);
            doublyLinkedList.append(1);

            doublyLinkedList.reverse();

            assertArrayEquals(createArray(1, 2), doublyLinkedList.toArray());
        }

        @Test
        void shouldReverseTheNodes() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(2);
            doublyLinkedList.prepend(1);
            doublyLinkedList.append(3);
            doublyLinkedList.append(4);

            doublyLinkedList.reverse();

            assertArrayEquals(createArray(4, 3, 2, 1), doublyLinkedList.toArray());
        }
    }

    @Nested
    class IsPalindrome {
        @Test
        void shouldReturnTrueWhenListIsEmpty() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

            assertTrue(doublyLinkedList.isPalindrome());
        }

        @Test
        void shouldReturnTrueWhenListHasOnlyOneElement() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(2);

            assertTrue(doublyLinkedList.isPalindrome());
        }

        @Test
        void shouldReturnTrueWhenListWithTwoSameNodes() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(2);
            doublyLinkedList.append(2);

            assertTrue(doublyLinkedList.isPalindrome());
        }

        @Test
        void shouldReturnFalseWhenListWithTwoDifferentNode() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(2);
            doublyLinkedList.append(1);

            assertFalse(doublyLinkedList.isPalindrome());
        }

        @Test
        void shouldReturnTrueIfListWithOddNodesHasPalindrome() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(2);
            doublyLinkedList.append(1);
            doublyLinkedList.prepend(1);

            assertTrue(doublyLinkedList.isPalindrome());
        }

        @Test
        void shouldReturnTrueIfListWithEventNodesHasPalindrome() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(1);
            doublyLinkedList.append(2);
            doublyLinkedList.append(3);
            doublyLinkedList.append(3);
            doublyLinkedList.append(2);
            doublyLinkedList.append(1);

            assertTrue(doublyLinkedList.isPalindrome());
        }

        @Test
        void shouldReturnFalseIfListWithOddNodesHasNoPalindrome() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(2);
            doublyLinkedList.append(3);
            doublyLinkedList.prepend(4);
            doublyLinkedList.append(1);
            doublyLinkedList.prepend(1);

            assertFalse(doublyLinkedList.isPalindrome());
        }

        @Test
        void shouldReturnFalseIfListWithEventNodesHasNoPalindrome() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(1);
            doublyLinkedList.append(2);
            doublyLinkedList.append(3);
            doublyLinkedList.append(4);
            doublyLinkedList.append(2);
            doublyLinkedList.append(1);

            assertFalse(doublyLinkedList.isPalindrome());
        }
    }

    @Nested
    class SwapPairs {
        @Test
        void shouldDoNothingWhenListIsEmpty() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

            doublyLinkedList.swapPairs();

            assertArrayEquals(createArray(), doublyLinkedList.toArray());
        }

        @Test
        void shouldDoNothingWhenListHasOnlyOneNode() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(2);

            doublyLinkedList.swapPairs();

            assertArrayEquals(createArray(2), doublyLinkedList.toArray());
        }

        @Test
        void shouldSwapTwoNodes() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(2);
            doublyLinkedList.append(3);

            doublyLinkedList.swapPairs();

            assertArrayEquals(createArray(3, 2), doublyLinkedList.toArray());
        }

        @Test
        void shouldSwapPairsWhenListHasOddLength() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(2);
            doublyLinkedList.append(3);
            doublyLinkedList.append(4);
            doublyLinkedList.append(2);
            doublyLinkedList.append(5);

            doublyLinkedList.swapPairs();

            assertArrayEquals(createArray(3, 2, 2, 4, 5), doublyLinkedList.toArray());
        }

        @Test
        void shouldSwapPairsWhenListHasEvenLength() {
            DoublyLinkedList doublyLinkedList = new DoublyLinkedList(2);
            doublyLinkedList.prepend(1);
            doublyLinkedList.append(3);
            doublyLinkedList.append(4);

            doublyLinkedList.swapPairs();

            assertArrayEquals(createArray(2, 1, 4, 3), doublyLinkedList.toArray());
        }
    }

    private int[] createArray(int... numbers) {
        return numbers;
    }
}