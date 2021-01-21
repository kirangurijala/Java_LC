package com.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
In a list of songs, the i-th song has a duration of time[i] seconds.

Return the number of pairs of songs for which their total duration in seconds is divisible by 60.  Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.



Example 1:

Input: [30,20,150,100,40]
Output: 3
Explanation: Three pairs have a total duration divisible by 60:
(time[0] = 30, time[2] = 150): total duration 180
(time[1] = 20, time[3] = 100): total duration 120
(time[1] = 20, time[4] = 40): total duration 60

Example 2:

Input: [60,60,60]
Output: 3
Explanation: All three pairs have a total duration of 120, which is divisible by 60.


*/
public class PairsofSongsDivisibleby60 {
    public static void main(String[] args) {
        PairsofSongsDivisibleby60 solution = new PairsofSongsDivisibleby60();
        int arr[] = {30, 20, 150, 100, 40};
        System.out.println(solution.numPairsDivisibleBy60(arr));
    }

    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> count = new HashMap<>();
        int ans = 0;
        for (int t : time) {
            int theOther = (60 - t % 60) % 60;
            ans += count.getOrDefault(theOther, 0); // in current HashMap, get the number of songs that if adding t equals to a multiple of 60.
            count.put(t % 60, 1 + count.getOrDefault(t % 60, 0)); // update the number of t % 60.
        }
        return ans;
    }
}