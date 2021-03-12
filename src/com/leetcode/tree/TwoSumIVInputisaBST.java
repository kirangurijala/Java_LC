package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such that their sum is equal to the given target.



Example 1:


Input: root = [5,3,6,2,4,null,7], k = 9
Output: true
Example 2:


Input: root = [5,3,6,2,4,null,7], k = 28
Output: false
Example 3:

Input: root = [2,1,3], k = 4
Output: true
Example 4:

Input: root = [2,1,3], k = 1
Output: false
Example 5:

Input: root = [2,1,3], k = 3
Output: true


Constraints:

The number of nodes in the tree is in the range [1, 104].
-104 <= Node.val <= 104
root is guaranteed to be a valid binary search tree.
-105 <= k <= 105
    */
public class TwoSumIVInputisaBST {
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
        TwoSumIVInputisaBST treee = new TwoSumIVInputisaBST();
        System.out.println(treee.findTarget(root,12));
    }
    List<Integer> res = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        inorder(root);
        int l = 0, r = res.size() - 1;
        while (l < r) {
            int sum = res.get(l) + res.get(r);
            if (sum == k)
                return true;
            if (sum < k)
                l++;
            else
                r--;
        }
        return false;
    }
    public List<Integer> inorder(TreeNode root) {
        if (root == null) {
            return res;
        }

        inorder(root.left);
        res.add(root.val);
        inorder(root.right);
        return res;
    }
}