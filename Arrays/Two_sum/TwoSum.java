package com.problem_solving.Arrays.Two_sum;

// Leetcode Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

//Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
// find two numbers such that they add up to a specific target number.
// Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

//Return the indices of the two numbers,
// index1 and index2, added by one as an integer array [index1, index2] of length 2.

//The tests are generated such that there is exactly one solution.
// You may not use the same element twice.

//Your solution must use only constant extra space.

//Example 1:

//Input: numbers = [2,7,11,15], target = 9
//Output: [1,2]
//Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
//Example 2:

//Input: numbers = [2,3,4], target = 6
//Output: [1,3]
//Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
//Example 3:

//Input: numbers = [-1,0], target = -1
//Output: [1,2]
//Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        TwoSumSolutionOne runOne = new TwoSumSolutionOne();
        TwoSumSolutionTwo runTwo = new TwoSumSolutionTwo();
        System.out.println(Arrays.toString(runOne.twoSum(numbers, target)));
        System.out.println(Arrays.toString(runTwo.twoSum(numbers, target)));
    }
}

class TwoSumSolutionOne {
    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            if (numbers[left] + numbers[right] > target) {
                right = right - 1;
            } else if (numbers[left] + numbers[right] < target) {
                left = left + 1;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }
        return null;
    }
}

class TwoSumSolutionTwo {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> twoSumMap = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            if(twoSumMap.containsKey(target - nums[i])) {
                return new int[] {i, twoSumMap.get(target - nums[i])};
            }
            // добавить в hashMap пару: индекс + значение
            twoSumMap.put(nums[i], i);
        }
        return new int[0];
    }
}



