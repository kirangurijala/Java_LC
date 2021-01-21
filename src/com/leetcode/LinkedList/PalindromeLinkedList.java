package com.leetcode.LinkedList;

/*
Given a singly linked list, determine if it is a palindrome.


Example 1:

Input: 1->2
Output: false

Example 2:

Input: 1->2->2->1
Output: true

Follow up:
Could you do it in O(n) time and O(1) space?


    */
public  class PalindromeLinkedList {
//12321 curr
//321
//12 rev
  public static boolean isPalindrome(ListNode head) {
    if (head == null) return true;
    ListNode curr=head;
    ListNode halfNode=half(head);
    ListNode rev=reverse(halfNode.next);
    ListNode sec=reverse(halfNode.next);

    while(rev!=null){
      if(rev.val!=curr.val){
        return false;
      }
      rev=rev.next;
      curr=curr.next;
    }

    halfNode.next = reverse(sec);//to restore node
    return true;
  }

  private static ListNode half(ListNode head) {
    ListNode slow=head;
    ListNode fast=head.next;

    while(fast!=null &&fast.next!=null){
      slow=slow.next;
      fast=fast.next.next;
    }

    return slow;
  }

  private static ListNode reverse(ListNode head) {
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
    System.out.println(ls4);

    System.out.println(isPalindrome(ls4));
  }
}