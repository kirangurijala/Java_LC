package com.leetcode.tree;

/*
What is a Binary Tree?
https://www.edureka.co/blog/java-binary-tree

A Tree is a non-linear data structure where data objects are generally organized in terms of hierarchical relationship.
The structure is non-linear in the sense that, unlike Arrays, Linked Lists, Stack and Queues, data in a tree is not organized linearly.
A binary tree is a recursive tree data structure where each node can have 2 children at most.

tree - trees in java - edureka

Binary trees have a few interesting properties when they’re perfect:

    Property 1: The number of total nodes on each “level” doubles as you move down the tree.
    Property 2: The number of nodes on the last level is equal to the sum of the number of nodes on all other levels, plus 1

Each data element stored in a tree structure called a node. A Tree node contains the following parts:
1. Data
2. Pointer to left child
3. Pointer to the right child

In Java, we can represent a tree node using class. Below is an example of a tree node with integer data.
1
2
3
4
5
6
7
8
9

static class Node {
    int value;
        Node left, right;

        Node(int value){
            this.value = value;
            left = null;
            right = null;
        }

Now that you know what is a binary tree, let’s check out different types of binary trees.
Types of Binary Trees
Full Binary Tree

A full binary tree is a binary tree where every node has exactly 0 or 2 children. The example of fully binary tress is:


Perfect Binary Tree

A binary tree is perfect binary Tree if all internal nodes have two children and all leaves are at the same level. The example of perfect binary tress is:

tree - trees in java - edureka
Complete Binary Tree

A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible. An example of a complete binary tree is:

tree - trees in java - edureka

Now that you are aware of different types of binary trees, let’s check out how to create a binary tree.
Binary Tree Implementation

For the implementation, there’s an auxiliary Node class that will store int values and keeps a reference to each child. The first step is to find the place where we want to add a new node in order to keep the tree sorted. We’ll follow these rules starting from the root node:

    if the new node’s value is lower than the current node’s, go to the left child
    if the new node’s value is greater than the current node’s, go to the right child
    when the current node is null, we’ve reached a leaf node, we insert the new node in that position
 */
public class BinaryTreeImplementation {
    public static void main(String[] args) {
        BinaryTreeImplementation binaryTreeImplementation = new BinaryTreeImplementation();
        TreeNode root = new TreeNode(5);
        System.out.println("Binary Tree Example");
        System.out.println("Building tree with root val " + root.val);
        binaryTreeImplementation.insert(root, 2);
        binaryTreeImplementation.insert(root, 4);
        binaryTreeImplementation.insert(root, 8);
        binaryTreeImplementation.insert(root, 6);
        binaryTreeImplementation.insert(root, 7);
        binaryTreeImplementation.insert(root, 3);
        binaryTreeImplementation.insert(root, 9);
        System.out.println("Traversing tree in order");
        binaryTreeImplementation.traverseInOrder(root);
        System.out.println("Traversing tree pre order");
        binaryTreeImplementation.traversePreOrder(root);
        System.out.println("Traversing tree in order");
        binaryTreeImplementation.traversePostOrder(root);
    }

//  Tree Traversals
//
//  Trees can be traversed in several ways: Let’s use the same tree example that we used before for each case.
//  Depth First Search
//
//  Depth-first search is a type of traversal where you go as deep as possible down one path before backing up and trying a different one.
//  There are several ways to perform a depth-first search: in-order, pre-order and post-order.

    public void insert(TreeNode tree, int val) {
        if (val < tree.val) {
            if (tree.left != null) {
                insert(tree.left, val);
            } else {
                System.out.println(" Inserted " + val + " to left of " + tree.val);
                tree.left = new TreeNode(val);
            }
        } else if (val > tree.val) {
            if (tree.right != null) {
                insert(tree.right, val);
            } else {
                System.out.println("  Inserted " + val + " to right of "
                        + tree.val);
                tree.right = new TreeNode(val);
            }
        }
    }

    //The in-order traversal consists of first visiting the left sub-tree, then the root node, and finally the right sub-tree. There are more ways to traverse a tree.
    public void traverseInOrder(TreeNode tree) {
        if (tree == null) {
            System.out.print(" " + "#");
            return;
        }
        traverseInOrder(tree.left);
        System.out.print(" " + tree.val);
        traverseInOrder(tree.right);
    }

    //In Pre-order traversal you visit the root node first, then the left subtree, and finally the right subtree.
    public void traversePreOrder(TreeNode tree) {
        if (tree != null) {
            System.out.print(" " + tree.val);
            traversePreOrder(tree.left);
            traversePreOrder(tree.right); //5 2 4 3 8 6 7 9
        }
    }

    //In Post-order traversal you visit left subtree first, then the right subtree, and the root node at the
    public void traversePostOrder(TreeNode tree) {
        if (tree != null) {
            traversePostOrder(tree.left);
            traversePostOrder(tree.right);
            System.out.print(" " + tree.val); //3 4 2 7 6 9 8 5
        }
    }
}
