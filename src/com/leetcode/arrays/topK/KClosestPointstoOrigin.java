package com.leetcode.arrays.topK;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/k-closest-points-to-origin/

We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)



Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].

Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)

*/
public class KClosestPointstoOrigin {
    public static void main(String[] args) {
        KClosestPointstoOrigin solution = new KClosestPointstoOrigin();
        System.out.println(solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (Integer num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

     PriorityQueue<Integer> q=new PriorityQueue<>((a,b)->counts.get(b)-counts.get(a));
     for(Integer num:counts.keySet()){
       q.add(num);
     }

     int[] topK=new int[k];
     for (int i = 0; i < k; i++) {
       topK[i]=q.poll();
     }

//        List<Integer> res = new ArrayList<>(counts.keySet());
//        Collections.sort(res, (a, b) -> counts.get(b) - counts.get(a));
//        int[] topK = new int[k];
//        for (int i = 0; i < k; i++) {
//            topK[i] = res.get(i);
//        }

        return topK;
    }
}