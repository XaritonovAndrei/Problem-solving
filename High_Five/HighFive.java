package com.problem_solving.High_Five;

//Given a list of scores of different students,
//      return the average score of each student's top five scores in the order of each student's id.

//Each entry items[i] has items[i][0] the student's id,
//      and items[i][1] the student's score.
//The average score is calculated using integer division.

import java.util.*;

class HighFive {

    public static void main(String[] args) {
        int[][] studs = {{1,45}, {1,23}, {2,17}, {2,30}, {3, 33}};
        System.out.println(Arrays.deepToString(highFive(studs)));
    }

    public static int[][] highFive(int[][] items) {

        Map<Integer, Queue<Integer>> scores = new TreeMap<>();

        for(int[] item: items){
            int id = item[0];
            int score = item[1];

            if(!scores.containsKey(id)){
                scores.put(id, new PriorityQueue<>((a, b) -> b-a));
            }
            scores.get(id).add(score);
        }

        List<int[]> ans = new ArrayList<>();

        for(int id:scores.keySet()){
            int sum=0;

            for(int i=0; i<5; i++){
                sum = sum+scores.get(id).poll();
            }

            ans.add(new int[]{id, sum/5});
        }

        int[][] ansArray = new int[ans.size()][];

        return ans.toArray(ansArray);
    }
}

