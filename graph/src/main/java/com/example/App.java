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
                if(!visited.contains(node)){
                    stack.push(node);
                }
            }
        }
    }
}

class BreadthFirstTraversal {

    private final Map<String, String[]> graph;
    public BreadthFirstTraversal(Map<String, String[]> graph){
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
                if(!visited.contains(node)){
                    queue.add(node);
                }
            }
        }
    }
}

public class App {

    public static void main(String[] args) {
        Map<String, String[]> map = new HashMap<>();
        map.put("b", new String[]{"d", "a"});
        map.put("a", new String[]{"b", "c"});
        map.put("c", new String[]{"e", "a"});
        map.put("d", new String[]{"f", "b"});
        map.put("e", new String[]{"c"});
        map.put("f", new String[]{"d"});

//        new DepthFirstTraversal(map).dft("a");
        new BreadthFirstTraversal(map).bft("a");
        System.out.println("Finish!");
    }

}
