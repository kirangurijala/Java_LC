package com.leetcode.backTrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
https://leetcode.com/problems/restore-ip-addresses/
Given a string s containing only digits, return all possible valid IP addresses that can be obtained from s. You can return them in any order.

A valid IP address consists of exactly four integers, each integer is between 0 and 255, separated by single dots and cannot have leading zeros. For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses and "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.



Example 1:

Input: s = "25525511135"
Output: ["255.255.11.135","255.255.111.35"]
Example 2:

Input: s = "0000"
Output: ["0.0.0.0"]
Example 3:

Input: s = "1111"
Output: ["1.1.1.1"]
Example 4:

Input: s = "010010"
Output: ["0.10.0.10","0.100.1.0"]
Example 5:

Input: s = "101023"
Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]


Constraints:

0 <= s.length <= 3000
s consists of digits only. */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int[] path=new int[4];
        backTrack(res, s, 0, path, 0);
        return res;
    }

    private void backTrack(List<String> res, String s, int builderIndex, int[] path, int segment) {
        if(segment==4 && builderIndex==s.length()){
            res.add(path[0]+"."+path[1]+"."+path[2]+"."+path[3]);
            return;
        }

        if(segment==4 || builderIndex==s.length()){
            return;
        }

        for (int i = 1; i <4 && builderIndex+i<=s.length(); i++) {
            String snapshot=s.substring(builderIndex,builderIndex+i);
            int value=Integer.parseInt(snapshot);
            if(value>255 || i>=2 && s.charAt(builderIndex)=='0'){
                break;
            }
            path[segment]=value;
            backTrack(res, s, builderIndex+i, path, segment+1);
            path[segment]=-1;
        }
    }


    public List<String> restoreIpAddresses22(String s) {
        List<String> res = new ArrayList<>();
        restoreHelper(s, res, "", 0, 0);
        return res;
    }
    private void restoreHelper(String s, List<String> res, String restored, int pos, int sec) {
        // check whether left section is too lengthy to be valid
        if (s.length() - pos > 3 * (4 - sec)) return;
        if (sec == 4 && pos == s.length()) {
            res.add(restored);
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (pos + i > s.length()) return;
            String part = s.substring(pos, pos + i);
            if (part.length() > 1 && part.startsWith("0") || i == 3 && Integer.valueOf(part) >= 256) continue;
            restoreHelper(s, res, sec == 0 ? part : restored + "." + part, pos + i, sec + 1);
        }
    }

    public static void main(String[] args) {
        RestoreIPAddresses solution = new RestoreIPAddresses();
        System.out.println(solution.restoreIpAddresses("25525511135"));
    }
}