package com.problem_solving.Roman_to_Integer;

//Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

//Symbol       Value
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000
//For example, 2 is written as II in Roman numeral,
// just two ones added together. 12 is written as XII,
// which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

//Roman numerals are usually written largest to smallest from left to right.
// However, the numeral for four is not IIII. Instead, the number four is written as IV.
// Because the one is before the five we subtract it making four.
// The same principle applies to the number nine, which is written as IX.
// There are six instances where subtraction is used:

//I can be placed before V (5) and X (10) to make 4 and 9.
//X can be placed before L (50) and C (100) to make 40 and 90.
//C can be placed before D (500) and M (1000) to make 400 and 900.
//Given a roman numeral, convert it to an integer.

//Example 1:
//Input: s = "III"
//Output: 3
//Explanation: III = 3.

//Example 2:
//Input: s = "LVIII"
//Output: 58
//Explanation: L = 50, V= 5, III = 3.

//Example 3:
//Input: s = "MCMXCIV"
//Output: 1994
//Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

import java.util.HashMap;
import java.util.Map;

class RomanToInteger {
public static void main(String[] args) {

    Map<String, Integer> values = new HashMap<>();


        values.put("I", 1);
        values.put("V", 5);
        values.put("X", 10);
        values.put("L", 50);
        values.put("C", 100);
        values.put("D", 500);
        values.put("M", 1000);
        values.put("IV", 4);
        values.put("IX", 9);
        values.put("XL", 40);
        values.put("XC", 90);
        values.put("CD", 400);
        values.put("CM", 900);

    String s = "MCMXCIV";
    String s2 = "III";
    String s3 = "LVIII";

    System.out.println(romanToInt(s2, values));

}
    public static int romanToInt(String s, Map<String, Integer> values) {

        int sum = 0;
        int i = 0;

        while(i < s.length()) {
            if(i < s.length() - 1) {
                String twoSymbols = s.substring(i, i + 2);
                if (values.containsKey(twoSymbols)) {
                    sum += values.get(twoSymbols);
                    i = i + 2;
                    continue;
                }
            }
            String oneSymbol = s.substring(i, i + 1);
            sum += values.get(oneSymbol);
            i = i + 1;
        }

        return sum;
    }
}
