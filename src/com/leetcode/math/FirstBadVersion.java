package com.leetcode.math;

/*
https://leetcode.com/problems/first-bad-version/
You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.



Example 1:

Input: n = 5, bad = 4
Output: 4
Explanation:
call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true
Then 4 is the first bad version.
Example 2:

Input: n = 1, bad = 1
Output: 1
*/
public class FirstBadVersion {
    //     public int firstBadVersion(int n) {
//         while(n>0){
//             if(!isBadVersion(n)){
//                 return n+1;
//             }

    int n = 0;

    FirstBadVersion(int n) {
        this.n = n;
    }

    public static void main(String[] args) {
        FirstBadVersion solution = new FirstBadVersion(4);
        System.out.println(solution.firstBadVersion(23));
    }

    //             n--;
//         }
//         return 0;
//     }
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isBadVersion(int n) {
        return this.n == n;
    }
}