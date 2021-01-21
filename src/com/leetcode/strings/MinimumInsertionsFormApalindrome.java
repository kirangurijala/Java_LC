package com.leetcode.strings;

/*

  Given a string word, count the minimum number of characters that needs to be added to word to make it anadrome - a string which is an anagram of some palindrome.

        For example, if word = "tatoo", it's possible to add a single letter 'a' which makes the resulting string an anadrome: "tatooa" letters can be rearranged to become "aottoa", which is a palindrome.

        Example

        For word = "abcb", the output should be changeToAnadrome(word) = 1.

        One can add either 'a' or 'c' to the string word: "abcba" is a palindrome already, "abcbc" is an anagram of a palindrome "cbabc".

        For word = "abab", the output should be changeToAnadrome(word) = 0.

        The string "abab" is already an anagram of a palindrome "abba".

        For word = "abc", the output should be changeToAnadrome(word) = 2.

        One can add, for example, characters 'a' and 'b' to the string word: "abcab" is an anagram of a palindrome "abcba".

        Input/Output

        [execution time limit] 3 seconds (java)

        [input] string word

        A string consisting of lowercase English letters, which should be adjusted to become an anadrome.

        Guaranteed constraints:
        1 ≤ word.length ≤ 106.

        [output] integer

        The minimum number of characters that can be added to word to make it anadrome.

        [Java] Syntax Tips

// Prints help message to the console
// Returns a string
//
// Globals declared here will cause a compilation error,
// declare variables inside the function instead!
        String helloWorld(String name) {
        System.out.println("This prints to the console when you Run Tests");
        return "Hello, " + name;
        }
*/
import java.util.Arrays;

class MinimumInsertionsFormApalindrome
{
    // A DP function to find minimum number
    // of insersions
    static int findMinInsertionsDP(String word)
    {
        // Create a arr of size n*n. arr[i][j]
        // will store minumum number of insertions
        // needed to convert str[i..j] to a palindrome.
        int n=word.length();
        int arr[][] = new int[n][n];
        int l, h, i;

        // Fill the arr
        for (i = 1; i < n; ++i)
            for (l = 0, h = i; h < n; ++l, ++h)
                arr[l][h] = (word.charAt(l) == word.charAt(h))?
                        arr[l+1][h-1] :
                        (Integer.min(arr[l][h-1],
                                arr[l+1][h]) + 1);

        // Return minimum number of insertions
        // for str[0..n-1]
        return arr[0][n-1];
    }

    // Driver program to test above function.
    public static void main(String args[])
    {
        String str = "geeks";
        System.out.println(
                findMinInsertionsDP(str));
    }
}
