package com.leetcode.math;

/*
https://leetcode.com/problems/robot-bounded-in-circle/

On an infinite plane, a robot initially stands at (0, 0) and faces north. The robot can receive one of three instructions:

    "G": go straight 1 unit;
    "L": turn 90 degrees to the left;
    "R": turn 90 degrees to the right.

The robot performs the instructions given in order, and repeats them forever.

Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.



Example 1:

Input: instructions = "GGLLGG"
Output: true
Explanation: The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.

Example 2:

Input: instructions = "GG"
Output: false
Explanation: The robot moves north indefinitely.

Example 3:

Input: instructions = "GL"
Output: true
Explanation: The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...



Constraints:

    1 <= instructions.length <= 100
    instructions[i] is 'G', 'L' or, 'R'.


 */
public class RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
        //clockwise sequence: 0. north 1.east 2. south 3. west
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0, i = 0;

        for (char instruction : instructions.toCharArray()) {
            switch (instruction) {
                case 'G':
                    x += dir[i][0];
                    y += dir[i][1];
                    break;
                case 'L':
                    i = (i + 3) % 4;
                    break;
                case 'R':
                    i = (i + 1) % 4;
                    break;
            }
        }
        return (x == 0 && y == 0) || i != 0;
    }

    public static void main(String[] args) {
        RobotBoundedInCircle solution = new RobotBoundedInCircle();
        ///System.out.println(solution.sol(23));
 //       char arr[][] = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(solution.isRobotBounded( "SEE"));
    }

}