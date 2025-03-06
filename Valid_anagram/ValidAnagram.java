package com.problem_solving.Valid_anagram;

//leetcode link https://leetcode.com/problems/valid-anagram/description/
//Given two strings s and t, return true if t is an anagram of s, and false otherwise.

// Example 1:
//Input: s = "anagram", t = "nagaram"
//Output: true

//Example 2:
//Input: s = "rat", t = "car"
//Output: false

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        ValidAnagramSolution check = new ValidAnagramSolution();
        System.out.println(check.validAnagramOne(s, t) + " (array solution)");
        System.out.println(check.validAnagramTwo(s, t) + " (hashMap solution)");
        System.out.println(check.validAnagramThree(s, t) + " (hashMapV2 solution)");
    }
}

class ValidAnagramSolution {
    public boolean validAnagramOne(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
        }

    public boolean validAnagramTwo(String s, String t) {
        HashMap<Character, Integer> counterMap = new HashMap<>();

        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        System.out.println(Arrays.toString(sCharArray) + " <- sCharArray");

        for(int i=0; i<sCharArray.length; i++) {
            counterMap.put(sCharArray[i], counterMap.getOrDefault(sCharArray[i], 0) + 1);
        }
        System.out.println(counterMap + " <- chars added");
        for(int i=0; i<tCharArray.length; i++) {
            counterMap.put(tCharArray[i], counterMap.getOrDefault(tCharArray[i], 0) - 1);
        }
        System.out.println(counterMap + " <- chars deleted");
        for (int value : counterMap.values()) {
            if (value != 0) {
                return false;
            }
        }
        System.out.println(counterMap);
        return true;
    }

    public boolean validAnagramThree(String s, String t) {
        HashMap<Character, Integer> count = new HashMap<>();

        // Count the frequency of characters in string s
        for (char x : s.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        // Decrement the frequency of characters in string t
        for (char x : t.toCharArray()) {
            count.put(x, count.getOrDefault(x, 0) - 1);
        }

        // Check if any character has non-zero frequency
        for (int val : count.values()) {
            if (val != 0) {
                return false;
            }
        }
        System.out.println(count);
        return true;
    }

}

