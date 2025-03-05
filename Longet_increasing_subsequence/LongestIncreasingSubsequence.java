package com.problem_solving.Longet_increasing_subsequence;

//leetcode link: https://leetcode.com/problems/longest-increasing-subsequence/description/

//Given an integer array nums, return the length of the longest strictly increasing subsequence.

//Example 1:

//Input: nums = [10,9,2,5,3,7,101,18]
//Output: 4
//Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
//Example 2:

//Input: nums = [0,1,0,3,2,3]
//Output: 4
//Example 3:

//Input: nums = [7,7,7,7,7,7,7]
//Output: 1

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums= {10,9,2,5,3,7,101,18};
        LongestIncreasingSubsequenceSolution find = new LongestIncreasingSubsequenceSolution();
        System.out.println(find.longestIncSSeq(nums));
    }
}

class LongestIncreasingSubsequenceSolution {
    public int longestIncSSeq(int[] nums) {

            int [] Lis = new int[nums.length];
            Arrays.fill(Lis, 1);
            int max=1;

            for(int i=1; i<nums.length; i++){
                for(int j=0; j<i; j++){
                    if(nums[i] > nums[j]){
                        Lis[i] = Math.max(Lis[i], 1+Lis[j]);
                        max = Math.max(max, Lis[i]);
                    }
                }
            }
            return max;
        }
    }

