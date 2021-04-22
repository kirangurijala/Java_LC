package com.leetcode.matrix;

/*
https://leetcode.com/problems/flipping-an-image/
Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image.

To flip an image horizontally means that each row of the image is reversed.

For example, flipping [1,1,0] horizontally results in [0,1,1].
To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.

For example, inverting [0,1,1] results in [1,0,0].


Example 1:

Input: image = [[1,1,0],[1,0,1],[0,0,0]]
Output: [[1,0,0],[0,1,0],[1,1,1]]
Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
Example 2:

Input: image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]


Constraints:

n == image.length
n == image[i].length
1 <= n <= 20
images[i][j] is either 0 or 1.
*/
public class FlippinganImage {
//    The idea is simple. For each row, use two pointers. One is going forward and the other is going backward.
//            (1). If the two elements are the same, then make a slight change like this 0 -> 1 or 1 -> 0.
//            (2). If the two elements are different, DON'T do anything. Just let it go.
//
//    Only scan the whole matrix once.

        public int[][] flipAndInvertImage(int[][] A) {
            for (int i = 0; i < A.length; i++) {
                int lo = 0, hi = A[0].length - 1;
                while (lo <= hi) {
                    if (A[i][lo] == A[i][hi]) {
                        A[i][lo] = 1 - A[i][lo];
                        A[i][hi] = A[i][lo];
                    }
                    lo++;
                    hi--;
                }
            }

            return A;
        }
    public int[][] flipAndInvertImage2(int[][] A) {
        int rowLen = A[0].length;
        for (int[] row: A)
            for (int i = 0; i < (rowLen + 1) / 2; ++i) {
                int tmp = row[i] ^ 1;
                row[i] = row[rowLen - 1 - i] ^ 1;
                row[rowLen - 1 - i] = tmp;
            }

        return A;
    }
    public static void main(String[] args) {
        FlippinganImage solution = new FlippinganImage();
        int arr[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        solution.flipAndInvertImage(arr);
        System.out.println(arr);
    }
}