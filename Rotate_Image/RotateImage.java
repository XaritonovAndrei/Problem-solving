package com.problem_solving.Rotate_Image;

//You are given an n x n 2D matrix representing an image,
//      rotate the image by 90 degrees (clockwise).

//You have to rotate the image in-place,
//      which means you have to modify the input 2D matrix directly.
//DO NOT allocate another 2D matrix and do the rotation.

import java.util.Arrays;

public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println("initial: " + "\n" + Arrays.deepToString(matrix));
        rotate(matrix);
        System.out.println("result: " + "\n" + Arrays.deepToString(matrix));
    }

    public static void rotate(int[][] matrix) {

        int n = matrix.length;
        for(int i=0; i<(n+1)/2 ; i++){
            for(int j=0; j< n/2; j++){
                int temp = matrix[n-1-j][i];

                matrix[n-1-j][i] = matrix[n-1-i][n-j-1];
                matrix[n-1-i][n-j-1] = matrix[j][n-1-i];
                matrix[j][n-1-i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}

