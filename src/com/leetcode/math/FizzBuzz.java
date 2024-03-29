package com.leetcode.math;
/*
412. Fizz Buzz
Write a program that outputs the string representation of numbers from 1 to n.
https://leetcode.com/problems/fizz-buzz/

But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.

Example:

n = 15,

Return:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]

*/

import java.util.ArrayList;
import java.util.List;

class FizzBuzz {
    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        System.out.println(fizzBuzz.fizzBuzz(15));
    }

    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if ((i % 3 == 0) && (i % 5 != 0)) {
                list.add("Fizz");
            } else if ((i % 3 != 0) && (i % 5 == 0)) {
                list.add("Buzz");
            } else if (i % 15 == 0) {
                list.add("FizzBuzz");
            } else {
                list.add(Integer.toString(i));
            }
        }

        return list;
    }
}


