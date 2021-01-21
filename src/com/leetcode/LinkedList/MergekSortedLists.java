package com.leetcode.LinkedList;

/*
https://leetcode.com/problems/merge-k-sorted-lists/
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.



Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []


Constraints:

k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] is sorted in ascending order.
The sum of lists[i].length won't exceed 10^4.

    */

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public  class MergekSortedLists {

  public ListNode mergeKLists(ListNode[] lists) {
    Queue<Integer> q=new PriorityQueue<>();
    for(ListNode ls:lists){
      while(ls!=null){
        q.add(ls.val);
        ls=ls.next;
      }
    }

   ListNode head=new ListNode(0);
    ListNode curr=head;
    while(!q.isEmpty()){
      curr.next=new ListNode(q.poll());
      curr=curr.next;
    }

return head.next;
  }



  public static void main(String[] args) {
    ListNode ls1=new ListNode(1,null);
    ListNode ls2=new ListNode(2,ls1);
    ListNode ls3=new ListNode(3,ls2);
    ListNode ls4=new ListNode(4,ls3);
    System.out.println(ls4);
    MergekSortedLists sol=new MergekSortedLists();
    System.out.println(sol.mergeKLists(new ListNode[]{ls4,ls2}));
  }
}