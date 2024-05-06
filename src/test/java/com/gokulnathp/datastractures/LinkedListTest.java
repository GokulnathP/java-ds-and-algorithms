package com.gokulnathp.datastractures;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    @Nested
    class ToArray {
        @Test
        void shouldReturnAllNodes() {
            LinkedList linkedList = new LinkedList(2);

            assertArrayEquals(linkedList.toArray(), createArray(2));
        }
    }

    @Nested
    class RemoveFirst {
        @Test
        void shouldRemoveFirstNode() {
            LinkedList linkedList = new LinkedList(1);


            assertEquals(linkedList.removeFirst().value, 1);
            assertArrayEquals(linkedList.toArray(), createArray());
        }

        @Test
        void shouldReturnNullWhenTheListIsEmptyForRemoveFirstNode() {
            LinkedList linkedList = new LinkedList(1);

            linkedList.removeFirst();

            assertNull(linkedList.removeFirst());
            assertEquals(linkedList.toArray().length, 0);
        }
    }

    @Nested
    class Prepend {
        @Test
        void shouldPrependNewElementToList() {
            LinkedList linkedList = new LinkedList(2);

            linkedList.prepend(3);

            assertArrayEquals(linkedList.toArray(), createArray(3, 2));
        }

        @Test
        void shouldPrependNewElementToEmptyList() {
            LinkedList linkedList = new LinkedList(1);

            linkedList.removeFirst();
            linkedList.prepend(2);

            assertArrayEquals(linkedList.toArray(), createArray(2));
        }
    }

    @Nested
    class Append {
        @Test
        void shouldAppendNewElementToList() {
            LinkedList linkedList = new LinkedList(2);

            linkedList.append(3);

            assertArrayEquals(linkedList.toArray(), createArray(2, 3));
        }

        @Test
        void shouldAppendNewElementToEmptyList() {
            LinkedList linkedList = new LinkedList(2);

            linkedList.removeFirst();
            linkedList.append(3);

            assertArrayEquals(linkedList.toArray(), createArray(3));
        }
    }

    @Nested
    class RemoveLast {
        @Test
        void shouldRemoveLastNode() {
            LinkedList linkedList = new LinkedList(2);

            assertEquals(linkedList.removeLast().value, 2);
            assertArrayEquals(linkedList.toArray(), createArray());
        }

        @Test
        void shouldReturnNullWhenTheListIsEmptyForRemoveLastNode() {
            LinkedList linkedList = new LinkedList(2);

            linkedList.removeLast();

            assertNull(linkedList.removeLast());
            assertEquals(linkedList.toArray().length, 0);
        }
    }

    @Nested
    class Get {
        @Test
        void shouldReturnNullWhenListIsEmpty() {
            LinkedList linkedList = new LinkedList(2);
            linkedList.removeFirst();

            assertNull(linkedList.get(0));
        }

        @Test
        void shouldReturnNullWhenIndexIsLessThanZero() {
            LinkedList linkedList = new LinkedList(2);

            assertNull(linkedList.get(-1));
        }

        @Test
        void shouldReturnNullWhenIndexIsGreaterThanLength() {
            LinkedList linkedList = new LinkedList(2);

            assertNull(linkedList.get(2));
        }

        @Test
        void shouldReturnNullWhenIndexIsEqualToLength() {
            LinkedList linkedList = new LinkedList(2);

            assertNull(linkedList.get(1));
        }

        @Test
        void shouldReturnNodeFromBeginningOfTheList() {
            LinkedList linkedList = new LinkedList(4);
            linkedList.append(3);
            linkedList.prepend(-2);

            assertEquals(linkedList.get(0).value, -2);
        }

        @Test
        void shouldReturnNodeFromMiddleOfTheList() {
            LinkedList linkedList = new LinkedList(2);
            linkedList.append(3);
            linkedList.prepend(1);

            assertEquals(linkedList.get(1).value, 2);
        }

        @Test
        void shouldReturnNodeFromEndOfTheList() {
            LinkedList linkedList = new LinkedList(0);
            linkedList.append(3);
            linkedList.prepend(-1);

            assertEquals(linkedList.get(2).value, 3);
        }
    }

    @Nested
    class Set {
        @Test
        void shouldNotUpdateIfTheNodeIsMissing() {
            LinkedList linkedList = new LinkedList(2);

            boolean isUpdated = linkedList.set(2, 3);

            assertFalse(isUpdated);
        }

        @Test
        void shouldUpdateTheValueForNodeInTheBeginning() {
            LinkedList linkedList = new LinkedList(3);
            linkedList.append(2);
            linkedList.prepend(0);

            boolean isUpdated = linkedList.set(0, 1);

            assertTrue(isUpdated);
            assertEquals(linkedList.get(0).value, 1);
        }

        @Test
        void shouldUpdateTheValueForNodeInTheMiddle() {
            LinkedList linkedList = new LinkedList(3);
            linkedList.append(2);
            linkedList.prepend(0);

            boolean isUpdated = linkedList.set(1, 5);

            assertTrue(isUpdated);
            assertEquals(linkedList.get(1).value, 5);
        }

        @Test
        void shouldUpdateTheValueForNodeInTheEnd() {
            LinkedList linkedList = new LinkedList(3);
            linkedList.append(2);
            linkedList.prepend(0);

            boolean isUpdated = linkedList.set(2, 4);

            assertTrue(isUpdated);
            assertEquals(linkedList.get(2).value, 4);
        }
    }

    @Nested
    class Insert {
        @Test
        void shouldNotInsertIfTheIndexIsLessThanZero() {
            LinkedList linkedList = new LinkedList(2);

            boolean isInserted = linkedList.insert(-1, 1);

            assertFalse(isInserted);
        }

        @Test
        void shouldNotInsertIfTheIndexIsGreaterThanTheListLength() {
            LinkedList linkedList = new LinkedList(2);

            boolean isInserted = linkedList.insert(2, 3);

            assertFalse(isInserted);
            assertEquals(linkedList.toArray().length, 1);
        }

        @Test
        void shouldPrependWhenTheIndexIsZero() {
            LinkedList linkedList = new LinkedList(3);

            boolean isInserted = linkedList.insert(0, 2);

            assertTrue(isInserted);
            assertEquals(linkedList.get(0).value, 2);
            assertEquals(linkedList.toArray().length, 2);
        }

        @Test
        void shouldAppendWhenTheIndexIsEqualToLength() {
            LinkedList linkedList = new LinkedList(3);

            boolean isInserted = linkedList.insert(1, 4);

            assertTrue(isInserted);
            assertEquals(linkedList.get(1).value, 4);
            assertEquals(linkedList.toArray().length, 2);
        }

        @Test
        void shouldInsertInTheMiddleOfTheList() {
            LinkedList linkedList = new LinkedList(2);
            linkedList.append(4);
            linkedList.prepend(0);

            boolean isInserted = linkedList.insert(2, 3);

            assertTrue(isInserted);
            assertEquals(linkedList.get(2).value, 3);
            assertEquals(linkedList.toArray().length, 4);
        }
    }

    @Nested
    class Remove {
        @Test
        void shouldReturnNullWhenIndexIsLessThanZero() {
            LinkedList linkedList = new LinkedList(2);

            assertNull(linkedList.remove(-1));
        }

        @Test
        void shouldReturnNullWhenIndexIsEqualToListLength() {
            LinkedList linkedList = new LinkedList(2);

            assertNull(linkedList.remove(1));
        }

        @Test
        void shouldReturnNullWhenIndexIsGreaterThanLength() {
            LinkedList linkedList = new LinkedList(2);

            assertNull(linkedList.remove(3));
        }

        @Test
        void shouldRemovedNodeFromTheBeginning() {
            LinkedList linkedList = new LinkedList(2);
            linkedList.append(3);
            linkedList.prepend(1);

            assertEquals(linkedList.remove(0).value, 1);
            assertArrayEquals(linkedList.toArray(), createArray(2, 3));
        }

        @Test
        void shouldRemoveNodeFromTheMiddle() {
            LinkedList linkedList = new LinkedList(2);
            linkedList.append(3);
            linkedList.prepend(1);

            assertEquals(linkedList.remove(1).value, 2);
            assertArrayEquals(linkedList.toArray(), createArray(1, 3));
        }

        @Test
        void shouldRemoveNodeFromTheEnd() {
            LinkedList linkedList = new LinkedList(2);
            linkedList.append(3);
            linkedList.prepend(1);

            assertEquals(linkedList.remove(2).value, 3);
            assertArrayEquals(linkedList.toArray(), createArray(1, 2));
        }
    }

    @Nested
    class Reverse {
        @Test
        void shouldReverseTheList() {
            LinkedList linkedList = new LinkedList(2);
            linkedList.prepend(1);
            linkedList.append(3);

            linkedList.reverse();

            assertArrayEquals(linkedList.toArray(), createArray(3, 2, 1));
        }

        @Test
        void shouldReverseEmptyList() {
            LinkedList linkedList = new LinkedList(2);
            linkedList.removeLast();

            linkedList.reverse();

            assertArrayEquals(linkedList.toArray(), createArray());
        }

        @Test
        void shouldReverseListWithTwoNodes() {
            LinkedList linkedList = new LinkedList(2);
            linkedList.append(3);

            linkedList.reverse();

            assertArrayEquals(linkedList.toArray(), createArray(3, 2));
        }
    }

    @Nested
    class FindMiddleNode {
        @Test
        void shouldReturnMiddleNodeForOddLengthList() {
            LinkedList linkedList = new LinkedList(2);
            linkedList.append(3);
            linkedList.prepend(1);

            assertEquals(linkedList.findMiddleNode().value, 2);
        }

        @Test
        void shouldReturnSecondMiddleNodeForEvenLengthList() {
            LinkedList linkedList = new LinkedList(2);
            linkedList.append(3);
            linkedList.append(4);
            linkedList.prepend(1);

            assertEquals(linkedList.findMiddleNode().value, 3);
        }

        @Test
        void shouldReturnFirstNodeForSingleNodeList() {
            LinkedList linkedList = new LinkedList(2);

            assertEquals(linkedList.findMiddleNode().value, 2);
        }

        @Test
        void shouldReturnLastNodeForListWithTwoNodes() {
            LinkedList linkedList = new LinkedList(2);
            linkedList.append(3);

            assertEquals(linkedList.findMiddleNode().value, 3);
        }

        @Test
        void shouldReturnNullForEmptyList() {
            LinkedList linkedList = new LinkedList(2);
            linkedList.removeLast();

            assertNull(linkedList.findMiddleNode());
        }
    }

    @Nested
    class HasLoop {
        @Test
        void shouldReturnFalseWhenListIsEmpty() {
            LinkedList linkedList = new LinkedList(2);
            linkedList.removeFirst();

            boolean hasLoop = linkedList.hasLoop();

            assertFalse(hasLoop);
        }

        @Test
        void shouldReturnFalseWhenListHasOneElement() {
            LinkedList linkedList = new LinkedList(3);

            boolean hasLoop = linkedList.hasLoop();

            assertFalse(hasLoop);
        }

        @Test
        void shouldReturnFalseWhenThereIsNoLoop() {
            LinkedList linkedList = new LinkedList(3);
            linkedList.append(4);
            linkedList.prepend(2);

            boolean hasLoop = linkedList.hasLoop();

            assertFalse(hasLoop);
        }

        @Test
        void shouldReturnTrueWhenThereIsLoop() {
            LinkedList linkedList = new LinkedList(3);
            linkedList.append(4);
            linkedList.prepend(2);
            linkedList.createLoop();

            boolean hasLoop = linkedList.hasLoop();

            assertTrue(hasLoop);
        }
    }

    @Nested
    class FindKthNodeFromEnd {
        @Test
        void shouldReturnNullWhenKIsLessThanZero() {
            LinkedList linkedList = new LinkedList(2);

            assertNull(linkedList.findKthNodeFromEnd(-1));
        }

        @Test
        void shouldReturnNullWhenKIsZero() {
            LinkedList linkedList = new LinkedList(2);

            assertNull(linkedList.findKthNodeFromEnd(0));
        }

        @Test
        void shouldReturnNullWhenKIsGreaterThanLength() {
            LinkedList linkedList = new LinkedList(2);
            linkedList.append(3);

            assertNull(linkedList.findKthNodeFromEnd(3));
        }

        @Test
        void shouldReturnKThNodeInTheStart() {
            LinkedList linkedList = new LinkedList(2);
            linkedList.append(3);
            linkedList.prepend(1);
            linkedList.append(4);

            assertEquals(linkedList.findKthNodeFromEnd(4).value, 1);
        }

        @Test
        void shouldReturnKThNodeFromEnd() {
            LinkedList linkedList = new LinkedList(2);
            linkedList.append(3);
            linkedList.prepend(1);

            assertEquals(linkedList.findKthNodeFromEnd(1).value, 3);
        }

        @Test
        void shouldReturnKThNodeFromMiddle() {
            LinkedList linkedList = new LinkedList(3);
            linkedList.prepend(2);
            linkedList.append(4);
            linkedList.append(5);

            assertEquals(linkedList.findKthNodeFromEnd(3).value, 3);
        }
    }

    @Nested
    class FindKthFromEnd {
        @Test
        void shouldReturnNullWhenKIsLessThanZero() {
            LinkedList linkedList = new LinkedList(2);

            assertNull(linkedList.findKthFromEnd(-1));
        }

        @Test
        void shouldReturnNullWhenKIsZero() {
            LinkedList linkedList = new LinkedList(2);

            assertNull(linkedList.findKthFromEnd(0));
        }

        @Test
        void shouldReturnNullWhenKIsGreaterThanLength() {
            LinkedList linkedList = new LinkedList(2);
            linkedList.append(3);

            assertNull(linkedList.findKthFromEnd(3));
        }

        @Test
        void shouldReturnKThNodeInTheStart() {
            LinkedList linkedList = new LinkedList(2);
            linkedList.append(3);
            linkedList.prepend(1);
            linkedList.append(4);

            assertEquals(linkedList.findKthFromEnd(4).value, 1);
        }

        @Test
        void shouldReturnKThNodeFromEnd() {
            LinkedList linkedList = new LinkedList(2);
            linkedList.append(3);
            linkedList.prepend(1);

            assertEquals(linkedList.findKthFromEnd(1).value, 3);
        }

        @Test
        void shouldReturnKThNodeFromMiddle() {
            LinkedList linkedList = new LinkedList(3);
            linkedList.prepend(2);
            linkedList.append(4);
            linkedList.append(5);

            assertEquals(linkedList.findKthFromEnd(3).value, 3);
        }
    }

    @Nested
    class PartitionList {
        @Test
        void shouldDoNoChangesWhenListIsEmpty() {
            LinkedList linkedList = new LinkedList(2);
            linkedList.removeFirst();

            linkedList.partitionList(1);

            assertArrayEquals(linkedList.toArray(), createArray());
        }

        @Test
        void shouldDoNoChangesWhenListHasOnlyOneElement() {
            LinkedList linkedList = new LinkedList(3);

            linkedList.partitionList(2);

            assertArrayEquals(linkedList.toArray(), createArray(3));
        }

        @Test
        void shouldDoNoChangesWhenListHasOnlyValuesLessThanX() {
            LinkedList linkedList = new LinkedList(3);
            linkedList.append(2);
            linkedList.append(1);

            linkedList.partitionList(4);

            assertArrayEquals(linkedList.toArray(), createArray(3, 2, 1));
        }

        @Test
        void shouldDoNoChangeWhenListHasOnlyValuesGreaterThanOrEqualToX() {
            LinkedList linkedList = new LinkedList(4);
            linkedList.append(3);
            linkedList.append(5);

            linkedList.partitionList(3);

            assertArrayEquals(linkedList.toArray(), createArray(4, 3, 5));
        }

        @Test
        void shouldRearrangeTheListWhenFirstNodeIsGreaterThanX() {
            LinkedList linkedList = new LinkedList(3);
            linkedList.append(2);
            linkedList.append(1);

            linkedList.partitionList(2);

            assertArrayEquals(linkedList.toArray(), createArray(1, 3, 2));
        }

        @Test
        void shouldRearrangeTheListWhenFirstNodeIsLessThanX() {
            LinkedList linkedList = new LinkedList(1);
            linkedList.append(4);
            linkedList.append(3);
            linkedList.append(2);
            linkedList.append(0);

            linkedList.partitionList(3);

            assertArrayEquals(linkedList.toArray(), createArray(1, 2, 0, 4, 3));
        }

        @Test
        void shouldDoNothingWhenItIsInExpectedOrder() {
            LinkedList linkedList = new LinkedList(1);
            linkedList.append(2);
            linkedList.append(4);
            linkedList.append(3);

            linkedList.partitionList(3);

            assertArrayEquals(linkedList.toArray(), createArray(1, 2, 4, 3));
        }
    }

    @Nested
    class RemoveDuplicates {
        @Test
        void shouldDoNothingWhenListIsEmpty() {
            LinkedList linkedList = new LinkedList(3);
            linkedList.removeFirst();

            linkedList.removeDuplicates();

            assertArrayEquals(linkedList.toArray(), createArray());
        }

        @Test
        void shouldDoNothingWhenListHasOnlyOneNode() {
            LinkedList linkedList = new LinkedList(2);

            linkedList.removeDuplicates();

            assertArrayEquals(linkedList.toArray(), createArray(2));
        }

        @Test
        void shouldDoNothingWhenThereIsNoDuplicates() {
            LinkedList linkedList = new LinkedList(3);
            linkedList.append(4);
            linkedList.prepend(2);
            linkedList.append(5);

            linkedList.removeDuplicates();

            assertArrayEquals(linkedList.toArray(), createArray(2, 3, 4, 5));
        }

        @Test
        void shouldRemoveDuplicatesInTheMiddle() {
            LinkedList linkedList = new LinkedList(4);
            linkedList.append(5);
            linkedList.append(3);
            linkedList.append(4);
            linkedList.append(5);
            linkedList.append(2);

            linkedList.removeDuplicates();

            assertArrayEquals(linkedList.toArray(), createArray(4, 5, 3, 2));
        }

        @Test
        void shouldRemoveDuplicatesInTheEnd() {
            LinkedList linkedList = new LinkedList(4);
            linkedList.append(4);
            linkedList.append(5);
            linkedList.append(3);
            linkedList.append(4);
            linkedList.append(5);

            linkedList.removeDuplicates();

            assertArrayEquals(linkedList.toArray(), createArray(4, 5, 3));
        }

        @Test
        void shouldRemoveAllDuplicates() {
            LinkedList linkedList = new LinkedList(4);
            linkedList.append(4);
            linkedList.append(4);
            linkedList.append(4);
            linkedList.append(4);

            linkedList.removeDuplicates();

            assertArrayEquals(linkedList.toArray(), createArray(4));
        }
    }
    
    @Nested
    class BinaryToDecimal {
        @Test
        void shouldReturnZeroWhenTheListIsEmpty() {
            LinkedList linkedList = new LinkedList(1);
            linkedList.removeFirst();

            int decimal = linkedList.binaryToDecimal();

            assertEquals(0, decimal);
        }

        @Test
        void shouldReturnOneWhenListHasOnlyOneNodeWithOne() {
            LinkedList linkedList = new LinkedList(1);

            int decimal = linkedList.binaryToDecimal();

            assertEquals(1, decimal);
        }

        @Test
        void shouldReturnZeroWhenListHasOnlyOneNodeWithZero() {
            LinkedList linkedList = new LinkedList(0);

            int decimal = linkedList.binaryToDecimal();

            assertEquals(0, decimal);
        }

        @Test
        void shouldConvertSimpleBinaryToDecimal() {
            LinkedList linkedList = new LinkedList(1);
            linkedList.append(0);
            linkedList.append(1);

            int decimal = linkedList.binaryToDecimal();

            assertEquals(5, decimal);
        }

        @Test
        void shouldConvertComplexBinaryToDecimal() {
            LinkedList linkedList = new LinkedList(1);
            linkedList.append(1);
            linkedList.append(1);
            linkedList.append(0);
            linkedList.append(1);
            linkedList.append(1);
            linkedList.append(0);

            int decimal = linkedList.binaryToDecimal();

            assertEquals(118, decimal);
        }
    }

    @Nested
    class ReverseBetween {
        @Test
        void shouldDoNothingWhenListIsEmpty() {
            LinkedList linkedList = new LinkedList();

            linkedList.reverseBetween(0, 0);

            assertArrayEquals(linkedList.toArray(), createArray());
        }

        @Test
        void shouldDoNothingWhenListHasOnlyOneElement() {
            LinkedList linkedList = new LinkedList(1);

            linkedList.reverseBetween(0, 1);

            assertArrayEquals(linkedList.toArray(), createArray(1));
        }

        @Test
        void shouldDoNothingWhenListStartingIndexIsLessThanZero() {
            LinkedList linkedList = new LinkedList(1);
            linkedList.append(2);
            linkedList.append(3);

            linkedList.reverseBetween(-1, 1);

            assertArrayEquals(linkedList.toArray(), createArray(1, 2, 3));
        }

        @Test
        void shouldDoNothingWhenListEndingIndexIsGreaterThanLength() {
            LinkedList linkedList = new LinkedList(1);
            linkedList.append(2);
            linkedList.append(3);

            linkedList.reverseBetween(1, 4);

            assertArrayEquals(linkedList.toArray(), createArray(1, 2, 3));
        }

        @Test
        void shouldDoNothingWhenListEndingIndexIsEqualToLength() {
            LinkedList linkedList = new LinkedList(1);
            linkedList.append(2);
            linkedList.append(3);

            linkedList.reverseBetween(1, 3);

            assertArrayEquals(linkedList.toArray(), createArray(1, 2, 3));
        }

        @Test
        void shouldDoNothingWhenDifferenceOfIndexIsNegative() {
            LinkedList linkedList = new LinkedList(1);
            linkedList.append(2);
            linkedList.append(3);

            linkedList.reverseBetween(2, 0);

            assertArrayEquals(linkedList.toArray(), createArray(1, 2, 3));
        }

        @Test
        void shouldDoNothingWhenDifferenceOfIndexIsZero() {
            LinkedList linkedList = new LinkedList(1);
            linkedList.append(2);
            linkedList.append(3);

            linkedList.reverseBetween(1, 1);

            assertArrayEquals(linkedList.toArray(), createArray(1, 2, 3));
        }

        @Test
        void shouldReverseEntireList() {
            LinkedList linkedList = new LinkedList(1);
            linkedList.append(2);
            linkedList.append(3);
            linkedList.append(4);
            linkedList.append(5);

            linkedList.reverseBetween(0, 4);

            assertArrayEquals(linkedList.toArray(), createArray(5, 4, 3, 2, 1));
        }

        @Test
        void shouldReverseFirstPartOfList() {
            LinkedList linkedList = new LinkedList(1);
            linkedList.append(2);
            linkedList.append(3);
            linkedList.append(4);
            linkedList.append(5);

            linkedList.reverseBetween(0, 2);

            assertArrayEquals(linkedList.toArray(), createArray(3, 2, 1, 4, 5));
        }

        @Test
        void shouldReverseEndPartOfList() {
            LinkedList linkedList = new LinkedList(1);
            linkedList.append(2);
            linkedList.append(3);
            linkedList.append(4);
            linkedList.append(5);

            linkedList.reverseBetween(2, 4);

            assertArrayEquals(linkedList.toArray(), createArray(1, 2, 5, 4, 3));
        }

        @Test
        void shouldReverseMiddlePartOfList() {
            LinkedList linkedList = new LinkedList(1);
            linkedList.append(2);
            linkedList.append(3);
            linkedList.append(4);
            linkedList.append(5);

            linkedList.reverseBetween(1, 3);

            assertArrayEquals(linkedList.toArray(), createArray(1, 4, 3, 2, 5));
        }
    }

    private int[] createArray(int... array) {
        return array;
    }
}