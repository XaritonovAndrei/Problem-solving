package com.problem_solving.String.Longest_Common_Prefix;

//Write a function to find the longest common prefix string amongst an array of strings.

//If there is no common prefix, return an empty string "".

//Example 1:
//Input: strs = ["flower","flow","flight"]
//Output: "fl"

//Example 2:
//Input: strs = ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        Arrays.sort(strs);
        String firstWord = strs[0];
        String lastWord = strs[strs.length - 1];
        int counter = 0;
        while(counter < firstWord.length())
        {
            if (firstWord.charAt(counter) == lastWord.charAt(counter))
                counter++;
            else
                break;
        }
        if(counter > 0) {
            return firstWord.substring(0, counter);
        }
        else return "";
    }
}
