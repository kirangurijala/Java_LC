package com.leetcode.math;

/*
https://leetcode.com/problems/climbing-stairs/

You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?



Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 */

// The key intuition to solve the problem is that given a number of stairs n, if we know the number ways to get to the points [n-1] and [n-2] respectively, denoted as n1 and n2 , then the total ways to get to the point [n] is n1 + n2. Because from the [n-1] point, we can take one single step to reach [n]. And from the [n-2] point, we could take two steps to get ther
public class ClimbingStairs {
    public static void main(String[] args) {
        ClimbingStairs solution = new ClimbingStairs();
        System.out.println(solution.climbStairs(23));
    }

//    Base cases:
//            if n <= 0, then the number of ways should be zero.
//            if n == 1, then there is only way to climb the stair.
//if n == 2, then there are two ways to climb the stairs. One solution is one step by another; the other one is two steps at one time.
//
//    The key intuition to solve the problem is that given a number of stairs n, if we know the number ways to get to the points [n-1] and [n-2] respectively, denoted as n1 and n2 , then the total ways to get to the point [n] is n1 + n2. Because from the [n-1] point, we can take one single step to reach [n]. And from the [n-2] point, we could take two steps to get there.
//
//    The solutions calculated by the above approach are complete and non-redundant. The two solution sets (n1 and n2) cover all the possible cases on how the final step is taken. And there would be NO overlapping among the final solutions constructed from these two solution sets, because they differ in the final step.
       public int climbStairs(int n) {
            if(n<3){
                return n;
            }

            int n1=1;
            int n2=2;
            int n3=0;
            for(int i=3;i<=n;i++){
                n3=n1+n2;
                n1=n2;
                n2=n3;
            }

        return n2;
    }
}