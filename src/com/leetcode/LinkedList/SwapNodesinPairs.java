package com.leetcode.LinkedList;

/*
https://leetcode.com/problems/swap-nodes-in-pairs/

Given a linked list, swap every two adjacent nodes and return its head.



Example 1:


Input: head = [1,2,3,4]
Output: [2,1,4,3]
Example 2:

Input: head = []
Output: []
Example 3:

Input: head = [1]
Output: [1]


Constraints:

The number of nodes in the list is in the range [0, 100].
0 <= Node.val <= 100


Follow up: Can you solve the problem without modifying the values in the list's nodes? (i.e., Only nodes themselves may be changed.)
    */
public  class SwapNodesinPairs {
  public static ListNode swapPairs(ListNode head) {
    ListNode dummy=new ListNode(-1);
    dummy.next=head;
    ListNode rev=dummy;
    ListNode curr=head;

    while(curr!=null && curr.next!=null){
      ListNode firstNode=curr;
      ListNode secondNode=curr.next;

      ListNode temp=firstNode.next;
      firstNode.next=secondNode.next;
      secondNode.next=firstNode;

      curr=temp.next;
    }

    return dummy.next;
  }


  public static void main(String[] args) {
    ListNode ls1=new ListNode(1,null);
    ListNode ls2=new ListNode(2,ls1);
    ListNode ls3=new ListNode(3,ls2);
    ListNode ls4=new ListNode(4,ls3);
    System.out.println(ls1);

    System.out.println(swapPairs(ls4));//4 3 2 1
    System.out.println(ls4==swapPairs(swapPairs(ls4)));
  }
}