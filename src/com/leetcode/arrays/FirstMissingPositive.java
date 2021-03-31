package com.leetcode.arrays;

/*
https://leetcode.com/problems/first-missing-positive/
Given an unsorted integer array nums, find the smallest missing positive integer.



Example 1:

Input: nums = [1,2,0]
Output: 3
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1


Constraints:

0 <= nums.length <= 300
-231 <= nums[i] <= 231 - 1


Follow up: Could you implement an algorithm that runs in O(n) time and uses constant extra space?
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {

//     int n=nums.length, count=0;
//         for(int i=0; i<n; i++){
//             if(nums[i]<=0 || nums[i]>n){
//                 nums[i]=1;
//             }
//         }


//         for(int i=0; i<n; i++){
//            nums[nums[i]%n]= n+nums[nums[i]%n];
//         }

//       for(int i=0; i<n; i++){
//             if(nums[i]/n==0)
//                 return i;
//         }
//           return n;
        // n = len(nums)
        // for i in range(len(nums)): #delete those useless elements
        //     if nums[i]<0 or nums[i]>=n:
        //         nums[i]=0
        // for i in range(len(nums)): #use the index as the hash to record the frequency of each number
        //     nums[nums[i]%n]+=n
        // for i in range(1,len(nums)):
        //     if nums[i]/n==0:
        //         return i
        //     return n
        int n=nums.length, count=0;
        for(int i=0; i<n; i++){
            if(nums[i] == 1){
                count++;
            }
        }

        if(count == 0){
            return 1;
        }

        if(n == 1){
            return 2;
        }

        for(int i=0; i<n; i++){
            if(nums[i]<=0 || nums[i]>n){
                nums[i]=1;
            }
        }

        for(int i=0; i<n; i++){
            int a= Math.abs(nums[i]);
            if(a==n){
                nums[0] = -Math.abs(nums[0]) ;
            }
            else{
                nums[a] = -Math.abs(nums[a]) ;
            }
        }

        for(int i=1; i<n;i++){
            if(nums[i]>0)
                return i;
        }

        if(nums[0]>0){
            return n;
        }

        return n+1;
    }

    public static void main(String[] args) {
        FirstMissingPositive solution = new FirstMissingPositive();
        int[] arr={1,2,3};

        //System.out.println(solution.threeSum(arr));
        //Arrays.stream(solution.sortedSquares(arr)).forEach(n->System.out.print(n+" "));
    }
}