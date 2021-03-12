package com.leetcode.LinkedList;

/*
https://leetcode.com/problems/add-two-numbers-ii/

You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7


    */
public  class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res=new ListNode(0);
        ListNode curr=res;
        int sum=0;
        l1=reverse(l1);
        l2=reverse(l2);
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

        return reverse(res.next);
    }

    private ListNode reverse(ListNode node){
        ListNode curr=node;
        ListNode pre=null;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=pre;
            pre=curr;
            curr=temp;
        }

        return pre;
    }


    public static void main(String[] args) {
    ListNode ls1=new ListNode(1,null);
    ListNode ls2=new ListNode(2,ls1);
    ListNode ls3=new ListNode(3,ls2);
    ListNode ls4=new ListNode(4,ls3);
    System.out.println(ls4);
    AddTwoNumbersII solution=new AddTwoNumbersII();
    System.out.println(solution.addTwoNumbers(ls3,ls4));
  }
}