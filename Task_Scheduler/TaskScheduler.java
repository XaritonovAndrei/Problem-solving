package com.problem_solving.Task_Scheduler;

//You are given an array of CPU tasks,
//      each labeled with a letter from A to Z, and a number n.
// Each CPU interval can be idle or allow the completion of one task.
// Tasks can be completed in any order,
//      but there's a constraint: there has to be a gap of at least n intervals
//      between two tasks with the same label.

//Return the minimum number of CPU intervals required to complete all tasks.

import java.util.*;

class Solution {

    public static void main(String[] args) {
        String[] tasks = {"A","A","A","B","B","B"};
        int n = 2;
    }

    public int leastInterval(char[] tasks, int n) {
        // frequency map for each task
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char task : tasks) {
            freqMap.put(task, freqMap.getOrDefault(task, 0) + 1);
        }

        // max heap of frequencies
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(freqMap.values());

        int time = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                if (!maxHeap.isEmpty()) {
                    temp.add(maxHeap.poll());
                }
            }

            for (int freq : temp) {
                if (--freq > 0) {
                    maxHeap.add(freq);
                }
            }
            
            time += maxHeap.isEmpty() ? temp.size() : n + 1;
        }

        return time;
    }
}