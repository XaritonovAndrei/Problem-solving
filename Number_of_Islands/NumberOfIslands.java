package com.problem_solving.Number_of_Islands;

//Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
//return the number of islands.

//An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
//You may assume all four edges of the grid are all surrounded by water.

//Example 1:
//Input: grid = [
//        ["1","1","1","1","0"],
//        ["1","1","0","1","0"],
//        ["1","1","0","0","0"],
//        ["0","0","0","0","0"]
//        ]
//Output: 1

//Example 2:
//Input: grid = [
//        ["1","1","0","0","0"],
//        ["1","1","0","0","0"],
//        ["0","0","1","0","0"],
//        ["0","0","0","1","1"]
//        ]
//Output: 3


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        char[][] grid2 = new char[][]{
                {'1', '1', '1', '0', '1'},
                {'1', '0', '1', '0', '1'},
                {'1', '0', '0', '0', '0'},
                {'0', '1', '0', '1', '1'}
        };

        System.out.println("Grid:");
        for (char[] e : grid) {
            System.out.println(Arrays.toString(e));
        }

        System.out.println("Islands counted by DFS, grid: " + islandsCounterDFS(grid));
        System.out.println("Islands counted by BFS, grid2: " + islandsCounterBFS(grid2));

    }



    public static int islandsCounterDFS(char[][] grid) {

        if (grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int columns = grid[0].length;

        int islandCounterDFS = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == '1') {
                    islandCounterDFS++;
                    dfs(grid, i, j);
                }
            }
        }
        return islandCounterDFS;
    }

    public static int islandsCounterBFS(char[][] grid) {

        if (grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int columns = grid[0].length;

        int islandCounterBFS = 0;
        boolean[][] visited = new boolean[rows][columns];
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    bfs(grid, queue, visited);
                    islandCounterBFS++;
                }
            }
        }
        return islandCounterBFS;
    }

    public static void dfs(char[][] grid, int i, int j) {

        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';

        dfs(grid, i, j + 1); // >
        dfs(grid, i, j - 1); // <
        dfs(grid, i - 1, j); // ^
        dfs(grid, i + 1, j); // v
    }


    private static void bfs(char[][] grid, Queue<int[]> queue, boolean[][] visited) {

        int[][] directories = {{0,1}, {1,0}, {0, -1}, {-1, 0}};

        int rows = grid.length;
        int columns = grid[0].length;

        while(!queue.isEmpty()) {
            int[] currentNode = queue.poll();
            for (int[] directory : directories) {
                int x = currentNode[0] + directory[0]; // check out of bounds for rows
                int y = currentNode[1] + directory[1]; // check out of bounds for columns

                if (x < 0 || x >= rows || y < 0 || y >= columns || visited[x][y] == true || grid[x][y] == '0') {
                    continue;
                }

                visited[x][y] = true;
                queue.offer(new int[]{x, y});
            }
        }
    }
}
