package com.leetcode.strings;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/text-justification/

Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.


Example 1:

Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Example 2:

Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
Note that the second line is also left-justified becase it contains only one word.
Example 3:

Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]


Constraints:

1 <= words.length <= 300
1 <= words[i].length <= 20
words[i] consists of only English letters and symbols.
1 <= maxWidth <= 100
words[i].length <= maxWidth
 */
public class TextJustification {
    //We start with left being the first word.
    // findRight: Then we greedily try to go as far right as possible until we fill our current line.
    //
    //Then we justify one line at a time.
    //
    //justify: In all cases we pad the right side with spaces until we reach max width for the line;
    //
    //If it's one word then it is easy, the result is just that word.
    //If it's the last line then the result is all words separated by a single space.
    //Otherwise we calculate the size of each space evenly and if there is a remainder we distribute an extra space until it is gone.
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int begin = 0;
        while(begin < words.length){
            int end = findWordsForLine(begin, maxWidth, words);
            ans.add(justifyLine(begin, end, maxWidth, words));
            begin = end + 1;
        }
        return ans;
    }
    private int findWordsForLine(int begin, int maxWidth, String[] words){
        int end = begin;
        int width = words[end].length();
        end++;
        while(end < words.length){
            int length = width + 1 + words[end].length();
            if (length> maxWidth){
                return end - 1;
            }

            width = width +(1 + words[end].length());
            end++;
        }
        return end - 1;
    }
    private String justifyLine(int begin, int end, int maxWidth, String[] words){
        StringBuilder line = new StringBuilder();
        if(begin == end)
            return line.append(words[begin]).append(multiSpace(maxWidth - line.length())).toString();
        boolean lastLine = (end == words.length - 1);
        int numSpaceSlot = end - begin;
        int totalSpace = maxWidth - wordsLength(begin, end, words);
        String spaceForSlot =" ";
        if(!lastLine){
            spaceForSlot = multiSpace(totalSpace / numSpaceSlot);
        }

        int remaindar = 0;
        if(!lastLine){
            remaindar = totalSpace % numSpaceSlot;
        }

        for(int i=begin; i<=end; i++){
            line.append(words[i]);
            if(i!=end){
                line.append(spaceForSlot);
            }

            if(remaindar>0){
                line.append(" ");
            }
            remaindar--;
        }

        if(lastLine){
            return line.append(multiSpace(maxWidth - line.length())).toString();
        }
        return line.toString();
    }
    private int wordsLength(int begin, int end, String[] words){
        int length = 0;
        for(int i=begin; i<=end; i++)
            length = length+words[i].length();
        return length;
    }
    private String multiSpace(int length){
        StringBuilder space = new StringBuilder();
        for(int i=0; i<length; i++)
            space.append(" ");
        return space.toString();
    }
    public static void main(String[] args) {
        TextJustification solution = new TextJustification();
        //System.out.println(solution.removeDuplicates("abbaca"));
    }
}