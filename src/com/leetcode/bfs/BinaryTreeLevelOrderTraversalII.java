package com.leetcode.bfs;


import com.leetcode.tree.BinaryTreeImplementation;
import com.leetcode.tree.TreeNode;

import java.util.*;

/*
https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
107. Binary Tree Level Order Traversal II


Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).
Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[15,7],[9,20],[3]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
    */
public class BinaryTreeLevelOrderTraversalII {
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
        BinaryTreeLevelOrderTraversalII invertBinaryTree = new BinaryTreeLevelOrderTraversalII();
       System.out.println("result: "+invertBinaryTree.levelOrder(root));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists=new ArrayList<>();
      Queue<TreeNode> queue=new LinkedList<>();
      queue.add(root);
      while (!queue.isEmpty()){
          int size= queue.size();
          List<Integer> list=new ArrayList<>();
          for(int i=0;i<size;i++){
              TreeNode node=queue.remove();
              list.add(node.val);
              if(node.left!=null){
                  queue.add(node.left);
              }
              if(node.right!=null){
                  queue.add(node.right);
              }
          }

          lists.add(list);
      }

        Collections.reverse(lists);
      return  lists;
    }
}