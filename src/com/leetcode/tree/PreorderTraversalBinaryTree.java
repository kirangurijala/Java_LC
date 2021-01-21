package com.leetcode.tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
https://leetcode.com/problems/binary-tree-preorder-traversal/
Given the root of a binary tree, return the preorder traversal of its nodes' values.



Example 1:

Input: root = [1,null,2,3]
Output: [1,2,3]

Example 2:

Input: root = []
Output: []

Example 3:

Input: root = [1]
Output: [1]

Example 4:

Input: root = [1,2]
Output: [1,2]

Example 5:

Input: root = [1,null,2]
Output: [1,2]



Constraints:

    The number of nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100



Follow up:

Recursive solution is trivial, could you do it iteratively?
    */
public class PreorderTraversalBinaryTree {
    List<Integer> res = new ArrayList<>();

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
//    binaryTreeImplementation.traverseInOrder(root);
        PreorderTraversalBinaryTree tree = new PreorderTraversalBinaryTree();
        System.out.println("Traversing tree in order:" + tree.preorderTraversal(root));
        System.out.println("Traversing tree pre order:" + tree.preorderTraversalIter(root));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }

        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return res;
    }

    public List<Integer> preorderTraversalIter(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                res.add(curr.val);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }
        return res;
    }
}