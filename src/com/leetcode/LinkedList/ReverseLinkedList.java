package com.leetcode.LinkedList;

/*
https://leetcode.com/problems/reverse-linked-list/
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL

Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?

    */
public  class ReverseLinkedList {
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