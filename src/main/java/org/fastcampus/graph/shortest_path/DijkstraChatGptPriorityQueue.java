package org.fastcampus.graph.shortest_path;

import java.util.*;

public class DijkstraChatGptPriorityQueue {
    private static final int INF = Integer.MAX_VALUE;

    public static void dijkstra(int[][] graph, int start) {
        int n = graph.length;
        int[] distance = new int[n];
        Arrays.fill(distance, INF);
        distance[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int u = node.vertex;

            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && distance[u] != INF && distance[u] + graph[u][v] < distance[v]) {
                    distance[v] = distance[u] + graph[u][v];
                    pq.offer(new Node(v, distance[v]));
                }
            }
        }

        printResult(distance);
    }

    private static void printResult(int[] distance) {
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < distance.length; i++) {
            System.out.println(i + "\t\t" + distance[i]);
        }
    }

    static class Node {
        int vertex;
        int distance;

        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        dijkstra(graph, 0);
    }
}

