package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/binary-tree-paths/
Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3

    */
public class BinaryTreePaths {
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
        BinaryTreePaths treee = new BinaryTreePaths();
        System.out.println(treee.binaryTreePaths(root));
    }

    List<String>  paths=new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        binaryTreePaths(root,"");
        return paths;
    }

    public void binaryTreePaths(TreeNode root,String path) {
        if(root == null){
            return;
        }

        path += Integer.toString(root.val);
        if(root.left==null && root.right==null){
            paths.add(path);
        }else{
            path=path+"->";
            binaryTreePaths(root.left,path);
            binaryTreePaths(root.right,path);
        }
    }
}