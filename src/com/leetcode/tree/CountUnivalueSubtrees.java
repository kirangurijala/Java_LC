package com.leetcode.tree;

/*
https://leetcode.com/problems/count-univalue-subtrees/
Given the root of a binary tree, return the number of uni-value subtrees.

A uni-value subtree means all nodes of the subtree have the same value.



Example 1:


Input: root = [5,1,5,5,5,null,5]
Output: 4
Example 2:

Input: root = []
Output: 0
Example 3:

Input: root = [5,5,5,5,5,null,5]
Output: 6


Constraints:

The numbrt of the node in the tree will be in the range [0, 1000].
-1000 <= Node.val <= 1000
*/
public class CountUnivalueSubtrees {

    int count;

    public int countUnivalSubtrees(TreeNode root) {
        count = 0;
        helper(root);
        return count;
    }

    private boolean helper(TreeNode root) {
        if(root==null){
            return true;
        }

        boolean left=helper(root.left);
        boolean right=helper(root.right);
        if(left&&right){
            if(root.left!=null&&root.left.val!=root.val){
                return  false;
            }
            if(root.right!=null&&root.right.val!=root.val){
                return  false;
            }
            count++;
            return true;
        }

        return  false;
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
        CountUnivalueSubtrees treee = new CountUnivalueSubtrees();
        System.out.println(treee.countUnivalSubtrees(root));
    }
}