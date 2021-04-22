package com.leetcode.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/coin-change/

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.



Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
Example 4:

Input: coins = [1], amount = 1
Output: 1
Example 5:

Input: coins = [1], amount = 2
Output: 2


Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
 */
public class CoinChange {

    /*
                              11(t)
                               |(1,2,5)
            10                 9           6
            |                  |           |
     9(*)   8      5       8   7  5      5 4 1
            |      |
          7 6 3   4 3 0
        Q[]    v[12]

*/
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        boolean[] visited=new boolean[amount+1];
        Queue<Integer> q=new LinkedList<>();
        q.add(amount);
        //visited[amount]=true;

        int level=1;
        while (!q.isEmpty()){
            int size=q.size();
            for (int i = 0; i <size ; i++) {
                int child=q.poll();
                if(visited[child]){
                    continue;
                }

                visited[child]=true;
                for (int coin:coins) {
                    int curr=child-coin;
                    if(curr==0){
                        return level;
                    }
                    if(curr>0){
                        q.add(curr);
                    }
                }
            }
            level++;
        }

        return -1;
    }

    public int coinChangeDP(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin:coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
    public static void main(String[] args) {
        CoinChange solution = new CoinChange();
        int[] arr={1,2,3};

        System.out.println(solution.coinChange
                (arr,6));
        //Arrays.stream(solution.sortedSquares(arr)).forEach(n->System.out.print(n+" "));
    }
}