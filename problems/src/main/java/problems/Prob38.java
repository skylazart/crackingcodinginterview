package problems;

import java.util.*;

/**
 * Created by fsantos on 1/2/17.
 */
public class Prob38 {
    public static class Graph {
        private Map<String, List<String>> graph = new TreeMap<>();
        private Stack<String> inversePostOrder = new Stack<>();
        private Set<String> visited = new HashSet<>();

        public Graph() {

        }

        public List<String> addVertex(String s) {
            List<String> adj = graph.get(s);
            if (adj == null) {
                adj = new ArrayList<>();
                graph.put(s, adj);
                return adj;
            }

            return adj;
        }

        public void connect(String s, String d) {
            List<String> adj = addVertex(s);
            adj.add(d);
        }

        public Stack<String> calculateDependencies() {
            for (String k: graph.keySet())
                dfs(k);

            return inversePostOrder;
        }

        private void dfs(String s) {
            if (visited.contains(s)) return;
            visited.add(s);

            List<String> adj = graph.get(s);
            for (String x: adj)
                dfs(x);

            inversePostOrder.push(s);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        for (String s: Arrays.asList("a", "b", "c", "d", "e", "f")) {
            g.addVertex(s);
        }

        g.connect("a", "d");
        g.connect("f", "b");
        g.connect("b", "d");
        g.connect("f", "a");
        g.connect("d", "c");

        Stack<String> stack = g.calculateDependencies();
    }
}
