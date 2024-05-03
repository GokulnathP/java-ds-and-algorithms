package com.gokulnathp.datastractures;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {
    @Nested
    class AddVertex {
        @Test
        void shouldAddVertexToEmptyGraph() {
            Graph graph = new Graph();

            assertTrue(graph.addVertex("A"));
            assertEquals(Map.of("A", List.of()), graph.getAdjList());
        }

        @Test
        void shouldAddVertexToGraph() {
            Graph graph = new Graph();
            graph.addVertex("A");

            assertTrue(graph.addVertex("B"));
            assertEquals(Map.of("A", List.of(), "B", List.of()), graph.getAdjList());
        }

        @Test
        void shouldNotAddVertexIfAlreadyExist() {
            Graph graph = new Graph();
            graph.addVertex("A");

            assertFalse(graph.addVertex("A"));
            assertEquals(Map.of("A", List.of()), graph.getAdjList());
        }
    }

    @Nested
    class AddEdge {
        @Test
        void shouldAddEdge() {
            Graph graph = new Graph();
            graph.addVertex("A");
            graph.addVertex("B");

            assertTrue(graph.addEdge("A", "B"));
            assertEquals(Map.of("A", List.of("B"), "B", List.of("A")), graph.getAdjList());
        }

        @Test
        void shouldNotAddEdgeIfOneVertexIsMissing() {
            Graph graph = new Graph();
            graph.addVertex("A");

            assertFalse(graph.addEdge("A", "B"));
            assertEquals(Map.of("A", List.of()), graph.getAdjList());
        }

        @Test
        void shouldNotAddEdgeIfBothVertexIsMissing() {
            Graph graph = new Graph();

            assertFalse(graph.addEdge("A", "B"));
            assertEquals(Map.of(), graph.getAdjList());
        }
    }

    @Nested
    class RemoveEdge {
        @Test
        void shouldRemoveEdge() {
            Graph graph = new Graph();
            graph.addVertex("A");
            graph.addVertex("B");
            graph.addEdge("A", "B");

            assertTrue(graph.removeEdge("A", "B"));
            assertEquals(Map.of("A", List.of(), "B", List.of()), graph.getAdjList());
        }

        @Test
        void shouldReturnFalseWhenOneVertexIsMissing() {
            Graph graph = new Graph();
            graph.addVertex("A");

            assertFalse(graph.removeEdge("A", "B"));
            assertEquals(Map.of("A", List.of()), graph.getAdjList());
        }

        @Test
        void shouldReturnFalseWhenBothVertexIsMissing() {
            Graph graph = new Graph();

            assertFalse(graph.removeEdge("A", "B"));
            assertEquals(Map.of(), graph.getAdjList());
        }
    }

    @Nested
    class RemoveVertex {
        @Test
        void shouldRemoveVertexWithEdges() {
            Graph graph = new Graph();
            graph.addVertex("A");
            graph.addVertex("B");
            graph.addEdge("A", "B");

            assertTrue(graph.removeVertex("A"));
            assertEquals(Map.of("B", List.of()), graph.getAdjList());
        }

        @Test
        void shouldRemoveVertexWithNoEdges() {
            Graph graph = new Graph();
            graph.addVertex("A");
            graph.addVertex("B");

            assertTrue(graph.removeVertex("A"));
            assertEquals(Map.of("B", List.of()), graph.getAdjList());
        }

        @Test
        void shouldReturnFalseWhenVertexIsMissing() {
            Graph graph = new Graph();

            assertFalse(graph.removeVertex("A"));
            assertEquals(Map.of(), graph.getAdjList());
        }
    }
}