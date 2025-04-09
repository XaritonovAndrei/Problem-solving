package com.problem_solving.BFS.Number_of_Connected_Components;

//You have a graph of N nodes and array of edges,
//where edges[i] = [ai, bi] indicated that there is an edge between ai and bi.
//Return the number of conencted components in the graph.

import com.problem_solving.BFS.UndirectedGraph;
import com.problem_solving.BFS.Vertex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfConnectedComponents {
    public static void main(String[] args) {

        int N = 9;
        int[][] array = {{0, 1}, {1, 2}, {2, 3}, {2, 4}, {5, 6}, {6, 7}, {5, 7}, {8, 8}};
        UndirectedGraph undirectedGraph = new UndirectedGraph(N);
        undirectedGraph.addEdge(0, 1);
        undirectedGraph.addEdge(1, 2);
        undirectedGraph.addEdge(2, 3);
        undirectedGraph.addEdge(2, 4);
        undirectedGraph.addEdge(5, 6);
        undirectedGraph.addEdge(5, 7);
        undirectedGraph.addEdge(6, 7);
        undirectedGraph.addEdge(8, 8);
        undirectedGraph.printGraph();

        System.out.println("Number of connected components: " + countComponentsDFS(N, array));
        System.out.println("Number of connected components: " + countComponentsBFS(N, array));

    }

    public static int countComponentsDFS(int n, int[][] edges) {

        int counter = 0;
        int[] visited = new int[n];

        List<Integer>[] adjList = new ArrayList[n];
        for(int i=0; i<n; i++){
            adjList[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<edges.length; i++){
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }

        for(int i=0; i<n; i++){
            if(visited[i] == 0){
                counter++;
                dfs(adjList,visited, i);
            }
        }

        return counter;
    }

    public static void dfs(List<Integer>[] adjList, int[] visited, int node){
        visited[node] = 1;

        for(int i=0; i<adjList[node].size(); i++){
            if(visited[adjList[node].get(i)] == 0){
                dfs(adjList, visited, adjList[node].get(i));
            }
        }
    }

    public static int countComponentsBFS(int n, int[][] array) {

        List<List<Integer>> graphL = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graphL.add(new ArrayList<>());
        }

        for (int[] edge : array) {
            int from = edge[0];
            int to = edge[1];
            graphL.get(from).add(to);
            graphL.get(to).add(from);
        }

        boolean[] visited = new boolean[n];
        int counter = 0;
        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                bfs(graphL, visited, i);
                counter++;
            }
        }
        return counter;
    }

    public static void bfs(List<List<Integer>> graphL, boolean[] visited, int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visited[i] = true;

        while(!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int neighbor : graphL.get(currentNode)) {
                if(!visited[neighbor]) {
                    visited[currentNode] = true;
                    queue.offer(neighbor);
                }
            }
        }

    }

}
