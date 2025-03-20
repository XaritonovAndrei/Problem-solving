package com.problem_solving.Arrays.Best_Time_to_Buy_and_Sell_Stock;


//You are given an array prices where prices[i] is the price of a given stock on the ith day.

//You want to maximize your profit by choosing a single day to buy one stock
// and choosing a different day in the future to sell that stock.

//Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

//Example 1:
//Input: prices = [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

//Example 2:
//Input: prices = [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transactions are done and the max profit = 0.

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println("1: " + maxProfit(prices));
        System.out.println("2: " + maxProfit2(prices));
    }

    public static int maxProfit(int[] prices) {

        int buy = 0;
        int sell = 1;
        int profit = 0;

        for (int i=1; i<prices.length; i++){

            profit = Math.max(profit, prices[sell]-prices[buy]);

            if (prices[sell] < prices[buy]){
                buy = sell;
            }
            sell++;
        }
        return profit;
    }

    public static int maxProfit2(int[] prices) {

        int leftPointer = 0;
        int rightPointer = 1;
        int maxProfit = 0;

        for (int i = 0; i < prices.length - 1; i++) {

            int currProfit = 0;

            currProfit = prices[rightPointer] - prices[leftPointer];
            maxProfit = Math.max(currProfit, maxProfit);

            if (prices[rightPointer] < prices[leftPointer]) {
                leftPointer++;
                rightPointer++;
            }
            else {
                rightPointer++;
            }
        }
        return maxProfit;
    }
}

