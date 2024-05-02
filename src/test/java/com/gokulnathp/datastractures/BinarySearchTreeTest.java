package com.gokulnathp.datastractures;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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
}