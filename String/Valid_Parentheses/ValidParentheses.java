package com.problem_solving.String.Valid_Parentheses;

//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
//determine if the input string is valid.

//An input string is valid if:
//Open brackets must be closed by the same type of brackets.
//Open brackets must be closed in the correct order.
//Every close bracket has a corresponding open bracket of the same type.

//        Example 1:
//        Input: s = "()"
//        Output: true

//        Example 2:
//        Input: s = "()[]{}"
//        Output: true

//        Example 3:
//        Input: s = "(]"
//        Output: false

//        Example 4:
//        Input: s = "([])"
//        Output: true


import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s) {

        HashMap<Character, Character> parenthesisPairs = new HashMap<>();

        parenthesisPairs.put(')','(');
        parenthesisPairs.put('}','{');
        parenthesisPairs.put(']','[');

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char currentParenthesis = s.charAt(i);

            if(!parenthesisPairs.containsKey(currentParenthesis)){
                stack.push(currentParenthesis);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                char topParenthesis = stack.pop();
                if(topParenthesis != parenthesisPairs.get(currentParenthesis)){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
