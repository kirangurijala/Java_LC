package com.leetcode.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.



Example 1:


Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
Example 4:

Input: root = [1,2]
Output: [1,2]


Constraints:

The number of nodes in the tree is in the range [0, 104].
-1000 <= Node.val <= 1000
*/
public class SerializeandDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize22(TreeNode root) {
        if(root==null){
            return "#";
        }

        return root.val+","+serialize(root.left)+","+serialize(root.right);
    }

    StringBuilder sb=new StringBuilder();
    public String serialize(TreeNode root) {
        if(root==null){
            sb.append("#");
            return sb.toString();
        }

        sb.append(root.val).append(",");
        serialize(root.left);
        sb.append(",");
        serialize(root.right);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes=new LinkedList<>(Arrays.asList(data.split(",")));
        return  helper(nodes);
    }

    private TreeNode helper(Queue<String> q){
        String val=q.poll();
        if(val.equals("#")){
            return null;
        }

        TreeNode node=new TreeNode(Integer.valueOf(val));
        node.left=helper(q);
        node.right=helper(q);
        return node;
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
        SerializeandDeserializeBinaryTree treee = new SerializeandDeserializeBinaryTree();
        System.out.println(treee.serialize(root));
    }
}