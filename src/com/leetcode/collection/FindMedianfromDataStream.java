package com.leetcode.collection;

import com.leetcode.collection.queue.priorityQueue.FindMedianfromDataStream;

import java.util.*;

/*
https://leetcode.com/problems/find-median-from-data-stream/

The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.


Example 1:

Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0


Constraints:

-105 <= num <= 105
There will be at least one element in the data structure before calling findMedian.
At most 5 * 104 calls will be made to addNum and findMedian.


Follow up:

If all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
If 99% of all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
 */
class MedianFinder {
    //Time complexity: O(log n) + O(1) ≈O(logn).
    //
    //At worst, there are three heap insertions and two heap deletions from the top. Each of these takes about O(\log n)O(logn) time.
    //Finding the median takes constant O(1)O(1) time since the tops of heaps are directly accessible.
    //Space complexity: O(n)linear space to hold input in containers.
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    private boolean even = true;

    public double findMedian() {
        if (even)
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        else
            return maxHeap.peek();
    }

    public void addNum(int num) {
        if (even) {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        } else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
        even = !even;
    }


    public static void main(String[] args) {
        FindMedianfromDataStream solution = new FindMedianfromDataStream();
        int[] arr={1,2,3};

        System.out.println(solution.threeSum(arr));
        //Arrays.stream(solution.sortedSquares(arr)).forEach(n->System.out.print(n+" "));
    }
}
//Time complexity: O(n\log n) + O(1) \simeq O(n\log n)O(nlogn)+O(1)≃O(nlogn).
//
//Adding a number takes amortized O(1)O(1) time for a container with an efficient resizing scheme.
//Finding the median is primarily dependent on the sorting that takes place. This takes O(n\log n)O(nlogn) time for a standard comparative sort.
//Space complexity: O(n)O(n) linear space to hold input in a container. No extra space other than that needed (since sorting can usually be done in-place).
class MedianFinderBrute {
    List<Integer> ls;
    /** initialize your data structure here. */
    public MedianFinderBrute() {
        ls=new ArrayList<>();
    }

    public void addNum(int num) {
        ls.add(num);
    }

    public double findMedian() {
        Collections.sort(ls);
        int size=ls.size();
        if(size%2==1){
            return ls.get(size/2);
        }
        return ((double)ls.get(size/2)+ls.get(size/2-1))/2;
    }
}