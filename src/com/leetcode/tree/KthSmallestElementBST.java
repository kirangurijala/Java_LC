package com.leetcode.tree;


import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/kth-smallest-element-in-a-bst/

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.



Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?



Constraints:

The number of elements of the BST is between 1 to 10^4.
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 */
public class KthSmallestElementBST {
    List<Integer> res = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        inorderTraversal(root);
        return res.get(k - 1);
    }

    public void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
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
        binaryTreeImplementation.traverseInOrder(root);
        KthSmallestElementBST invertBinaryTree = new KthSmallestElementBST();

        System.out.println(invertBinaryTree.kthSmallest(root, 2));
        binaryTreeImplementation.traverseInOrder(root);
    }
}