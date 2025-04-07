package com.problem_solving.Arrays.Top_K_Frequent_Elements;

import java.util.*;
//Given an integer array nums and an integer k, return the k most frequent elements.
// You may return the answer in any order.

//Example 1:
//Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]

//Example 2:
//Input: nums = [1], k = 1
//Output: [1]

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3,3,3,3,3,3,4};
        int k = 2;
        findElements(nums, k);
    }

    public static int[] findElements(int[] nums, int k) {
        HashMap<Integer, Integer> elementCounter = new HashMap<>();
        for(int element : nums) {
            elementCounter.put(element, elementCounter.getOrDefault(element, 0) + 1);
        }
        System.out.println("map: " + elementCounter);
        Queue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(elementCounter::get));
        for(int mapKey : elementCounter.keySet()) {
            heap.add(mapKey);
            if(heap.size() > k) {
                heap.poll();
            }
        }
        System.out.println("heap: " + heap);

        int[] answer = new int[k];
        for(int i=0; i<k; i++){
            answer[i] = heap.poll();
        }

        return answer;
    }

}
