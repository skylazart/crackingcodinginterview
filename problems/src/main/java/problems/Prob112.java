package problems;

import java.util.*;

/**
 * Created by fsantos on 1/30/17.
 */
public class Prob112 {
    // Undirected graph using adjacent list
    public static final class Graph {
        private Map<Integer, List<Integer>> adjList = new HashMap<>();

        public Graph() {

        }

        public void addEdge(Integer v) {
            adjList.put(v, new ArrayList<>());
        }

        public void connect(Integer s, Integer d) {
            List<Integer> l = adjList.get(s);
            l.add(d);

            l = adjList.get(d);
            l.add(s);
        }

        public List<Integer> getAdj(Integer v) {
            return adjList.get(v);
        }
    }

    public static class Path {
        private Set<Integer> visited = new HashSet<>();

        public Path(Graph g, int s) {
            List<Integer> adj = g.getAdj(s);

            for (Integer x: adj) {
                dfs(g, s, x);
            }
        }

        private void dfs(Graph g, int s, Integer v) {
            if (visited.contains(v)) return;

            visited.add(v);
            List<Integer> adj = g.getAdj(v);

            for (Integer x: adj)
                dfs(g, s, x);
        }

        public boolean hasPathTo(Integer d) {
            return visited.contains(d);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(1);
        g.addEdge(2);
        g.addEdge(3);
        g.addEdge(4);
        g.addEdge(5);
        g.addEdge(6);
        g.addEdge(7);
        g.addEdge(8);

        //[1 = 2, 2 = 4, 3 = 4, 6 = 7, 5 = 8, 8 = 3]
        g.connect(1, 2);
        g.connect(2, 4);
        g.connect(3, 4);
        g.connect(6, 7);
        g.connect(5, 8);
        g.connect(8, 3);

        Path path = new Path(g, 1);
        System.out.println(!path.hasPathTo(3));
    }
}
