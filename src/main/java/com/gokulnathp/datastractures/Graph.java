package com.gokulnathp.datastractures;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    private final HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    public boolean addVertex(String vertex) {
        if(adjList.containsKey(vertex)) return false;

        adjList.put(vertex, new ArrayList<>());
        return true;
    }

    public boolean addEdge(String vertex1, String vertex2) {
        if (!adjList.containsKey(vertex1) || !adjList.containsKey(vertex2)) return false;

        adjList.get(vertex1).add(vertex2);
        adjList.get(vertex2).add(vertex1);
        return true;
    }

    public boolean removeEdge(String vertex1, String vertex2) {
        if (!adjList.containsKey(vertex1) || !adjList.containsKey(vertex2)) return false;

        adjList.get(vertex1).remove(vertex2);
        adjList.get(vertex2).remove(vertex1);
        return true;
    }

    public boolean removeVertex(String vertex) {
        if (!adjList.containsKey(vertex)) return false;

        for(String otherVertex: adjList.get(vertex)) adjList.get(otherVertex).remove(vertex);
        adjList.remove(vertex);
        return true;
    }

    public HashMap<String, ArrayList<String>> getAdjList() {
        return adjList;
    }
}
