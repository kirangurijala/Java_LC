package com.leetcode.tree;


import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/

Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.





Example 1:

Input: root = [2,2,5,null,null,5,7]
Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.

Example 2:

Input: root = [2,2,2]
Output: -1
Explanation: The smallest value is 2, but there isn't any second smallest value.



Constraints:

    The number of nodes in the tree is in the range [1, 25].
    1 <= Node.val <= 231 - 1
    root.val == min(root.left.val, root.right.val) for each internal node of the tree.
 */
public class SecondMinimumNodeBinaryTree {
    Set<Integer> res = new HashSet<Integer>();

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
        SecondMinimumNodeBinaryTree invertBinaryTree = new SecondMinimumNodeBinaryTree();

        root = new TreeNode(5);
        binaryTreeImplementation.insert(root, 8);
        binaryTreeImplementation.insert(root, 5);
        System.out.println("Traversing tree in order");
        binaryTreeImplementation.traverseInOrder(root);

        System.out.println(invertBinaryTree.findSecondMinimumValue(root));
        binaryTreeImplementation.traverseInOrder(root);
    }

    public int findSecondMinimumValue(TreeNode root) {
        preorderTraversal(root);
        int min = root.val;
        long ans = Long.MAX_VALUE;
        for (int v : res) {
            if (min < v && v < ans) {
                ans = v;
            }
        }

        if (ans == Long.MAX_VALUE) {
            return -1;
        }

        return (int) ans;
    }

    public void preorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }
}