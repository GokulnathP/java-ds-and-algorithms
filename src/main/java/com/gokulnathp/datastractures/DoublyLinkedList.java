package com.gokulnathp.datastractures;

public class DoublyLinkedList {
    public static class Node {
        public int value;
        public Node next;
        public Node prev;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int length = 0;

    public DoublyLinkedList() {
    }

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        addNodeToEmptyList(newNode);
    }

    public void append(int value) {
        Node newNode = new Node(value);

        if (isListEmpty()) {
            addNodeToEmptyList(newNode);
            return;
        }

        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
        length++;
    }

    public Node removeLast() {
        if (isListEmpty()) return null;

        Node nodeToBeRemoved = tail;
        if (length == 1) {
            emptyList();
            return nodeToBeRemoved;
        }

        Node newTail = nodeToBeRemoved.prev;
        newTail.next = null;
        nodeToBeRemoved.prev = null;

        tail = newTail;
        length--;

        return nodeToBeRemoved;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);

        if (isListEmpty()) {
            addNodeToEmptyList(newNode);
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        length++;
    }

    public Node removeFirst() {
        if (isListEmpty()) return null;

        Node nodeToBeRemoved = head;
        if (length == 1) {
            emptyList();
            return nodeToBeRemoved;
        }

        Node newHead = nodeToBeRemoved.next;
        nodeToBeRemoved.next = null;
        newHead.prev = null;

        head = newHead;
        length--;
        return nodeToBeRemoved;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) return null;

        Node nodeToGet;
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

        Node newNode = new Node(value);
        Node prevNode = get(index - 1);
        Node nextNode = prevNode.next;

        prevNode.next = newNode;
        newNode.prev = prevNode;
        nextNode.prev = newNode;
        newNode.next = nextNode;
        length++;

        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;

        if (index == 0) return removeFirst();

        if (index == length - 1) return removeLast();

        Node nodeToBeRemoved = get(index);
        Node prevNode = nodeToBeRemoved.prev;
        Node nextNode = nodeToBeRemoved.next;

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
        Node currentNode = head;
        head = tail;
        tail = currentNode;

        while(currentNode != null) {
            Node nextNode = currentNode.next;
            currentNode.next = currentNode.prev;
            currentNode.prev = nextNode;

            currentNode = nextNode;
        }
    }

    public boolean isPalindrome() {
        Node nodeFromStart = head;
        Node nodeFromEnd = tail;

        for (int i = 0; i < length / 2; i++) {
            if(nodeFromStart.value != nodeFromEnd.value) return false;

            nodeFromStart = nodeFromStart.next;
            nodeFromEnd = nodeFromEnd.prev;
        }

        return true;
    }

    public void swapPairs() {
        if(length <= 1) return;

        Node currentNode = head;
        Node nodeToSwap = currentNode.next;
        head = head.next;

        while(currentNode != null && currentNode.next != null) {
            Node nextPairStartingNode = currentNode.next.next;
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

        Node currentNode = head;
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

    private void addNodeToEmptyList(Node node) {
        head = node;
        tail = node;
        length++;
    }
}
