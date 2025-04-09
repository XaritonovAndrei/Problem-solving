package com.problem_solving.BFS;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    int id;
    List<Vertex> neighbors;

    public Vertex(int id) {
        this.id = id;
        // Each vertex can have many neighbors.
        this.neighbors = new ArrayList<>();
    }

    // Adds a neighbor if it isn't already present.
    public void addNeighbor(Vertex neighbor) {
        if (!neighbors.contains(neighbor)) {
            neighbors.add(neighbor);
        }
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
