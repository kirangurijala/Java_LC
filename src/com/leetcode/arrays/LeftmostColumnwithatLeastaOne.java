package com.leetcode.arrays;

import java.util.*;

/*
https://leetcode.com/problems/leftmost-column-with-at-least-a-one/
(This problem is an interactive problem.)

A row-sorted binary matrix means that all elements are 0 or 1 and each row of the matrix is sorted in non-decreasing order.

Given a row-sorted binary matrix binaryMatrix, return the index (0-indexed) of the leftmost column with a 1 in it. If such an index does not exist, return -1.

You can't access the Binary Matrix directly. You may only access the matrix using a BinaryMatrix interface:

BinaryMatrix.get(row, col) returns the element of the matrix at index (row, col) (0-indexed).
BinaryMatrix.dimensions() returns the dimensions of the matrix as a list of 2 elements [rows, cols], which means the matrix is rows x cols.
Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer. Also, any solutions that attempt to circumvent the judge will result in disqualification.

For custom testing purposes, the input will be the entire binary matrix mat. You will not have access to the binary matrix directly.



Example 1:



Input: mat = [[0,0],[1,1]]
Output: 0
Example 2:



Input: mat = [[0,0],[0,1]]
Output: 1
Example 3:



Input: mat = [[0,0],[0,0]]
Output: -1
Example 4:



Input: mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]]
Output: 1


Constraints:

rows == mat.length
cols == mat[i].length
1 <= rows, cols <= 100
mat[i][j] is either 0 or 1.
mat[i] is sorted in non-decreasing order.
 */
interface BinaryMatrix {
      public int get(int x, int y) ;
//      public List<Integer> dimensions  ;
  }
public class LeftmostColumnwithatLeastaOne {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dim=new ArrayList<>();
//        dim=binaryMatrix.dimensions();
        int rows=dim.get(0), cols=dim.get(1);
        if(rows==0 || cols==0){
            return -1;
        }

        int result=-1;
        int r=0, c=cols-1;
        while(r<rows &&c>=0){
            if(binaryMatrix.get(r,c)==1){
                result=c;
                c--;
            }
            else{
                r++;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        Z solution = new Z();
        int[] arr={1,2,3};

        System.out.println(solution.threeSum(arr));
        //Arrays.stream(solution.sortedSquares(arr)).forEach(n->System.out.print(n+" "));
    }
}