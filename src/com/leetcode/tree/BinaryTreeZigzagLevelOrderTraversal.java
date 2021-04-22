package com.leetcode.tree;


import java.util.*;

/*
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100
    */
public class BinaryTreeZigzagLevelOrderTraversal {
    /*
    * Apply BFS with a zigzag variable
    * Add root to q,ziqzag to false
    * loop to queue
    *   create new list to keep the elements in same level
    *   poll the element from q assign to size
    *   loop through q elements for o to size
    *       poll q elements add to levelNodes
    *           IF ZIGZAG is true add to list start of list(zero position) else add to end of list
    *       if node left is not null add left element
    *       if node right is not null add right element
    *   after for loop add levelNodes to res list
    *  Time complexity : O(n)
    *  Space complexity : O(n)
    */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null){
            return res;
        }

        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        boolean zigzag=false;
        while(!q.isEmpty()){
            List<Integer> levelNodes=new ArrayList<>();
            int cnt = q.size();
            for (int i = 0; i < cnt; i++) {
                TreeNode node=q.poll();
                if(zigzag){
                    levelNodes.add(0, node.val);
                }else{
                    levelNodes.add(node.val);
                }

                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }

            res.add(levelNodes);
            zigzag=!zigzag;
        }

        return res;
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
        BinaryTreeZigzagLevelOrderTraversal invertBinaryTree = new BinaryTreeZigzagLevelOrderTraversal();

        System.out.println(invertBinaryTree.zigzagLevelOrder(root));
    }
}