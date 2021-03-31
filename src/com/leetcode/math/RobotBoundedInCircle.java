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
    /*
    My thought process:
    So in question its given we are initially at 0, 0 at North directions. So we need to keep track of the points as well as the directions in which the robot travels. So we can have x, y = 0 and directions = North

    Now our problem is to find whether the robot is moving outside the circle after following some instructions. So the robot leaves the circle if it keep moving in the North direction.

    So lets loop through each and every character from the instruction string, then:
    1. We check whether its G, if G then we have to move one point from the current position.
        SO if we are at North direction, then if we consider the coordinate, we are at +y directions, so we will move only up, just understand like that, SO we increment our y by 1, by following this pattern we can automatically deduce that if we are at South, then decrement y by 1. Same way for East, increment x by 1 and for West decrement x by 1.
    2. Next we check wheter its L, then we have to move 90 degree left wards.
                    North
            West                East    , So do a counter clockwise assumption. If we are at a directions North, then its
                                          counter clockwis, yes West update direction by west, Same way if our directions is                          South                West, them its counter clockwise south, same way for direction south, update                                                     direction by east. So just rememebr if chaarcter is L, then counter clockwise.
    3. Next whetehr the character if R, then we already got it rememebr about clockwise direction and update direction according to it

    Finally we check whetehr the robot get back to the position, if yes, return true as the robot donot go out of the circle.
    We check whether the direction is still North, then it will sure go out of the circle, so return false.
    If none of the above condition satisfies, then also the robot will be some where inside the circle, so return true.
    */

    enum Direction {
        NORTH,
        SOUTH,
        WEST,
        EAST
    }

    public boolean isRobotBounded(String instructions) {
        // TODO validation if no constrains
        int x = 0, y = 0;
        Direction direction = Direction.NORTH;

        for (char instruction : instructions.toCharArray()) {
            if (instruction == 'G') {
                switch (direction) {
                    case NORTH:
                        y++;
                        break;
                    case SOUTH:
                        y--;
                        break;
                    case WEST:
                        x--;
                        break;
                    case EAST:
                        x++;
                        break;
                }
            } else if (instruction == 'L') {
                switch (direction) {
                    case NORTH:
                        direction = Direction.WEST;
                        break;
                    case SOUTH:
                        direction = Direction.EAST;
                        break;
                    case WEST:
                        direction = Direction.SOUTH;
                        break;
                    case EAST:
                        direction = Direction.NORTH;
                        break;
                }
            } else if (instruction == 'R') {
                switch (direction) {
                    case NORTH:
                        direction = Direction.EAST;
                        break;
                    case SOUTH:
                        direction = Direction.WEST;
                        break;
                    case WEST:
                        direction = Direction.NORTH;
                        break;
                    case EAST:
                        direction = Direction.SOUTH;
                        break;
                }
            }
        }

        if (x == 0 && y == 0) { return true; }
        if (direction == Direction.NORTH) { return false; }

        return true;
    }

    public boolean isRobotBounded2(String instructions) {
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