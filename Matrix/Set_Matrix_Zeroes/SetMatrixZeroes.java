package com.problem_solving.Matrix.Set_Matrix_Zeroes;

//Given an m x n integer matrix,
// if an element is 0, set its entire row and column to 0's.

//You must do it in place.

//Example 1:
//Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
//Output: [[1,0,1],[0,0,0],[1,0,1]]

//Example 2:
//Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

import java.util.Arrays;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {{1,1,1}, {1,0,1}, {1,1,1}};

        System.out.println("original:");
        for(int[] e : matrix) {
            System.out.println(Arrays.toString(e));
        }

        setZeroesWithTwoArrays(matrix);

        System.out.println("result:");
        for(int[] e : matrix) {
            System.out.println(Arrays.toString(e));
        }
    }

    public static void setZeroesWithTwoArrays(int[][] matrix){

        int m=matrix.length, n=matrix[0].length;
        int[] rowsArray = new int[m];
        int[] colsArray = new int[n];

        Arrays.fill(rowsArray,1);
        Arrays.fill(colsArray,1);

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    rowsArray[i]=0;
                    colsArray[j]=0;
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(rowsArray[i]==0 || colsArray[j]==0)
                    matrix[i][j]=0;
            }
        }
    }
}
