package com.leetcode.LinkedList;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/middle-of-the-linked-list/

Given a non-empty, singly linked list with head node head, return a middle node of linked list.

If there are two middle nodes, return the second middle node.



Example 1:

Input: [1,2,3,4,5]
Output: Node 3 from this list (Serialization: [3,4,5])
The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
Note that we returned a ListNode object ans, such that:
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
Example 2:

Input: [1,2,3,4,5,6]
Output: Node 4 from this list (Serialization: [4,5,6])
Since the list has two middle nodes with values 3 and 4, we return the second one.


Note:

The number of nodes in the given list will be between 1 and 100.    */
public  class PalindromeLinkedList {
//12321 curr
//321
//12 rev
//Time complexity : O(n)
//Space  complexity : O(1)
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

  //Time complexity : O(n)
  //Space  complexity : O(n)

  public boolean isPalindromeByList(ListNode head) {
    List<Integer> vals = new ArrayList<>();

    // Convert LinkedList into ArrayList.
    ListNode currentNode = head;
    while (currentNode != null) {
      vals.add(currentNode.val);
      currentNode = currentNode.next;
    }

    // Use two-pointer technique to check for palindrome.
    int front = 0;
    int back = vals.size() - 1;
    while (front < back) {
      // Note that we must use ! .equals instead of !=
      // because we are comparing Integer, not int.
      if (!vals.get(front).equals(vals.get(back))) {
        return false;
      }
      front++;
      back--;
    }
    return true;
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