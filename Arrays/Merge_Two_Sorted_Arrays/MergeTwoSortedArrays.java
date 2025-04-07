package com.problem_solving.Arrays.Merge_Two_Sorted_Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3, n = 3;
        System.out.println(Arrays.toString(nums1) + " merges with " + Arrays.toString(nums2));
        merge(nums1, m, nums2, n);
        System.out.println("result is " + Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

            // Pointers for nums1, nums2, and the end of the merged array
            int p1 = m - 1, p2 = n - 1, i = m + n - 1;

            // Merge in reverse order
            while (p2 >= 0) {
                if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                    nums1[i] = nums1[p1];
                    p1--;
                } else {
                    nums1[i] = nums2[p2];
                    p2--;
                }
                i--;
            }
        }
    }

