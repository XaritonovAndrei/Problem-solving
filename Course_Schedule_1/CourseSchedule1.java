package com.problem_solving.BFS.Course_Schedule_1;

//There are a total of numCourses courses you have to take,
// labeled from 0 to numCourses - 1.
// You are given an array prerequisites,
// where prerequisites[i] = [ai, bi] indicates
// that you must take course bi first if you want to take course ai.

//For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
//Return true if you can finish all courses. Otherwise, return false.

//Example 1:
//Input: numCourses = 2, prerequisites = [[1,0]]
//Output: true
//Explanation: There are a total of 2 courses to take.
//To take course 1 you should have finished course 0. So it is possible.

//Example 2:
//Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
//Output: false
//Explanation: There are a total of 2 courses to take.
//To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.


import jdk.jshell.spi.SPIResolutionException;

import java.util.*;

public class CourseSchedule1 {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequsites = {{1,0}, {0,1}};
        System.out.println(finishCheck(numCourses, prerequsites));
    }

    public static boolean finishCheck(int numCourses, int[][] prerequsutes) {
        Map<Integer, List<Integer>> courseMap = new HashMap<>();

        for (int[] pair : prerequsutes) {
            if (courseMap.containsKey(pair[1])) {
                courseMap.get(pair[1]).add(pair[0]);
            }
            else{
            LinkedList<Integer> nextCourses = new LinkedList<>();
            nextCourses.add(pair[0]);
            courseMap.put(pair[1], nextCourses);
        }
    }

        // cycle checker
        HashSet<Integer> cycleChecker = new HashSet<>();
        for (int currentCourse = 0; currentCourse < numCourses; currentCourse++){
            if (courseSchedule(currentCourse, courseMap, cycleChecker) == false) {
                return false;
            }
        }
        return true;
    }

    public static boolean courseSchedule(int currentCourse,
                                         Map<Integer, List<Integer>> courseMap,
                                         HashSet<Integer> cycleChecker) {

        if(cycleChecker.contains(currentCourse)) return false;

        if(courseMap.get(currentCourse) == null) return true;

        cycleChecker.add(currentCourse);

        for(int pair: courseMap.get(currentCourse)){
            if(courseSchedule(pair, courseMap, cycleChecker) == false){
                return false;
            }
        }

        cycleChecker.remove(currentCourse);
        courseMap.put(currentCourse,null);
        return true;
    }

}
