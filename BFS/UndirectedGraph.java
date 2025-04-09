package com.problem_solving.BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UndirectedGraph {
    // Map to store vertices by their id for quick lookup.
    private Map<Integer, Vertex> vertexMap;

    public UndirectedGraph() {
        vertexMap = new HashMap<>();
    }

    // Constructor that pre-creates vertices from 0 to (numVertices - 1)
    public UndirectedGraph(int numVertices) {
        vertexMap = new HashMap<>();
        // Pre-create the vertices
        for (int i = 0; i < numVertices; i++) {
            vertexMap.put(i, new Vertex(i));
        }
    }

    // Retrieves an existing vertex or creates a new one if it doesn't exist.
    public Vertex getOrCreateVertex(int id) {
        if (!vertexMap.containsKey(id)) {
            vertexMap.put(id, new Vertex(id));
        }
        return vertexMap.get(id);
    }

    // Adds an undirected edge between src and dest.
    public void addEdge(int src, int dest) {
        Vertex vertexSrc = getOrCreateVertex(src);
        Vertex vertexDest = getOrCreateVertex(dest);
        // For an undirected graph, add each vertex as a neighbor to the other.
        vertexSrc.addNeighbor(vertexDest);
        vertexDest.addNeighbor(vertexSrc);
    }

    // Prints the graph with each vertex and its list of neighbors.
    public void printGraph() {
        for (Vertex vertex : vertexMap.values()) {
            System.out.print("Vertex " + vertex.id + " neighbors: ");
            for (Vertex neighbor : vertex.neighbors) {
                System.out.print(neighbor.id + " ");
            }
            System.out.println();
        }
    }

    // New method: Returns the neighbors of the vertex with the given id.
    public List<Vertex> getNeighbors(int id) {
        Vertex vertex = vertexMap.get(id);
        // Return an empty list if the vertex doesn't exist.
        return vertex != null ? vertex.neighbors : new ArrayList<>();
    }

    // Main method to demonstrate the graph implementation
    public static void main(String[] args) {
        // Create an undirected graph with 5 vertices (0 through 4)
        UndirectedGraph graph = new UndirectedGraph(9);

        // Adding some edges
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);
        graph.addEdge(8, 8);

        // Print the adjacency list of the graph
        System.out.println("Undirected Graph Adjacency List:");
        graph.printGraph();
    }
}
