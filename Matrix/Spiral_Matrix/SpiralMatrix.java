package com.problem_solving.Matrix.Spiral_Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix1 = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] matrix2 = {{1,2,3}, {4,5,6}, {7,8,9}};

        System.out.println("original:");
        for(int[] e : matrix1) {
            System.out.println(Arrays.toString(e));
        }

        System.out.println("Solution one result: " + spiralOrderOne(matrix1));
        System.out.println("Solution two result: " + spiralOrderOne(matrix2));
    }


    public static List<Integer> spiralOrderOne (int[][] matrix1) {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix1.length == 0 || matrix1[0].length == 0) return result;

        int top = 0;
        int bottom = matrix1.length - 1;
        int left = 0;
        int right = matrix1[0].length - 1;

        while (true) {
            for (int i = left; i <= right; i++) result.add(matrix1[top][i]);
            top++;
            if (left > right || top > bottom) break;

            for (int i = top; i <= bottom; i++) result.add(matrix1[i][right]);
            right--;
            if (left > right || top > bottom) break;

            for (int i = right; i >= left; i--) result.add(matrix1[bottom][i]);
            bottom--;
            if (left > right || top > bottom) break;

            for (int i = bottom; i >= top; i--) result.add(matrix1[i][left]);
            left++;
            if (left > right || top > bottom) break;
        }
        return result;
}

    public static List<Integer> spiralOrderTwo(int[][] matrix2) {
        List<Integer> result = new ArrayList<>();
        if (matrix2 == null || matrix2.length == 0) {
            return result;
        }

        int rows = matrix2.length, cols = matrix2[0].length;
        int left = 0, right = cols-1, top = 0, bottom = rows-1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result.add(matrix2[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result.add(matrix2[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix2[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix2[i][left]);
                }
                left++;
            }
        }

        return result;
    }
}