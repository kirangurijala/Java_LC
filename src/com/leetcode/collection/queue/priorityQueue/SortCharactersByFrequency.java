package com.leetcode.collection.queue.priorityQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/sort-characters-by-frequency/

Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.

Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.

*/
public class SortCharactersByFrequency {
    public static void main(String[] args) {
        SortCharactersByFrequency solution = new SortCharactersByFrequency();
        System.out.println(solution.frequencySort("248397243879"));
    }

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b)- map.get(a));
        pq.addAll(map.keySet());

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Character key = pq.poll();
            for (int i = 0; i < map.get(key); i++)
                sb.append(key);
        }
        return sb.toString();
    }
}