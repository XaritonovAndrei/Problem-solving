package com.problem_solving.Minimum_window_substring;

//leetcode ling https://leetcode.com/problems/minimum-window-substring/description/

//Given two strings s and t of lengths m and n respectively,
// return the minimum window substring of s such that every character in t (including duplicates) is included in the window.
// If there is no such substring, return the empty string "".

//The testcases will be generated such that the answer is unique.

//Example 1:
//Input: s = "ADOBECODEBANC", t = "ABC"
//Output: "BANC"
//Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

//Example 2:
//Input: s = "a", t = "a"
//Output: "a"
//Explanation: The entire string s is the minimum window.

//Example 3:
//Input: s = "a", t = "aa"
//Output: ""
//Explanation: Both 'a's from t must be included in the window.

//Since the largest window of s only has one 'a', return empty string.

import java.util.HashMap;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        MinimumWindowSubstringSolution find = new MinimumWindowSubstringSolution();
        System.out.println(find.minimumWindowSubstring(s, t));
    }
}

class MinimumWindowSubstringSolution {
    public String minimumWindowSubstring(String s, String t) {

        if(s.length() == 0 || t.length() == 0 || s.length() < t.length()){
            return "";
        }

        HashMap<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }
        int requiredWindowSize = mapT.size();
        int leftPointer = 0, rightPointer = 0;
        int numberOfVariablesPresentInSubStringMap = 0;
        int[] answer = {-1, 0, 0};
        HashMap<Character, Integer> subStringMap = new HashMap<>();

        while (rightPointer < s.length()) {
            char charAtPointer = s.charAt(rightPointer);
            int count = subStringMap.getOrDefault(charAtPointer, 0);
            subStringMap.put(charAtPointer, count + 1);
            if (mapT.containsKey(charAtPointer) && subStringMap.get(charAtPointer).intValue() == mapT.get(charAtPointer).intValue()) {
                numberOfVariablesPresentInSubStringMap++;
            }
            while (leftPointer <= rightPointer && requiredWindowSize == numberOfVariablesPresentInSubStringMap) {
                charAtPointer = s.charAt(leftPointer);
                if (answer[0] == -1 || answer[0] >= rightPointer - leftPointer + 1) {
                    answer[0] = rightPointer - leftPointer + 1;
                    answer[1] = leftPointer;
                    answer[2] = rightPointer;
                }

                subStringMap.put(charAtPointer, subStringMap.get(charAtPointer) - 1);
                if (mapT.containsKey(charAtPointer) && subStringMap.get(charAtPointer).intValue() < mapT.get(charAtPointer).intValue()) {
                    numberOfVariablesPresentInSubStringMap--;
                }
                leftPointer++;
            }
            rightPointer++;
        }
        if (answer[0] == -1) {
            return "";
        } else {
            return s.substring(answer[1], answer[2] + 1);
        }
    }
}