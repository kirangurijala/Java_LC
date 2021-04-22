package com.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/same-tree/
Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.



Example 1:


Input: p = [1,2,3], q = [1,2,3]
Output: true
Example 2:


Input: p = [1,2], q = [1,null,2]
Output: false
Example 3:


Input: p = [1,2,1], q = [1,1,2]
Output: false


Constraints:

The number of nodes in both trees is in the range [0, 100].
-104 <= Node.val <= 104
*/
public class SameTree {
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
        SameTree treee = new SameTree();
        treee.isSameTree(root,root);
        System.out.println(treee.isSameTree(root,root));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null || q==null )
            return p==q;

        if(p.val!=q.val) return false;

        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
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
}