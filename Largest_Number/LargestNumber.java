package com.problem_solving.Largest_Number;

//Given a list of non-negative integers nums,
//  arrange them such that they form the largest number and return it.

//Since the result may be very large, so you need to return a string instead of an integer.

//Example 1:
//Input: nums = [10,2]
//Output: "210"

//Example 2:
//Input: nums = [3,30,34,5,9]
//Output: "9534330"

import java.util.Arrays;
//import java.util.Comparator;

public class LargestNumber {
    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {

        String[] numsAsStrings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsAsStrings[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numsAsStrings, (a, b) -> {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        });

        if (numsAsStrings[0].equals("0")) {
            return "0";
        }

        StringBuilder largestNumberString = new StringBuilder();
        for (String numberAsString : numsAsStrings) {
            largestNumberString.append(numberAsString);
        }
        return largestNumberString.toString();
    }
}
