package com.leetcode.tree;

/*
https://leetcode.com/problems/balanced-binary-tree/
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the left and right subtrees of every node differ in height by no more than 1.



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: true
Example 2:


Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
Example 3:

Input: root = []
Output: true
Constraints:

The number of nodes in the tree is in the range [0, 5000].
-104 <= Node.val <= 104

    */
public class BalancedBinaryTree {
    public static void main(String[] args) {
        BinaryTreeImplementation binaryTreeImplementation = new BinaryTreeImplementation();
        TreeNode root = new TreeNode(5);
        System.out.println("Binary Tree Example");
/*
     5
   /   \
  3     7
 / \   / \
2   4 6   8
 */
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
        BalancedBinaryTree treee = new BalancedBinaryTree();
        System.out.println(treee.isBalanced(root));
    }

    boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return isBalanced;
        dfs(root);
        return isBalanced;
    }

    private int dfs(TreeNode root){
        if(root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if(Math.abs(left-right) > 1) isBalanced = false;
        return Math.max(left,right)+1;
    }
}