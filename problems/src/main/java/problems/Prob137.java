package problems;

import java.util.*;

/**
 * Created by fsantos on 2/7/17.
 */
public class Prob137 {
    public static class Graph {
        private Map<Integer, List<Integer>> adjList = new HashMap<>();
        private boolean hasCycle = false;

        public Graph() {

        }

        public void connect(int v, int d) {
            List<Integer> adj = create(v);
            create(d);

            // Connect v with d
            adj.add(d);
        }

        private List<Integer> create(int v) {
            List<Integer> list = adjList.get(v);
            if (list == null) {
                list = new ArrayList<Integer>();
                adjList.put(v, list);
            }
            return list;
        }

        private boolean hasCycle() {
            for (Integer v: adjList.keySet()) {
                Set<Integer> visited = new HashSet<>();
                dfs(v, visited, v);
                if (hasCycle) return true;
            }

            return hasCycle;
        }

        private void dfs(Integer v, Set<Integer> visited, Integer u) {
            if (!visited.contains(v)) {
                visited.add(v);
                List<Integer> adj = adjList.get(v);
                for (Integer d : adj)
                    dfs(d, visited, v);
            } else {
                if (v != u)
                    hasCycle = true;
            }
        }
    }

    public static boolean hasLoop(int[] arr) {
        Graph graph = new Graph();
        int totalOfMoves = 0;
        int idx = 0;

        while (totalOfMoves++ < arr.length * 2) {
            int src = idx;
            int dest = (idx + arr[idx]) % arr.length;
            idx = dest;

            if (src == dest)
                break;

            System.out.println("Connecting src " + src + " with dest: " + dest);
            graph.connect(src, dest);
        }

        return graph.hasCycle();
    }

    public static void main(String[] args) {
        System.out.println(hasLoop(new int[] {2, -1, 1, 2, 2}));
        System.out.println(hasLoop(new int[] {1, 2}));
    }
}
