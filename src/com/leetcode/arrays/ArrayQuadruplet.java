/*
Given an unsorted array of integers arr and a number s, write a function findArrayQuadruplet that finds four numbers (quadruplet) in arr that sum up to s. Your function should return an array of these numbers in an ascending order. If such a quadruplet doesn’t exist, return an empty array.

Note that there may be more than one quadruplet in arr whose sum is s. You’re asked to return the first one you encounter (considering the results are sorted).

Explain and code the most efficient solution possible, and analyze its time and space complexities.

Example:

input:  arr = [2, 7, 4, 0, 9, 5, 1, 3], s = 20

output: [0, 4, 7, 9] # The ordered quadruplet of (7, 4, 0, 9)
                     # whose sum is 20. Notice that there
                     # are two other quadruplets whose sum is 20:
                     # (7, 9, 1, 3) and (2, 4, 9, 5), but again you’re
                     # asked to return the just one quadruplet (in an
                     # ascending order)*/
package com.leetcode.arrays;

import java.util.Arrays;

class ArrayQuadruplet {
    static int[] findArrayQuadruplet(int[] arr, int s) {
        int n = arr.length;
        if (n < 4) return new int[0];
        if (n == 4) if (arr[0] + arr[1] + arr[2] + arr[3] == s) return arr;
        Arrays.sort(arr);
        for (int i = 0; i < n - 4; i++) {
            for (int j = i + 1; j < n - 3; j++) {
                int r = s - (arr[i] + arr[j]);
                int low = j + 1, high = n - 1;
                while (low < high) {
                    if (arr[low] + arr[high] < r)
                        low++;
                    else if (arr[low] + arr[high] > r)
                        high--;
                    else
                        return new int[]{arr[i], arr[j], arr[low], arr[high]};
                }
            }
        }

        return new int[0];
    }

    public static void main(String[] args) {
        for (int i : findArrayQuadruplet(new int[]{1, 2, 6, 8, 3, 10,}, 16))
            System.out.println(i);
    }
}
