package com.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/count-good-nodes-in-binary-tree/
Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

Return the number of good nodes in the binary tree.



Example 1:



Input: root = [3,1,4,3,null,1,5]
Output: 4
Explanation: Nodes in blue are good.
Root Node (3) is always a good node.
Node 4 -> (3,4) is the maximum value in the path starting from the root.
Node 5 -> (3,4,5) is the maximum value in the path
Node 3 -> (3,1,3) is the maximum value in the path.
Example 2:



Input: root = [3,3,null,4,2]
Output: 3
Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.
Example 3:

Input: root = [1]
Output: 1
Explanation: Root is considered as good.


Constraints:

The number of nodes in the binary tree is in the range [1, 10^5].
Each node's value is between [-10^4, 10^4].
    */
public class CountGoodNodesinBinaryTree {
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
        CountGoodNodesinBinaryTree treee = new CountGoodNodesinBinaryTree();
        treee.goodNodes(root);
        System.out.println(treee.goodNodes(root));
    }

    public int goodNodes(TreeNode root) {
        return preorder(root,Integer.MIN_VALUE);
    }

    int res=0,max=0;
    public int preorder(TreeNode root,int max){
        if(root==null){
            return 0;
        }

        if(root.val>=max){
            res=1;
            max=root.val;
        }else{
            res=0;
        }

        res+=preorder(root.left, max);
        res+=preorder(root.right, max);
        return res;
    }

    // public int goodNodes(TreeNode root, int ma) {
//         if (root == null) return 0;
//         int res = root.val >= ma ? 1 : 0;
//         res += goodNodes(root.left, Math.max(ma, root.val));
//         res += goodNodes(root.right, Math.max(ma, root.val));
//         return res;
//     }
}