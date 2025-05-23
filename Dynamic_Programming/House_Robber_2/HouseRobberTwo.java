package com.problem_solving.Dynamic_Programming.House_Robber_2;

//You are a professional robber planning to rob houses along a street.
// Each house has a certain amount of money stashed,
// the only constraint stopping you from robbing each of them is
// that adjacent houses have security systems connected
// and it will automatically contact the police
// if two adjacent houses were broken into on the same night.

//Given an integer array nums representing the amount of money of each house,
// return the maximum amount of money you can rob tonight without alerting the police.

//Example 1:
//Input: nums = [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//Total amount you can rob = 1 + 3 = 4.

//Example 2:
//Input: nums = [2,7,9,3,1]
//Output: 12
//Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
//Total amount you can rob = 2 + 9 + 1 = 12.

public class HouseRobberTwo {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        HouseRobberTwoSolution findMax = new HouseRobberTwoSolution();
        System.out.println("money -> " + findMax.money(nums));
    }
}

class HouseRobberTwoSolution {
    public int money(int[] nums) {


        int rob1 = 0;
        int rob2 = 0;
        int max1 = nums[0];
        int max2 = 0;

        for(int i=0; i<nums.length-1; i++){
            max1= Math.max(rob1+nums[i], rob2);
            rob1= rob2;
            rob2= max1;
        }

        rob1=0;
        rob2=0;

        for(int i=1; i<nums.length; i++){
            max2= Math.max(rob1+nums[i], rob2);
            rob1= rob2;
            rob2= max2;
        }

        return Math.max(max1, max2);
    }
}
