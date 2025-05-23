package com.problem_solving.Dynamic_Programming.Unique_Paths;

//There is a robot on an m x n grid.
// The robot is initially located at the top-left corner (i.e., grid[0][0]).
// The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
// The robot can only move either down or right at any point in time.
//
//Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
//
//The test cases are generated so that the answer will be less than or equal to 2 * 109.

//Example 1:
//Input: m = 3, n = 7
//Output: 28

//Example 2:
//Input: m = 3, n = 2
//Output: 3
//Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:

//        1. Right -> Down -> Down
//        2. Down -> Down -> Right
//        3. Down -> Right -> Down


import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        int m = 7, n = 3;
        System.out.println(uniquePaths(m, n));
        System.out.println(uniquePathsRecursive(m, n));
    }


    public static int uniquePaths(int m, int n) {
        int [][] dp = new int[m][n];

        for(int[] row:dp){
            Arrays.fill(row,1);
        }

        for(int i=1; i<m;i++){
            for(int j=1; j<n; j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

    Map<String, Integer> map = new HashMap<String, Integer>();
    public int uniquePathsRecursive(int m, int n) {
        // Map<String, Integer> map = new HashMap<String, Integer>();
        
        if(m == 1 || n == 1) return 1;
        
        String cell = new String(m + "," + n);
        if(map.containsKey(cell)) {
            return map.get(cell);
        }
        
        int upMove = uniquePathsRecursive(m-1, n);
        int leftMove = uniquePathsRecursive(m, n-1);
        
        map.put(cell, upMove + leftMove);
        
        return upMove + leftMove;
    }   
}


