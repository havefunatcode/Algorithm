package org.fastcampus.graph.search;

import org.fastcampus.graph.Graph;

import java.util.*;

public class Dfs {

    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> graph = Graph.graph();
        System.out.println(dfs(graph, "A"));
    }

    private static ArrayList<String> dfs(HashMap<String, ArrayList<String>> graph, String startedPoint) {
        ArrayList<String> visited = new ArrayList<>();
        Stack<String> needVisit = new Stack<>();
        needVisit.push(startedPoint);

        while (needVisit.size() > 0) {
            String currentNode = needVisit.pop();

            if (!visited.contains(currentNode)) {
                visited.add(currentNode);
                needVisit.addAll(graph.get(currentNode));
            }
        }

        return visited;
    }

}
