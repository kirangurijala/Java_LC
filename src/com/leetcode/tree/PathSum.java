package com.leetcode.tree;


import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/path-sum/
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1

return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

    */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right==null) return sum==root.val;
        return hasPathSum(root.left,sum- root.val) || hasPathSum(root.right,sum- root.val);
    }

    public boolean hasPathSumBFS(TreeNode root, int sum) {
        if(root == null){
            return false;
        }

        LinkedList<Integer> sums = new LinkedList<Integer>();
        LinkedList<TreeNode> q=new LinkedList<>();
        q.add(root);
        sums.add(sum - root.val);
        int pathSum=0;
        TreeNode node;
        while(!q.isEmpty()){
            int size=q.size();
            node=q.pollLast();
            pathSum=sums.pollLast();
            if ((node.right == null) && (node.left == null) && (pathSum == 0))
                return true;

            if (node.right != null) {
                q.add(node.right);
                sums.add(pathSum - node.right.val);
            }
            if (node.left != null) {
                q.add(node.left);
                sums.add(pathSum - node.left.val);
            }
        }

        return false;
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
        PathSum invertBinaryTree = new PathSum();
       // invertBinaryTree.(root);
        System.out.println("Traversing tree in order");
        binaryTreeImplementation.traverseInOrder(root);
    }
}