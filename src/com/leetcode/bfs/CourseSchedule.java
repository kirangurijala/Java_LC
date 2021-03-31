package com.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/course-schedule/

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.



Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.


Constraints:

1 <= numCourses <= 105
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.
 */
public class CourseSchedule {
   //Time Complexity: O(|E| + |V|) where |V|∣V∣ is the number of courses, and |E|∣E∣ is the number of dependencies.
   //Space Complexity: O(|E| + |V|) where |V|∣V∣ is the number of courses, and |E|∣E∣ is the number of dependencies.
   public boolean canFinish(int numCourses, int[][] prerequisites) {
      if (numCourses == 0 || prerequisites.length == 0) return true;

      // Convert graph presentation from edges to indegree of adjacent list.
      //[0 1] [0 2] [0 3] [2 3] [4 1] [4 3]
      //20, {{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}}

      int[] indegree = new int[numCourses];
      // Indegree - how many prerequisites are needed.
      for (int[] prerequisite : prerequisites) {
         indegree[prerequisite[0]]++;
      }

      Queue<Integer> queue = new LinkedList<>();
      for (int i = 0; i < numCourses; i++)
         if (indegree[i] == 0)
            queue.add(i);

      // How many courses don't need prerequisites.
      int finishedCourseCount = queue.size();
      while (!queue.isEmpty()) {
         int finishedPrerequisite = queue.remove(); // Already finished this prerequisite course.
         for (int[] prerequisite : prerequisites) {
            if (prerequisite[1] == finishedPrerequisite) {
               indegree[prerequisite[0]]--;
               if (indegree[prerequisite[0]] == 0) {
                  finishedCourseCount++;
                  queue.add(prerequisite[0]);
               }
            }
         }
      }

      return (finishedCourseCount == numCourses);
   }

   public static void main(String[] args) {
      CourseSchedule solution = new CourseSchedule();
      System.out.println(solution.canFinish(20,new int[][] {{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}}));
      //Arrays.stream(solution.sortedSquares(arr)).forEach(n->System.out.print(n+" "));

   }
}