package com.leetcode.tree;


import java.util.Stack;

/*
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
*/
public class ConvertSortedArraytoBinarySearchTree {
    public static void main(String[] args) {

        ConvertSortedArraytoBinarySearchTree invertBinaryTree = new ConvertSortedArraytoBinarySearchTree();
TreeNode res=invertBinaryTree.sortedArrayToBST(new int[]{1,2,3,4,5,6,7});
        System.out.println(res.val);
    }

    public TreeNode sortedArrayToBST(int[] num) {
        return helper(num,0,num.length-1);
    }

    private TreeNode helper(int[] nums,int l,int h){
        if(l>h){
            return null;
        }
        int m=(l+h)/2;
        TreeNode root=new TreeNode(nums[m]);
        root.left=helper(nums,l,m-1);
        root.right=helper(nums,m+1,h);

        return root;
    }
}