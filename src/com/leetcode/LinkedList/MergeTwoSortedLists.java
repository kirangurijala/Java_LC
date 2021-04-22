package com.leetcode.LinkedList;

import java.util.Stack;

/*
https://leetcode.com/problems/merge-two-sorted-lists/

Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.



Example 1:


Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: l1 = [], l2 = []
Output: []
Example 3:

Input: l1 = [], l2 = [0]
Output: [0]


Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both l1 and l2 are sorted in non-decreasing order.

    */
public  class








MergeTwoSortedLists {

  /*
  * Create a preHead (-1) to keep track of result link list, create l to iterate prehead
  * loop through l1&&L2 not null
  *  if l1 val is less than or equal l2 val, assign l1 to l.next..i.e l1.next=l1,else l.next=l2
  * After the loop check l1or l2 null, if l1 is null l.next=l2, else l.next =l1
  * return preHead.next(Don't return l beacuse l is used only for iteration when it reaches end its val is null)
  * Time complexity : O(n + m)
  * Space complexity : O(1)
  */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // maintain an unchanging reference to node ahead of the return node.
        ListNode prehead = new ListNode(-1);
        ListNode l = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                l.next = l1;
                l1 = l1.next;
            } else {
                l.next = l2;
                l2 = l2.next;
            }
            l = l.next;
        }

        // exactly one of l1 and l2 can be non-null at this point, so connect
        // the non-null list to the end of the merged list.
        if(l1!=null){
            l.next=l1;
        }else{
             l.next=l2;
        }

        return prehead.next;
    }


  public static void main(String[] args) {
    ListNode ls1=new ListNode(1,null);
    ListNode ls2=new ListNode(2,ls1);
    ListNode ls3=new ListNode(3,ls2);
    ListNode ls4=new ListNode(4,ls3);
    System.out.println(ls4);
    MergeTwoSortedLists sol=new MergeTwoSortedLists();
    System.out.println(sol.mergeTwoLists(ls4,ls3));
  }
}