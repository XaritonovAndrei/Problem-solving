package com.problem_solving.Backtracking.Letter_Combinations_of_a_Phone_Number;

//Given a string containing digits from 2-9 inclusive,
// return all possible letter combinations that the number could represent.
// Return the answer in any order.

//A mapping of digits to letters (just like on the telephone buttons) is given below.
// Note that 1 does not map to any letters.

//Example 1:
//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

//Example 2:
//Input: digits = ""
//Output: []

//Example 3:
//Input: digits = "2"
//Output: ["a","b","c"]

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
    public static void main(String[] args) {
        String digits = "23";
        String digits2 = "47";
        System.out.println(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();

        String[] letters = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        List<String> combinations = new ArrayList<>();
        backtrack(combinations, digits.toCharArray(), "", letters);
        return combinations;
    }

    public static void backtrack(List<String> combinations, char[] digits, String s, String[] letters) {
        if (s.length() == digits.length) {
            combinations.add(s);
            return;
        }
        int i = s.length();
        int digit = Integer.parseInt(String.valueOf(digits[i]));
        for (char letter : letters[digit].toCharArray()) {
            backtrack(combinations, digits, s + Character.toString(letter), letters);
        }
    }

}
