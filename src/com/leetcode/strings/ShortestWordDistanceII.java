package com.leetcode.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/shortest-word-distance-ii/

Design a data structure that will be initialized with a string array, and then it should answer queries of the shortest distance between two different strings from the array.

Implement the WordDistance class:

WordDistance(String[] wordsDict) initializes the object with the strings array wordsDict.
int shortest(String word1, String word2) returns the shortest distance between word1 and word2 in the array wordsDict.


Example 1:

Input
["WordDistance", "shortest", "shortest"]
[[["practice", "makes", "perfect", "coding", "makes"]], ["coding", "practice"], ["makes", "coding"]]
Output
[null, 3, 1]

Explanation
WordDistance wordDistance = new WordDistance(["practice", "makes", "perfect", "coding", "makes"]);
wordDistance.shortest("coding", "practice"); // return 3
wordDistance.shortest("makes", "coding");    // return 1


Constraints:

1 <= wordsDict.length <= 3 * 104
1 <= wordsDict[i].length <= 10
wordsDict[i] consists of lowercase English letters.
word1 and word2 are in wordsDict.
word1 != word2
At most 5000 calls will be made to shortest.
 */
public class ShortestWordDistanceII {
    public static void main(String[] args) {
        ShortestWordDistanceII solution = new ShortestWordDistanceII();
//        System.out.println(solution.removeDuplicates("abbaca"));
  //      System.out.println(solution.isPossibleDivide(new int[]{1,2,3,3,4,4,5,6},4));
    }

    class WordDistance {
        Map<String, List<Integer>> locations;
        public WordDistance(String[] wordsDict) {
            locations=new HashMap<>();
            for (int i = 0; i < wordsDict.length; i++) {
                locations.putIfAbsent(wordsDict[i], new ArrayList<>());
                locations.get(wordsDict[i]).add(i);
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> word1locations=locations.get(word1);
            List<Integer> word2locations=locations.get(word2);
            int l1=0,l2=0,min=Integer.MAX_VALUE;
            while (l1<word1locations.size() && l2<word2locations.size()){
                min=Math.min(min,Math.abs(word1locations.get(l1)-word2locations.get(l2)));
                if(word1locations.get(l1)<word2locations.get(l2)){
                    l1++;
                } else {
                    l2++;
                }
            }

            return min;
        }
    }
}