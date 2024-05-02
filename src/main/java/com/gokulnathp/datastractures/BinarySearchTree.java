package com.gokulnathp.datastractures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class BinarySearchTree {
    private TreeNode root = null;

    public boolean insert(int value) {
        TreeNode newNode = new TreeNode(value);

        if (root == null) {
            root = newNode;
            return true;
        }

        TreeNode currentNode = root;
        TreeNode prevNode = null;

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

    public boolean contains(int value) {
        TreeNode currentNode = root;

        while (currentNode != null) {
            if (currentNode.value == value) return true;

            if (value < currentNode.value) currentNode = currentNode.left;
            else currentNode = currentNode.right;
        }

        return false;
    }

    public TreeNode getRoot() {
        return root;
    }
}
