package com.problem_solving.Happy_Number;

//Write an algorithm to determine if a number n is happy.
//
//        A happy number is a number defined by the following process:
//
//        Starting with any positive integer, replace the number by the sum of the squares of its digits.
//        Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
//        Those numbers for which this process ends in 1 are happy.
//        Return true if n is a happy number, and false if not.

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HappyNumber {

    public static void main(String[] args) {
        int n = 7;
        System.out.println(isHappy(n));
    }

    public static boolean isHappy(int n) {
        Set<Integer> seenNumbers = new HashSet<>();

        while (n != 1 && !seenNumbers.contains(n)) {
            seenNumbers.add(n);
            n = getSumOfSquares(n);
        }

        return n == 1;
    }

    private static int getSumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}

