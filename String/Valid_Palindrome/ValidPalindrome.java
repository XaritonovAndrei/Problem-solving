package com.problem_solving.String.Valid_Palindrome;

//A phrase is a palindrome if,
// after converting all uppercase letters into lowercase letters
// and removing all non-alphanumeric characters, it reads the same forward and backward.
// Alphanumeric characters include letters and numbers.

//Given a string s, return true if it is a palindrome, or false otherwise.

//Example 1:
//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.

//Example 2:
//Input: s = "race a car"
//Output: false
//Explanation: "raceacar" is not a palindrome.

//Example 3:
//Input: s = " "
//Output: true
//Explanation: s is an empty string "" after removing non-alphanumeric characters.

//Since an empty string reads the same forward and backward, it is a palindrome.

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(palindromeCheck(s));
    }

    public static boolean palindromeCheck(String s) {
        s = removeNonANsymbols(s.toLowerCase());
        System.out.println(s);
        int leftPointer = 0;
        int rightPointer = s.length() - 1;

        while(leftPointer <= rightPointer){
            for (int i = 0; i <= s.length() - 1; i++) {
                if (s.charAt(leftPointer) != s.charAt(rightPointer)) {
                    return false;
                } else {
                    leftPointer++;
                    rightPointer--;
                }
            }
        }
        return true;
    }

    public static String removeNonANsymbols(String s) {
        Set<Character> alphanumericalChars = new HashSet<>();
        for (char c = 'a'; c <= 'z'; c++) {
            alphanumericalChars.add(c);
        }
        for (char c = '0'; c <= '9'; c++) {
            alphanumericalChars.add(c);
        }
        System.out.println(alphanumericalChars);

        StringBuilder stringBuilder = new StringBuilder();

        for(char stringChar : s.toCharArray()) {
            if (alphanumericalChars.contains(stringChar)) {
                stringBuilder.append(stringChar);
            }
        }
        return stringBuilder.toString();
    }
}
