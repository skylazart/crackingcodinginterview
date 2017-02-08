package problems;

import java.util.*;

/**
 * Created by fsantos on 2/7/17.
 */
public class Prob138 {
    public static class FindValue {
        private Map<Integer, List<Integer>> locationsByValue = new HashMap<>();

        public FindValue(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                List<Integer> locations = locationsByValue.get(arr[i]);
                if (locations == null) {
                    locations = new ArrayList<>();
                    locationsByValue.put(arr[i], locations);
                }

                locations.add(i);
            }
        }

        public List<Integer> findLocations(int value, int excludedLocation) {
            List<Integer> list = locationsByValue.get(value);

            List<Integer> returnedList = new ArrayList<>();
            if (list == null) return returnedList;

            for (Integer x: list) {
                if (x == excludedLocation) continue;
                returnedList.add(x);
            }

            return returnedList;
        }
    }

    public static class DirectedGraph {
        private Map<Integer, List<Integer>> adjList = new HashMap<>();

        public DirectedGraph() {

        }

        private List<Integer> addVertex(Integer v) {
            List<Integer> adj = adjList.get(v);
            if (adj == null) {
                adj = new ArrayList<>();
                adjList.put(v, adj);
            }
            return adj;
        }

        public void connect(Integer v, Integer d) {
            System.out.println("Connecting " + v + " with " + d);
            List<Integer> adj = addVertex(v);
            addVertex(d);
            adj.add(d);
        }

        public List<Integer> getAdj(Integer v) {
            List<Integer> adj = adjList.get(v);
            List<Integer> copyOfAdj;

            if (adj == null)
                copyOfAdj = new ArrayList<>();
            else
                copyOfAdj = new ArrayList<>(adj);

            return copyOfAdj;
        }

        public List<Integer> getVertexList() {
            List<Integer> copyOfVertex = new ArrayList<>();
            for (Integer v: adjList.keySet())
                copyOfVertex.add(v);

            return copyOfVertex;
        }
    }

    public static class BFS {
        private int minimumSteps = 0;
        private boolean pathFound = false;
        private final int s;

        private Map<Integer, Integer> edgeTo = new HashMap<>();
        private Set<Integer> visited = new HashSet<>();

        public BFS(DirectedGraph graph, Integer s) {
            this.s = s;
            bfs(graph, s);
        }

        private void bfs(DirectedGraph graph, Integer s) {
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(s);
            visited.add(s);

            while (!queue.isEmpty()) {
                Integer v = queue.remove();

                for (Integer w: graph.getAdj(v)) {
                    if (!visited.contains(w)) {
                        edgeTo.put(w, v);
                        visited.add(w);
                        queue.add(w);
                    }
                }
            }
        }

        private void addToQueue(Queue<Integer> queue, List<Integer> adj) {
            for (Integer x: adj)
                queue.add(x);
        }

        public boolean hasPathTo(int d) {
            return visited.contains(d);
        }

        public int getMinimumSteps(int d) {
            if (!hasPathTo(d)) return -1;
            Stack<Integer> path = new Stack<>();

            while (true) {
                Integer w = edgeTo.get(d);
                path.push(w);
                d = w;

                if (d == s)
                    break;
            }

            return path.size();
        }
    }

    public static int findMinimumSteps(int[] arr) {
        FindValue findValue = new FindValue(arr);
        DirectedGraph directedGraph = new DirectedGraph();

        for (int i = 0; i < arr.length; i++) {
            if (i > 0) directedGraph.connect(i, i - 1);
            if (i < arr.length - 1) directedGraph.connect(i, i + 1);

            List<Integer> connections = findValue.findLocations(arr[i], i);
            for (Integer d: connections)
                directedGraph.connect(i, d);

        }

        BFS bfs = new BFS(directedGraph, 0);
        if (bfs.hasPathTo(arr.length - 1))
            return bfs.getMinimumSteps(arr.length - 1);

        return -1;
    }


    public static void main(String[] args) {
        System.out.println(findMinimumSteps(new int[]{5, 4, 2, 5, 0}));
        System.out.println(findMinimumSteps(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 5, 4, 3, 6, 0, 1, 2, 3, 4, 5, 7}));
    }
}
