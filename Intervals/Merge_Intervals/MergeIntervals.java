package com.problem_solving.Intervals.Merge_Intervals;


//Given an array of intervals where intervals[i] = [starti, endi],
//merge all overlapping intervals, and return an array
//of the non-overlapping intervals that cover all the intervals in the input.

//Example 1:
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

//Example 2:
//Input: intervals = [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main (String[] args) {
        int[][] intervals = {{1,3}, {2,6}, {8, 10}, {15, 18}};
        Arrays.sort(intervals, (a, b) ->
            Integer.compare(a[0], b[0]));
        System.out.println(Arrays.deepToString(intervals));
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    public static int[][] merge(int[][] intervals) {

        List<int[]> mergedIntervals = new ArrayList<>();
        int[] previousInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            if (currentInterval[0] <= previousInterval[1]) {
                previousInterval[1] = Math.max(previousInterval[1], currentInterval[1]);
            } else {
                mergedIntervals.add(previousInterval);
                previousInterval = currentInterval;
            }
        }

        mergedIntervals.add(previousInterval);

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
