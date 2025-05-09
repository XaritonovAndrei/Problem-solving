package com.problem_solving.Dynamic_Programming_2D.Longest_consecutive_subsequence;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;


//Given an unsorted array of integers nums,
// return the length of the longest consecutive elements sequence.

//You must write an algorithm that runs in O(n) time.

//Example 1:
//Input: nums = [100,4,200,1,3,2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

//Example 2:
//Input: nums = [0,3,7,2,5,8,4,6,0,1]
//Output: 9

//Example 3:
//Input: nums = [1,0,1,2]
//Output: 3

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {

        int[] nums1 = {100, 4, 200, 1, 3, 2};
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("Solution one, nums1 Longest Consecutive Subsequence: " + longestConsecutiveSubsequenceOne(nums1));
        System.out.println("Solution one, nums2 Longest Consecutive Subsequence: " + longestConsecutiveSubsequenceOne(nums2));

        System.out.println("Solution two, nums1 Longest Consecutive Subsequence: " + longestConsecutiveSubsequenceTwo(nums1));
        System.out.println("Solution two, nums2 Longest Consecutive Subsequence: " + longestConsecutiveSubsequenceTwo(nums2));

    }

    public static int longestConsecutiveSubsequenceOne(int[] nums) {

        int numsLength = nums.length;

        if (numsLength == 0) {
            return 0;
        }

        Arrays.sort(nums);
        System.out.println("Sorted array: " + Arrays.toString(nums));

        int counter = 1;
        int maximum = 0;

        for (int i = 1; i < numsLength; i++) {

            if (nums[i] == nums[i - 1] + 1) {
                counter++;
                maximum = Math.max(counter, maximum);
                System.out.println("i: " + i + ", " + "counter: " + counter);
                System.out.println("i: " + i + ", " + "maximum: " + maximum);
            } else if (nums[i] != nums[i - 1] + 1) {
                counter = 1; //reset counter
                System.out.println("i: " + i + ", " + "counter: " + counter + " (counter reset)");
            }

        }
        return Math.max(maximum, counter);
    }


    public static int longestConsecutiveSubsequenceTwo(int[] nums) {

        if(nums.length ==0){
            return 0;
        }

        HashSet<Integer> numSet = new HashSet<>();

        for(int i=0; i<nums.length; i++){
            numSet.add(nums[i]);
        }
        System.out.println("nums set: " + numSet);

        int maximum = 1;

        for(int num : numSet){
            if(numSet.contains(num-1)){
                continue;
            }
            else{
                int currentNum = num;
                int counter = 1;
                while(numSet.contains(currentNum + 1)) {
                    currentNum++;
                    counter++;
                }
                maximum = Math.max(maximum, counter);
            }
        }
        return maximum;
    }
}
