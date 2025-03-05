package com.problem_solving.Longest_substring_without_repeating_chars;

//leetcode: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

//Given a string s, find the length of the longest substring without duplicate characters.

//Example 1:
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.

//Example 2:
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.

//Example 3:
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.

//Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingChars {
    public static void main(String[] args) {
        String s = "bbbbbbbb";
        LongestSubstringWithoutRepeatingCharsSolution find = new LongestSubstringWithoutRepeatingCharsSolution();
        System.out.println(find.SStringLength(s));
        System.out.println(find.SStringLengthTwo(s));
    }
}

class LongestSubstringWithoutRepeatingCharsSolution {
    public int SStringLength(String s) {
        int n = s.length();
        int maxLength = 0;
        HashSet<Character> charSet = new HashSet<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (!charSet.contains(s.charAt(right))) {
                charSet.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                while (charSet.contains(s.charAt(right))) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
                charSet.add(s.charAt(right));
            }
        }
        System.out.println(charSet);
        return maxLength;
    }

    public int SStringLengthTwo(String s) {

        if(s == null || s.length()==0){
            return 0;
        }

        if(s.length() == 1){
            return 1;
        }

        int left = 0;
        int right = 0;
        int ans = 0;

        HashSet<Character> set = new HashSet<>();

        while(right < s.length()){
            char c = s.charAt(right);
            while(set.contains(c)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            ans = Math.max(ans, right-left + 1);
            right++;
        }
        System.out.println(set);
        return ans;
    }
}




