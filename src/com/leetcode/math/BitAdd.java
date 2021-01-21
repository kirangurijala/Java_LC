package com.leetcode.math;

public class BitAdd {
    public static void main(String args[]) {
        int arr[] = {10, 7, 8, 9, 1, 5};
        System.out.println("sorted array");
        System.out.println(add(1, 3));
    }

    private static int add(int a, int b) {//3//1
        if (a == 0) return b;
        if (b == 0) return a;
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
  