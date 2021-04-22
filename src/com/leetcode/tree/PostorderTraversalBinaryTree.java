package com.leetcode.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
https://leetcode.com/problems/binary-tree-postorder-traversal/
Given the root of a binary tree, return the postorder traversal of its nodes' values.



Example 1:

Input: root = [1,null,2,3]
Output: [3,2,1]

Example 2:

Input: root = []
Output: []

Example 3:

Input: root = [1]
Output: [1]

Example 4:

Input: root = [1,2]
Output: [2,1]

Example 5:

Input: root = [1,null,2]
Output: [2,1]



Constraints:

    The number of the nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100



Follow up:

Recursive solution is trivial, could you do it iteratively?
 */
public class PostorderTraversalBinaryTree {
    List<Integer> res = new ArrayList();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        res.add(root.val);
        return res;
    }

    public List<Integer> postorderTraversalIterative(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                res.addFirst(curr.val);  // Reverse the process of preorder
                curr = curr.right;             // Reverse the process of preorder
            }

            curr = stack.pop();
            curr = curr.left;           // Reverse the process of preorder
        }

        return res;
    }


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
        PostorderTraversalBinaryTree tree = new PostorderTraversalBinaryTree();
        System.out.println("Traversing tree post order:" + tree.postorderTraversal(root));
        System.out.println("Traversing tree post order iter:" + tree.postorderTraversalIterative(root));
    }
}