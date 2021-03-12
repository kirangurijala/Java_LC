package com.leetcode.tree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.



Follow up:

    You may only use constant extra space.
    Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.



Example 1:

Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.

    */
public class PopulatingNextRightPointersEachNode {
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
        PopulatingNextRightPointersEachNode invertBinaryTree = new PopulatingNextRightPointersEachNode();

       // System.out.println(invertBinaryTree.connect(root));
    }

    public Node connect(Node root) {
        if(root==null) return root;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            for (int i = 0; i < size ; i++) {
                Node node=q.poll();
                if(i != size - 1){
                    node.next=q.peek();
                }
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
        }

        return root;
    }


//       public Node connect(Node root) {
//
//            if (root == null) {
//                return root;
//            }
//
//            // Start with the root node. There are no next pointers
//            // that need to be set up on the first level
//            Node leftmost = root;
//
//            // Once we reach the final level, we are done
//            while (leftmost.left != null) {
//
//                // Iterate the "linked list" starting from the head
//                // node and using the next pointers, establish the
//                // corresponding links for the next level
//                Node head = leftmost;
//
//                while (head != null) {
//
//                    // CONNECTION 1
//                    head.left.next = head.right;
//
//                    // CONNECTION 2
//                    if (head.next != null) {
//                        head.right.next = head.next.left;
//                    }
//
//                    // Progress along the list (nodes on the current level)
//                    head = head.next;
//                }
//
//                // Move onto the next level
//                leftmost = leftmost.left;
//            }
//
//            return root;
//        }
//






















    public Node connect22(Node root) {

        if (root == null) {
            return root;
        }

        // Initialize a queue data structure which contains
        // just the root of the tree
        Queue<Node> Q = new LinkedList<Node>();
        Q.add(root);

        // Outer while loop which iterates over
        // each level
        while (Q.size() > 0) {

            // Note the size of the queue
            int size = Q.size();

            // Iterate over all the nodes on the current level
            for(int i = 0; i < size; i++) {

                // Pop a node from the front of the queue
                Node node = Q.poll();

                // This check is important. We don't want to
                // establish any wrong connections. The queue will
                // contain nodes from 2 levels at most at any
                // point in time. This check ensures we only
                // don't establish next pointers beyond the end
                // of a level
                if (i < size - 1) {
                    node.next = Q.peek();
                }

                // Add the children, if any, to the back of
                // the queue
                if (node.left != null) {
                    Q.add(node.left);
                }
                if (node.right != null) {
                    Q.add(node.right);
                }
            }
        }

        // Since the tree has now been modified, return the root node
        return root;
    }
}

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
