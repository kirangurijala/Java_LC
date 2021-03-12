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
  public static ListNode reverseList(ListNode head) {
    ListNode rev=null;
    ListNode curr=head;
    while(curr!=null){
      ListNode temp=curr.next;
      curr.next=rev;
      rev=curr;
      curr=temp;
    }

    return rev;
  }


  public static void main(String[] args) {
    ListNode ls1=new ListNode(1,null);
    ListNode ls2=new ListNode(2,ls1);
    ListNode ls3=new ListNode(3,ls2);
    ListNode ls4=new ListNode(4,ls3);
    System.out.println(ls1);

    System.out.println(reverseList(ls4));//4 3 2 1
    System.out.println(ls4==reverseList(reverseList(ls4)));
  }
}