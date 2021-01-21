package com.leetcode.LinkedList;

/*
83. Remove Duplicates from Sorted List
Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3
    */
public  class RemoveDuplicatesfromSortedList {
  public static ListNode removeElements(ListNode head,int val) {
    ListNode curr=head;
    while(curr!=null && curr.next!=null){
      if(curr.val==curr.next.val){
        curr.next=curr.next.next;
      }else{
        curr=curr.next;
      }
    }
    return head;
  }


  public static void main(String[] args) {
    ListNode ls1=new ListNode(1,null);
    ListNode ls2=new ListNode(1,ls1);
    ListNode ls3=new ListNode(2,ls2);
    ListNode ls4=new ListNode(2,ls3);
    ListNode ls5=new ListNode(4,ls4);
    System.out.println(ls4);

    System.out.println(removeElements(ls5,4));
  }
}