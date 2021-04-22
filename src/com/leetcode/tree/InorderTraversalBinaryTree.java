package com.leetcode.tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
https://leetcode.com/problemj

s/binary-tree-inorder-traversal/
Given the root of a binary tree, return the inorder traversal of its nodes' values.



Example 1:

Input: root = [1,null,2,3]
Output: [1,3,2]

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
Output: [1,2]



Constraints:

    The number of nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100



Follow up:

Recursive solution is trivial, could you do it iteratively?
*/
public class InorderTraversalBinaryTree {
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }

        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        return res;
    }

    public List<Integer> inorderTraversalIter(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
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
        InorderTraversalBinaryTree tree = new InorderTraversalBinaryTree();
        System.out.println("Traversing tree in order:" + tree.inorderTraversal(root));
        System.out.println("Traversing tree in order iter:" + tree.inorderTraversalIter(root));
    }
}