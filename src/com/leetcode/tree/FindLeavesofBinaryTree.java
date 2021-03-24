package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/find-leaves-of-binary-tree/
Given the root of a binary tree, collect a tree's nodes as if you were doing this:

Collect all the leaf nodes.
Remove all the leaf nodes.
Repeat until the tree is empty.


Example 1:


Input: root = [1,2,3,4,5]
Output: [[4,5,3],[2],[1]]
Explanation:
[[3,5,4],[2],[1]] and [[3,4,5],[2],[1]] are also considered correct answers since per each level it does not matter the order on which elements are returned.
Example 2:

Input: root = [1]
Output: [[1]]


Constraints:

The number of nodes in the tree is in the range [1, 100].
1 <= Node.val <= 100
*/
public class FindLeavesofBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> leaves=new ArrayList<>();
        while (root!=null){
            if(isleaf(root,leaves)) root=null;
            res.add(leaves);
            leaves=new ArrayList<Integer>();
        }

        return res;
    }

    public boolean isleaf(TreeNode root,List<Integer> leaves) {
        if(root.left==null && root.right==null){
            leaves.add(root.val);
            return true;
        }

        if(root.left!=null){
            if(isleaf(root.left,leaves)) root.left=null;
        }

        if(root.right!=null){
            if(isleaf(root.right,leaves)) root.right=null;
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
        FindLeavesofBinaryTree treee = new FindLeavesofBinaryTree();
        System.out.println(treee.findLeaves(root));
    }
}