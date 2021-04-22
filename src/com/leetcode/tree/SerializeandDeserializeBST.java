package com.leetcode.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/serialize-and-deserialize-bst/
Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You need to ensure that a binary search tree can be serialized to a string, and this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.



Example 1:

Input: root = [2,1,3]
Output: [2,1,3]
Example 2:

Input: root = []
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 104].
0 <= Node.val <= 104
The input tree is guaranteed to be a binary search tree.
*/
public class SerializeandDeserializeBST {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        public void serialize(TreeNode root, StringBuilder sb) {
            if (root == null) return;
            sb.append(root.val).append(",");
            serialize(root.left, sb);
            serialize(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) return null;
            Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
            return deserialize(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        public TreeNode deserialize(Queue<String> q, int lower, int upper) {
            if (q.isEmpty()) return null;
            String s = q.peek();
            int val = Integer.parseInt(s);
            if (val < lower || val > upper) return null;
            q.poll();
            TreeNode root = new TreeNode(val);
            root.left = deserialize(q, lower, val);
            root.right = deserialize(q, val, upper);
            return root;
        }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

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
        SerializeandDeserializeBST treee = new SerializeandDeserializeBST();
        System.out.println(treee.serialize(root));
    }
}