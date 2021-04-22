package com.leetcode.LinkedList;

import java.util.Stack;

/*
https://leetcode.com/problems/add-two-numbers/

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.



Example 1:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]

Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]


    */
public  class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode l=new ListNode(0);
    ListNode curr=l;
    int sum=0;
    while(l1!=null || l2!=null){
      if(l1!=null){
        sum=sum+l1.val;
        l1=l1.next;
      }
      if(l2!=null){
        sum=sum+l2.val;
        l2=l2.next;
      }

      curr.next=new ListNode(sum%10);
      curr=curr.next;
      sum=sum/10;
    }

    if(sum>0){
      curr.next=new ListNode(sum%10);
    }

    return l.next;
  }


  public static void main(String[] args) {
    ListNode ls1=new ListNode(1,null);
    ListNode ls2=new ListNode(2,ls1);
    ListNode ls3=new ListNode(3,ls2);
    ListNode ls4=new ListNode(4,ls3);
    System.out.println(ls4);
    AddTwoNumbers solution=new AddTwoNumbers();
    System.out.println(solution.addTwoNumbers(ls3,ls4));
  }
}