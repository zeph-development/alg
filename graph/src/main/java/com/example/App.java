package com.example;

import java.util.*;


class DepthFirstTraversal {
    private final Map<String, String[]> graph;

    public DepthFirstTraversal(Map<String, String[]> graph) {
        this.graph = graph;
    }

    public void dft(String firstNode) {
        Set<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();
        stack.push(firstNode);

        while (stack.size() > 0) {
            String current = stack.pop();
            System.out.println(current);
            visited.add(current);

            for (String node : graph.get(current)) {
                if (!visited.contains(node)) {
                    stack.push(node);
                }
            }
        }
    }
}

class BreadthFirstTraversal {

    private final Map<String, String[]> graph;

    public BreadthFirstTraversal(Map<String, String[]> graph) {
        this.graph = graph;
    }

    public void bft(String firstNode) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(firstNode);

        while (queue.size() > 0) {
            String current = queue.poll();
            System.out.println(current);
            visited.add(current);

            for (String node : graph.get(current)) {
                if (!visited.contains(node)) {
                    queue.add(node);
                }
            }
        }
    }
}

class DepthFirstPath {

    private final Map<String, String[]> graph;

    public DepthFirstPath(Map<String, String[]> graph) {
        this.graph = graph;
    }

    public boolean hasPathR(Map<String, String[]> graph, Set<String> visited, String src, String dsc) {
        if (src.equals(dsc)) {
            return true;
        }

        String[] currentNodes = graph.get(src);
        for (String currentNode : currentNodes) {
            visited.add(currentNode);
            if (!visited.contains(currentNode) && hasPathR(graph, visited, currentNode, dsc)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasPath(Map<String, String[]> graph, String src, String dsc) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(src);

        while (queue.size() > 0) {
            String current = queue.poll();
            if (current.equals(dsc)) {
                return true;
            }

            visited.add(current);
            for (String currentNode : graph.get(current)) {
                if (!visited.contains(currentNode)) {
                    queue.add(currentNode);
                }
            }
        }
        return false;
    }
}



public class App {

    public static void main(String[] args) {
        Map<String, String[]> bidirectionalGraph = new HashMap<>();

        bidirectionalGraph.put("b", new String[]{"d", "a"});
        bidirectionalGraph.put("a", new String[]{"b", "c"});
        bidirectionalGraph.put("c", new String[]{"e", "a"});
        bidirectionalGraph.put("d", new String[]{"f", "b"});
        bidirectionalGraph.put("e", new String[]{"c"});
        bidirectionalGraph.put("f", new String[]{"d"});

//        new DepthFirstTraversal(bidirectionalGraph).dft("a");
//        new BreadthFirstTraversal(bidirectionalGraph).bft("a");

//        Set<String> visitedNodes = new HashSet<>();
//        boolean has = false;
//        has = new DepthFirstPath(bidirectionalGraph).hasPathR(bidirectionalGraph, visitedNodes, "a", "d");

//        has = new DepthFirstPath(bidirectionalGraph).hasPath(bidirectionalGraph, "a", "z");
//        System.out.println(has);

        String[][] edges = new String[][]{{"a", "b"}, {"a", "c"}, {"c", "d"}, {"b", "e"}};





        System.out.println("Finish!");
    }
}
