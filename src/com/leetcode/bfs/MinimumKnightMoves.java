package com.leetcode.bfs;

import java.util.*;

/*
https://leetcode.com/problems/minimum-knight-moves/

In an infinite chess board with coordinates from -infinity to +infinity, you have a knight at square [0, 0].

A knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, then one square in an orthogonal direction.



Return the minimum number of steps needed to move the knight to the square [x, y].  It is guaranteed the answer exists.



Example 1:

Input: x = 2, y = 1
Output: 1
Explanation: [0, 0] → [2, 1]
Example 2:

Input: x = 5, y = 5
Output: 4
Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]


Constraints:

|x| + |y| <= 300

*/
public class MinimumKnightMoves {
    public static void main(String[] args) {
        MinimumKnightMoves solution = new MinimumKnightMoves();
        System.out.println(solution.minKnightMoves(5,5));
    }

    public int minKnightMoves(int x, int y) {
        x = Math.abs(x); y = Math.abs(y);
        if (x == 1 && y == 1) return 2;
        int[][] directions={{1,2},{2,1},{-1,2},{2,-1},{-1,-2},{-2,-1},{1,-2},{-2,1}};
        Queue<int[]> q=new LinkedList<>();
        Set<String> visits=new HashSet<>();
        q.add(new int[]{0,0});
        visits.add("0.0");
        int count=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i< size;i++){
               int[] dir= q.remove();
               int dirX=dir[0];
               int dirY=dir[1];
               if(dirX==x&&dirY==y){
                   return count;
               }

               for(int[] dirs:directions){
                   int dirx=dirX+dirs[0];
                   int diry=dirY+dirs[1];
                   if(!visits.contains(dirx+"."+diry)&& dirx>=0&&dirY>=0){
                       q.add(new int[]{dirx,diry});
                       visits.add(dirx+"."+diry);
                   }
               }
            }
            count++;
        }
        return -1;
    }

    public int minKnightMoves2(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        Map<String, Integer> memo = new HashMap<>();
        return helper(x, y, memo);
    }

    private int helper(int x, int y, Map<String, Integer> memo) {
        String key = x + ":" + y;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (x + y == 0) {
            return 0;
        } else if (x + y == 2) {
            return 2;
        }
        int min = Math.min(helper(Math.abs(x - 1), Math.abs(y - 2), memo),
                helper(Math.abs(x - 2), Math.abs(y - 1), memo)) + 1;
        memo.put(key, min);
        return min;
    }
}