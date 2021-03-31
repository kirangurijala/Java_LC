package com.leetcode.arrays;

import java.util.*;

/*
https://leetcode.com/problems/employee-free-time/

We are given a list schedule of employees, which represents the working time for each employee.

Each employee has a list of non-overlapping Intervals, and these intervals are in sorted order.

Return the list of finite intervals representing common, positive-length free time for all employees, also in sorted order.

(Even though we are representing Intervals in the form [x, y], the objects inside are Intervals, not lists or arrays. For example, schedule[0][0].start = 1, schedule[0][0].end = 2, and schedule[0][0][0] is not defined).  Also, we wouldn't include intervals like [5, 5] in our answer, as they have zero length.



Example 1:

Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
Output: [[3,4]]
Explanation: There are a total of three employees, and all common
free time intervals would be [-inf, 1], [3, 4], [10, inf].
We discard any intervals that contain inf as they aren't finite.
Example 2:

Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
Output: [[5,6],[7,9]]


Constraints:

1 <= schedule.length , schedule[i].length <= 50
0 <= schedule[i].start < schedule[i].end <= 10^8
 */
public class EmployeeFreeTime {
    private class IntervelComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a,Interval b){
            return a.start<b.start?-1:a.start==b.start?0:1;
        }
    }

    // public List<Interval> employeeFreeTime2(List<List<Interval>> s) {
    //     List<Interval> l = new ArrayList<>(), res = new ArrayList<>();
    //     for (List<Interval> is : s) {
    //         l.addAll(is);
    //     }
    //     Collections.sort(l, new IntervelComparator());
    //     Interval tmp = l.get(0);
    //     for (int i = 1; i < l.size(); i++){
    //        // if (i == 0) tmp = l.get(i);
    //        // else {
    //             Interval curr = l.get(i);
    //             if (curr.start > tmp.end) {
    //                 res.add(new Interval(tmp.end, curr.start));
    //                 tmp = curr;
    //             } else {
    //                 tmp.end = Math.max(curr.end, tmp.end);
    //             }
    //         //}
    //     }
    //     return res;
    // }
    class Interval {
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> s) {
        List<Interval> intervals = new ArrayList<>(), res = new ArrayList<>();
        for (List<Interval> interval : s) {
            intervals.addAll(interval);
        }

        Collections.sort(intervals, new IntervelComparator());

        LinkedList<Interval> free= new LinkedList<>();
        Interval lastInterval=new Interval(-1,-1);
        for(Interval interval:intervals){
            if(lastInterval.start==-1) {
                lastInterval = interval;
            }
            else if(interval.start>lastInterval.end) {
                free.add(new Interval(lastInterval.end, interval.start));
                lastInterval = interval;
            }
            else {
                lastInterval.end=Math.max(lastInterval.end, interval.end);
            }

        }

        return free;
    }

    public static void main(String[] args) {
        EmployeeFreeTime solution = new EmployeeFreeTime();
        int[] arr={1,2,3};

       // System.out.println(solution.threeSum(arr));
        //Arrays.stream(solution.sortedSquares(arr)).forEach(n->System.out.print(n+" "));
    }
}