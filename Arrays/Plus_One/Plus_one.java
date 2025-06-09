package com.problem_solving.Arrays.Plus_One;

//You are given a large integer represented as an integer array digits,
//      where each digits[i] is the ith digit of the integer.
// The digits are ordered from most significant to least significant in left-to-right order.
// The large integer does not contain any leading 0's.

//Increment the large integer by one and return the resulting array of digits.

import java.util.Arrays;

class Plus_one {

    public static void main(String[] args) {
        int[] digits = {1,2,3,4};
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    public static int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;  // The most significant digit is 1, rest are 0 by default
        return newDigits;
    }

}