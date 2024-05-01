package com.gokulnathp.datastractures;

public class Queue {
    private Node first;
    private Node last;
    private int length;

    public Queue(int value) {
        Node newNode = new Node(value);
        addNodeToEmptyQueue(newNode);
    }

    public Queue() {}

    public void enqueue(int value) {
        Node newNode = new Node(value);

        if(isQueueEmpty()) {
            addNodeToEmptyQueue(newNode);
            return;
        }

        last.next = newNode;
        last = newNode;
        length++;
    }

    public Node dequeue() {
        if(isQueueEmpty()) return null;

        Node nodeToBeRemoved = first;
        if(length == 1) {
            emptyQueue();
            return nodeToBeRemoved;
        }

        first = nodeToBeRemoved.next;
        nodeToBeRemoved.next = null;

        length--;
        return nodeToBeRemoved;
    }

    public int[] toArray() {
        int[] array = new int[length];
        Node currentNode = first;

        for (int i = 0; i < length; i++) {
            array[i] = currentNode.value;
            currentNode = currentNode.next;
        }

        return array;
    }

    private boolean isQueueEmpty() {
        return length == 0;
    }

    public void emptyQueue() {
        first = null;
        last = null;
        length = 0;
    }

    private void addNodeToEmptyQueue(Node node) {
        first = node;
        last = node;
        length = 1;
    }
}
