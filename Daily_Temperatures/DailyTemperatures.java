package com.problem_solving.Daily_Temperatures;

//Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

//Example 1:
//Input: temperatures = [73,74,75,71,69,72,76,73]
//Output: [1,1,4,2,1,1,0,0]

//Example 2:
//Input: temperatures = [30,40,50,60]
//Output: [1,1,1,0]

//Example 3:
//Input: temperatures = [30,60,90]
//Output: [1,1,0]

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static void main (String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(temperatures));
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int indexOfLowerTemperature = stack.pop();
                answer[indexOfLowerTemperature] = i - indexOfLowerTemperature;
            }
            stack.push(i);
        }

        return answer;
    }
}
