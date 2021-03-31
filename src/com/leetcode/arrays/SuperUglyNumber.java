package com.leetcode.arrays;

/*
https://leetcode.com/problems/super-ugly-number/
Given an integer n and an array of integers primes, return the nth super ugly number.

Super ugly number is a positive number whose all prime factors are in the array primes.

The nth super ugly number is guaranteed to fit in a 32-bit signed integer.



Example 1:

Input: n = 12, primes = [2,7,13,19]
Output: 32
Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12 super ugly numbers given primes == [2,7,13,19].
Example 2:

Input: n = 1, primes = [2,3,5]
Output: 1
Explanation: 1 is a super ugly number for any given primes.


Constraints:

1 <= n <= 106
1 <= primes.length <= 100
2 <= primes[i] <= 1000
primes[i] is guaranteed to be a prime number.
All the values of primes are unique and sorted in ascending order.
 */
public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int [] res = new int[n];
        res[0] = 1;
        int [] cur = new int[primes.length];
        for(int i = 1; i < n; i++){
            res[i] = Integer.MAX_VALUE;
            for(int j = 0; j < primes.length; j++){
                if (primes[j] * res[cur[j]] == res[i-1]) {
                    cur[j]++;
                }
                res[i] = Math.min(res[i], primes[j]*res[cur[j]]);
            }
        }
        return res[n-1];
    }
    public static void main(String[] args) {
        SuperUglyNumber solution = new SuperUglyNumber();
        int[] arr={2,7,13,19};

        System.out.println(solution.nthSuperUglyNumber(12,arr));
        //Arrays.stream(solution.sortedSquares(arr)).forEach(n->System.out.print(n+" "));
    }
}