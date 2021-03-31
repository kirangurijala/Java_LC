package com.leetcode.tree;

import java.util.*;

/*
https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

We are given a binary tree (with root node root), a target node, and an integer value K.

Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.



Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2

Output: [7,4,1]

Explanation:
The nodes that are a distance 2 from the target node (with value 5)
have values 7, 4, and 1.



Note that the inputs "root" and "target" are actually TreeNodes.
The descriptions of the inputs above are just serializations of these objects.


Note:

The given tree is non-empty.
Each node in the tree has unique values 0 <= node.val <= 500.
The target node is a node in the tree.
0 <= K <= 1000.
*/
public class AllNodesDistanceKinBinaryTree {
    //Method 1: use HashMap
    //1. build a undirected graph using treenodes as vertices, and the parent-child relation as edges
    //2. do BFS with source vertice (target) to find all vertices with distance K to it.
    Map<TreeNode, List<TreeNode>> map = new HashMap();
    //here can also use Map<TreeNode, TreeNode> to only store the child - parent mapping, since parent-child mapping is inherent in the tree structure

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null || K < 0){
            return res;
        }
        buildMap(root, null);
        if (!map.containsKey(target)){
            return res;
        }

        Set<TreeNode> visited = new HashSet<TreeNode>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(target);
        visited.add(target);
        while (!q.isEmpty()) {
            int size = q.size();
            if (K == 0) {
                for (int i = 0; i < size ; i++) res.add(q.poll().val);
                    return res;
                }
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                for (TreeNode next : map.get(node)) {
                    if (visited.contains(next)){
                      continue;
                    }
                    visited.add(next);
                    q.add(next);
                }
            }

            K--;
        }
        return res;
    }

    private void buildMap(TreeNode node, TreeNode parent) {
        if (node == null){
            return;
        }

        if (map.containsKey(node)) {
            return;
        }

        map.put(node, new ArrayList<TreeNode>());
        if (parent != null)  {
            map.get(node).add(parent);
            map.get(parent).add(node) ;
        }

        buildMap(node.left, node);
        buildMap(node.right, node);
    }


    //Method 2: No HashMap
//kind of like clone the tree, in the meanwhile add a parent link to the node
        private GNode targetGNode;

        private class GNode {
            TreeNode node;
            GNode parent, left, right;
            GNode (TreeNode node) {
                this.node = node;
            }
        }

        public List<Integer> distanceKNoHashMap(TreeNode root, TreeNode target, int K) {
            List<Integer> res = new ArrayList<Integer> ();
            if (root == null || K < 0) return res;
            cloneGraph(root, null, target);
            if (targetGNode == null) return res;
            Set<GNode> visited = new HashSet<GNode>();
            Queue<GNode> q = new LinkedList<GNode>();
            q.add(targetGNode);
            visited.add(targetGNode);
            while (!q.isEmpty()) {
                int size = q.size();
                if (K == 0) {
                    for (int i = 0; i < size ; i++) res.add(q.poll().node.val);
                    return res;
                }
                for (int i = 0; i < size; i++) {
                    GNode gNode = q.poll();
                    if (gNode.left != null && !visited.contains(gNode.left)) { visited.add(gNode.left); q.add(gNode.left); }
                    if (gNode.right != null && !visited.contains(gNode.right)) { visited.add(gNode.right); q.add(gNode.right); }
                    if (gNode.parent != null && !visited.contains(gNode.parent)) { visited.add(gNode.parent); q.add(gNode.parent); }
                }
                K--;
            }
            return res;
        }

        private GNode cloneGraph(TreeNode node, GNode parent, TreeNode target) {
            if (node == null) return null;
            GNode gNode = new GNode(node);
            if (node == target) targetGNode = gNode;
            gNode.parent = parent;
            gNode.left = cloneGraph(node.left, gNode, target);
            gNode.right = cloneGraph(node.right, gNode, target);
            return gNode;
        }

    Map<TreeNode, Integer> map2 = new HashMap<>();

    public List<Integer> distanceKdfs(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new LinkedList<>();
        find(root, target);
        dfs(root, target, K, map2.get(root), res);
        return res;
    }

    // find target node first and store the distance in that path that we could use it later directly
    private int find(TreeNode root, TreeNode target) {
        if (root == null) return -1;
        if (root == target) {
            map2.put(root, 0);
            return 0;
        }
        int left = find(root.left, target);
        if (left >= 0) {
            map2.put(root, left + 1);
            return left + 1;
        }
        int right = find(root.right, target);
        if (right >= 0) {
            map2.put(root, right + 1);
            return right + 1;
        }
        return -1;
    }

    private void dfs(TreeNode root, TreeNode target, int K, int length, List<Integer> res) {
        if (root == null) return;
        if (map2.containsKey(root)) length = map2.get(root);
        if (length == K) res.add(root.val);
        dfs(root.left, target, K, length + 1, res);
        dfs(root.right, target, K, length + 1, res);
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
        AllNodesDistanceKinBinaryTree treee = new AllNodesDistanceKinBinaryTree();
    //    System.out.println(treee.isBalanced(root));
    }
}