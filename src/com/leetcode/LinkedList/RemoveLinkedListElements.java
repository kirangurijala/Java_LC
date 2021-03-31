package com.leetcode.LinkedList;

/*
https://leetcode.com/problems/remove-linked-list-elements/

203. Remove Linked List Elements
Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
    */
public  class RemoveLinkedListElements {
  public static ListNode removeElements(ListNode head,int val) {
    while(head!=null && head.val==val){
      head=head.next;
    }
    ListNode curr=head;
    while(curr!=null && curr.next!=null){
      if(curr.next.val==val){
        curr.next=curr.next.next;
      }else{
        curr=curr.next;
      }
    }
    return head;
  }


  public static void main(String[] args) {
    ListNode ls1=new ListNode(1,null);
    ListNode ls2=new ListNode(2,ls1);
    ListNode ls3=new ListNode(4,ls2);
    ListNode ls4=new ListNode(3,ls3);
    ListNode ls5=new ListNode(4,ls4);
    System.out.println(ls4);

    System.out.println(removeElements(ls5,4));
  }
}