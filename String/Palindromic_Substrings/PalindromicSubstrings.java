package com.problem_solving.String.Palindromic_Substrings;

//Given a string s, return the number of palindromic substrings in it.

//A string is a palindrome when it reads the same backward as forward.

//A substring is a contiguous sequence of characters within the string.

//Example 1:
//Input: s = "abc"
//Output: 3
//Explanation: Three palindromic strings: "a", "b", "c".

//Example 2:
//Input: s = "aaa"
//Output: 6
//Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

public class PalindromicSubstrings {
    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countEm(s));
    }

    public static int countEm(String s) {
        int n = s.length();
        int answer = 0;
        for(int i = 0; i < n; i++) {
            int even = palindromeCounter(s, i, i+1);
            int odd = palindromeCounter(s, i-1, i+1);
            answer += even + odd + 1;
        }
        return answer;
    }

    public static int palindromeCounter(String s, int left, int right) {
        int count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }
        return count;
    }
}
