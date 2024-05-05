package com.gokulnathp.datastractures;

public class BinarySearchTree {
    public static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    private Node root = null;

    public boolean insert(int value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
            return true;
        }

        Node currentNode = root;
        Node prevNode = null;

        while (currentNode != null) {
            if (currentNode.value == value) return false;

            prevNode = currentNode;

            if (value < currentNode.value) currentNode = currentNode.left;
            else currentNode = currentNode.right;
        }

        if (value > prevNode.value) prevNode.right = newNode;
        else prevNode.left = newNode;

        return true;
    }

    private Node rInsert(Node currentNode, int value) {
        if (currentNode == null) return new Node(value);

        if (value < currentNode.value) {
            currentNode.left = rInsert(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = rInsert(currentNode.right, value);
        }

        return currentNode;
    }

    public void rInsert(int value) {
        root = rInsert(root, value);
    }

    public boolean contains(int value) {
        Node currentNode = root;

        while (currentNode != null) {
            if (currentNode.value == value) return true;

            if (value < currentNode.value) currentNode = currentNode.left;
            else currentNode = currentNode.right;
        }

        return false;
    }

    private boolean rContains(Node currentNode, int value) {
        if (currentNode == null) return false;

        if (currentNode.value == value) return true;

        if (value < currentNode.value) return rContains(currentNode.left, value);

        return rContains(currentNode.right, value);
    }

    public boolean rContains(int value) {
        return rContains(root, value);
    }

    public int minValue(Node currentNode) {
        while (currentNode.left != null) currentNode = currentNode.left;
        return currentNode.value;
    }

    private Node deleteNode(Node currentNode, int value) {
        if (currentNode == null) return null;

        if (value < currentNode.value) currentNode.left = deleteNode(currentNode.left, value);
        else if (value > currentNode.value) currentNode.right = deleteNode(currentNode.right, value);
        else {
            if (currentNode.left == null && currentNode.right == null) return null;
            if (currentNode.left == null) return currentNode.right;
            if (currentNode.right == null) return currentNode.left;

            currentNode.value = minValue(currentNode.right);
            currentNode.right = deleteNode(currentNode.right, currentNode.value);
        }

        return currentNode;
    }

    public void deleteNode(int value) {
        root = deleteNode(root, value);
    }

    private Node sortedArrayToBST(int[] nums, int left, int right) {
        if(right < left) return null;

        int mid = left + (right - left) / 2;
        Node node = new Node(nums[mid]);
        node.left = sortedArrayToBST(nums, left, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, right);
        return node;
    }

    public void sortedArrayToBST(int[] nums) {
        this.root = sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private Node invertTree(Node currentNode) {
        if(currentNode == null) return null;

        Node leftNode = currentNode.left;
        currentNode.left = invertTree(currentNode.right);
        currentNode.right = invertTree(leftNode);

        return currentNode;
    }

    public void invertTree() {
        root = invertTree(root);
    }

    public Node getRoot() {
        return root;
    }
}
