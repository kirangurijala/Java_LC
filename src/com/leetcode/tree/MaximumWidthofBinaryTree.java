package com.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://leetcode.com/problems/maximum-width-of-binary-tree/

Given a binary tree, write a function to get the maximum width of the given tree. The maximum width of a tree is the maximum width among all levels.

The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.

It is guaranteed that the answer will in the range of 32-bit signed integer.
`
Example 1:

Input:

           1
         /   \
        3     2
       / \     \
      5   3     9

Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
Example 2:

Input:

          1
         /
        3
       / \
      5   3

Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).
Example 3:

Input:

          1
         / \
        3   2
       /
      5

Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).
Example 4:

Input:

          1
         / \
        3   2
       /     \
      5       9
     /         \
    6           7
Output: 8
Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).


Constraints:

The given binary tree will have between 1 and 3000 nodes.
    */
public class MaximumWidthofBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        int max=0,start=0,end=0;
        Queue<TreeNode> nodes=new LinkedList<>();
        nodes.add(root);
        Queue<Integer> indexes=new LinkedList<>();
        indexes.add(1);
        while (!nodes.isEmpty()){
            int size= nodes.size();
            start=0;
            end=0;
            for (int i = 0; i < size; i++) {
                TreeNode node=nodes.poll();
                int index=indexes.poll();
                if(i==0) start=index;
                if(i==size-1) end=index;
                if(node.left!=null){
                    nodes.add(node.left);
                    indexes.add(2*index);
                }
                if(node.right!=null){
                    nodes.add(node.right);
                    indexes.add(2*index+1);
                }
            }
            max=Math.max(max,end-start+1);
        }

        return max;
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
        MaximumWidthofBinaryTree treee = new MaximumWidthofBinaryTree();
        System.out.println(treee.widthOfBinaryTree(root));
    }
}