package com.leetcode.arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/meeting-rooms-ii/

56. Merge Intervals
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2

Example 2:

Input: [[7,10],[2,4]]
Output: 1
*/
public class MeetingRoomsII {
    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        MeetingRoomsII sol = new MeetingRoomsII();
        System.out.println(sol.minMeetingRooms(arr));
    }

    /*
     * Time complexity : O(nlog(n)).
     * Space complexity : O(n).
     */
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        for (int[] interval:intervals) {
            if(!pq.isEmpty()&&pq.peek()[1]<=interval[0]){
                pq.poll();
            }
            pq.add(interval);
        }

        return pq.size();
    }

    /*
     * Time complexity : O(nlog(n)).
     * Space complexity : O(n).
     */
    public int minMeetingRoomsBysort(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        int index = 0;
        for (int[] interval : intervals) {
            starts[index] = interval[0];
            ends[index] = interval[1];
            index++;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0, endptr = 0;
        for (int i = 0; i < starts.length; i++) {//Note we not iterating entire
            if (starts[i] < ends[endptr]) {
                rooms++;
            } else {
                endptr++;
            }
        }
        return rooms;
    }
}