package problems;

import java.util.*;

/**
 * Created by fsantos on 2/13/17.
 */
public class Prob162 {
    public static class DirectGraph {
        private Map<String, List<String>> adjList = new HashMap<>();

        public DirectGraph() {

        }

        public void connect(String s, String d) {
            addVertex(d);
            List<String> adj = addVertex(s);
            adj.add(d);
        }

        private List<String> addVertex(String v) {
            List<String> adj = adjList.get(v);
            if (adj == null) {
                adj = new ArrayList<>();
                adjList.put(v, adj);
            }
            return adj;
        }

        public List<String> getAdj(String v) {
            List<String> adj = adjList.get(v);
            if (adj == null) return null;

            // Returning a copy
            List<String> t = new ArrayList<>(adj);
            return t;
        }
    }

    public static class BFS {
        private Set<String> visited = new HashSet<>();
        private Map<String, String> pathTo = new HashMap<>();
        private final String s;

        public BFS(DirectGraph g, String s) {
            this.s = s;
            bfs(g, s);
        }

        public boolean hasPathTo(String d) {
            return visited.contains(d);
        }

        private void bfs(DirectGraph g, String s) {
            Queue<String> queue = new ArrayDeque<>();
            queue.add(s);
            visited.add(s);

            while (!queue.isEmpty()) {
                String v = queue.remove();

                for (String w: g.getAdj(v)) {
                    if (!visited.contains(w)) {
                        pathTo.put(w, v);
                        visited.add(w);
                        queue.add(w);
                    }
                }
            }
        }

        public Stack<String> pathTo(String d) {
            if (!hasPathTo(d)) return null;
            Stack<String> path = new Stack<>();

            path.add(d);

            String v = pathTo.get(d);
            path.add(v);

            while (v.compareTo(s) != 0) {
                v = pathTo.get(v);
                path.add(v);
            }

            return path;
        }
    }

    public static void main(String[] args) {
        DirectGraph g = new DirectGraph();
        g.connect("felipe", "larissa");
        g.connect("felipe", "larissaxx");
        g.connect("larissaxx", "larissayy");
        g.connect("larissayy", "gael");
        g.connect("larissayy", "vvv");
        g.connect("larissa", "breno");
        g.connect("larissa", "gael");

        BFS bfs = new BFS(g, "felipe");
//        System.out.println(bfs.hasPathTo("larissa"));
//        System.out.println(bfs.hasPathTo("breno"));
//        System.out.println(bfs.hasPathTo("gael"));
//        System.out.println(bfs.hasPathTo("xxx"));

        Stack<String> path = bfs.pathTo("vvv");
        while (!path.isEmpty())
            System.out.println(path.pop());

    }
}
