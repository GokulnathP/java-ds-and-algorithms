package com.gokulnathp.datastractures;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    @Nested
    class Insert {
        @Test
        void shouldSetRootNodeToEmptyTree() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();

            assertTrue(binarySearchTree.insert(2));
            assertEquals(2, binarySearchTree.getRoot().value);
        }

        @Test
        void shouldInsertNodeToLeftWhenValueIsLow() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(2);

            assertTrue(binarySearchTree.insert(1));
            assertEquals(1, binarySearchTree.getRoot().left.value);
        }

        @Test
        void shouldInsertNodeToRightWhenValueIsHigh() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(2);

            assertTrue(binarySearchTree.insert(3));
            assertEquals(3, binarySearchTree.getRoot().right.value);
        }

        @Test
        void shouldReturnFalseIfTheValueAlreadyExist() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(1);

            assertFalse(binarySearchTree.insert(1));
        }
    }

    @Nested
    class RInsert {
        @Test
        void shouldSetRootNodeToEmptyTree() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();

            binarySearchTree.rInsert(2);

            assertEquals(2, binarySearchTree.getRoot().value);
        }

        @Test
        void shouldInsertNodeToLeftWhenValueIsLow() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.rInsert(2);

            binarySearchTree.rInsert(1);

            assertEquals(1, binarySearchTree.getRoot().left.value);
        }

        @Test
        void shouldInsertNodeToRightWhenValueIsHigh() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.rInsert(2);

            binarySearchTree.rInsert(3);

            assertEquals(3, binarySearchTree.getRoot().right.value);
        }

        @Test
        void shouldReturnFalseIfTheValueAlreadyExist() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.rInsert(1);

            binarySearchTree.rInsert(1);
        }
    }

    @Nested
    class Contains {
        @Test
        void shouldReturnFalseIfTreeIsEmpty() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();

            assertFalse(binarySearchTree.contains(1));
        }

        @Test
        void shouldReturnFalseForTreeWithOneNode() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(2);

            assertFalse(binarySearchTree.contains(1));
        }

        @Test
        void shouldReturnTrueForTreeWithOneNode() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(2);

            assertTrue(binarySearchTree.contains(2));
        }

        @Test
        void shouldReturnTrueIfTreeHasTheValue() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(2);
            binarySearchTree.insert(48);
            binarySearchTree.insert(27);
            binarySearchTree.insert(71);
            binarySearchTree.insert(56);

            assertTrue(binarySearchTree.contains(27));
        }

        @Test
        void shouldReturnFalseWhenTheValueIsNotPresent() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(2);
            binarySearchTree.insert(48);
            binarySearchTree.insert(27);
            binarySearchTree.insert(71);
            binarySearchTree.insert(56);

            assertFalse(binarySearchTree.contains(72));
        }
    }

    @Nested
    class RContains {
        @Test
        void shouldReturnFalseIfTreeIsEmpty() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();

            assertFalse(binarySearchTree.rContains(1));
        }

        @Test
        void shouldReturnFalseForTreeWithOneNode() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(2);

            assertFalse(binarySearchTree.rContains(1));
        }

        @Test
        void shouldReturnTrueForTreeWithOneNode() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(2);

            assertTrue(binarySearchTree.rContains(2));
        }

        @Test
        void shouldReturnTrueIfTreeHasTheValue() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(2);
            binarySearchTree.insert(48);
            binarySearchTree.insert(27);
            binarySearchTree.insert(71);
            binarySearchTree.insert(56);

            assertTrue(binarySearchTree.rContains(27));
        }

        @Test
        void shouldReturnFalseWhenTheValueIsNotPresent() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(2);
            binarySearchTree.insert(48);
            binarySearchTree.insert(27);
            binarySearchTree.insert(71);
            binarySearchTree.insert(56);

            assertFalse(binarySearchTree.rContains(72));
        }
    }

    @Nested
    class MinValue {
        @Test
        void shouldReturnRootWhenTreeHasOnlyOneNode() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.rInsert(2);

            assertEquals(2, binarySearchTree.minValue(binarySearchTree.getRoot()));
        }

        @Test
        void shouldReturnLeftValueWhenTreeHasOneNodeLayer() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.rInsert(2);
            binarySearchTree.rInsert(3);
            binarySearchTree.rInsert(1);

            assertEquals(1, binarySearchTree.minValue(binarySearchTree.getRoot()));
        }

        @Test
        void shouldReturnLeftMostValue() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.rInsert(5);
            binarySearchTree.rInsert(2);
            binarySearchTree.rInsert(1);
            binarySearchTree.rInsert(3);

            assertEquals(1, binarySearchTree.minValue(binarySearchTree.getRoot()));
        }
    }

    @Nested
    class DeleteNode {
        @Test
        void shouldRemoveRootIfTreeHasOnlyOneNode() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.rInsert(1);

            binarySearchTree.deleteNode(1);

            assertNull(binarySearchTree.getRoot());
        }

        @Test
        void shouldRemoveNodeWithNoChild() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.rInsert(2);
            binarySearchTree.rInsert(1);
            binarySearchTree.rInsert(3);

            binarySearchTree.deleteNode(1);

            assertEquals(2, binarySearchTree.getRoot().value);
            assertEquals(3, binarySearchTree.getRoot().right.value);
            assertNull(binarySearchTree.getRoot().left);
        }

        @Test
        void shouldRemoveNodeWithLeftChild() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.rInsert(5);
            binarySearchTree.rInsert(1);
            binarySearchTree.rInsert(3);
            binarySearchTree.rInsert(2);

            binarySearchTree.deleteNode(3);

            assertEquals(2, binarySearchTree.getRoot().left.right.value);
        }

        @Test
        void shouldRemoveNodeWithRightChild() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.rInsert(5);
            binarySearchTree.rInsert(1);
            binarySearchTree.rInsert(3);
            binarySearchTree.rInsert(4);

            binarySearchTree.deleteNode(3);

            assertEquals(4, binarySearchTree.getRoot().left.right.value);
        }

        @Test
        void shouldRemoveNodeWithBothChild() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.rInsert(5);
            binarySearchTree.rInsert(1);
            binarySearchTree.rInsert(3);
            binarySearchTree.rInsert(6);
            binarySearchTree.rInsert(2);
            binarySearchTree.rInsert(4);

            binarySearchTree.deleteNode(3);

            assertEquals(4, binarySearchTree.getRoot().left.right.value);
        }
    }

    @Nested
    class SortedArrayToBST {
        @Test
        void testEmptyArray() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();

            binarySearchTree.sortedArrayToBST(new int[]{});

            assertNull(binarySearchTree.getRoot());
        }

        @Test
        void testArrayWithOneElement() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();

            binarySearchTree.sortedArrayToBST(new int[]{1});

            assertEquals(1, binarySearchTree.getRoot().value);
            assertNull(binarySearchTree.getRoot().left);
            assertNull(binarySearchTree.getRoot().right);
        }

        @Test
        void testArrayWithTwoElements() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();

            binarySearchTree.sortedArrayToBST(new int[]{1, 2});

            assertEquals(1, binarySearchTree.getRoot().value);
            assertNull(binarySearchTree.getRoot().left);
            assertEquals(2, binarySearchTree.getRoot().right.value);
        }

        @Test
        void testArrayWithThreeElements() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();

            binarySearchTree.sortedArrayToBST(new int[]{1, 2, 3});

            assertEquals(2, binarySearchTree.getRoot().value);
            assertEquals(1, binarySearchTree.getRoot().left.value);
            assertEquals(3, binarySearchTree.getRoot().right.value);
        }

        @Test
        void testArrayWithFourElements() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();

            binarySearchTree.sortedArrayToBST(new int[]{1, 2, 3, 4});

            assertEquals(2, binarySearchTree.getRoot().value);
            assertEquals(1, binarySearchTree.getRoot().left.value);
            assertEquals(3, binarySearchTree.getRoot().right.value);
            assertEquals(4, binarySearchTree.getRoot().right.right.value);
        }

        @Test
        void testArrayWithOddNumberOfElements() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();

            binarySearchTree.sortedArrayToBST(new int[]{1, 2, 3, 4, 5});

            assertEquals(3, binarySearchTree.getRoot().value);
            assertEquals(1, binarySearchTree.getRoot().left.value);
            assertEquals(2, binarySearchTree.getRoot().left.right.value);
            assertEquals(4, binarySearchTree.getRoot().right.value);
            assertEquals(5, binarySearchTree.getRoot().right.right.value);
        }
    }

    @Nested
    class InvertTree {
        @Test
        void testEmptyTree() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();

            binarySearchTree.invertTree();

            assertNull(binarySearchTree.getRoot());
        }

        @Test
        void testTreeWithOneNode() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.rInsert(2);

            binarySearchTree.invertTree();

            assertEquals(2, binarySearchTree.getRoot().value);
        }

        @Test
        void testTreeWithTwoNode() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.rInsert(2);
            binarySearchTree.rInsert(1);

            binarySearchTree.invertTree();

            assertEquals(2, binarySearchTree.getRoot().value);
            assertEquals(1, binarySearchTree.getRoot().right.value);
        }

        @Test
        void testTreeWithThreeNode() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.rInsert(2);
            binarySearchTree.rInsert(1);
            binarySearchTree.rInsert(3);

            binarySearchTree.invertTree();

            assertEquals(2, binarySearchTree.getRoot().value);
            assertEquals(3, binarySearchTree.getRoot().left.value);
            assertEquals(1, binarySearchTree.getRoot().right.value);
        }

        @Test
        void testTreeWithFourNode() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.rInsert(2);
            binarySearchTree.rInsert(1);
            binarySearchTree.rInsert(3);
            binarySearchTree.rInsert(4);

            binarySearchTree.invertTree();

            assertEquals(2, binarySearchTree.getRoot().value);
            assertEquals(3, binarySearchTree.getRoot().left.value);
            assertEquals(4, binarySearchTree.getRoot().left.left.value);
            assertEquals(1, binarySearchTree.getRoot().right.value);
        }

        @Test
        void testTreeWithFiveNode() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.rInsert(3);
            binarySearchTree.rInsert(1);
            binarySearchTree.rInsert(2);
            binarySearchTree.rInsert(4);
            binarySearchTree.rInsert(5);

            binarySearchTree.invertTree();

            assertEquals(3, binarySearchTree.getRoot().value);
            assertEquals(4, binarySearchTree.getRoot().left.value);
            assertEquals(5, binarySearchTree.getRoot().left.left.value);
            assertEquals(1, binarySearchTree.getRoot().right.value);
            assertEquals(2, binarySearchTree.getRoot().right.left.value);
        }

        @Test
        void testTreeWithSixNode() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.rInsert(3);
            binarySearchTree.rInsert(1);
            binarySearchTree.rInsert(2);
            binarySearchTree.rInsert(5);
            binarySearchTree.rInsert(4);
            binarySearchTree.rInsert(6);

            binarySearchTree.invertTree();

            assertEquals(3, binarySearchTree.getRoot().value);
            assertEquals(5, binarySearchTree.getRoot().left.value);
            assertEquals(6, binarySearchTree.getRoot().left.left.value);
            assertEquals(4, binarySearchTree.getRoot().left.right.value);
            assertEquals(1, binarySearchTree.getRoot().right.value);
            assertEquals(2, binarySearchTree.getRoot().right.left.value);
        }
    }

    @Nested
    class BFS {
        @Test
        void testEmptyTree() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();

            assertEquals(List.of(), binarySearchTree.BFS());
        }

        @Test
        void testSingleNode() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(1);

            assertEquals(List.of(1), binarySearchTree.BFS());
        }

        @Test
        void testTwoNode() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(2);
            binarySearchTree.insert(1);

            assertEquals(List.of(2, 1), binarySearchTree.BFS());
        }

        @Test
        void testThreeNode() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(2);
            binarySearchTree.insert(1);
            binarySearchTree.insert(3);

            assertEquals(List.of(2, 1, 3), binarySearchTree.BFS());
        }

        @Test
        void testFourNode() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(2);
            binarySearchTree.insert(1);
            binarySearchTree.insert(3);
            binarySearchTree.insert(4);

            assertEquals(List.of(2, 1, 3, 4), binarySearchTree.BFS());
        }

        @Test
        void testFiveNode() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(3);
            binarySearchTree.insert(2);
            binarySearchTree.insert(1);
            binarySearchTree.insert(4);
            binarySearchTree.insert(5);

            assertEquals(List.of(3, 2, 4, 1, 5), binarySearchTree.BFS());
        }

        @Test
        void testSixNode() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(3);
            binarySearchTree.insert(2);
            binarySearchTree.insert(1);
            binarySearchTree.insert(5);
            binarySearchTree.insert(4);
            binarySearchTree.insert(6);

            assertEquals(List.of(3, 2, 5, 1, 4, 6), binarySearchTree.BFS());
        }

        @Test
        void testSevenNode() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(4);
            binarySearchTree.insert(2);
            binarySearchTree.insert(3);
            binarySearchTree.insert(1);
            binarySearchTree.insert(6);
            binarySearchTree.insert(5);
            binarySearchTree.insert(7);

            assertEquals(List.of(4, 2, 6, 1, 3, 5, 7), binarySearchTree.BFS());
        }
    }

    @Nested
    class DFSPreOrder {
        @Test
        void testEmptyTree() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();

            assertEquals(List.of(), binarySearchTree.DFSPreOrder());
        }

        @Test
        void testSingleNode() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(1);

            assertEquals(List.of(1), binarySearchTree.DFSPreOrder());
        }

        @Test
        void testTwoNode() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(2);
            binarySearchTree.insert(1);

            assertEquals(List.of(2, 1), binarySearchTree.DFSPreOrder());
        }

        @Test
        void testThreeNode() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(2);
            binarySearchTree.insert(1);
            binarySearchTree.insert(3);

            assertEquals(List.of(2, 1, 3), binarySearchTree.DFSPreOrder());
        }

        @Test
        void testFourNode() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(2);
            binarySearchTree.insert(1);
            binarySearchTree.insert(3);
            binarySearchTree.insert(4);

            assertEquals(List.of(2, 1, 3, 4), binarySearchTree.DFSPreOrder());
        }

        @Test
        void testFiveNode() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(3);
            binarySearchTree.insert(2);
            binarySearchTree.insert(1);
            binarySearchTree.insert(4);
            binarySearchTree.insert(5);

            assertEquals(List.of(3, 2, 1, 4, 5), binarySearchTree.DFSPreOrder());
        }

        @Test
        void testSixNode() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(3);
            binarySearchTree.insert(2);
            binarySearchTree.insert(1);
            binarySearchTree.insert(5);
            binarySearchTree.insert(6);
            binarySearchTree.insert(4);

            assertEquals(List.of(3, 2, 1, 5, 4, 6), binarySearchTree.DFSPreOrder());
        }

        @Test
        void testSevenNode() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(4);
            binarySearchTree.insert(2);
            binarySearchTree.insert(3);
            binarySearchTree.insert(1);
            binarySearchTree.insert(6);
            binarySearchTree.insert(7);
            binarySearchTree.insert(5);

            assertEquals(List.of(4, 2, 1, 3, 6, 5, 7), binarySearchTree.DFSPreOrder());
        }
    }

    @Nested
    class DFSPostOrder {
        @Test
        void testEmptyTree() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();

            assertEquals(List.of(), binarySearchTree.DFSPostOrder());
        }

        @Test
        void testSingleNode() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(1);

            assertEquals(List.of(1), binarySearchTree.DFSPostOrder());
        }

        @Test
        void testTwoNode() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(2);
            binarySearchTree.insert(1);

            assertEquals(List.of(1, 2), binarySearchTree.DFSPostOrder());
        }

        @Test
        void testThreeNode() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(2);
            binarySearchTree.insert(1);
            binarySearchTree.insert(3);

            assertEquals(List.of(1, 3, 2), binarySearchTree.DFSPostOrder());
        }

        @Test
        void testFourNode() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(2);
            binarySearchTree.insert(1);
            binarySearchTree.insert(3);
            binarySearchTree.insert(4);

            assertEquals(List.of(1, 4, 3, 2), binarySearchTree.DFSPostOrder());
        }

        @Test
        void testFiveNode() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(3);
            binarySearchTree.insert(2);
            binarySearchTree.insert(1);
            binarySearchTree.insert(4);
            binarySearchTree.insert(5);

            assertEquals(List.of(1, 2, 5, 4, 3), binarySearchTree.DFSPostOrder());
        }

        @Test
        void testSixNode() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(3);
            binarySearchTree.insert(2);
            binarySearchTree.insert(1);
            binarySearchTree.insert(5);
            binarySearchTree.insert(4);
            binarySearchTree.insert(6);

            assertEquals(List.of(1, 2, 4, 6, 5, 3), binarySearchTree.DFSPostOrder());
        }

        @Test
        void testSevenNode() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(4);
            binarySearchTree.insert(2);
            binarySearchTree.insert(3);
            binarySearchTree.insert(1);
            binarySearchTree.insert(6);
            binarySearchTree.insert(5);
            binarySearchTree.insert(7);

            assertEquals(List.of(1, 3, 2, 5, 7, 6, 4), binarySearchTree.DFSPostOrder());
        }
    }

    @Nested
    class DFSInOrder {
        @Test
        void testEmptyTree() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();

            assertEquals(List.of(), binarySearchTree.DFSInOrder());
        }

        @Test
        void testSingleNode() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(1);

            assertEquals(List.of(1), binarySearchTree.DFSInOrder());
        }

        @Test
        void testTwoNode() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(2);
            binarySearchTree.insert(1);

            assertEquals(List.of(1, 2), binarySearchTree.DFSInOrder());
        }

        @Test
        void testThreeNode() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(2);
            binarySearchTree.insert(1);
            binarySearchTree.insert(3);

            assertEquals(List.of(1, 2, 3), binarySearchTree.DFSInOrder());
        }

        @Test
        void testFourNode() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(2);
            binarySearchTree.insert(1);
            binarySearchTree.insert(4);
            binarySearchTree.insert(3);

            assertEquals(List.of(1, 2, 3, 4), binarySearchTree.DFSInOrder());
        }

        @Test
        void testFiveNode() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(3);
            binarySearchTree.insert(2);
            binarySearchTree.insert(1);
            binarySearchTree.insert(4);
            binarySearchTree.insert(5);

            assertEquals(List.of(1, 2, 3, 4, 5), binarySearchTree.DFSInOrder());
        }

        @Test
        void testSixNode() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(3);
            binarySearchTree.insert(2);
            binarySearchTree.insert(1);
            binarySearchTree.insert(5);
            binarySearchTree.insert(4);
            binarySearchTree.insert(6);

            assertEquals(List.of(1, 2, 3, 4, 5, 6), binarySearchTree.DFSInOrder());
        }

        @Test
        void testSevenNode() {
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            binarySearchTree.insert(4);
            binarySearchTree.insert(2);
            binarySearchTree.insert(3);
            binarySearchTree.insert(1);
            binarySearchTree.insert(6);
            binarySearchTree.insert(5);
            binarySearchTree.insert(7);

            assertEquals(List.of(1, 2, 3, 4, 5, 6, 7), binarySearchTree.DFSInOrder());
        }
    }
}