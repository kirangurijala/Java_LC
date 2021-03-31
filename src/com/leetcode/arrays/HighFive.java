package com.leetcode.arrays;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/*
https://leetcode.com/problems/high-five/
Given a list of the scores of different students, items, where items[i] = [IDi, scorei] represents one score from a student with IDi, calculate each student's top five average.

Return the answer as an array of pairs result, where result[j] = [IDj, topFiveAveragej] represents the student with IDj and their top five average. Sort result by IDj in increasing order.

A student's top five average is calculated by taking the sum of their top five scores and dividing it by 5 using integer division.



Example 1:

Input: items = [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
Output: [[1,87],[2,88]]
Explanation:
The student with ID = 1 got scores 91, 92, 60, 65, 87, and 100. Their top five average is (100 + 92 + 91 + 87 + 65) / 5 = 87.
The student with ID = 2 got scores 93, 97, 77, 100, and 76. Their top five average is (100 + 97 + 93 + 77 + 76) / 5 = 88.6, but with integer division their average converts to 88.
Example 2:

Input: items = [[1,100],[7,100],[1,100],[7,100],[1,100],[7,100],[1,100],[7,100],[1,100],[7,100]]
Output: [[1,100],[7,100]]


Constraints:

1 <= items.length <= 1000
items[i].length == 2
1 <= IDi <= 1000
0 <= scorei <= 100
For each IDi, there will be at least five scores.
 */
public class HighFive {
        public int[][] highFive(int[][] items) {
            Map<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
            for (int[] i : items) {
                int id = i[0];
                int score = i[1];
                PriorityQueue<Integer> q = map.get(id);
                if (q == null) {
                    q = new PriorityQueue<>(5);
                    map.put(id, q);
                }
                q.offer(score);
                if (q.size() > 5) {
                    q.poll();
                }
            }

            int index = 0;
            int[][] ret = new int[map.size()][2];
            for (int id : map.keySet()) {
                PriorityQueue<Integer> q = map.get(id);
                int sum = 0;
                while (!q.isEmpty()) {
                    sum += q.poll();
                }
                ret[index][0] = id;
                ret[index][1] = sum / 5;
                index++;
            }
            return ret;
        }

    public static void main(String[] args) {
        HighFive solution = new HighFive();
        int[] arr={1,2,3};

       // System.out.println(solution.threeSum(arr));
        //Arrays.stream(solution.sortedSquares(arr)).forEach(n->System.out.print(n+" "));
    }
}