package com.problem_solving.Dynamic_Programming.Target_Sum;


//You are given an integer array nums and an integer target.

//You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

//For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
//Return the number of different expressions that you can build, which evaluates to target.

//Example 1:
//Input: nums = [1,1,1,1,1], target = 3
//Output: 5
//Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
//        -1 + 1 + 1 + 1 + 1 = 3
//        +1 - 1 + 1 + 1 + 1 = 3
//        +1 + 1 - 1 + 1 + 1 = 3
//        +1 + 1 + 1 - 1 + 1 = 3
//        +1 + 1 + 1 + 1 - 1 = 3

//Example 2:
//Input: nums = [1], target = 1
//Output: 1

import java.util.HashMap;
import java.util.Map;

public class TargetSum {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int[] nums2 = {1};
        int target = 3;
        int target2 = 1;
        System.out.println(findWays(nums, target));
        System.out.println(findWays(nums2, target2));
    }

    public static int findWays(int[] nums, int target) {
        Map<String, Integer> dpMap = new HashMap<>();
        return backtrackDP(nums, target, 0, 0, dpMap);
    }

    public static int backtrackDP(int[] nums, int target, int idx, int currentSum, Map<String, Integer> dpMap) {

        String dpKey = idx + "," + currentSum;

        // check for already computed result
        if(dpMap.containsKey(dpKey)) {
            return dpMap.get(dpKey);
        }

        // base case
        if(idx >= nums.length) {
            if(currentSum == target) return 1;
            else return 0;
        }

        int add = backtrackDP(nums, target, idx+1, currentSum - nums[idx], dpMap);
        int subtract = backtrackDP(nums, target, idx+1, currentSum + nums[idx], dpMap);

        int result = add + subtract;
        dpMap.put(dpKey, result);

        return result;
    }


}
