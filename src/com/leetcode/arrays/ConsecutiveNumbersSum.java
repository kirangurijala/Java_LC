package com.leetcode.arrays;

/*
https://leetcode.com/problems/consecutive-numbers-sum/
Given a positive integer N, how many ways can we write it as a sum of consecutive positive integers?

Example 1:

Input: 5
Output: 2
Explanation: 5 = 5 = 2 + 3
Example 2:

Input: 9
Output: 3
Explanation: 9 = 9 = 4 + 5 = 2 + 3 + 4
Example 3:

Input: 15
Output: 4
Explanation: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
Note: 1 <= N <= 10 ^ 9.
 */
public class ConsecutiveNumbersSum {
    //let N = k + (k+1) + (k+2) + (k+3) + ... + (k+i-1) = i*k + (1+2+3+... + i-1)
    //let sum(i) = (1+2+3+...+i-1), then we have
    //N = sum(i) + i*k ==>i*k = N - sum(i)
    //Which means: for each i, we can calculate N-sum(i). If N-sum(i) can be divided by i, there is an answer with length i.
    //Because, let k = (N - sum(i)) / i, we can add an integer k to each of (0,1, 2, 3, 4, ...., i-1) to become (k, k+1, k+2, k+3,.... k + i-1)
    //that is: sum(i) + i * k = N
    //
    //Obviously, the runtime is O(n^0.5).

    public int consecutiveNumbersSum(int N) {
        int n=1,sum=0,ans=0;
        while(sum<N){
            sum=sum+n;
            if(((N-sum)%n)==0){
                ans++;
            }
            n++;
        }

        return ans;
    }

    //The idea is to represent N as a sequence of length L+1 as:
    //N = a + (a+1) + (a+2) + .. + (a+L)
    //=> N = (L+1)*a + (L*(L+1))/2
    //=> a = (N- L*(L+1)/2)/(L+1)
    //We substitute the values of L starting from 1 till L*(L+1)/2 < N
    //If we get 'a' as a natural number then the solution should be counted.
    // Utility method to compute number of ways
    // in which N can be represented as sum of
    // consecutive number
    public int countConsecutive(int N)
    {
        // constraint on values of L gives us the
        // time Complexity as O(N^0.5)
        int count = 0;
        for (int L = 1; L * (L + 1) < 2 * N; L++)
        {
            float a = (float) ((1.0 * N-(L * (L + 1)) / 2) / (L + 1));
            if (a-(int)a == 0.0)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        ConsecutiveNumbersSum solution = new ConsecutiveNumbersSum();
        int[] arr={1,2,3};

        System.out.println(solution.consecutiveNumbersSum(15));
        //Arrays.stream(solution.sortedSquares(arr)).forEach(n->System.out.print(n+" "));
    }
}