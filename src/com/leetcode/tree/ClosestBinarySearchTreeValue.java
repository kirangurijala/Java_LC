package com.leetcode.tree;

/*
https://leetcode.com/problems/closest-binary-search-tree-value/
Given the root of a binary search tree and a target value, return the value in the BST that is closest to the target.



Example 1:


Input: root = [4,2,5,1,3], target = 3.714286
Output: 4
Example 2:

Input: root = [1], target = 4.428571
Output: 1


Constraints:

The number of nodes in the tree is in the range [1, 104].
0 <= Node.val <= 109
-109 <= target <= 109
    */
public class ClosestBinarySearchTreeValue {


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
        ClosestBinarySearchTreeValue treee = new ClosestBinarySearchTreeValue();
        System.out.println(treee.closestValue(root,3.7667));
    }

    double min=Double.MAX_VALUE;
    int res=0;
    public int closestValue(TreeNode root, double target) {
        //int val=0, closest=root.val;
        double min=Double.MAX_VALUE;
        int res=0;
        while(root!=null){
            // val=root.val;
            // if(Math.abs(val-target)<Math.abs(closest-target)){
            //   closest = val;
            // }
            if(min>Math.abs(root.val-target)){
                min=Math.abs(root.val-target);
                res= root.val;
            }

            if(target< root.val){
                root =root.left;
            }else{
                root = root.right;
            }
        }

//     return closest;
        return res;
    }

    public int closestValue22(TreeNode root, double target) {
        if(root==null){
            return res;
        }

        if(min>Math.abs(root.val-target)){
            min=Math.abs(root.val-target);
            res= root.val;
        }
        closestValue(root.left,target);
        closestValue(root.right,target);
        return res;
    }
}