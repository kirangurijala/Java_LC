package com.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/symmetric-tree/
226. Invert Binary Tree
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3



But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3



Follow up: Solve it both recursively and iteratively.

    */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSame(root.left, root.right);
    }

    public boolean isSame(TreeNode left,TreeNode right) {
        if(left == null || right==null){
            return left==right;
        }

        if(left.val!=right.val){
            return false;
        }

        return isSame(left.right, right.left) && isSame(left.left, right.right);
    }


    public boolean isSymmetricR(TreeNode root) {
        Queue<TreeNode> nodes=new LinkedList<>();
        nodes.add(root.left);
        nodes.add(root.right);

        while(!nodes.isEmpty()){
            TreeNode p1=nodes.poll();
            TreeNode p2=nodes.poll();
            if(p1 == null || p2==null){
                if(p1==p2){
                    continue;
                }else{
                    return false;
                }
            }

            if(p1.val!=p2.val){
                return false;
            }
            nodes.add(p1.left);
            nodes.add(p2.right);
            nodes.add(p1.right);
            nodes.add(p2.left);
        }

        return true;
        //return isSymmetric(root.left, root.right);
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
        SymmetricTree treee = new SymmetricTree();
        treee.isSymmetric(root);
        System.out.println(treee.isSymmetric(root));
    }
}