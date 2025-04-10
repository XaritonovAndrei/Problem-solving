package com.problem_solving.BFS.Number_of_Provinces;

import java.util.*;

//There are n cities. Some of them are connected, while some are not.
// If city a is connected directly with city b, and city b is connected directly with city c,
// then city a is connected indirectly with city c.

//A province is a group of directly or indirectly connected cities
// and no other cities outside of the group.

//You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city
// and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

//Return the total number of provinces.

//Example 1:
//Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//Output: 2

//Example 2:
//Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//Output: 3


public class NumberOfProvinces {

    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0}, {1,1,0}, {0,0,1}};
        System.out.println(countProvinces(isConnected));
        System.out.println(countProvincesV2(isConnected));
    }

    public static int countProvinces(int[][] isConnected) {

        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinceCounter = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(isConnected, visited, i);
                provinceCounter++;
            }
        }

        return provinceCounter;
    }

    private static void bfs(int[][] isConnected, boolean[] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int city = queue.poll();
            for (int i = 0; i < isConnected.length; i++) {
                if (isConnected[city][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }

    
    public static int countProvincesV2(int[][] isConnected) {

        int n = isConnected.length;
        // To create an adjacency list 'l'
        List<List<Integer>> l = new ArrayList<>();

        // Creating adjacency list from the adjacency matrix
        for (int i = 0; i < n; i++) {
            l.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    // Adding connected nodes to the adjacency list
                    l.get(i).add(j);
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        int count = 0; // Counter for connected components

        // Checking for each node whether it has any path or is part of a disjoint component
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                // Starting BFS from unvisited node
                q.add(i);
                visited.add(i);
                while (!q.isEmpty()) {
                    int current = q.poll();
                    for (int j : l.get(current)) {
                        if (!visited.contains(j)) {
                            q.add(j);
                            visited.add(j);
                        }
                    }
                }
                count++; // Increment count for each connected component found
            }
        }
        return count; // Returning the total count of connected components
    }

}
