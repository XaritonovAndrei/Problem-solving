package com.problem_solving.Meeting_Rooms2;

//Given an array of meeting times "intervals",
//where intervals[i] = [start-i, end-i],
//determine minumum number of required rooms.
//
//Example 1:
//input: intervals[][] = {{0, 30}, {5, 10}, {15, 20}};
//output: false

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms2 {
    public static void main(String[] args) {
        int [][] intervals1 = {{0, 30}, {5, 10}, {15, 20}};
        int [][] intervals2 = {{15, 20}, {0, 30}, {5, 10}};
        int [][] intervals3 = {{3, 6}, {18, 22}, {12, 15}};

        System.out.println("interval 1: " + Arrays.deepToString(intervals1) + " required rooms: " + meetingRooms2(intervals1));
        System.out.println("interval 2: " + Arrays.deepToString(intervals2) + " required rooms:  " + meetingRooms2(intervals2));
        System.out.println("interval 3: " + Arrays.deepToString(intervals3) + " required rooms:  " + meetingRooms2(intervals3));
    }

    public static int meetingRooms2(int[][] intervals) {

        if(intervals.length == 0){
            return 0;
        }

        int[] startIndex= new int[intervals.length];
        int[] endIndex = new int[intervals.length];

        for(int i = 0; i < intervals.length; i++) {
            startIndex[i] = intervals[i][0];
            endIndex[i] = intervals[i][1];
        }

        Arrays.sort(startIndex);
        Arrays.sort(endIndex);

        int startPointer = 0;
        int endPointer = 0;

        int meetingCounter = 0;

        while(startPointer < startIndex.length) {

            if (startIndex[startPointer] >= endIndex[endPointer]) {
                meetingCounter--;
                endPointer++;
            }
            meetingCounter++;
            startPointer++;
        }

        return meetingCounter;
    }
}
