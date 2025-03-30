package com.problem_solving.Minimum_Remove_to_Make_Valid_Parentheses;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


//Given a string s of '(' , ')' and lowercase English characters.

//Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions )
// so that the resulting parentheses string is valid and return any valid string.

//Formally, a parentheses string is valid if and only if:

//It is the empty string, contains only lowercase characters, or
//It can be written as AB (A concatenated with B), where A and B are valid strings, or
//It can be written as (A), where A is a valid string.

//Example 1:
//Input: s = "lee(t(c)o)de)"
//Output: "lee(t(c)o)de"
//Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.

//Example 2:
//Input: s = "a)b(c)d"
//Output: "ab(c)d"

//Example 3:
//Input: s = "))(("
//Output: ""
//Explanation: An empty string is also valid.


public class MinimumRemoveToMakeValidParentheses {
    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        System.out.println(minRemoveToMakeValid(s));
    }

    public static String minRemoveToMakeValid(String s) {
        Set<Integer> letterIndexesToRemove = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    letterIndexesToRemove.add(i);
                } else {
                    stack.pop();
                }
            }
        }

        while (!stack.isEmpty()) {
            letterIndexesToRemove.add(stack.pop());
        }

        StringBuilder result = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (letterIndexesToRemove.contains(i)) {
//                result.append(s.charAt(i));
                result.deleteCharAt(i);
            }
        }
        return result.toString();
    }
}
