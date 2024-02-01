package org.fastcampus.graph.search;

import org.fastcampus.graph.Graph;

import java.util.*;

public class Bfs {

    public static void main(String[] args) {
        ArrayList<String> result = bfs(Graph.graph(), "A");
        System.out.println(result);
    }

    private static ArrayList<String> bfs(HashMap<String, ArrayList<String>> graph, String startNode) {
        ArrayList<String> visited = new ArrayList<>();
        Queue<String> needVisit = new LinkedList<>();

        needVisit.add(startNode);

        while (needVisit.size() > 0) {
            String currentNode = needVisit.poll();
            if (visited.contains(currentNode)) {
                continue;
            }

            visited.add(currentNode);
            needVisit.addAll(graph.get(currentNode));
        }

        return visited;
    }

}
