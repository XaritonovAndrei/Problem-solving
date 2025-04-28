package com.problem_solving.String.Longest_Palindromic_Substring;

//Given a string s, return the longest palindromic substring in s.

//Example 1:
//Input: s = "babad"
//Output: "bab"
//Explanation: "aba" is also a valid answer.

//Example 2:
//Input: s = "cbbd"
//Output: "bb"


import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(findLongest(s));
    }

    public static String findLongest(String s) {

        List<Character> longestPalindromicSubstring = new LinkedList<>();

        for (int middlePointer = 1; middlePointer < s.length(); middlePointer++) {

            int leftPointer = middlePointer - 1;
            int rightPointer = middlePointer + 1;

            List<Character> currentLongestPalindromicSubstring = new LinkedList<>();
            currentLongestPalindromicSubstring.add(s.charAt(middlePointer));

            while (leftPointer >= 0 && rightPointer < s.length() && s.charAt(leftPointer) == s.charAt(rightPointer)) {

                currentLongestPalindromicSubstring.addFirst(s.charAt(leftPointer));
                currentLongestPalindromicSubstring.addLast(s.charAt(rightPointer));

                leftPointer--;
                rightPointer++;
                if (currentLongestPalindromicSubstring.size() > longestPalindromicSubstring.size()) {
                    longestPalindromicSubstring = currentLongestPalindromicSubstring;
                }
            }

            System.out.println("cur: " + currentLongestPalindromicSubstring.size());
            System.out.println("longest: " + longestPalindromicSubstring.size());

        }
    return longestPalindromicSubstring.stream()
            .map(String::valueOf)
            .collect(Collectors.joining());
    }
}
