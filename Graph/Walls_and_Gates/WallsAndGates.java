package com.problem_solving.Graph.Walls_and_Gates;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//You are given a m x n 2D grid initialized with these three possible values.

//-1 - A wall or an obstacle.
//0 - A gate.
//INF - Infinity means an empty room.
// We use the value 231 - 1 = 2147483647 to represent INF
//      as you may assume that the distance to a gate is less than 2147483647.
//Fill each empty room with the distance to its nearest gate.
// If it is impossible to reach a gate, it should be filled with INF.


public class WallsAndGates {
    public static void main(String[] args) {
       int[][] rooms =  {{INF, -1, 0, INF},
                        {INF, INF, INF, -1},
                        {INF, -1, INF, -1},
                        {0, -1, INF, INF}};
       System.out.println("Before:" + "\n" + Arrays.deepToString(rooms));
       wallsAndGates(rooms);
       System.out.println("After:" + "\n" + Arrays.deepToString(rooms));
    }

    private static final int INF = 2147483647;
    private static final int[] DIRS = {0, 1, 0, -1, 0}; // 4-directional (right, down, left, up)

    public static void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;

        int m = rooms.length, n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // Add gates to the queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // BFS from each gate
        while (!queue.isEmpty()) {
            int[] gate = queue.poll();
            int row = gate[0];
            int col = gate[1];

            for (int i = 0; i < 4; i++) { // Explore 4 directions
                int newRow = row + DIRS[i];
                int newCol = col + DIRS[i + 1];

                // Check boundaries and if the cell is an empty room
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && rooms[newRow][newCol] == INF) {
                    rooms[newRow][newCol] = rooms[row][col] + 1; // Update distance
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }
}
