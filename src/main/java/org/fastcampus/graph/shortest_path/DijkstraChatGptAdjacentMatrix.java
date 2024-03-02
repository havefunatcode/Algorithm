package org.fastcampus.graph.shortest_path;

import java.util.Arrays;

public class DijkstraChatGptAdjacentMatrix {

    private static final int INF = Integer.MAX_VALUE;

    public static void dijkstra(int[][] graph, int start) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        int[] distance = new int[n];

        Arrays.fill(distance, INF);
        distance[start] = 0;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = findMinDistanceIndex(distance, visited);
            visited[minIndex] = true;

            for (int j = 0; j < n; j++) {
                if (!visited[j] && graph[minIndex][j] != 0 && distance[minIndex] != INF &&
                        distance[minIndex] + graph[minIndex][j] < distance[j]) {
                    distance[j] = distance[minIndex] + graph[minIndex][j];
                }
            }
        }

        printResult(distance);
    }

    private static int findMinDistanceIndex(int[] distance, boolean[] visited) {
        int minIndex = -1;
        int minDistance = INF;

        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && distance[i] <= minDistance) {
                minDistance = distance[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    private static void printResult(int[] distance) {
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < distance.length; i++) {
            System.out.println(i + "\t\t" + distance[i]);
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
