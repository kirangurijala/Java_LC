package com.leetcode.LinkedList;

import java.util.HashSet;

/*
https://leetcode.com/problems/linked-list-cycle/

Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL

Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?

    */
public  class LinkedListCycle {
  public static boolean hasCycle(ListNode head) {
    if(head == null) return false;
    ListNode slow=head;
    ListNode fast=head.next;

    while(slow!=fast){
      if(fast==null || fast.next==null){
        return false;
      }
      slow=slow.next;
      fast=fast.next.next;
    }

    return true;
  }

  public static boolean hasCycle2(ListNode head) {
    HashSet<ListNode> nodes=new HashSet<>();
    ListNode curr=head;
    while(curr!=null){
      if(nodes.contains(curr)){
        return true;
      }
      nodes.add(curr);
      curr=curr.next;
    }
    return false;
  }


  public static void main(String[] args) {
    ListNode ls1=new ListNode(1,null);
    ListNode ls2=new ListNode(2,ls1);
    ListNode ls3=new ListNode(3,ls2);
    ListNode ls4=new ListNode(4,ls3);
    System.out.println(hasCycle(ls4));
    ls2.next=ls4;
    System.out.println(hasCycle(ls4));
  }
}