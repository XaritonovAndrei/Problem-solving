package com.problem_solving.Arrays.Kth_Largest_Element_in_Array;

//Given an integer array nums and an integer k,
// return the kth largest element in the array.

//Note that it is the kth largest element in the sorted order, not the kth distinct element.

//Can you solve it without sorting?

//Example 1:
//Input: nums = [3,2,1,5,6,4], k = 2
//Output: 5

//Example 2:
//Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
//Output: 4

import java.io.FilterOutputStream;
import java.util.PriorityQueue;

public class KthLargestElementInArray {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
            return minHeap.peek();

    }
}
