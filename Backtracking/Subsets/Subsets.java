package com.problem_solving.Backtracking.Subsets;

//Given an integer array nums of unique elements, return all possible subsets (the power set).

//The solution set must not contain duplicate subsets. Return the solution in any order.

//Example 1:
//Input: nums = [1,2,3]
//Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

//Example 2:
//Input: nums = [0]
//Output: [[],[0]]

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsetsRecursive(0, nums, new ArrayList<>(), result);
        return result;
    }

    private static void generateSubsetsRecursive(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            generateSubsetsRecursive(i + 1, nums, current, result);
            current.remove(current.size() - 1); // current.removeLast
        }
    }
}
