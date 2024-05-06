package com.gokulnathp.datastractures;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int length = 0;

    public LinkedList(int value) {
        Node newNode = new Node(value);
        addNodeToEmptyList(newNode);
    }

    public LinkedList() {}

    public Node removeFirst() {
        if (isListEmpty()) return null;
        Node firstNode = head;

        head = head.next;
        if (length == 1) tail = null;

        firstNode.next = null;
        length--;
        return firstNode;
    }

    public Node removeLast() {
        if (isListEmpty()) return null;

        if (length == 1) {
            Node lastNode = tail;
            emptyList();
            return lastNode;
        }

        Node lastNode = head.next;
        Node secondLastNode = head;

        while (lastNode.next != null) {
            secondLastNode = lastNode;
            lastNode = lastNode.next;
        }

        secondLastNode.next = null;
        tail = secondLastNode;
        length--;
        return lastNode;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);

        if (isListEmpty()) {
            addNodeToEmptyList(newNode);
            return;
        }

        newNode.next = head;
        head = newNode;
        length++;
    }

    public void append(int value) {
        Node newNode = new Node(value);

        if (isListEmpty()) {
            addNodeToEmptyList(newNode);
            return;
        }

        tail.next = newNode;
        tail = newNode;
        length++;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) return null;

        Node nodeToGet = head;

        for (int i = 0; i < index; i++) nodeToGet = nodeToGet.next;

        return nodeToGet;
    }

    public boolean set(int index, int value) {
        Node nodeToUpdate = get(index);

        if (nodeToUpdate == null) return false;

        nodeToUpdate.value = value;
        return true;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) return false;

        if (index == 0) {
            prepend(value);
            return true;
        }

        if (index == length) {
            append(value);
            return true;
        }

        Node nodeToBeInserted = new Node(value);
        Node nodeBeforeInsertion = get(index - 1);

        nodeToBeInserted.next = nodeBeforeInsertion.next;
        nodeBeforeInsertion.next = nodeToBeInserted;
        length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;

        if (index == 0) return removeFirst();

        if (index == length - 1) return removeLast();

        Node nodeToBeRemoved = get(index);
        Node previousNode = get(index - 1);

        previousNode.next = nodeToBeRemoved.next;
        nodeToBeRemoved.next = null;
        length--;
        return nodeToBeRemoved;
    }

    public void reverse() {
        Node currentNode = head;
        Node prevNode = null;
        Node nextNode;

        head = tail;
        tail = currentNode;

        while (currentNode != null) {
            nextNode = currentNode.next;

            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
    }

    public Node findMiddleNode() {
        Node slowerPointer = head;
        Node fasterPointer = head;

        while (fasterPointer != null && fasterPointer.next != null) {
            slowerPointer = slowerPointer.next;
            fasterPointer = fasterPointer.next.next;
        }

        return slowerPointer;
    }

    public void createLoop() {
        tail.next = head;
    }

    public boolean hasLoop() {
        Node slowPointer = head;
        Node fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer == fastPointer) return true;
        }

        return false;
    }

    public Node findKthNodeFromEnd(int k) {
        if (k <= 0) return null;

        Node slowPointer = head;
        Node fasterPointer = head;

        int slowPointerIndex = 0;
        int fasterPointerIndex = 0;

        while (fasterPointer != null && fasterPointer.next != null) {
            slowPointer = slowPointer.next;
            slowPointerIndex += 1;

            fasterPointer = fasterPointer.next.next;
            fasterPointerIndex += 2;
        }

        int listLength = fasterPointer == null ? fasterPointerIndex : fasterPointerIndex + 1;
        if (k > listLength) return null;

        int indexFromStart = listLength - k;

        int startingIndex = indexFromStart >= slowPointerIndex ? slowPointerIndex : 0;
        Node nodeToBeFound = indexFromStart >= slowPointerIndex ? slowPointer : head;

        while (startingIndex < indexFromStart) {
            nodeToBeFound = nodeToBeFound.next;
            startingIndex++;
        }

        return nodeToBeFound;
    }

    public Node findKthFromEnd(int k) {
        Node slowPointer = head;
        Node fastPointer = head;

        for (int i = 0; i < k; i++) {
            if (fastPointer == null) return null;
            fastPointer = fastPointer.next;
        }

        while (fastPointer != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }

        return slowPointer;
    }

    public void partitionList(int x) {
        if (length <= 1) return;

        Node smallerNode = new Node(0);
        Node largerNode = new Node(0);

        Node smallerList = smallerNode;
        Node largerList = largerNode;

        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.value < x) {
                smallerList.next = currentNode;
                smallerList = currentNode;
            } else {
                largerList.next = currentNode;
                largerList = currentNode;
            }
            currentNode = currentNode.next;
        }

        largerList.next = null;
        smallerList.next = largerNode.next;
        head = smallerNode.next;
    }

    public void partitionListV1(int x) {
        if (length <= 1) return;

        Node smallerListHead = null;
        Node smallerListTail = null;
        int smallerListLength = 0;

        Node largerListHead = null;
        Node largerListTail = null;
        int largerListLength = 0;

        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.value < x) {
                if (smallerListHead == null) {
                    smallerListHead = currentNode;
                    smallerListTail = currentNode;
                } else {
                    smallerListTail.next = currentNode;
                    smallerListTail = currentNode;
                }
                smallerListLength++;
            } else {
                if (largerListHead == null) {
                    largerListHead = currentNode;
                    largerListTail = currentNode;
                } else {
                    largerListTail.next = currentNode;
                    largerListTail = currentNode;
                }
                largerListLength++;
            }
            currentNode = currentNode.next;
        }

        if (smallerListLength > 0 && largerListLength > 0) {
            head = smallerListHead;
            smallerListTail.next = largerListHead;
            tail = largerListTail;
        }
    }

    public void partitionListV2(int x) {
        if (length <= 1) return;

        Node currentNode = head;
        Node nextNode;

        Node lastSmallestNode = null;
        Node firstLargestNode = null;

        while (currentNode != null) {
            nextNode = currentNode.next;

            if (currentNode.value >= x) {
                if (firstLargestNode == null) firstLargestNode = currentNode;
                if (lastSmallestNode != null) lastSmallestNode.next = firstLargestNode;

                currentNode = nextNode;
                continue;
            }

            if (lastSmallestNode == null) {
                lastSmallestNode = currentNode;
                lastSmallestNode.next = firstLargestNode;
                head = lastSmallestNode;
                currentNode = nextNode;
                continue;
            }

            lastSmallestNode.next = currentNode;
            lastSmallestNode = currentNode;
            lastSmallestNode.next = firstLargestNode;
            currentNode = nextNode;
        }
    }

    public void partitionListV0(int x) {
        if (length <= 1) return;

        Node lastLowestValueNode = null;
        Node firstHightestValueNode = null;
        Node currentNode = head;
        Node nextNode;
        Node prevNode = null;

        while (currentNode != null) {
            nextNode = currentNode.next;

            // x = 2, l = 3, 4, 5, cn = 3 => l = 3, 4, 5
            if (currentNode.value >= x) {
                if (firstHightestValueNode == null) firstHightestValueNode = currentNode;
                prevNode = currentNode;
                currentNode = nextNode;
                continue;
            }

            // x = 2, l = 1, 2, 3, cn = 1 => l = 1, 2, 3
            if (lastLowestValueNode == null && firstHightestValueNode == null) {
                lastLowestValueNode = currentNode;
                prevNode = currentNode;
                currentNode = nextNode;
                continue;
            }

            // x = 2, l = 3, 1, 5, cn = 1 => l = 1, 3, 5
            if (lastLowestValueNode == null) {
                prevNode.next = nextNode;
                currentNode.next = firstHightestValueNode;
                head = currentNode;
                lastLowestValueNode = currentNode;
                currentNode = nextNode;
                continue;
            }

            // x = 2, l = 1, 0, 2, cn = 0 => l = 1, 0, 2
            if (firstHightestValueNode == null) {
                prevNode = currentNode;
                currentNode = nextNode;
                continue;
            }

            // x = 2, l = 8, 2, 1, 0, cn = 0 => l = 1, 0, 8, 2
            prevNode.next = nextNode;
            currentNode.next = lastLowestValueNode.next;
            lastLowestValueNode.next = currentNode;
            lastLowestValueNode = currentNode;

            currentNode = nextNode;
        }
    }

    public void partitionListV01(int x) {
        if (length <= 1) return;

        Node lastLowestValueNode = null;
        Node firstHightestValueNode = null;
        Node currentNode = head;
        Node nextNode;

        while (currentNode != null) {
            nextNode = currentNode.next;

            if (currentNode.value >= x) {
                if (firstHightestValueNode == null) firstHightestValueNode = currentNode;
                currentNode = nextNode;
                continue;
            }

            if (lastLowestValueNode == null && firstHightestValueNode == null) {
                lastLowestValueNode = currentNode;
                currentNode = nextNode;
                continue;
            }

            if (lastLowestValueNode == null) {
                currentNode.next = firstHightestValueNode;
                head = currentNode;
                lastLowestValueNode = currentNode;
                currentNode = nextNode;
                continue;
            }

            if (firstHightestValueNode == null) {
                currentNode = nextNode;
                continue;
            }

            currentNode.next = lastLowestValueNode.next;
            lastLowestValueNode.next = currentNode;
            lastLowestValueNode = currentNode;

            currentNode = nextNode;
        }
    }

    public void removeDuplicates() {
        if (length <= 0) return;

        Set<Integer> integers = new HashSet<>();
        integers.add(head.value);

        Node prevNode = head;
        Node currentNode = head.next;

        while (currentNode != null) {
            if (integers.add(currentNode.value)) {
                prevNode = currentNode;
                currentNode = currentNode.next;
                continue;
            }

            Node nextNode = currentNode.next;
            prevNode.next = nextNode;
            currentNode.next = null;
            length--;
            currentNode = nextNode;
        }
    }

    public void removeDuplicatesV1() {
        Node outerCurrentNode = head;
        while (outerCurrentNode != null) {
            Node innerPreviousNode = outerCurrentNode;
            Node innerCurrentNode = outerCurrentNode.next;

            while (innerCurrentNode != null) {
                if (outerCurrentNode.value != innerCurrentNode.value) {
                    innerPreviousNode = innerCurrentNode;
                    innerCurrentNode = innerCurrentNode.next;
                    continue;
                }

                Node innerNextNode = innerCurrentNode.next;
                innerPreviousNode.next = innerNextNode;
                innerCurrentNode.next = null;
                length--;
                innerCurrentNode = innerNextNode;
            }
            outerCurrentNode = outerCurrentNode.next;
        }
    }

    public int binaryToDecimal() {
        int num = 0;

        Node currentNode = head;
        while (currentNode != null) {
            num = (num * 2) + currentNode.value;
            currentNode = currentNode.next;
        }

        return num;
    }

    public void reverseBetween(int startIndex, int endIndex) {
        if(length <= 1) return;
        if(startIndex < 0 || endIndex >= length) return;
        if(endIndex - startIndex <= 0) return;

        Node lastNodeBeforeReverse = null;
        Node currentNode = head;

        for(int i = 0; i < startIndex; i++) {
            lastNodeBeforeReverse = currentNode;
            currentNode = currentNode.next;
        }

        Node firstNodeOfReverse = currentNode;
        Node previousNode = currentNode;
        currentNode = currentNode.next;

        for(int i = 0; i < endIndex - startIndex; i++) {
            Node nextNode = currentNode.next;
            currentNode.next = previousNode;

            previousNode = currentNode;
            currentNode = nextNode;
        }

        if(lastNodeBeforeReverse == null) head = previousNode;
        else lastNodeBeforeReverse.next = previousNode;
        firstNodeOfReverse.next = currentNode;
    }

    public int[] toArray() {
        int[] array = new int[length];
        Node currentNode = head;

        for (int i = 0; i < length; i++) {
            array[i] = currentNode.value;
            currentNode = currentNode.next;
        }

        return array;
    }

    private void addNodeToEmptyList(Node newNode) {
        head = newNode;
        tail = newNode;
        length++;
    }

    private boolean isListEmpty() {
        return length == 0;
    }

    private void emptyList() {
        head = null;
        tail = null;
        length = 0;
    }
}
