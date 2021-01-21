package com.leetcode.strings;

/*

 */
public class
CanFormPalindrome {
    static final int NO_OF_CHARS = 256;

    /* function to check whether characters of
      a string can form a palindrome */
    static boolean canFormPalindrome(String str) {
        int[] arr = new int[256];

        for (int i = 0; i < str.length(); i++)
            arr[str.charAt(i)]++;

        int odd = 0;
        for (int i = 0; i < 256; i++) {
            if ((arr[i] %2) == 1)
                odd++;

            if (odd > 1)
                return false;
        }

        return true;
    }

    /* Driver program to test to print printDups*/
    public static void main(String args[]) {
        System.out.println(canFormPalindrome("geeksforgeeks"));
        System.out.println(canFormPalindrome("geeksogeeks"));
        System.out.println(canFormPalindrome("AABB"));
        System.out.println(canFormPalindrome("AABBcd"));
    }
}