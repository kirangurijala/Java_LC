package com.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/symmetric-tree/
226. Invert Binary Tree
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3



But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3



Follow up: Solve it both recursively and iteratively.

    */
public class CountGoodNodesinBinaryTree {
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
        CountGoodNodesinBinaryTree treee = new CountGoodNodesinBinaryTree();
        treee.goodNodes(root);
        System.out.println(treee.goodNodes(root));
    }

    public int goodNodes(TreeNode root) {
        return preorder(root,Integer.MIN_VALUE);
    }

    int res=0,max=0;
    public int preorder(TreeNode root,int max){
        if(root==null){
            return 0;
        }

        if(root.val>=max){
            res=1;
            max=root.val;
        }else{
            res=0;
        }

        res+=preorder(root.left, max);
        res+=preorder(root.right, max);
        return res;
    }

    // public int goodNodes(TreeNode root, int ma) {
//         if (root == null) return 0;
//         int res = root.val >= ma ? 1 : 0;
//         res += goodNodes(root.left, Math.max(ma, root.val));
//         res += goodNodes(root.right, Math.max(ma, root.val));
//         return res;
//     }
}