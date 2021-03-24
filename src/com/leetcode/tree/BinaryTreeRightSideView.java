package com.leetcode.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://leetcode.com/problems/binary-tree-right-side-view/
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
    */
public class BinaryTreeRightSideView {
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
        binaryTreeImplementation.traverseInOrder(root);
        BinaryTreeRightSideView invertBinaryTree = new BinaryTreeRightSideView();
        System.out.println(invertBinaryTree.rightSideView(root));
        System.out.println("Traversing tree in order");
        binaryTreeImplementation.traverseInOrder(root);
    }
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q=new LinkedList<>();
        while (!q.isEmpty()){
            int size= q.size();
            for (int i = 0; i < size; i++) {
               TreeNode node=q.poll();
               if(i==size-1){
                   res.add(node.val);
               }

               if(node.right!=null){
                    q.offer(node.right);
                }
                if(node.left!=null){
                    q.offer(node.left);
                }
            }
        }

        return res;
    }
    public List<Integer> rightSideView22(TreeNode root) {
        if (root == null) {
            return res;
        }

        dfs(root, 1);
        return res;
    }

    public void dfs(TreeNode node, int level) {
        if (node == null)
            return;
        if (level > res.size()) {
            res.add(node.val);
        }
        dfs(node.right, level + 1);
        dfs(node.left, level + 1);
    }
}