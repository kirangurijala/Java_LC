package com.leetcode.collection.queue.priorityQueue;

import java.util.PriorityQueue;
import java.util.Queue;

/*
https://leetcode.com/problems/find-median-from-data-stream/
Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.


Example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3)
findMedian() -> 2


Follow up:

If all integer numbers from the stream are between 0 and 100, how would you optimize it?
If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
 */
public class FindMedianfromDataStream {
    public static void main(String[] args) {
        MedianFinder solution = new MedianFinder();
        int[] arr={1,2,3};
        solution.addNum(8);
        System.out.println("*******");
        System.out.println(solution.small);
        System.out.println(solution.large);
        solution.addNum(9);
        System.out.println("*******");
        System.out.println(solution.small);
        System.out.println(solution.large);
        solution.addNum(6);
        System.out.println("*******");
        System.out.println(solution.small);
        System.out.println(solution.large);
        solution.addNum(1);
        System.out.println("*******");
        System.out.println(solution.small);
        System.out.println(solution.large);
    }

    public int threeSum(int[] nums) {

        return 0;
    }
}


class MedianFinder {
    public Queue<Integer> small,large;

    /** initialize your data structure here. */
    public MedianFinder() {
        small = new PriorityQueue<Integer>() ;
        large = new PriorityQueue<Integer>((a,b) -> (b.compareTo(a)));
    }

    public void addNum(int num) {
        large.add(num);
        small.add(large.poll());
        if (large.size() < small.size())
            large.add(small.poll());
    }

    public double findMedian() {
        return large.size() > small.size()
                ? large.peek()
                : (large.peek()/2.0 + small.peek()/2.0);
    }
}