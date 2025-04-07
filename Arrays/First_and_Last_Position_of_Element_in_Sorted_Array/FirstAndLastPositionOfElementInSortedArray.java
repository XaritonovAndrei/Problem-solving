package com.problem_solving.Arrays.First_and_Last_Position_of_Element_in_Sorted_Array;

import java.util.Arrays;

//Given an array of integers nums sorted in non-decreasing order,
// find the starting and ending position of a given target value.

//If target is not found in the array, return [-1, -1].

//You must write an algorithm with O(log n) runtime complexity.

//Example 1:
//Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]

//Example 2:
//Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]

//Example 3:
//Input: nums = [], target = 0
//Output: [-1,-1]

public class FirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(findPos(nums, target)));
    }
    public static int[] findPos(int[] nums, int target) {
        int[] result = new int[2];

        result[0] = findFirstPos(nums, target);
        result[1] = findLastPos(nums, target);
        return result;
    }

    public static int findFirstPos(int[] nums, int target){

        int startIndex = 0;
        int endIndex = nums.length - 1;
        int resultID = -1;

        while(startIndex <= endIndex){
            int midIndex = (endIndex - startIndex) / 2;

            if (nums[midIndex] < target){
                startIndex = midIndex +1;
            } else if (nums[midIndex] > target){
                endIndex = midIndex - 1;
            } else { // nums[mid] == target
                resultID = midIndex;
                endIndex = midIndex - 1;
            }
        }
        return resultID;
    }

    public static int findLastPos(int[] nums, int target){

        int startIndex = 0;
        int endIndex = nums.length - 1;
        int resultID = -1;

        while(startIndex <= endIndex){

            int midIndex = (endIndex - startIndex) / 2;

            if (nums[midIndex] < target){
                startIndex = midIndex +1;
            } else if (nums[midIndex] > target){
                endIndex = midIndex - 1;
            } else { // nums[mid] == target
                resultID = midIndex;
                startIndex = midIndex + 1;
            }
        }
        return resultID;
    }
}
