package com.leetcode.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://leetcode.com/problems/validate-binary-search-tree/
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.



Example 1:

Input: root = [2,1,3]
Output: true

Example 2:

Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.



Constraints:

    The number of nodes in the tree is in the range [1, 104].
    -231 <= Node.val <= 231 - 1


    */
public class BinaryTreeLevelOrderTraversal {
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
        BinaryTreeLevelOrderTraversal invertBinaryTree = new BinaryTreeLevelOrderTraversal();

        System.out.println(invertBinaryTree.levelOrder(root));
    }

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res= new ArrayList<>();
        if(root==null){
            return res;
        }

        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> levelNodes=new ArrayList<>();
            int count=q.size();
            for(int i=0;i<count;i++){
                TreeNode node=q.poll();
                levelNodes.add(node.val);
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }

            res.add(levelNodes);
        }

        return res;
    }
}