package com.leetcode.tree;


import com.leetcode.LinkedList.ListNode;

/*
https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.



Example 1:


Input: head = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.
Example 2:

Input: head = []
Output: []
Example 3:

Input: head = [0]
Output: [0]
Example 4:

Input: head = [1,3]
Output: [3,1]


Constraints:

The number of nodes in head is in the range [0, 2 * 104].
-10^5 <= Node.val <= 10^5
*/
public class ConvertSortedListtoBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        if(null == head){
            return null;
        }

        if(null == head.next){
            return new TreeNode(head.val);
        }

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while(null != fast && null != fast.next){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);

        return root;
    }


    public static void main(String[] args) {

        ConvertSortedListtoBinarySearchTree invertBinaryTree = new ConvertSortedListtoBinarySearchTree();
//TreeNode res=invertBinaryTree.sortedListToBST(new int[]{1,2,3,4,5,6,7});
     //   System.out.println(res.val);
    }

    public TreeNode sortedListToBST33(ListNode head){
        if(head == null){
            return null;
        }

        ListNode middleNode=middleNode(head);
        TreeNode root= new TreeNode(middleNode.val);

        if (head == middleNode) {
            return root;
        }

        root.left=sortedListToBST(head);
        root.right=sortedListToBST(middleNode.next);

        return root;
    }

    private ListNode middleNode(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }

        ListNode prev = null;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            prev = slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        if (prev != null)
            prev.next = null;

//        // System.out.println("!!!!!!!!!!!!!!!");
//        //if (prev.next != null)
//            // if (prev != null)
//     //  System.out.println(prev.val+":");
//    //   System.out.println("********************");
//       //       if (slow != null)
//      // System.out.println(slow.val+":");

//       if (slow.next != null)
//     //  System.out.println(slow.val+":"+slow.next.val);
        return slow;

    }
}