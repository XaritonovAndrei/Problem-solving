package com.problem_solving.Meeting_Rooms;

//Given an array of meeting times "intervals",
//where intervals[i] = [start-i, end-i],
//determine if a person can attend all meetings.
//
//Example 1:
//input: intervals[][] = {{0, 30}, {5, 10}, {15, 20}};
//output: false

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MeetingRooms {
    public static void main(String[] args) {
        int [][] intervals1 = {{0, 30}, {5, 10}, {15, 20}};
        int [][] intervals2 = {{15, 20}, {0, 30}, {5, 10}};
        int [][] intervals3 = {{3, 6}, {18, 22}, {12, 15}};

        System.out.println("interval 1: " + Arrays.deepToString(intervals1) + " " + meetingRooms(intervals1));
        System.out.println("interval 2: " + Arrays.deepToString(intervals2) + " " + meetingRooms(intervals2));
        System.out.println("interval 3: " + Arrays.deepToString(intervals3) + " " + meetingRooms(intervals3));
    }

    public static boolean meetingRooms(int[][] intervals) {
        //        Arrays.sort(intervals2, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }
}
