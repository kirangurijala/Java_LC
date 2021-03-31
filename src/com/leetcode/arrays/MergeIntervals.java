package com.leetcode.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/*
https://leetcode.com/problems/merge-intervals/
56. Merge Intervals
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.



Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
*/
public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Collections.sort(Arrays.asList(intervals), (a, b) -> a[0] - b[0]);
        LinkedList<int[]> merge = new LinkedList<>();
        for (int[] interval : intervals) {
            if (merge.isEmpty() || merge.getLast()[1] < interval[0]) {
                merge.add(interval);
            } else {
                merge.getLast()[1] = Math.max(merge.getLast()[1], interval[1]);
            }
        }

        return merge.toArray(new int[merge.size()][]);
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(merge(arr));
    }
}