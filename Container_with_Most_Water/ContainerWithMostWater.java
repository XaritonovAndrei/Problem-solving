package com.problem_solving.Arrays.Container_with_Most_Water;


//You are given an integer array height of length n.
// There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

//Find two lines that together with the x-axis form a container,
// such that the container contains the most water.

//Return the maximum amount of water a container can store.
//Notice that you may not slant the container.

//Example 1:
//Input: height = [1,8,6,2,5,4,8,3,7]
//Output: 49
//Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

//Example 2:
//Input: height = [1,1]
//Output: 1

import java.util.Arrays;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] array = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println("max amount of water for array " + Arrays.toString(array) + " is " + findContainerArea(array));
    }

    public static int findContainerArea(int[] array) {

        int maxArea = 0;
        int leftPointer = 0;
        int rightPointer = array.length - 1;

        while (leftPointer < rightPointer) {

            int minHeight = Math.min(array[leftPointer], array[rightPointer]);
            int length = rightPointer - leftPointer;
            int area = minHeight * length;
            maxArea = Math.max(maxArea, area);

            if (array[leftPointer] < array[rightPointer]) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }

        return maxArea;
    }
}
