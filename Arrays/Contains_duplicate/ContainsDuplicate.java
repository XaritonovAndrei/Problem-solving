package com.problem_solving.Arrays.Contains_duplicate;

//leetcode link: https://leetcode.com/problems/contains-duplicate/description/

//Given an integer array nums,
// return true if any value appears at least twice in the array,
// and return false if every element is distinct.

//Example 1:
//Input: nums = [1,2,3,1]
//Output: true
//Explanation:
//The element 1 occurs at the indices 0 and 3.

//Example 2:
//Input: nums = [1,2,3,4]
//Output: false
//Explanation:
//All elements are distinct.

//Example 3:
//Input: nums = [1,1,1,3,3,4,3,2,4,2]
//Output: true

import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        ContainsDuplicateSolution doesThisArray = new ContainsDuplicateSolution();
        System.out.println(doesThisArray.containsDuplicate(nums));
    }
}

class ContainsDuplicateSolution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> numsSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (numsSet.contains(nums[i])) {
                return true;
            }
            else {
                numsSet.add(nums[i]);
            }
        }
        return false;
    }
}

