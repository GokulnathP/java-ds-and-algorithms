package com.gokulnathp.datastractures;

public class DoublyLinkedList {
    private DoublyNode head;
    private DoublyNode tail;
    private int length = 0;

    public DoublyLinkedList() {
    }

    public DoublyLinkedList(int value) {
        DoublyNode newNode = new DoublyNode(value);
        addNodeToEmptyList(newNode);
    }

    public void append(int value) {
        DoublyNode newNode = new DoublyNode(value);

        if (isListEmpty()) {
            addNodeToEmptyList(newNode);
            return;
        }

        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
        length++;
    }

    public DoublyNode removeLast() {
        if (isListEmpty()) return null;

        DoublyNode nodeToBeRemoved = tail;
        if (length == 1) {
            emptyList();
            return nodeToBeRemoved;
        }

        DoublyNode newTail = nodeToBeRemoved.prev;
        newTail.next = null;
        nodeToBeRemoved.prev = null;

        tail = newTail;
        length--;

        return nodeToBeRemoved;
    }

    public void prepend(int value) {
        DoublyNode newNode = new DoublyNode(value);

        if (isListEmpty()) {
            addNodeToEmptyList(newNode);
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        length++;
    }

    public DoublyNode removeFirst() {
        if (isListEmpty()) return null;

        DoublyNode nodeToBeRemoved = head;
        if (length == 1) {
            emptyList();
            return nodeToBeRemoved;
        }

        DoublyNode newHead = nodeToBeRemoved.next;
        nodeToBeRemoved.next = null;
        newHead.prev = null;

        head = newHead;
        length--;
        return nodeToBeRemoved;
    }

    public DoublyNode get(int index) {
        if (index < 0 || index >= length) return null;

        DoublyNode nodeToGet;
        if (index < length / 2) {
            nodeToGet = head;
            for (int i = 0; i < index; i++) nodeToGet = nodeToGet.next;
        } else {
            nodeToGet = tail;
            for (int i = length - 1; i > index; i--) nodeToGet = nodeToGet.prev;
        }
        return nodeToGet;
    }

    public boolean set(int index, int value) {
        DoublyNode nodeToUpdate = get(index);

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

        DoublyNode newNode = new DoublyNode(value);
        DoublyNode prevNode = get(index - 1);
        DoublyNode nextNode = prevNode.next;

        prevNode.next = newNode;
        newNode.prev = prevNode;
        nextNode.prev = newNode;
        newNode.next = nextNode;
        length++;

        return true;
    }

    public DoublyNode remove(int index) {
        if (index < 0 || index >= length) return null;

        if (index == 0) return removeFirst();

        if (index == length - 1) return removeLast();

        DoublyNode nodeToBeRemoved = get(index);
        DoublyNode prevNode = nodeToBeRemoved.prev;
        DoublyNode nextNode = nodeToBeRemoved.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        nodeToBeRemoved.next = null;
        nodeToBeRemoved.prev = null;
        length--;

        return nodeToBeRemoved;
    }

    public void swapFirstLast() {
        if(length <= 1) return;

        int temp = head.value;
        head.value = tail.value;
        tail.value = temp;
    }

    public void reverse() {
        DoublyNode currentNode = head;
        head = tail;
        tail = currentNode;

        while(currentNode != null) {
            DoublyNode nextNode = currentNode.next;
            currentNode.next = currentNode.prev;
            currentNode.prev = nextNode;

            currentNode = nextNode;
        }
    }

    public boolean isPalindrome() {
        DoublyNode nodeFromStart = head;
        DoublyNode nodeFromEnd = tail;

        for (int i = 0; i < length / 2; i++) {
            if(nodeFromStart.value != nodeFromEnd.value) return false;

            nodeFromStart = nodeFromStart.next;
            nodeFromEnd = nodeFromEnd.prev;
        }

        return true;
    }

    public void swapPairs() {
        if(length <= 1) return;

        DoublyNode currentNode = head;
        DoublyNode nodeToSwap = currentNode.next;
        head = head.next;

        while(currentNode != null && currentNode.next != null) {
            DoublyNode nextPairStartingNode = currentNode.next.next;
            nodeToSwap = currentNode.next;

            if(currentNode.prev != null) currentNode.prev.next = nodeToSwap;

            if(nextPairStartingNode != null) nextPairStartingNode.prev = currentNode;

            nodeToSwap.next = currentNode;
            nodeToSwap.prev = currentNode.prev;

            currentNode.next = nextPairStartingNode;
            currentNode.prev = nodeToSwap;

            currentNode = nextPairStartingNode;
        }

        if(currentNode == null) tail = nodeToSwap.next;
    }

    public int[] toArray() {
        int[] array = new int[length];

        DoublyNode currentNode = head;
        for (int i = 0; i < length; i++) {
            array[i] = currentNode.value;
            currentNode = currentNode.next;
        }

        return array;
    }

    private boolean isListEmpty() {
        return length == 0;
    }

    private void emptyList() {
        head = null;
        tail = null;
        length = 0;
    }

    private void addNodeToEmptyList(DoublyNode node) {
        head = node;
        tail = node;
        length++;
    }
}
