package com.problem_solving.Search_2D_Matrix;

//You are given an m x n integer matrix matrix with the following two properties:

//Each row is sorted in non-decreasing order.
//The first integer of each row is greater than the last integer of the previous row.
//Given an integer target, return true if target is in matrix or false otherwise.

//You must write a solution in O(log(m * n)) time complexity.

class Search2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,  3,  5,  7},
                          {10, 11, 16, 20},
                          {23, 30, 34, 60}};
        int targetValue = 11;
        System.out.println(searchMatrix(matrix, targetValue));
    }
    public static boolean searchMatrix(int[][] matrix, int targetValue) {
        int m = matrix.length;
        int n = matrix[0].length;

        int leftPointer = 0;
        int rightPointer = m * n - 1;

        while (leftPointer <= rightPointer) {
            int midPointer = leftPointer + (rightPointer - leftPointer) / 2;
            int midValue = matrix[midPointer / m][midPointer % n];

            if (midValue == targetValue) {
                return true;
            } else if (midValue < targetValue) {
                leftPointer = midPointer + 1;
            } else {
                rightPointer = midPointer - 1;
            }
        }

        return false;
    }
}
