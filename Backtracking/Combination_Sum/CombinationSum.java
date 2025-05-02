package com.problem_solving.Backtracking.Combination_Sum;

import java.util.ArrayList;
import java.util.List;


//Given an array of distinct integers candidates and a target integer target,
// return a list of all unique combinations of candidates where the chosen numbers sum to target.
// You may return the combinations in any order.

//The same number may be chosen from candidates an unlimited number of times.
// Two combinations are unique if the frequency of at least one of the chosen numbers is different.

//The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

//Example 1:
//Input: candidates = [2,3,6,7], target = 7
//Output: [[2,2,3],[7]]
//Explanation:
//2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
//7 is a candidate, and 7 = 7.
//These are the only two combinations.

//Example 2:
//Input: candidates = [2,3,5], target = 8
//Output: [[2,2,2,2],[2,3,3],[3,5]]

//Example 3:
//Input: candidates = [2], target = 1
//Output: []

public class CombinationSum {
    public static void main(String[] args) {
        int [] candidates = {2,3,6,7};
        int targetValue = 7;

        System.out.println(combinationSum(candidates, targetValue));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int targetValue) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();

        backTrack(targetValue, result, combination, 0, candidates);

        return result;
    }

    public static void backTrack(int targetValue, List<List<Integer>> res, List<Integer> combination,
                                 int start, int[] candidates) {
        if(targetValue == 0){
            res.add(new ArrayList<Integer>(combination));
            System.out.println("targetValue " + targetValue + " == 0" );
        }
        else if(targetValue <0){
            System.out.println("targetValue " + targetValue + " < 0");
            return;
        }
        else if(targetValue > 0){
            for (int i = start; i < candidates.length; i++) {
                combination.add(candidates[i]);
                System.out.println("i: " + i + ", added: " + candidates[i] + ", targetValue: " + targetValue + ", currentComb: " + combination);
                backTrack(targetValue - candidates[i], res, combination, i, candidates);
                combination.remove(combination.size() - 1);
            }
        }
    }
}
