package com.problem_solving.Arrays.Product_of_Array_Except_Self;


//Given an integer array nums, return an array answer
// such that answer[i] is equal to the product of all the elements of nums except nums[i].

//The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

//You must write an algorithm that runs in O(n) time and without using the division operation.

//Example 1:
//Input: nums = [1,2,3,4]
//Output: [24,12,8,6]

//Example 2:
//Input: nums = [-1,1,0,-3,3]
//Output: [0,0,9,0,0]


import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,3,6,11};
        System.out.println("v1: " + Arrays.toString(productExceptSelf(nums)));
        System.out.println("v2: " + Arrays.toString(productExceptSelfV2(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];

        Arrays.fill(result, 1);

        int preFix = 1;
        for(int i=0; i<nums.length; i++){
            result[i] = preFix;
            preFix = preFix * nums[i];
        }

        int postFix = 1;
        for(int i=nums.length - 1; i>=0; i--){
            result[i] = postFix * result[i];
            postFix = postFix * nums[i];
        }
        return result;
    }

    public static int[] productExceptSelfV2(int[] nums) {

        int[] result = new int[nums.length];
        int[] prefixArray = new int[nums.length];
        int[] postfixArray = new int[nums.length];
        Arrays.fill(result, 1);

        prefixArray[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            prefixArray[i] = prefixArray[i - 1] * nums[i - 1];
        }

        postfixArray[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >= 0; i--) {
            postfixArray[i] = postfixArray[i + 1] * nums[i + 1];
        }

        System.out.println("prefix array: " + Arrays.toString(prefixArray));
        System.out.println("postfix array: " + Arrays.toString(postfixArray));

        int[] result2 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result2[i] = prefixArray[i] * postfixArray[i];
        }
        return result2;
    }
}
