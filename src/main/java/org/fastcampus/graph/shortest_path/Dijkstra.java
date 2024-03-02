package org.fastcampus.graph.shortest_path;

import org.fastcampus.graph.Edge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Dijkstra {

    public static void main(String[] args) {
        HashMap<String, ArrayList<Edge>> graph = getGraph();
        HashMap<String, Integer> result = dijkstra(graph, "A");
        System.out.println(result);
    }

    private static HashMap<String, Integer> dijkstra(HashMap<String, ArrayList<Edge>> graph, String start) {
        HashMap<String, Integer> distances = init(graph, start);
        PriorityQueue<Edge> edges = new PriorityQueue<>();
        edges.offer(new Edge(distances.get(start),  start));

        while (!edges.isEmpty()) {
            Edge currentEdge = edges.poll();
            int currentDistance = currentEdge.getDistance();
            String currentVertex = currentEdge.getVertex();

            if (distances.get(currentVertex) < currentDistance) {
                continue;
            }

            ArrayList<Edge> connectedNodes = graph.get(currentVertex);
            for (Edge adjacntNode : connectedNodes) {
                String adjacentVertex = adjacntNode.getVertex();
                int adjacentDistance = adjacntNode.getDistance();

                int distance = currentDistance + adjacentDistance;

                if (distance < distances.get(adjacentVertex)) {
                    distances.put(adjacentVertex, distance);
                    edges.offer(new Edge(distance, adjacentVertex));
                }
            }

        }

        return distances;
    }

    private static HashMap<String, Integer> init(HashMap<String, ArrayList<Edge>> graph, String start) {
        HashMap<String, Integer> distances = new HashMap<>();
        for (String key : graph.keySet()) {
            distances.put(key, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        return distances;
    }

    private static HashMap<String, ArrayList<Edge>> getGraph() {
        HashMap<String, ArrayList<Edge>> graph = new HashMap<>();
        graph.put("A", new ArrayList<Edge>(Arrays.asList(new Edge(8, "B"), new Edge(1, "C"), new Edge(2, "D"))));
        graph.put("B", new ArrayList<Edge>());
        graph.put("C", new ArrayList<Edge>(Arrays.asList(new Edge(5, "B"), new Edge(2, "D"))));
        graph.put("D", new ArrayList<Edge>(Arrays.asList(new Edge(3, "E"), new Edge(5, "F"))));
        graph.put("E", new ArrayList<Edge>(Arrays.asList(new Edge(1, "F"))));
        graph.put("F", new ArrayList<Edge>(Arrays.asList(new Edge(5, "A"))));
        return graph;
    }

}
