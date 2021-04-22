package com.leetcode.bfs;

import java.util.*;

/*
https://leetcode.com/problems/course-schedule-ii/

There are a total of n courses you have to take labelled from 0 to n - 1.

Some courses may have prerequisites, for example, if prerequisites[i] = [ai, bi] this means you must take the course bi before the course ai.

Given the total number of courses numCourses and a list of the prerequisite pairs, return the ordering of courses you should take to finish all courses.

If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.



Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]


Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= numCourses * (numCourses - 1)
prerequisites[i].length == 2
0 <= ai, bi < numCourses
ai != bi
All the pairs [ai, bi] are distinct.
 */
public class CourseScheduleII {
    //Time Complexity: O(|E| + |V|) where |V|∣V∣ is the number of courses, and |E|∣E∣ is the number of dependencies.
    //Space Complexity: O(|E| + |V|) where |V|∣V∣ is the number of courses, and |E|∣E∣ is the number of dependencies.
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return null;
        // Convert graph presentation from edges to indegree of adjacent list.
        //[0 1] [0 2] [0 3] [2 3] [4 1] [4 3]
        //20, {{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}}
        int[] indegree = new int[numCourses];
        int[] order = new int[numCourses];
        int index = 0;

        // Indegree - how many prerequisites are needed.
        for (int[] prerequisite : prerequisites) {
            indegree[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (indegree[i] == 0) {
                // Add the course to the order because it has no prerequisites.
                order[index++] = i;
                queue.offer(i);
            }
        }

        // How many courses don't need prerequisites.
        while (!queue.isEmpty()) {
            int finishedCourse = queue.poll(); // Already finished this prerequisite course.
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == finishedCourse) {
                    int finishedPrerequisite = prerequisite[0];
                    indegree[finishedPrerequisite]--;
                    if (indegree[finishedPrerequisite] == 0) {
                        // If indegree is zero, then add the course to the order.
                        order[index++] = finishedPrerequisite;
                        queue.offer(finishedPrerequisite);
                    }
                }
            }
        }

        if(index != numCourses){
            return new int[0];
        }

        return order;
    }
       public int[] findOrderMap(int numCourses, int[][] prerequisites) {
            int[] inorder=new int[numCourses];
            int[] order=new int[numCourses];
            Map<Integer, Set<Integer>> map = new HashMap<>();
            for (int[] prerequisite:prerequisites) {
                inorder[prerequisite[0]]++;
                map.putIfAbsent(prerequisite[1], new HashSet<>());
                map.get(prerequisite[1]).add(prerequisite[0]);
            }

            int index=0;
            Queue<Integer> q=new LinkedList<>();
            for (int i=0;i< inorder.length;i++) {
                if(inorder[i]==0){
                    q.add(i);
                    order[index++]=i;
                }
            }

            if(index==numCourses){
                return order;
            }
            while (!q.isEmpty()){
                int finishedCoursed=q.poll();
                if(!map.containsKey(finishedCoursed) || map.get(finishedCoursed).isEmpty()){
                    continue;
                }

                for(int prerequisite : map.get(finishedCoursed)){
                    inorder[prerequisite]--;
                    if(inorder[prerequisite] == 0){
                        q.add(prerequisite);
                        order[index++] = prerequisite;
                    }
                }
            }
            if(index==numCourses){
                return order;
            }
            return new int[0];
        }

    public static void main(String[] args) {
        CourseScheduleII solution = new CourseScheduleII();
        Arrays.stream(solution.findOrder(20,new int[][] {{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}})).forEach(n->System.out.print(n+" "));
    }
}