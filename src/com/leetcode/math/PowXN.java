package com.leetcode.math;

/*
https://leetcode.com/problems/powx-n/

plement pow(x, n), which calculates x raised to the power n (i.e. xn).



Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25


Constraints:

-100.0 < x < 100.0
-231 <= n <= 231-1
-104 <= xn <= 104


 */
public class PowXN {

    public static void main(String[] args) {
        PowXN solution = new PowXN();
        ///System.out.println(solution.sol(23));
        //char arr[][] = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(solution.myPow(2, 10));
    }
    public double myPow(double x, int n) {
        long N=n;
        if(N<0){
            x=1/x;
            N=-n;
        }

        double res=1;
        long i=n;
        double curr=x;
        while(i>0){
            if(i%2==1){
                res=res*N;
            }
            curr=curr*curr;
        }
        return res;
    }
}