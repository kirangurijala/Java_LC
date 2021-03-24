package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/balance-a-binary-search-tree/

Given a binary search tree, return a balanced binary search tree with the same node values.

A binary search tree is balanced if and only if the depth of the two subtrees of every node never differ by more than 1.

If there is more than one answer, return any of them.



Example 1:



Input: root = [1,null,2,null,3,null,4,null,null]
Output: [2,1,3,null,null,null,4]
Explanation: This is not the only correct answer, [3,1,4,null,2,null,null] is also correct.


Constraints:

The number of nodes in the tree is between 1 and 10^4.
The tree nodes will have distinct values between 1 and 10^5
*/
public class BalanceaBinarySearchTree {
    List<Integer> nodeValues=new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return constructBST(0,nodeValues.size()-1);
    }

    private TreeNode constructBST(int left,int right) {
        if(left>right){
            return null;
        }
        int m=(left+right)/2;
        TreeNode root=new TreeNode(nodeValues.get(m));
        root.left=constructBST(left,m-1);
        root.right=constructBST(m+1,right);
        return root;
    }

    private void inorder(TreeNode root) {
        if(root==null){
            return;
        }

        inorder(root.left);
        nodeValues.add(root.val);
        inorder(root.right);
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
        BalanceaBinarySearchTree treee = new BalanceaBinarySearchTree();
        System.out.println(treee.balanceBST(root));
    }
}