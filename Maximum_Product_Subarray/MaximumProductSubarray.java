package com.problem_solving.Arrays.Maximum_Product_Subarray;

//Given an integer array nums, find a subarray that has the largest product,
// and return the product.

//The test cases are generated so that the answer will fit in a 32-bit integer.

//Example 1:
//Input: nums = [2,3,-2,4]
//Output: 6
//Explanation: [2,3] has the largest product 6.

//Example 2:
//Input: nums = [-2,0,-1]
//Output: 0
//Explanation: The result cannot be 2, because [-2,-1] is not a subarray.


public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(findMaxProduct(nums));
    }

    public static int findMaxProduct(int[] nums) {

        if(nums.length == 0){
            return 0;
        }

        int minValue = nums[0];
        int maxValue = nums[0];
        int result = maxValue;

        for(int i = 1; i < nums.length; i++){
            int currentValue = nums[i];
            maxValue = Math.max(currentValue, Math.max(maxValue * currentValue, minValue * currentValue));
            minValue = Math.min(currentValue, Math.min(minValue * currentValue, maxValue * currentValue));
            result = Math.max(result, maxValue);
        }
        return result;
    }

    
        public static int maxProduct(int[] nums) {
        
        int max = nums[0], min = nums[0], ans = nums[0];
        int n = nums.length;
        
        for (int i = 1; i < n; i++) {
        
			// Swapping min and max
            if (nums[i] < 0){
                int temp = max;
                max = min;
                min = temp;
            }
                
            max = Math.max(nums[i], max * nums[i]); (-2, -12) -> -2;
            min = Math.min(nums[i], min * nums[i]);  (-2, -12) -> -12 

            ans = Math.max(ans, max);
        }
        return ans;
    } 
}
