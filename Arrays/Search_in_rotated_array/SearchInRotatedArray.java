package com.problem_solving.Arrays.Search_in_rotated_array;

//There is an integer array nums sorted in ascending order (with distinct values).
//Prior to being passed to your function,
// nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
// such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
// For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
//Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

//You must write an algorithm with O(log n) runtime complexity.

//Example 1:
//Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4

//Example 2:
//Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1

//Example 3:
//Input: nums = [1], target = 0
//Output: -1

public class SearchInRotatedArray {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        SearchInRotatedArraySolution search = new SearchInRotatedArraySolution();
        System.out.println(search.InRotatedArray(nums, target));
    }
}

class SearchInRotatedArraySolution {
    public int InRotatedArray(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = (left+right)/2;
            if(nums[mid] == target){
                return mid;
            }

            if(nums[left] <= nums[mid]){
                if(target < nums[left] || target > nums[mid]){
                    left = mid+1;
                }
                else{
                    right = mid-1;
                }
            }
            else{
                if(target > nums[right] || target < nums[mid]){
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
            }
        }
        return -1;
    }
}

