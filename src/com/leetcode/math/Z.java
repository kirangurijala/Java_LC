package com.leetcode.math;

/*

 */
public class Z {

    public boolean exist(char[][] board, String word) {

        return false;
    }

    public static void main(String[] args) {
        Z solution = new Z();
        ///System.out.println(solution.sol(23));
        char arr[][] = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(solution.exist(arr, "SEE"));
    }
}