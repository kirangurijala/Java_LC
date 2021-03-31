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

    //Time complexity: O(n), when n is the length of the input array, because we would visit each element in time once.
    //Space complexity: O(1), because the size of the array remainders is fixed with 60.
    public int numPairsDivisibleBy60(int[] time) {
        int remainders[] = new int[60];
        int count = 0;
        for (int t: time) {
            if (t % 60 == 0) { // check if a%60==0 && b%60==0
                count = count+remainders[0];
            } else { // check if a%60+b%60==60
                count = count+remainders[60 - t % 60];
            }
            remainders[t % 60]++; // remember to update the remainders
        }
        return count;
    }

    //Time complexity: {O}(n^2) when n is the length of the input array. For each item in time, we iterate through the rest of the array to find a qualified complement taking \mathcal{O}(n)O(n) time.
    //Space complexity: O(1).
    public int numPairsDivisibleBy602loops(int[] time) {
        int count = 0, n = time.length;
        for (int i = 0; i < n; i++) {
            // j starts with i+1 so that i is always to the left of j
            // to avoid repetitive counting
            for (int j = i + 1; j < n; j++) {
                if ((time[i] + time[j]) % 60 == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}