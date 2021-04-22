package com.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/inorder-successor-in-bst/
Given the root of a binary search tree and a node p in it, return the in-order successor of that node in the BST. If the given node has no in-order successor in the tree, return null.

The successor of a node p is the node with the smallest key greater than p.val.



Example 1:

Input: root = [2,1,3], p = 1
Output: 2
Explanation: 1's in-order successor node is 2. Note that both p and the return value is of TreeNode type.

Example 2:

Input: root = [5,3,6,2,4,null,null,1], p = 6
Output: null
Explanation: There is no in-order successor of the current node, so the answer is null.



Constraints:

    The number of nodes in the tree is in the range [1, 104].
    -105 <= Node.val <= 105
    All Nodes will have unique values.


    */
public class InorderSuccessorinBST {
    int res = 1;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        }

        TreeNode left = inorderSuccessor(root.left, p);
        if(left!=null){
            return  left;
        }

        return  root;
    }

    public TreeNode inorderSuccessoWhile(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while(root!=null) {
            if(root.val > p.val) {
                res = root;
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return res;
    }

     List<TreeNode> nodes=new ArrayList<>();
     public TreeNode inorderSuccessorList(TreeNode root, TreeNode n) {
         inorderSuccessor(root);
         int index=nodes.indexOf(n);
         if(index<0||index+1==nodes.size()){
             return null;
         }

         return nodes.get(index+1);
     }

     public void inorderSuccessor(TreeNode root) {
         if (root == null) {
             return;
         }

         inorderSuccessor(root.left);
         nodes.add(root);
         inorderSuccessor(root.right);
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
        InorderSuccessorinBST treee = new InorderSuccessorinBST();
        System.out.println(treee.inorderSuccessor(root,root));
    }
}