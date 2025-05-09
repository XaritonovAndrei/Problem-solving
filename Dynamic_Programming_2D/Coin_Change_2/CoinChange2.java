package com.problem_solving.Dynamic_Programming_2D.Coin_Change_2;

//You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
//
//Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
//
//You may assume that you have an infinite number of each kind of coin.
//
//The answer is guaranteed to fit into a signed 32-bit integer.
//
//
//
//Example 1:
//
//Input: amount = 5, coins = [1,2,5]
//Output: 4
//Explanation: there are four ways to make up the amount:
//        5=5
//        5=2+2+1
//        5=2+1+1+1
//        5=1+1+1+1+1
//Example 2:
//
//Input: amount = 3, coins = [2]
//Output: 0
//Explanation: the amount of 3 cannot be made up just with coins of 2.
//Example 3:
//
//Input: amount = 10, coins = [10]
//Output: 1

import java.util.Arrays;

public class CoinChange2 {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1,2,5};
        System.out.println(change(amount, coins));
    }
    public static int change(int amount, int[] coins) {
        // dp array to store the number of ways to make each amount
        int[] dp = new int[amount + 1];
        dp[0] = 1;  // There is one way to make the amount 0: use no coins

        // Update the dp array for each coin
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
                System.out.println("curr coin (iteration): " + coin +
                                   ", j: " + j +
                                   ", dp[j]: " + dp[j] +
                                   ", dp arr: " + Arrays.toString(dp));
            }
        }

        // The answer for the original amount
        return dp[amount];
    }

}
