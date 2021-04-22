package com.leetcode.tree;


import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/

Given two nodes of a binary tree p and q, return their lowest common ancestor (LCA).

Each node will have a reference to its parent node. The definition for Node is below:

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
}
According to the definition of LCA on Wikipedia: "The lowest common ancestor of two nodes p and q in a tree T is the lowest node that has both p and q as descendants (where we allow a node to be a descendant of itself)."



Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5 since a node can be a descendant of itself according to the LCA definition.
Example 3:

Input: root = [1,2], p = 1, q = 2
Output: 1


Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q exist in the tree.

    */
public class LowestCommonAncestorBinaryTreeIII {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };
    public Node lowestCommonAncestor(Node p, Node q) {
        Node a=p, b=q;
        while(a!=b){
            if(a==null){
                a=q;
            }else{
                a=a.parent;
            }
            if(b==null){
                b=p;
            }else{
                b=b.parent;
            }
        }

        return a;
    }
    public Node lowestCommonAncestor22(Node p, Node q) {
        List<Node> path = find_Path(p);
        while (q.parent != null) {
            for (Node node : path) {
                if (node == q) return q;
            }
            q = q.parent;
        }
        return q;
    }

    public List<Node> find_Path(Node p) {
        List<Node> path = new ArrayList<>();
        while (p.parent != null) {
            path.add(p);
            p = p.parent;
        }
        return path;
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
        LowestCommonAncestorBinaryTreeIII invertBinaryTree = new LowestCommonAncestorBinaryTreeIII();
        //      System.out.println("LCA:" + invertBinaryTree.lowestCommonAncestor(root, new TreeNode(8), new TreeNode(9)));
    }
}