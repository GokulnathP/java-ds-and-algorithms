package com.gokulnathp.datastractures;

public class Stack {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node top;
    private int height = 0;

    public Stack(int value) {
        Node newNode = new Node(value);
        addNodeToEmptyStack(newNode);
    }

    public Stack() {}

    public void push(int value) {
        Node newNode = new Node(value);

        if(isStackEmpty()) {
            addNodeToEmptyStack(newNode);
            return;
        }

        newNode.next = top;
        top = newNode;
        height++;
    }

    public Node pop() {
        if(isStackEmpty()) return null;

        Node nodeToBeRemoved = top;
        top = nodeToBeRemoved.next;
        nodeToBeRemoved.next = null;

        height--;
        return nodeToBeRemoved;
    }

    public int[] toArray() {
        int[] array = new int[height];
        Node currentNode = top;

        for(int i = 0; i < height; i++) {
            array[i] = currentNode.value;
            currentNode = currentNode.next;
        }

        return array;
    }

    private boolean isStackEmpty() {
        return height == 0;
    }

    private void addNodeToEmptyStack(Node node) {
        top = node;
        height = 1;
    }
}
