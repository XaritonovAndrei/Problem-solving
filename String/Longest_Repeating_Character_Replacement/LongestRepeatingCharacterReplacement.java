package com.problem_solving.String.Longest_Repeating_Character_Replacement;
import java.util.HashMap;
import java.util.Map;

//You are given a string s and an integer k.
// You can choose any character of the string and change it to any other uppercase English character.
// You can perform this operation at most k times.

//Return the length of the longest substring containing the same letter
// you can get after performing the above operations.

//Example 1:
//Input: s = "ABAB", k = 2
//Output: 4
//Explanation: Replace the two 'A's with two 'B's or vice versa.

//Example 2:
//Input: s = "AABABBA", k = 1
//Output: 4
//Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
//The substring "BBBB" has the longest repeating letters, which is 4.

//There may exists other ways to achieve this answer too.


public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "ABAB";
        String s2 = "AABABBA";
        int k = 2;
        int k2 = 1;
        System.out.println(characterReplacement(s, k));
        System.out.println(characterReplacement(s2, k2));
    }

    public static int characterReplacement(String s, int k) {

        int[] occurance = new int[26];
        int left = 0;
        int ans = 0;
        int maxOccurance = 0;

        Map<Character, Integer> letterCounter = new HashMap<>();


        for(int right = 0; right < s.length(); right++){
            letterCounter.put(s.charAt(right), letterCounter.getOrDefault(s.charAt(right),0) + 1);
            maxOccurance = Math.max(maxOccurance, letterCounter.get(s.charAt(right)));

            if(right - left + 1 - maxOccurance > k){
                letterCounter.put(s.charAt(left), letterCounter.getOrDefault(s.charAt(left),0) - 1);
                left++;
            }

            ans = Math.max(ans, right-left + 1);
        }

        return ans;

    }
}
