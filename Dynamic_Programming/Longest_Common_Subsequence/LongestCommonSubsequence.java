package com.problem_solving.Dynamic_Programming.Longest_Common_Subsequence;

//Given two strings text1 and text2,
// return the length of their longest common subsequence.
// If there is no common subsequence, return 0.

//A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

//For example, "ace" is a subsequence of "abcde".
//A common subsequence of two strings is a subsequence that is common to both strings.

//Example 1:
//Input: text1 = "abcde", text2 = "ace"
//Output: 3
//Explanation: The longest common subsequence is "ace" and its length is 3.

//Example 2:
//Input: text1 = "abc", text2 = "abc"
//Output: 3
//Explanation: The longest common subsequence is "abc" and its length is 3.

//Example 3:
//Input: text1 = "abc", text2 = "def"
//Output: 0
//Explanation: There is no such common subsequence, so the result is 0.

import java.util.Arrays;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        System.out.println(longestCommonSubsequence(text1, text2));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int[] dp = new int[text1.length()];
        int longestSequence = 0;

        for (char letter : text2.toCharArray()) {
            int currentLength = 0;
            for (int i = 0; i < dp.length; i++) {
                 if (letter == text1.charAt(i)) {
                     dp[i] = currentLength + 1;
                     longestSequence = Math.max(longestSequence, currentLength + 1);
                 }
                 else if (currentLength < dp[i]) {
                     currentLength = dp[i];
                    }
                }
            }
        System.out.println(Arrays.toString(dp));
        return longestSequence;
    }
}