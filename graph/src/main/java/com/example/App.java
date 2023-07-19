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

class DetectCycle {

    private final Map<String, String[]> graph;

    DetectCycle(Map<String, String[]> graph) {
        this.graph = graph;
    }

    public boolean isCycle(String current, Set<String> visited, Set<String> recStack) {

        if (recStack.contains(current)) {
            return true;
        }

        if (visited.contains(current)) {
            return false;
        }

        recStack.add(current);
        visited.add(current);

        String[] children = graph.get(current);
        if (children != null) {
            for (String child : children) {
                if (isCycle(child, visited, recStack)) {
                    return true;
                }
            }
        }


        recStack.remove(current);
        return false;
    }

    public boolean detectCycle() {
        int graphSize = graph.keySet().size();
        Set<String> recStack = new HashSet<>(graphSize);
        Set<String> visited = new HashSet<>(graphSize);

        for (String node : graph.keySet()) {
            if (isCycle(node, visited, recStack)) {
                return true;
            }
        }
        return false;
    }
}

public class App {

    public static void main(String[] args) {
        Map<String, String[]> graph = new HashMap<>();
        graph.put("b", new String[]{"d", "a"});
        graph.put("a", new String[]{"b", "c"});
        graph.put("c", new String[]{"e", "a"});
        graph.put("d", new String[]{"f", "b"});
        graph.put("e", new String[]{"c"});
        graph.put("f", new String[]{"d"});

//        new DepthFirstTraversal(graph).dft("a");
//        new BreadthFirstTraversal(graph).bft("a");

        Map<String, String[]> unidirectionalGraph = new HashMap<>();
        unidirectionalGraph.put("a", new String[]{"b"});
        unidirectionalGraph.put("b", new String[]{"c"});
        unidirectionalGraph.put("c", new String[]{"d"});
        unidirectionalGraph.put("d", new String[]{"e"});
        unidirectionalGraph.put("e", new String[]{"b"});

        boolean isCycle = new DetectCycle(unidirectionalGraph).detectCycle();
        System.out.println(isCycle);
    }

}
