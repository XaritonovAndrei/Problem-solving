package com.problem_solving.Arrays.Minimum_Size_Subarray_Sum;

//Given an array of positive integers nums and a positive integer target,
// return the minimal length of a subarray whose sum is greater than or equal to target.
// If there is no such subarray, return 0 instead.

//Example 1:
//Input: target = 7, nums = [2,3,1,2,4,3]
//Output: 2
//Explanation: The subarray [4,3] has the minimal length under the problem constraint.

//Example 2:
//Input: target = 4, nums = [1,4,4]
//Output: 1

//Example 3:
//Input: target = 11, nums = [1,1,1,1,1,1,1,1]
//Output: 0

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println(findSubarray(nums, target));
    }

    public static int findSubarray(int[] nums, int target) {

        int i = 0;
        int j = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int result;

        while (j < nums.length) {
            sum += nums[j];
            j++;

            while (sum >= target) {
                min = Math.min(min, j - i);
                sum -= nums[i];
                i++;
            }
        }

        if (min == Integer.MAX_VALUE) {
            result = 0;
        } else {
            result = min;
        }
    return result;
    }
}
