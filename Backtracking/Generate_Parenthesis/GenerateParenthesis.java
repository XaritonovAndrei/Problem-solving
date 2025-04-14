package com.problem_solving.Backtracking.Generate_Parenthesis;

//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

//Example 1:
//Input: n = 3
//Output: ["((()))","(()())","(())()","()(())","()()()"]

//Example 2:
//Input: n = 1
//Output: ["()"]


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(generateParenthesisBacktrackRecursion(n));
        System.out.println(generateParenthesisDynamicProgramming(n));
    }

    public static List<String> generateParenthesisBacktrackRecursion (int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    public static void backtrack(List<String> result,
                                 StringBuilder current,
                                 int openParenthesis,
                                 int closeParenthesis,
                                 int targetPairs) {

        //base case to stop recursion: if total parenthesis = 8, which is equal to pairs*2, then return
        if (current.length() == targetPairs * 2) {
            result.add(current.toString());
            return;
        }

        if (openParenthesis < targetPairs) {
            current.append("("); // ( ( ( (
            backtrack(result, current, openParenthesis + 1, 0, targetPairs);
            current.deleteCharAt(current.length() - 1);
        }

        if (closeParenthesis < openParenthesis) {
            current.append(")");
            backtrack(result, current, openParenthesis, closeParenthesis + 1, targetPairs);
            current.deleteCharAt(current.length() - 1);
        }

    }


    public static List<String> generateParenthesisDynamicProgramming(int n) {
        List<List<String>> dp = new ArrayList<>();

        // Base case to start: 0 pairs of parentheses -> empty string
        dp.add(Collections.singletonList(""));

        for (int i = 1; i <= n; i++) {
            List<String> currentList = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                for (String left : dp.get(j)) {
                    for (String right : dp.get(i - j - 1)) {
                        currentList.add("(" + left + ")" + right);
                    }
                }
            }
            dp.add(currentList);
        }

        return dp.get(n);
    }
}
