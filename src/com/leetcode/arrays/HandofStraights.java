package com.leetcode.arrays;

import java.util.Map;
import java.util.TreeMap;

/*
https://leetcode.com/problems/hand-of-straights/
or
https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers

Alice has a hand of cards, given as an array of integers.

Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.

Return true if and only if she can.

Note: This question is the same as 1296: https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/



Example 1:

Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
Output: true
Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
Example 2:

Input: hand = [1,2,3,4,5], W = 4
Output: false
Explanation: Alice's hand can't be rearranged into groups of 4.



Constraints:

1 <= hand.length <= 10000
0 <= hand[i] <= 10^9
1 <= W <= hand.length
 */
public class HandofStraights {
    public static void main(String[] args) {
        HandofStraights solution = new HandofStraights();
        int[] arr={1,2,3,6,2,3,4,7,8};
        System.out.println(solution.isNStraightHand(arr,3));
    }

    public boolean isNStraightHand(int[] hand, int W) {
        Map<Integer,Integer> counts=new TreeMap<>();/////TREEEEEEEEEEEEEEEEEE MAP
        for (int n:hand) {
            counts.put(n,counts.getOrDefault(n,0)+1);
        }

        //[1 1  2 1  3 2  4 2  51  6 1] k=4//O(N∗(N/W))
        for (int key:counts.keySet()){
            Integer count = counts.get(key);
            if(count <=0){
                continue;
            }

            for(int i=0;i<W;i++){
                if(counts.getOrDefault(i+key,0)< count){
                    return false;
                }

                counts.put(i+key,counts.get(i+key)- count);
            }
        }

        return true;
    }

}