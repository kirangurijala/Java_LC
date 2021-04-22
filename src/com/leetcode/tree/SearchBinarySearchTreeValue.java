package com.leetcode.tree;

/*
https://leetcode.com/problems/diameter-of-binary-tree/
G Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree

          1
         / \
        2   3
       / \
      4   5

Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.
    */
public class SearchBinarySearchTreeValue {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null){
            return root;
        }

        if(root.val==val){
            return root;
        }
        if(root.val>val){
            return searchBST(root.left,val);
        }
        return searchBST(root.right,val);
    }

    public TreeNode searchBSTWhile(TreeNode root, int val) {
        while(root!=null){
            if(root.val==val){
                return root;
            }

            if(root.val>val){
                root=root.left;
            }else{
                root=root.right;
            }
        }

        return null;
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
        SearchBinarySearchTreeValue treee = new SearchBinarySearchTreeValue();
        System.out.println(treee.searchBST(root,4));
    }
}